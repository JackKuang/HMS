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

</head>
<body class="tab">

  <!-- Start: Main -->
  <div>
    <table id="tb" ></table>

  </div>
  <!-- End: Main -->

  <!-- BEGIN: PAGE SCRIPTS -->

  <%@ include file="../include/js.jsp" %>
  
  <script src="<%=basePath %>/vendor/plugins/treegrid/js/jquery.treegrid.js"></script>
  <script src="<%=basePath %>/vendor/plugins/treegrid/js/jquery.treegrid.bootstrap3.js"></script>
  <script src="<%=basePath %>/vendor/plugins/treegrid/extension/jquery.treegrid.extension.js"></script>

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
            url: '<%=basePath %>/system/testJson',   //请求数据的ajax的url
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
                    title: '操作',
                    field: 'permissionCode',
                    formatter: test,
                    width: 240
                }
            ]
        });
    });
  });

  function style_formatter(index,value,row){
	  return '<span class="'+value+'"></span>';
  }

  function test(index,value,row){
	  var btn = '<div class="btn-group">';
	  btn += '<button type="button" class="btn btn-warning">修改</button>';
	  btn += '<button type="button" class="btn btn-danger">删除</button>';
	  btn += '<button type="button" class="btn btn-info">上移</button>';
	  btn += '<button type="button" class="btn btn-info">下移</button>';
	  btn += '</div>';
	  return btn;
  }

  </script>
  <!-- END: PAGE SCRIPTS -->

</body>

</html>
