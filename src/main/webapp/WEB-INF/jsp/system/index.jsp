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
  <title>HMS 后台管理平台</title>
  <%@ include file="../include/head.jsp" %>
  <%@ include file="../include/css.jsp" %>
  
  <!-- addTabs CSS -->
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/vendor/plugins/addtabs/bootstrap.addtabs.css">
  <style type="text/css">
	body {
	  overflow-y:hidden;  
	}  
  </style>
</head>
<body class="">

  <!-- Start: Main -->
  <div id="main" >

    <!-- Start: Header -->
    <header class="navbar navbar-fixed-top bg-dark">
      <!-- logo -->
      <div class="navbar-branding">
        <a class="navbar-brand" >
          <b>HMS</b> 后台管理平台
        </a>
        <!-- 三功能菜单，位置调整  -->
        <span id="toggle_sidemenu_l" class="ad ad-lines"></span>
      </div>
      
      <ul class="nav navbar-nav navbar-left">
      	<!-- 菜单1 -->
        <li>
          <a class="sidebar-menu-toggle" href="#">
            <span class="ad ad-ruby fs18"></span>
          </a>
        </li>
        <!-- 菜单2 -->
        <!-- <li>
          <a class="topbar-menu-toggle" href="#">
            <span class="ad ad-wand fs16"></span>
          </a>
        </li> -->
        <!-- 全屏 -->
        <li class="hidden-xs">
          <a class="request-fullscreen toggle-active" href="#">
            <span class="ad ad-screen-full fs18"></span>
          </a>
        </li>
      </ul>
	  <!-- 搜索框，不需要 -->
	  <!-- <form class="navbar-form navbar-left navbar-search" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search..." value="Search...">
        </div>
      </form> -->
      <!-- 消息栏 -->
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <span class="ad ad-radio-tower fs18"></span>
          </a>
          <ul class="dropdown-menu media-list w350 animated animated-shorter fadeIn" role="menu">
            <li class="dropdown-header">
              <span class="dropdown-title"> Notifications</span>
              <span class="label label-warning">12</span>
            </li>
            <li class="media">
              <a class="media-left" href="#"> <img src="<%=basePath %>/assets/img/avatars/5.jpg" class="mw40" alt="avatar"> </a>
              <div class="media-body">
                <h5 class="media-heading">Article
                  <small class="text-muted">- 08/16/22</small>
                </h5> Last Updated 36 days ago by
                <a class="text-system" href="#"> Max </a>
              </div>
            </li>
            <li class="media">
              <a class="media-left" href="#"> <img src="<%=basePath %>/assets/img/avatars/2.jpg" class="mw40" alt="avatar"> </a>
              <div class="media-body">
                <h5 class="media-heading mv5">Article
                  <small> - 08/16/22</small>
                </h5> Last Updated 36 days ago by
                <a class="text-system" href="#"> Max </a>
              </div>
            </li>
            <li class="media">
              <a class="media-left" href="#"> <img src="<%=basePath %>/assets/img/avatars/3.jpg" class="mw40" alt="avatar"> </a>
              <div class="media-body">
                <h5 class="media-heading">Article
                  <small class="text-muted">- 08/16/22</small>
                </h5> Last Updated 36 days ago by
                <a class="text-system" href="#"> Max </a>
              </div>
            </li>
            <li class="media">
              <a class="media-left" href="#"> <img src="<%=basePath %>/assets/img/avatars/4.jpg" class="mw40" alt="avatar"> </a>
              <div class="media-body">
                <h5 class="media-heading mv5">Article
                  <small class="text-muted">- 08/16/22</small>
                </h5> Last Updated 36 days ago by
                <a class="text-system" href="#"> Max </a>
              </div>
            </li>
          </ul>
        </li>

        <li class="dropdown">
          <a  class="dropdown-toggle fw600 p15" data-toggle="dropdown" href="#">
            <img src="<%=basePath %>/assets/img/avatars/1.jpg" alt="avatar" class="mw30 br64 mr15">${systemUser.userName }
            <span class="caret caret-tp hidden-xs"></span>
          </a>
          <ul class="dropdown-menu list-group dropdown-persist w250" role="menu">
            <li class="list-group-item">
              <a  class="animated animated-short fadeInUp" href="#">
                <span class="fa fa-envelope"></span> 消息
                <span class="label label-warning">2</span>
              </a>
            </li>
            <li class="list-group-item">
              <a  class="animated animated-short fadeInUp" href="#">
                <span class="fa fa-user"></span> 朋友
                <span class="label label-warning">6</span>
              </a>
            </li>
            <li class="list-group-item">
              <a  class="animated animated-short fadeInUp" href="#">
                <span class="fa fa-gear"></span> 账户设置 </a>
            </li>
            <li class="list-group-item">
              <a  class="animated animated-short fadeInUp" href="#">
                <span class="fa fa-power-off"></span> 退出登录 </a>
            </li>
          </ul>
        </li>
      </ul>
    </header>
    <!-- End: Header -->

    <!-- Start: Sidebar Left左边菜单栏 -->
    <aside id="sidebar_left" class="nano nano-primary affix">

      <!-- Start: Sidebar Left Content -->
      <div class="sidebar-left-content nano-content">

        <!-- Start: Sidebar Header -->
        <header class="sidebar-header">

          <!-- Sidebar Widget - Menu (Slidedown) -->
          <div class="sidebar-widget menu-widget">
            <div class="row text-center mbn">
              <div class="col-xs-4">
                <a href="dashboard.html" class="text-primary" data-toggle="tooltip" data-placement="top" title="Dashboard">
                  <span class="glyphicon glyphicon-home"></span>
                </a>
              </div>
              <div class="col-xs-4">
                <a href="pages_messages.html" class="text-info" data-toggle="tooltip" data-placement="top" title="Messages">
                  <span class="glyphicon glyphicon-inbox"></span>
                </a>
              </div>
              <div class="col-xs-4">
                <a href="pages_profile.html" class="text-alert" data-toggle="tooltip" data-placement="top" title="Tasks">
                  <span class="glyphicon glyphicon-bell"></span>
                </a>
              </div>
              <div class="col-xs-4">
                <a href="pages_timeline.html" class="text-system" data-toggle="tooltip" data-placement="top" title="Activity">
                  <span class="fa fa-desktop"></span>
                </a>
              </div>
              <div class="col-xs-4">
                <a href="pages_profile.html" class="text-danger" data-toggle="tooltip" data-placement="top" title="Settings">
                  <span class="fa fa-gears"></span>
                </a>
              </div>
              <div class="col-xs-4">
                <a href="pages_gallery.html" class="text-warning" data-toggle="tooltip" data-placement="top" title="Cron Jobs">
                  <span class="fa fa-flask"></span>
                </a>
              </div>
            </div>
          </div>

          <!-- Sidebar Widget - Author (hidden)  -->
          <div class="sidebar-widget author-widget hidden">
            <div class="media">
              <a class="media-left" href="#">
                <img src="<%=basePath %>/assets/img/avatars/3.jpg" class="img-responsive">
              </a>
              <div class="media-body">
                <div class="media-links">
                   <a href="#" class="sidebar-menu-toggle">User Menu -</a> <a href="pages_login(alt).html">Logout</a>
                </div>
                <div class="media-author">Michael Richards</div>
              </div>
            </div>
          </div>

          <!-- Sidebar Widget - Search (hidden) -->
          <div class="sidebar-widget search-widget hidden">
            <div class="input-group">
              <span class="input-group-addon">
                <i class="fa fa-search"></i>
              </span>
              <input type="text" id="sidebar-search" class="form-control" placeholder="Search...">
            </div>
          </div>

        </header>
        <!-- End: Sidebar Header -->

        <!-- Start: Sidebar Left Menu -->
        <ul class="nav sidebar-menu">
          <li class="sidebar-label pt20">菜单</li>
          <!-- 一级菜单循环开始  -->
          <c:forEach items="${permissionList }"  var="item1">
          	<c:if test="${item1.list == null }">
          	  <li>
          	    <a onclick="addTab('${item1.permissionCode }','${item1.permissionName }','${item1.permissionUrl }')" href="#">
	              <span class="${item1.permissionStyle }"></span>
	              <span class="sidebar-title">${item1.permissionName }</span>
	            </a>
          	  </li>
          	</c:if>
          	<c:if test="${item1.list != null }">
	          <li>
          	    <a class="accordion-toggle" href="#">
	              <span class="${item1.permissionStyle }"></span>
	              <span class="sidebar-title">${item1.permissionName }</span>
	              <span class="caret"></span>
	            </a>
	            <ul class="nav sub-nav">
		          <!-- 二级菜单循环开始  -->
	              <c:forEach items="${item1.list }"  var="item2">
		          	<c:if test="${item2.list == null }">
		          	  <li>
		          	    <a class="accordion-toggle" onclick="addTab('${item2.permissionCode }','${item2.permissionName }','${item1.permissionUrl }')" href="#">
			              <span class="${item2.permissionStyle }"></span>
			              ${item2.permissionName }
			            </a>
		          	  </li>
		          	</c:if>
		          	<c:if test="${item2.list != null }">
			          <li>
		          	    <a class="accordion-toggle" href="#">
			              <span class="${item2.permissionStyle }"></span>
			              ${item2.permissionName }
			              <span class="caret"></span>
			            </a>
			            <ul class="nav sub-nav">
			              <!-- 三级菜单循环开始  -->
			              <c:forEach items="${item2.list }"  var="item3">
			          	    <li>
			          	      <a class="accordion-toggle" onclick="addTab('${item3.permissionCode }','${item3.permissionName }','${item1.permissionUrl }')" href="#">
				               <%--  <span class="${item3.permissionStyle }"></span> --%>
				                ${item3.permissionName }
				              </a>
			          	    </li>
				          </c:forEach>
				          <!-- 三级菜单循环结束  -->
			            </ul>
		          	  </li>
			        </c:if>
		          </c:forEach>
		          <!-- 二级菜单循环结束  -->
	            </ul>
	          </li>
	        </c:if>
          </c:forEach>
          <!-- 一级菜单循环结束  -->
        </ul>
        <!-- End: Sidebar Menu -->
		<!-- Start: Sidebar Collapse Button -->
		<div class="sidebar-toggle-mini">
		<a href="#">
            <span class="fa fa-sign-out"></span>
          </a>
        </div>
        <!-- End: Sidebar Collapse Button -->

      </div>
      <!-- End: Sidebar Left Content -->

    </aside>
    <!-- End: Sidebar Left -->

    <!-- Start: Content-Wrapper -->
    <section id="content_wrapper">
      <!-- Begin: Content -->
      <div class="col-sm-12" style="padding:0px;">
	       <!-- Nav tabs -->
	       <ul class="nav nav-tabs" id="tabs1" role="tablist">
          </ul>
          <div class="tab-content">
          </div>
      </section>
      <!-- End: Content -->
  </div>
  <!-- End: Main -->

  <!-- BEGIN: PAGE SCRIPTS -->

  <%@ include file="../include/js.jsp" %>
  
  <script src="<%=basePath %>/vendor/plugins/addtabs/bootstrap.addtabs.js"></script>
  
  <script type="text/javascript">

  jQuery(document).ready(function() {

    "use strict";

    // Init Theme Core    
    Core.init();

    // Init Demo JS  
    Demo.init();

  });

  function addTab(id,title,url){
	  if(url.indexOf('http') == -1){
		  url = ".."+url;
      }
	  var tabHeight = $(window).height() - 100;
	  $.addtabs.add({
		  id:id,
	      title:title,
	      url:url,
	      close: true, //是否可以关s闭
	      monitor: 'body', //监视的区域
	      iframe: true, //使用iframe还是ajax
	      iframeHeight: tabHeight, //固定TAB中IFRAME高度,根据需要自己修改
	      target: '.nav-tabs',
	      contextmenu: true, //是否使用右键菜单
	      local: {
	          'refreshLabel': '刷新此标签',
	          'closeThisLabel': '关闭此标签',
	          'closeOtherLabel': '关闭其他标签',
	          'closeLeftLabel': '关闭左侧标签',
	          'closeRightLabel': '关闭右侧标签'
	      },
	      callback: function() { //关闭后回调函数
	      }
	  })
  }

  </script>
  <!-- END: PAGE SCRIPTS -->

</body>

</html>
