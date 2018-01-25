<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%
	/* 项目使用绝对路径，basePath只在主JSP上定义，不再include里面定义，避免变量名定义冲突 */
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>

<!DOCTYPE html>
<html>

<head>
  <title>角色管理</title>
  <meta charset="utf-8">
  <meta name="keywords" content="HMS" />
  <meta name="description" content="HMS - Hu's Management System">
  <meta name="author" content="JackKuang">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
  <!-- Font CSS (Via CDN) -->
  <!-- <link rel='stylesheet' type='text/css' href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700'> -->

  <!-- Theme CSS -->
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/assets/skin/default_skin/css/theme.css">

  <!-- Favicon -->
  <link rel="shortcut icon" href="<%=basePath %>/assets/img/favicon.ico">
  
  <!-- Admin forms -->
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/assets/admin-tools/admin-forms/css/admin-forms.css">
  
  <!-- Vendor CSS -->
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/vendor/plugins/magnific/magnific-popup.css">

</head>
<body class="tab">

  <!-- Start: Main -->
  <div class="col-xs-12">
	<div class="row text-center">
	  <div class="col-xs-2">
	    <button type="button" class="btn btn-primary btn-block" onclick="addRole()">添加</button>
	  </div>
	  <div class="col-xs-2">
	    <button type="button" class="btn btn-primary btn-block" onclick="updateRole()">修改</button>
	  </div>
	  <div class="col-xs-2">
	    <button type="button" class="btn btn-primary btn-block" onclick="deleteRole()">删除</button>
	  </div>
	  <div class="col-xs-2">
	    <button type="button" class="btn btn-info btn-block"  onclick="initTreeGridData()">刷新</button>
	  </div>
	</div>
    <table id="tb" class="col-xs-12">
	    <thead>
	    <tr>
	        <th data-field="uuid" data-align="right" data-sortable="true">Item ID</th>
	        <th data-field="roleName" data-align="center" data-sortable="true">Item Name</th>
	    </tr>
	    </thead>
    </table>
  </div>
  <!-- Admin Form Popup -->
  <div id="modal-form" class="popup-basic admin-form mfp-with-anim mfp-hide">
    <div class="panel">
      <div class="panel-heading">
        <span class="panel-title">
          <i class="fa fa-bookmark"></i><span id="permissionTitle"></span></span>
      </div>
      <!-- end .panel-heading section -->
      	<form class="form-horizontal" role="form" data-toggle="validator" action="<%=basePath %>/system/permissions" method="post" id="permissionForm">
	      <div class="panel-body">
		    <!-- .end: panel-body  -->
	        <div class="panel-footer text-right">
	          <button type="submit" class="button btn-primary">提交</button>
	          <button type="button" class="button btn-default" onclick="closePermission()">取消</button>
	        </div>
        </form>
    </div>
    <!-- end: .panel -->
  </div>
  <!-- end: .admin-form -->
  <!-- End: Main -->
  
  <!-- BEGIN: PAGE SCRIPTS -->

  <!-- jQuery -->
  <script src="<%=basePath %>/vendor/jquery/jquery-1.11.1.min.js"></script>
  <script src="<%=basePath %>/vendor/jquery/jquery_ui/jquery-ui.min.js"></script>
    
  <!-- Theme Javascript -->
  <script src="<%=basePath %>/assets/js/utility/utility.js"></script>
  <script src="<%=basePath %>/assets/js/demo/demo.js"></script>
  <script src="<%=basePath %>/assets/js/main.js"></script>
  <script src="<%=basePath %>/assets/js/common.js"></script>
  
  <!-- Page Plugins -->
  <script src="<%=basePath %>/vendor/plugins/magnific/jquery.magnific-popup.js"></script>
  <script src="<%=basePath %>/vendor/plugins/table/bootstrap-table.js"></script>
  <script src="<%=basePath %>/vendor/plugins/table/extensions/bootstrap-table-zh-CN.js"></script>
  <script src="<%=basePath %>/vendor/plugins/form/jquery.form.js"></script>
  <script src="<%=basePath %>/vendor/plugins/pnotify/pnotify.js"></script>
  <script src="<%=basePath %>/vendor/plugins/confirm/jquery.confirm.min.js"></script>

  <script type="text/javascript">

  var updateFlag = false;
  var permissionUuidGlobal = "";
  
  jQuery(document).ready(function() {
    	//initSavePermission();
    	initDataTables();
  });

  //初始化提交表单方法
  function initSavePermission(){
	  $("#permissionForm").validator().on('submit', function (e) {
		  if (e.isDefaultPrevented()) {
			  //输入未通过验证
		  } else {
			  var formData = $("#permissionForm").serialize();
			  if(updateFlag == false){
				  $.ajax({
					  type: 'post',
					  url: "<%=basePath %>/system/permissions",
					  data: formData,
					  success: function(data) {
						  if(data.success){
							  $.magnificPopup.close();
							  initTreeGridData();
						  }
						  showPNotify(data);
					  }
				  });
			  }else{
				  $.ajax({
					  type: 'put',
					  url: "<%=basePath %>/system/permissions/"+permissionUuidGlobal,
					  data: formData,
					  success: function(data) {
						  if(data.success){
							  $.magnificPopup.close();
							  initTreeGridData();
						  }
						  showPNotify(data);
					  }
				  });
			  }
			  return false;
		  }
	  })
  }
  
  function initDataTables(){
	  $('#tb').bootstrapTable({ 
          url:"<%=basePath %>/system/roles",
          pagination:true,//设置为 true 会在表格底部显示分页条
          sidePagination:'server'//设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
	  });
  };
    

  </script>
  <!-- END: PAGE SCRIPTS -->

</body>

</html>
