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
						<label class="layui-form-label">XXX</label>
						<div class="layui-input-block">
							<input type="checkbox" id="jobConcurrent" name="jobConcurrent"
							value="1" lay-skin="switch" lay-text="启用|关闭" checked>
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
		{{#  if(d.jobStatus === '1'){ }}
			<span class="layui-badge layui-bg-blue">运行中</span>
  		{{#  } else { }}
			<span class="layui-badge layui-bg-gray">结束</span>
 		{{#  } }}

	</script>
	
	<script type="text/html" id="operateBar">
		<a class="layui-btn layui-btn-xs layui-btn-primary" lay-event="start">启用</a>
		<a class="layui-btn layui-btn-xs layui-btn-primary" lay-event="startOne">立即运行一次</a>
		<a class="layui-btn layui-btn-xs " lay-event="edit">编辑</a>
		<a class="layui-btn layui-btn-xs layui-btn-danger " lay-event="del">删除</a>
	</script>
	
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
    	        {field: 'jobConcurrent', title: 'XXX', width:'10%'},
    	        {field: 'jobStatus', title: '运行状态', width:'10%',templet: '#statusTemplet'},
    	        {title:'操作',fixed: 'right', width:'15%', align:'center', toolbar: '#operateBar'}
            ]]
	    })
	    table.on('tool(jobFilter)', function(obj){
			var data = obj.data;
			if(obj.event === 'del'){
				if( data.jobStatus == 1 ){
					alertModel.alertMsg(4, "请先关闭任务");
					return;
				}
				jobUuidGlobal = data.uuid;
				jobOperate.deleteJob();
			} else if(obj.event === 'edit'){
				if( data.jobStatus == 1 ){
					alertModel.alertMsg(4, "请先关闭任务");
					return;
				}
				jobUuidGlobal = data.uuid;
				$('#jobName').val(data.jobName);
				$('#jobDescription').val(data.jobDescription);
				$('#jobCron').val(data.jobCron);
				$('#jobBeanClass').val(data.jobBeanClass);
				$('#jobMethod').val(data.jobMethod);
				if(data.jobConcurrent == "1"){
					$('#jobConcurrent').prop("checked",true);
				}else{
					$('#jobConcurrent').prop("checked",false);
				}
				layer.open({
					type: 1,
					title: '编辑任务',
					skin: 'layui-layer-rim', //加上边框
					area: ['400px', '400px'], //宽高
					shadeClose: false,
					content: $('#jobDialog'),
				});	
			}
		});
	    
	    //按钮点击事件
    	form = layui.form;
	    form.on('submit(*)', function(data){
		  if(jobUuidGlobal == ""){
			  $.ajax({
				  type: 'post',
				  url: "${ctx}/system/jobs",
				  data: data.field,
				  success: function(data) {
					  loadingModel.hideLoading();
					  if(data.success){
						  $('#jobForm')[0].reset();
						  table.reload('jobsTable',{});
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
	  });
	});

	var jobOperate = {
		addJob: function(){
			jobUuidGlobal = '';
			//页面层
			layer.open({
				type: 1,
				title: '新增任务',
				skin: 'layui-layer-rim', //加上边框
				area: ['400px', '400px'], //宽高
				shadeClose: false,
				content: $('#jobDialog'),
			});
		},
		deleteJob: function(){
			if(jobUuidGlobal != ''){
				layer.confirm('确认删除',{icon: 3}, function(index){
					loadingModel.showLoading();
					$.ajax({
						  type: 'delete',
						  url: "${ctx}/system/jobs/"+jobUuidGlobal,
						  success: function(data) {
							  loadingModel.hideLoading();
							  if(data.success){
								  table.reload('jobsTable',{});
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