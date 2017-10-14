<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8"%>  
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
  

</head>
<body class="">

  <!-- Start: Main -->
  <div id="main">

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
          <a class="request-fullscreen toggle-active" >
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
          <a class="dropdown-toggle" data-toggle="dropdown" >
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
          <a  class="dropdown-toggle fw600 p15" data-toggle="dropdown">
            <img src="<%=basePath %>/assets/img/avatars/1.jpg" alt="avatar" class="mw30 br64 mr15">超级管理员
            <span class="caret caret-tp hidden-xs"></span>
          </a>
          <ul class="dropdown-menu list-group dropdown-persist w250" role="menu">
            <li class="list-group-item">
              <a  class="animated animated-short fadeInUp">
                <span class="fa fa-envelope"></span> 消息
                <span class="label label-warning">2</span>
              </a>
            </li>
            <li class="list-group-item">
              <a  class="animated animated-short fadeInUp">
                <span class="fa fa-user"></span> 朋友
                <span class="label label-warning">6</span>
              </a>
            </li>
            <li class="list-group-item">
              <a  class="animated animated-short fadeInUp">
                <span class="fa fa-gear"></span> 账户设置 </a>
            </li>
            <li class="list-group-item">
              <a  class="animated animated-short fadeInUp">
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
        <ul class="nav sidebar-menu" id="container">
          <li class="sidebar-label pt20">菜单</li>
          <li>
            <a onclick="addTab('sina','新浪','http://sina.com.cn')">
              <span class="fa fa-calendar"></span>
              <span class="sidebar-title">Calendar</span>
            </a>
          </li>
          <li>
            <a onclick="addTab('sina2','新浪2','http://sina.com.cn')">
              <span class="fa fa-calendar"></span>
              <span class="sidebar-title">Calendar</span>
            </a>
          </li>
          <li>
            <a onclick="addTab('sina3','新浪3','http://sina.com.cn')">
              <span class="fa fa-calendar"></span>
              <span class="sidebar-title">Calendar</span>
            </a>
          </li><li>
            <a onclick="addTab('sina4','新浪4','http://sina.com.cn')">
              <span class="fa fa-calendar"></span>
              <span class="sidebar-title">Calendar</span>
            </a>
          </li>
          <li>
            <a class="accordion-toggle" href="#">
              <span class="glyphicon glyphicon-duplicate"></span>
              <span class="sidebar-title">Pages</span>
              <span class="caret"></span>
            </a>
            <ul class="nav sub-nav">
              <li>
                <a class="accordion-toggle" href="#">
                  <span class="fa fa-gears"></span> Utility
                  <span class="caret"></span>
                </a>
                <ul class="nav sub-nav">
                  <li>
                    <a onclick="addTabTest();"> 500 Error </a>
                  </li>
                  <li>
                    <a href="pages_404(alt).html"> 404 Error Alt </a>
                  </li>
                  <li>
                    <a href="pages_500(alt).html"> 500 Error Alt </a>
                  </li>
                </ul>
              </li>
              <li>
                <a class="accordion-toggle" href="#">
                  <span class="fa fa-desktop"></span> Basic
                  <span class="caret"></span>
                </a>
                <ul class="nav sub-nav">
                  <li>
                    <a href="pages_search-results.html">Search Results
                      <span class="label label-xs bg-primary">New</span>
                    </a>
                  </li>
                  <li>
                    <a href="pages_profile.html"> Profile </a>
                  </li>
                  <li>
                    <a href="pages_timeline.html"> Timeline Split </a>
                  </li>
                  <li>
                    <a href="pages_timeline-single.html"> Timeline Single </a>
                  </li>
                  <li>
                    <a href="pages_faq.html"> FAQ Page </a>
                  </li>
                  <li>
                    <a href="pages_calendar.html"> Calendar </a>
                  </li>
                  <li>
                    <a href="pages_messages.html"> Messages </a>
                  </li>
                  <li>
                    <a href="pages_messages(alt).html"> Messages Alt </a>
                  </li>
                  <li>
                    <a href="pages_gallery.html"> Gallery </a>
                  </li>
                </ul>
              </li>
              <li>
                <a class="accordion-toggle" href="#">
                  <span class="fa fa-usd"></span> Misc
                  <span class="caret"></span>
                </a>
                <ul class="nav sub-nav">
                  <li>
                    <a href="pages_invoice.html"> Printable Invoice </a>
                  </li>
                  <li>
                    <a href="pages_blank.html"> Blank </a>
                  </li>
                </ul>
              </li>
            </ul>
          </li>
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

  var tabHeight;
  jQuery(document).ready(function() {

    "use strict";

    // Init Theme Core    
    Core.init();

    // Init Demo JS  
    Demo.init();

    setTabHeight();

  });

  function setTabHeight(){
	  tabHeight = $(window).height() - 60 - 40 - 10;
  }

  function addTab(id,title,url){
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
