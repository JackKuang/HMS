<%@ page language="java" isThreadSafe="true" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%@ include file="../../include/head.jsp" %>
<body class="childrenBody">
	<div class="layui-row layui-col-space10">
		<div class="layui-col-md4">
			<ul id="dictionaryTree"></ul>
		</div>
		<div class="layui-col-md4">
			<form class="layui-form" id="dictionaryForm">
				<blockquote class="layui-elem-quote">
					<button onclick="dictionaryOperate.saveRootDictionary();" type="button" class="layui-btn layui-btn-normal">根节点添加</button>
					<button onclick="dictionaryOperate.saveDictionary();" type="button" class="layui-btn layui-btn-normal">当前子节点节点添加</button>
				</blockquote>
				<div class="layui-col-md12">
					<fieldset class="layui-elem-field layui-field-title site-title">
				      <legend><a id="operateName">根节点添加</a></legend>
				    </fieldset>
				</div>
				<input type="hidden" id="dictionaryParUuid" name="dictionaryParUuid">
				<div class="layui-form-item">
					<label class="layui-form-label">字典名称</label>
					<div class="layui-input-block">
						<input type="text" id="dictionaryName" name="dictionaryName"
							placeholder="字典名称，如：天气" autocomplete="off"
							lay-verify="required" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">字典Value</label>
					<div class="layui-input-block">
						<input type="text" id="dictionaryValue" name="dictionaryValue"
							placeholder="字典Value，例如：WEATHER" autocomplete="off"
							lay-verify="required|" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">字典排序</label>
					<div class="layui-input-block">
						<input type="text" id="dictionaryOrder" name="dictionaryOrder"
							placeholder="字典排序，例如：1" autocomplete="off" lay-verify="required"
							class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
				    <label class="layui-form-label">字典状态</label>
				    <div class="layui-input-block">
				      <input type="checkbox" id="dictionaryState" name="dictionaryState"
				      value="1" lay-skin="switch" lay-text="启用|关闭" checked>
				    </div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="*">保存</button>
						<!-- <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
						<button onclick="javascript:dictioaryOperate.deletePermission();" type="button" class="layui-btn layui-btn-danger">删除</button>
					</div>
				</div>
				<!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
			</form>
		</div>
	</div>
	<script type="text/javascript" src="${ctx}/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript" src="${ctx}/js/common.js"></script>
	<script>
	//JavaScript代码区域
	var $;
	var form;
	var dictionaryUuidGlobal = "";
	layui.use(['jquery','form'],function(){
	    $ = layui.jquery;
	    form = layui.form;
	    initModel.initDictionaryTree();
	    form.on('submit(*)', function(data){
			  loadingModel.showLoading();
			  if(dictionaryUuidGlobal == ""){
				  $.ajax({
					  type: 'post',
					  url: "${ctx}/system/dictionarys",
					  data: data.field,
					  success: function(data) {
						  loadingModel.hideLoading();
						  $('#dictionaryForm')[0].reset();
						  if(data.success){
							  initModel.initDictionaryTree();
						  }
						  alertModel.alertData(data);
					  }
				  });
			  }else{
				  $.ajax({
					  type: 'put',
					  url: "${ctx}/system/dictionarys/"+dictionaryUuidGlobal,
					  data: data.field,
					  success: function(data) {
						  loadingModel.hideLoading();
						  $('#dictionaryForm')[0].reset();
						  if(data.success){
							  initModel.initDictionaryTree();
						  }
						  alertModel.alertData(data);
					  }
				  });
			  }
			  return false;
		  });
	});

	var initModel = {
		initDictionaryTree:function(){
			dictionaryUuidGlobal = '';
			$.ajax({
			    url:'${ctx}/system/dictionarys',
			    type:'GET', //GET
			    async:true,    //或false,是否异步
			    dataType:'json',
			    success:function(data,textStatus,jqXHR){
				    $('#dictionaryTree').html('');
			    	layui.use('tree', function(){
				    	layui.tree({
					    	elem: '#dictionaryTree',//传入元素选择器
				    		nodes: data,//数据内容
				    		click: function(node){//点击事件
				    			$('#operateName').html('节点修改');
				    			dictionaryUuidGlobal = node.dictionaryUuid;
								$("#dictionaryName").val(node.dictionaryName);
								$("#dictionaryValue").val(node.dictionaryValue);
								$("#dictionaryOrder").val(node.dictionaryOrder);
								if(node.permissionState == 1){
									$('#dictionaryState').prop("checked",true);
								}else{
									$('#dictionaryState').prop("checked",false);
								}
								$('#dictionaryParUuid').val(node.dictionaryParUuid);
				    		}
				    	});
		    		});
			    }
		    });
		}
	}

	var dictionaryOperate = {
		saveRootDictionary:function(){
			$('#dictionaryForm')[0].reset();
			$('#operateName').html('根节点添加');
			dictionaryUuidGlobal = '';
			$('#permissionParCode').val('');
		},
		saveDictionary:function(){
			if(dictionaryUuidGlobal != ''){
				$('#dictionaryForm')[0].reset();
				$('#operateName').html('当前子节点添加');
				$('#dictionaryParUuid').val(dictionaryUuidGlobal);
				dictionaryUuidGlobal = "";
			}else{
				alertModel.alertMsg('lock','请先选择一个节点！')
			}
		},
		deleteDictionary:function(){
			if(dictionaryUuidGlobal != ''){
				layer.confirm('确认删除',{icon: 3}, function(index){
					loadingModel.showLoading();
					$.ajax({
						  type: 'delete',
						  url: "${ctx}/system/dictionarys/"+dictionaryUuidGlobal,
						  success: function(data) {
							  loadingModel.hideLoading();
							  if(data.success){
								  initModel.initPermissionTree();
								  $('#dictionaryForm')[0].reset();
							  }
							  alertModel.alertData(data);
						  }
					  });
					  layer.close(index);
				});
			}else{
				alertModel.alertMsg('lock','请先选择一个节点！')
			}
		}
	}
	</script>
</body>
</html>
