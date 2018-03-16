<%@ page language="java" isThreadSafe="true" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%@ include file="../../include/head.jsp" %>
<body class="childrenBody">
	<div class="layui-row layui-col-space10">
		<blockquote class="layui-elem-quote">
			<button class="layui-btn layui-btn-normal" onclick="javascript:jobOperate.addJob();" type="button">新增任务</button>
		</blockquote>
		<div class="layui-col-md12">
			<table id="jobTable" lay-filter="jobFilter"></table>
		</div>
	</div>
	
	<div id="jobDialog" class="hide" >
		<form class="layui-form" id="jobForm">
			<div class="layui-col-md12">
				<div class="layui-col-md11">
					<div class="layui-form-item">
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">任务名称</label>
						<div class="layui-input-block">
							<input type="text" id="jobName" name="jobName"
								placeholder="任务名称" autocomplete="off"
								lay-verify="required" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">任务描述</label>
						<div class="layui-input-block">
							<input type="text" id="jobDescription" name="jobDescription"
								placeholder="任务描述" autocomplete="off"
								lay-verify="required" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">Cron表达式</label>
						<div class="layui-input-block">
							<input type="text" id="jobCron" name="jobCron"
								placeholder="邮箱，" autocomplete="off"
								lay-verify="required" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">包名+类名</label>
						<div class="layui-input-block">
							<input type="text" id="jobBeanClass" name="jobBeanClass"
								placeholder="com.hurenjieee.com.test" autocomplete="off"
								lay-verify="required" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">方法名</label>
						<div class="layui-input-block">
							<input type="text" id="jobMethod" name="jobMethod"
								placeholder="com.hurenjieee.com.test" autocomplete="off"
								lay-verify="required" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">是否允许并发</label>
						<div class="layui-input-block">
							<input type="checkbox" id="jobConcurrent" name="jobConcurrent"
							value="1" lay-skin="switch" lay-text="是|否" checked>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit lay-filter="*">保存</button>
							<!-- <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	
	<script type="text/html" id="statusTemplet">
		{{#  if(d.jobStatus === 1){ }}
			<span class="layui-badge layui-bg-blue">运行中</span>
  		{{#  } else { }}
			<span class="layui-badge layui-bg-gray">未运行</span>
 		{{#  } }}
	</script>
	
	<script type="text/html" id="concurrentTemplet">
		{{#  if(d.jobConcurrent === 1){ }}
			是
  		{{#  } else { }}
			否
 		{{#  } }}
	</script>
	
	<script type="text/html" id="operateBar">

		{{#  if(d.jobStatus === 1){ }}
			<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="stopJob">禁用</a>
  		{{#  } else { }}
			<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="startJob">启用</a>
 		{{#  } }}
		<a class="layui-btn layui-btn-xs layui-btn-primary" lay-event="startJobOnce">立即运行一次</a>
		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
		<a class="layui-btn layui-btn-xs layui-btn-danger " lay-event="del">删除</a>
	</script>
	
	<!-- 
	<script type="text/html" id="statusBar">
		{{#  if(d.jobStatus === '1'){ }}
			<input type="checkbox" name="status" lay-filter="statusFilter" lay-skin="switch" lay-text="启用|禁用" checked>
  		{{#  } else { }}
			<input type="checkbox" name="status" lay-filter="statusFilter" lay-skin="switch" lay-text="启用|禁用">
 		{{#  } }}
	</script>
	 -->
	<script type="text/javascript" src="${ctx}/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript" src="${ctx}/js/common.js"></script>
	
	<script>
	//JavaScript代码区域
	var $;
	var layer;
	var jobUuidGlobal = "";
	var table;
	var form;
	layui.use(['jquery','table','layer','form'],function(){
	    $ = layui.jquery;
	    layer = layui.layer;
	    table = layui.table;
	    table.render({
		    id:'jobTable',
	        elem: '#jobTable',
	        url:"${ctx}/system/jobs",
	        method: 'get', 
	        page:true,//分页
	        height : "full-100",
	        limit:50,
	        request:pageModel.request,
	        loading:true,
	        //response:pageModel.response,
	        cols:[[ //表头
    	        {field: '',type:'numbers', title: '序号', width:'5%'},
    	        {field: 'jobName', title: '任务名称', width:'10%'},
    	        {field: 'jobDescription', title: '任务描述', width:'10%'},
    	        {field: 'jobCron', title: 'Cron表达式', width:'10%'},
    	        {field: 'jobBeanClass', title: '包名+类名', width:'20%'},
    	        {field: 'jobMethod', title: '方法名', width:'10%'},
    	        {field: 'jobConcurrent', title: '是否并发', width:'10%',templet: '#concurrentTemplet'},
    	        {field: 'jobStatus', title: '状态', width:'5%',templet: '#statusTemplet'},
    	        {title: '操作',fixed: 'right', width:'20%', align:'center', toolbar: '#operateBar'}
    	        /* {title: '启用',fixed: 'right', width:'5%', align:'center', toolbar: '#statusBar'} */
            ]]
	    })
	    table.on('tool(jobFilter)', function(obj){
			var data = obj.data;
			if(obj.event === 'del'){
				if( data.jobStatus === "1" ){
					alertModel.alertMsg("question", "请先禁用任务");
					return;
				}
				jobUuidGlobal = data.uuid;
				jobOperate.deleteJob();
			} else if(obj.event === 'edit'){
				if( data.jobStatus == 1 ){
					alertModel.alertMsg("question", "请先禁用任务");
					return;
				}
				jobUuidGlobal = data.uuid;
				$('#jobName').val(data.jobName);
				$('#jobDescription').val(data.jobDescription);
				$('#jobCron').val(data.jobCron);
				$('#jobBeanClass').val(data.jobBeanClass);
				$('#jobMethod').val(data.jobMethod);
				if(data.jobConcurrent === '1'){
					$('#jobConcurrent').prop("checked",true);
				}else{
					$('#jobConcurrent').prop("checked",false);
				}
				form.render();
				layer.open({
					type: 1,
					title: '编辑任务',
					skin: 'layui-layer-rim', //加上边框
					area: ['400px', '500px'], //宽高
					shadeClose: false,
					content: $('#jobDialog'),
				});	
			} else if (obj.event == 'startJobOnce'){
			    var requestUrl = root + '/system/startJobOnce';
			    var obj = {'uuid': data.uuid};
			    layer.confirm('确认立即运行一次？',{
			        icon: 3,
			        title:'系统提示',
			        cancel : function(index){
			            layer.close(index);
			        }
			    },function(index){
				    //确认操作
					  loadingModel.showLoading();
					  $.ajax({
						  type: 'post',
						  url: requestUrl,
						  data: obj,
						  success: function(data) {
							  loadingModel.hideLoading();
							  if(data.success){
								  table.reload('jobTable',{});
							  }
						      layer.close(index);
							  alertModel.alertData(data);
						  }
					  });
			    },function(index){
			        layer.close(index);
			    });
			} else if(obj.event === 'startJob' || obj.event === 'stopJob'){
				var tipText = '确定启动该任务调度？';
			    var requestUrl = root + '/system/startJob';
			    if(obj.event === 'stopJob'){
			        tipText = '确定禁用该任务调度？';
			        requestUrl = root + '/system/stopJob';
			    }
			    var obj = {'uuid': data.uuid};
			    layer.confirm(tipText,{
			        icon: 3,
			        title:'系统提示',
			        cancel : function(index){
			            layer.close(index);
			        }
			    },function(index){
				    //确认操作
					  loadingModel.showLoading();
					  $.ajax({
						  type: 'post',
						  url: requestUrl,
						  data: obj,
						  success: function(data) {
							  loadingModel.hideLoading();
							  if(data.success){
								  table.reload('jobTable',{});
							  }
						      layer.close(index);
							  alertModel.alertData(data);
						  }
					  });
			    },function(index){
			        layer.close(index);
			    });
			}
		});
	    
	    //按钮点击事件
    	form = layui.form;
	    form.on('submit(*)', function(data){
		  loadingModel.showLoading();
		  if(jobUuidGlobal == ""){
			  $.ajax({
				  type: 'post',
				  url: "${ctx}/system/jobs",
				  data: data.field,
				  success: function(data) {
					  loadingModel.hideLoading();
					  if(data.success){
						  $('#jobForm')[0].reset();
						  table.reload('jobTable',{});
						  layer.closeAll('page');
					  }
					  alertModel.alertData(data);
				  }
			  });
		  }else{
			  $.ajax({
				  type: 'put',
				  url: "${ctx}/system/jobs/"+jobUuidGlobal,
				  data: data.field,
				  success: function(data) {
					  loadingModel.hideLoading();
					  if(data.success){
						  $('#jobForm')[0].reset();
						  table.reload('jobTable',{});
						  layer.closeAll('page');
					  }
					  alertModel.alertData(data);
				  }
			  });
		  }
		  return false;
	  });/* 
		form.on('switch(statusFilter)', function(data){
		    var tipText = '确定启动该任务调度？';
		    var requestUrl = root + '/system/startJob';
		    if(!data.elem.checked){
		        tipText = '确定禁用该任务调度？';
		        requestUrl = root + '/system/stopJob';
		    }
		    layer.confirm(tipText,{
		        icon: 3,
		        title:'系统提示',
		        cancel : function(index){
		            data.elem.checked = !data.elem.checked;
		            form.render();
		            layer.close(index);
		        }
		    },function(index){
			    //确认操作
				  loadingModel.showLoading();
				  $.ajax({
					  type: 'post',
					  url: requestUrl,
					  data: obj,
					  success: function(data) {
						  loadingModel.hideLoading();
						  if(data.success){
							  table.reload('jobTable',{});
						  }
					      layer.close(index);
						  alertModel.alertData(data);
					  }
				  });
		    },function(index){
		        data.elem.checked = !data.elem.checked;
		        form.render();
		        layer.close(index);
		    });
		}); */
	});

	var jobOperate = {
		addJob: function(){
			jobUuidGlobal = '';
			//页面层
			layer.open({
				type: 1,
				title: '新增任务',
				skin: 'layui-layer-rim', //加上边框
				area: ['400px', '500px'], //宽高
				shadeClose: false,
				content: $('#jobDialog'),
			});
		},
		deleteJob: function(){
			if(jobUuidGlobal != ''){
				layer.confirm('确认删除',{icon: 3, title:'系统提示'}, function(index){
					loadingModel.showLoading();
					$.ajax({
						  type: 'delete',
						  url: "${ctx}/system/jobs/"+jobUuidGlobal,
						  success: function(data) {
							  loadingModel.hideLoading();
							  if(data.success){
								  table.reload('jobTable',{});
							  }
							  alertModel.alertData(data);
						  }
					  });
					  layer.close(index);
				});
			}
		}
	}
	</script>
</body>
</html>