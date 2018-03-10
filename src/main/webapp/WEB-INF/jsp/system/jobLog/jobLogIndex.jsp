
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
			<div class="layui-inline">
				<label class="layui-form-label">开始时间</label>
				<div class="layui-input-inline">
					<input type="text" name="date" id="startDate" lay-verify="date" placeholder="yyyy-MM-dd HH:mm:ss" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">结束时间</label>
				<div class="layui-input-inline">
					<input type="text" name="date" id="endDate" lay-verify="date" placeholder="yyyy-MM-dd HH:mm:ss" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<button class="layui-btn" onclick="javascript:jobLogOperate.searchJobLog();" type="button">查询</button>
			</div>
		</blockquote>
		<div class="layui-col-md12">
			<table id="jobLogTable" lay-filter="jobLogFilter"></table>
		</div>
	</div>
	
	
	
	<script type="text/html" id="stateTemplet">
		{{#  if(d.logState === '0'){ }}
			<span class="layui-badge layui-bg-blue">运行中</span>
		{{#  } else if(d.logState === '1'){ }}
			<span class="layui-badge layui-bg-gray">运行结束</span>
  		{{#  } else { }}
 		{{#  } }}
	</script>
	
	<script type="text/html" id="resultTemplet">
		{{#  if(d.logResult === '成功'){ }}
			<span class="layui-badge layui-bg-blue">成功</span>
  		{{#  } else if(d.logResult === '失败'){ }}
			<span class="layui-badge layui-bg-gray">失败</span>
  		{{#  } else{ }}
 		{{#  } }}
	</script>

	<script type="text/javascript" src="${ctx}/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript" src="${ctx}/js/common.js"></script>
	
	<script>
	//JavaScript代码区域
	var $;
	var layer;
	var table;
	var form;
	var laydate;
	layui.use(['jquery','table','layer','form','laydate'],function(){
	    $ = layui.jquery;
	    layer = layui.layer;
	    table = layui.table;
	    form = layui.form;
	    laydate = layui.laydate;
	    laydate.render({
	      elem: '#startDate'
	      ,type: 'datetime'
	    });
	    laydate.render({
	      elem: '#endDate'
	      ,type: 'datetime'
	    });
	    table.render({
		    id:'jobLogTable',
	        elem: '#jobLogTable',
	        url:"${ctx}/system/jobLogs",
	        method: 'get', 
	        page:true,//分页
	        height : "full-100",
	        limit:50,
	        request:pageModel.request,
	        loading:true,
	        //response:pageModel.response,
	        cols:[[ //表头
    	        {field: '',type:'numbers', title: '序号', width:'5%'},
    	        {field: 'logJobName', title: '任务名称', width:'10%'},
    	        {field: 'logJobDescription', title: '任务描述', width:'25%'},
    	        {field: 'logStartDate', title: '开始时间', width:'10%'},
    	        {field: 'logTime', title: '运行时间', width:'10%'},
    	        {field: 'logState', title: '状态', width:'6%',templet: '#stateTemplet'},
    	        {field: 'logResult', title: '结果', width:'5%',templet: '#resultTemplet'},
    	        {field: 'logMessage', title: '结果描述', width:'28%'}
            ]]
	    })
	});
	var jobLogOperate = {
		searchJobLog : function(){
			table.reload('jobLogTable',{	
	            where:{
	                'strMap[\'startDate\']':$('#startDate').val(),
	                'strMap[\'endDate\']':$('#endDate').val()
	            }
                });
			return;
		}
	}
	</script>
</body>
</html>