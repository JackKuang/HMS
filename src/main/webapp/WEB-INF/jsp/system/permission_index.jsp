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
  <title>菜单管理</title>
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
  
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/vendor/plugins/treegrid/css/jquery.treegrid.css">
  
  <!-- Admin forms -->
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/assets/admin-tools/admin-forms/css/admin-forms.css">
  
  <!-- Vendor CSS -->
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/vendor/plugins/magnific/magnific-popup.css">

</head>
<body class="tab">

  <!-- Start: Main -->
  <div class="row text-center">
    <div class="col-xs-2">
      <button type="button" class="btn btn-primary btn-block" onclick="showPermission()">添加父菜单</button>
    </div>
    <div class="col-xs-2">
      <button type="button" class="btn btn-info btn-block">刷新</button>
    </div>
  </div>
  <div>
    <table id="tb" ></table>
  </div>
  <!-- Admin Form Popup -->
  <div id="modal-form" class="popup-basic admin-form mfp-with-anim mfp-hide">
    <div class="panel">
      <div class="panel-heading">
        <span class="panel-title">
          <i class="fa fa-bookmark"></i><span id="permissionTitle"></span></span>
      </div>
      <!-- end .panel-heading section -->
      	<form class="form-horizontal" role="form" data-toggle="validator" id="permissionForm">
	      <div class="panel-body">
	         <div class="form-group">
	            <label for="permissionTitleInput" class="col-lg-3 control-label">功能名称</label>
	            <div class="col-lg-8">
	              <input type="text" id="permissionTitleInput" class="form-control" placeholder="菜单名称，例如：功能管理" required="124414">
  				  <div class="help-block with-errors"></div>
	            </div>
	          </div>
	          <div class="form-group">
	            <label for="permissionUrlInput" class="col-lg-3 control-label">功能路径</label>
	            <div class="col-lg-8">
	              <input type="text" id="permissionUrlInput"  pattern="^[_A-z0-9]{1,}$" class="form-control" placeholder="功能路径，例如：/system/permissionIndex"
	              required>
  				  <div class="help-block with-errors"></div>
	            </div>
	          </div>
	          <div class="form-group">
	            <label for="permissionStyleInput" class="col-lg-3 control-label">风格</label>
	            <div class="col-lg-8">
	              <input type="text" id="permissionStyleInput" class="form-control" placeholder="风格，例如：fa fa-calendar" >
  				  <div class="help-block with-errors"></div>
	            </div>
	          </div>
	          <div class="form-group">
	            <label class="col-lg-3 control-label" for="permissionDescInput">功能描述</label>
	            <div class="col-lg-8">
	              <textarea class="form-control textarea-grow" id="permissionDescInput" rows="4" placeholder="功能描述，例如：用户登录系统所有功能管理"></textarea>
  				  <div class="help-block with-errors"></div>
	            </div>
	          </div>
	        </div>
		    <!-- .end: panel-body  -->
	        <div class="panel-footer text-right">
	          <button type="submit" class="button btn-primary" onclick="savePermission()">提交</button>
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
  
  <script src="<%=basePath %>/vendor/plugins/treegrid/js/jquery.treegrid.js"></script>
  <script src="<%=basePath %>/vendor/plugins/treegrid/js/jquery.treegrid.bootstrap3.js"></script>
  <script src="<%=basePath %>/vendor/plugins/treegrid/extension/jquery.treegrid.extension.js"></script>
  
  
  <!-- Page Plugins -->
  <script src="<%=basePath %>/vendor/plugins/magnific/jquery.magnific-popup.js"></script>
  <script src="<%=basePath %>/vendor/plugins/validator/bootstrap-validator.js"></script>

  <script type="text/javascript">

  jQuery(document).ready(function() {

    "use strict";

    // Init Theme Core    
    Core.init();

    // Init Demo JS  
    Demo.init();

    $(document).ready(function () {
        $('#tb').treegridData({
        	id: 'permissionCode',
            parentColumn: 'permissionParCode',
            type: "GET", //请求数据的ajax类型
            url: '<%=basePath %>/system/permissions',   //请求数据的ajax的url
            ajaxParams: {
                }, //请求数据的ajax的data属性
            expandColumn: null,//在哪一列上面显示展开按钮
            striped: true,   //是否各行渐变色
            bordered: true,  //是否显示边框
            //expandAll: false,  //是否全部展开
            columns: [
                {
                    title: '菜单名称',
                    field: 'permissionName',
                    width: 120,
                },
                {
                    title: '功能描述',
                    field: 'permissionDesc',
                    width: 180,
                },
                {
                    title: '地址',
                    field: 'permissionUrl'
                },
                {
                    title: '风格',
                    field: 'permissionStyle',
                    width: 120
                },
                {
                    title: '风格预览',
                    field: 'permissionStyle',
                    formatter: style_formatter,
                    width: 80
                },
                {
                    title: '排序',
                    field: 'permissionOrder',
                    width: 80
                },
                {
                    title: '操作',
                    field: 'permissionCode',
                    formatter: code_formatter,
                    width: 320
                }
            ]
        });
    });
    $('#permissionForm').validator().on('submit', function (e) {
		  if (e.isDefaultPrevented()) {
			  //输入出错
		  } else {
			  //校验成功,取消默认的事件，手动处理
			  return false;
		  }
	  })
  });
  
  function style_formatter(index,value,row){
	  return '<span class="'+value+'"></span>';
  }

  function code_formatter(index,value,row){
	  var btn = '<div class="btn-group">';
	  btn += '<button type="button" class="btn btn-primary" onclick="showPermission(\''+row.permissionUuid+'\')">添加子菜单</button>';
	  btn += '<button type="button" class="btn btn-warning">修改</button>';
	  btn += '<button type="button" class="btn btn-danger">删除</button>';
	  btn += '<button type="button" class="btn btn-info">上移</button>';
	  btn += '<button type="button" class="btn btn-info">下移</button>';
	  btn += '</div>';
	  return btn;
  }
  //弹窗，新增修改
  function showPermission(uuid){
	  $('#permissionForm')[0].reset();
	  if(uuid == null){
		  $('#permissionTitle').text('添加父菜单');
	  }else{
		  $('#permissionTitle').text('添加子菜单');
	  }
	  $.magnificPopup.open({
		  items: {
		    src: '#modal-form'
		  },
		  type: 'inline',
		  preloader: false,
		  closeOnBgClick:false,//点击背景关闭弹窗
		  closeBtnInside:true//关闭按钮在窗口内
	  });
  }
  //关闭弹窗
  function closePermission(){
	  $('#permissionForm')[0].reset();
	  $.magnificPopup.close();
  }


  </script>
  <!-- END: PAGE SCRIPTS -->

</body>

</html>
