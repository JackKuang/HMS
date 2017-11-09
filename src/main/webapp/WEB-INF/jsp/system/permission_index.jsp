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
  <%@ include file="../include/head.jsp" %>
  <%@ include file="../include/css.jsp" %>
  
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
      <button type="button" class="btn btn-primary btn-block" onclick="addPermission()">添加父菜单</button>
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
      <div class="panel-body">
        <form class="form-horizontal" role="form" id="permissionForm">
          <div class="form-group">
            <label for="inputStandard" class="col-lg-3 control-label">功能名称</label>
            <div class="col-lg-8">
              <input type="text" id="permissionTitle_input" class="form-control" placeholder="菜单名称，例如：功能管理"
                data-bv-notempty-message="菜单名称不能为空" aria-required="true" aria-invalid="true">
            </div>
          </div>
          <div class="form-group">
            <label for="inputStandard" class="col-lg-3 control-label">功能路径</label>
            <div class="col-lg-8">
              <input type="text" id="permissionUrl_input" class="form-control" placeholder="功能路径，例如：/system/permissionIndex">
            </div>
          </div>
          <div class="form-group">
            <label for="inputStandard" class="col-lg-3 control-label">风格</label>
            <div class="col-lg-8">
              <input type="text" id="permissionStyle_input" class="form-control" placeholder="风格，例如：fa fa-calendar">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label" for="textArea1">功能描述</label>
            <div class="col-lg-8">
              <textarea class="form-control textarea-grow" id="permissionDesc_input" rows="4" placeholder="功能描述，例如：用户登录系统所有功能管理"></textarea>
            </div>
          </div>
        </form>
      </div>
	  <!-- .end: panel-body  -->
      <div class="panel-footer text-right">
        <button type="button" class="button btn-primary">提交</button>
        <button type="button" class="button btn-default">取消</button>
      </div>
    </div>
    <!-- end: .panel -->
  </div>
  <!-- end: .admin-form -->
  <!-- End: Main -->
  
  <!-- BEGIN: PAGE SCRIPTS -->

  <%@ include file="../include/js.jsp" %>
  
  <script src="<%=basePath %>/vendor/plugins/treegrid/js/jquery.treegrid.js"></script>
  <script src="<%=basePath %>/vendor/plugins/treegrid/js/jquery.treegrid.bootstrap3.js"></script>
  <script src="<%=basePath %>/vendor/plugins/treegrid/extension/jquery.treegrid.extension.js"></script>
  
  
  <!-- Page Plugins -->
  <script src="<%=basePath %>/vendor/plugins/magnific/jquery.magnific-popup.js"></script>

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
  });
  
  function style_formatter(index,value,row){
	  return '<span class="'+value+'"></span>';
  }

  function code_formatter(index,value,row){
	  var btn = '<div class="btn-group">';
	  btn += '<button type="button" class="btn btn-primary" onclick="addPermission(\''+row.permissionUuid+'\')">添加子菜单</button>';
	  btn += '<button type="button" class="btn btn-warning">修改</button>';
	  btn += '<button type="button" class="btn btn-danger">删除</button>';
	  btn += '<button type="button" class="btn btn-info">上移</button>';
	  btn += '<button type="button" class="btn btn-info">下移</button>';
	  btn += '</div>';
	  return btn;
  }

  function addPermission(uuid){
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
		  closeOnBgClick:false,
		  closeBtnInside:true
	  });
  }

  </script>
  <!-- END: PAGE SCRIPTS -->

</body>

</html>
