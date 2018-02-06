<%@ page language="java" isThreadSafe="true" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
	/* 项目使用绝对路径，basePath只在主JSP上定义，不再include里面定义，避免变量名定义冲突 */
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>HMS-后台管理系统</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">

<link rel="stylesheet" type="text/css"
	href="<%=basePath %>/layui/css/layui.css">
	
<link rel="stylesheet" type="text/css"
	href="<%=basePath %>/common/common.css">
	
</head>
<body class="layui-layout-body">

	<div class="layui-row layui-col-space10">
		<div class="layui-col-md4">
			<table id="roleTable" lay-filter="roleFilter"></table>
		</div>
		<div class="layui-col-md4">
			<form class="layui-form" id="roleForm">
				<div class="layui-col-md12">
				    <button class="layui-btn layui-btn-normal" onclick="javascript:roleOperate.addRole();" type="button">新增角色</button>
			    </div>
				<div class="layui-col-md12">
					<fieldset class="layui-elem-field layui-field-title site-title">
				      <legend><a id="operateName">新增角色</a></legend>
				    </fieldset>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">角色名称</label>
					<div class="layui-input-block">
						<input type="text" id="roleName" name="roleName"
							placeholder="角色名称" autocomplete="off"
							lay-verify="required" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">权限配置</label>
					<div class="layui-input-block">
						<ul id="permissionTree"></ul>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="*">保存</button>
						<button onclick="javascript:roleOperate.deleteRole();" type="button" class="layui-btn layui-btn-danger" >删除</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="<%=basePath %>/layui/layui.js" charset="utf-8"></script>
	<script src="<%=basePath %>/common/common.js"></script>
	
	<script>
	//JavaScript代码区域
	var $;
	var layer;
	var roleUuidGlobal = "";
	var table;
	layui.use(['jquery','table','layer','form'],function(){
	    $ = layui.jquery;
	    layer = layui.layer;
	    table = layui.table;
	    table.render({
		    id:'roleTable',
	        elem: '#roleTable',
	        url:"<%=basePath %>/system/roles",
	        method: 'get', 
	        height:500,
	        page:true,//分页
	        limit:50,
	        request:pageModel.request,
	        loading:true,
	        //response:pageModel.response,
	        cols:[[ //表头
    	        {field: '',type:'numbers', title: '序号', width:'10%',event:'commonEvent'},
    	        {field: 'roleName', title: '角色名称', width:'88%',event:'commonEvent'}
            ]]
	    })
	    
	    table.on('tool(roleFilter)',function(obj){
			$('#operateName').html('修改角色');
		    var data = obj.data;
		    roleUuidGlobal = data.uuid;
		    initOperate.initPermissionTree(roleUuidGlobal);
		    $('#roleName').val(data.roleName);
	    })
	    //按钮点击事件
	    
    	var form = layer.form;
	    form = layui.form;
	    form.on('submit(*)', function(data){
		    var permissions = "";
		    $('.lee-onChecked').each(function(){
		    	permissions += $(this).attr('value') + ",";
		    });
		    console.log(permissions);
		    data.field['permissions']=permissions;
			  if(roleUuidGlobal == ""){
				  $.ajax({
					  type: 'post',
					  url: "<%=basePath %>/system/roles",
					  data: data.field,
					  success: function(data) {
						  loadingModel.hideLoading();
						  if(data.success){
							  $('#roleForm')[0].reset();
							  table.reload('roleTable',{});
						  }
						  alertModel.alertData(data);
					  }
				  });
			  }else{
				  $.ajax({
					  type: 'put',
					  url: "<%=basePath %>/system/roles/"+roleUuidGlobal,
					  data: data.field,
					  success: function(data) {
						  loadingModel.hideLoading();
						  if(data.success){
							  $('#roleForm')[0].reset();
							  table.reload('roleTable',{});
						  }
						  alertModel.alertData(data);
					  }
				  });
			  }
			  return false;
		  });
	    initOperate.initPermissionTree("");
	});

	var initOperate = {
		initPermissionTree:function(roleUuid){
		    $.ajax({
			    url:'<%=basePath %>/system/rols_permissions',
			    type:'GET', //GET
			    async:true,    //或false,是否异步
			    data: {'roleUuid':roleUuid},
			    dataType:'json',
			    success:function(data,textStatus,jqXHR){
				    $('#permissionTree').html('');
			    	layui.use('tree', function(){
				    	layui.tree({
				    		check:'checkbox',//checkbox
					    	elem: '#permissionTree',//传入元素选择器
				    		nodes: data,//数据内容
				    		click:function(){}//写一个事件触发
				    	});
		    		});
			    }
		    });
	    }
	}

	var roleOperate = {
		addRole: function(){
			$('#operateName').html('新增角色');
			roleUuidGlobal = '';
		},
		deleteRole: function(){
			if(roleUuidGlobal != ''){
				layer.confirm('确认删除',{icon: 3}, function(index){
					loadingModel.showLoading();
					$.ajax({
						  type: 'delete',
						  url: "<%=basePath %>/system/roles/"+roleUuidGlobal,
						  success: function(data) {
							  loadingModel.hideLoading();
							  if(data.success){
								    table.reload('roleTable',{});
							  }
							  alertModel.alertData(data);
						  }
					  });
					  layer.close(index);
				});
			}else{
				alertModel.alertMsg('lock','请先选择一个角色！')
			}
		}
	}

	</script>
</body>
</html>
