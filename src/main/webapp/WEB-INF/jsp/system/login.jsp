<%@ page language="java" isThreadSafe="true" pageEncoding="utf-8" %>  
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
</head>

<body class="external-page sb-l-c sb-r-c">

  <!-- Start: Main -->
  <div id="main" class="animated fadeIn">

    <!-- Start: Content-Wrapper -->
    <section id="content_wrapper">

      <!-- begin canvas animation bg -->
      <div id="canvas-wrapper">
        <canvas id="demo-canvas"></canvas>
      </div>

      <!-- Begin: Content -->
      <section id="content">

        <div class="admin-form theme-info mw500" id="login">

          <!-- Login Logo -->
          <div class="row table-layout">
            <a href="" title="">
              <img src="../assets/img/logos/logo.png" title="AdminDesigns Logo" class="center-block img-responsive" style="max-width: 275px;">
            </a>
          </div>

          <!-- Login Panel/Form -->
          <div class="panel mt30 mb25">

            <form method="post" action="<%=basePath %>/system/login " id="contact">
              <div class="panel-body bg-light p25 pb15">
                <!-- UsernameInput -->
                <div class="section">
                  <label for="username" class="field-label text-muted fs18 mb10">用户名</label>
                  <label for="username" class="field prepend-icon">
                    <input type="text" name="username" id="username" class="gui-input" placeholder="请输入用户名">
                    <label for="username" class="field-icon">
                      <i class="fa fa-user"></i>
                    </label>
                  </label>
                </div>

                <!-- Password Input -->
                <div class="section">
                  <label for="username" class="field-label text-muted fs18 mb10">密码</label>
                  <label for="password" class="field prepend-icon">
                    <input type="password" name="password" id="password" class="gui-input" placeholder="请输入密码">
                    <label for="password" class="field-icon">
                      <i class="fa fa-lock"></i>
                    </label>
                  </label>
                </div>

              </div>

              <div class="panel-footer clearfix">
                <button type="submit" class="button btn-primary mr10 pull-right">登录</button>
                <label class="switch ib switch-primary mt10">
                  <input type="checkbox" name="remember" id="remember" checked="">
                  <label for="remember" data-on="是" data-off="否"></label>
                  <span>记住我</span>
                </label>
              </div>

            </form>
          </div>

          <!-- Registration Links -->
          <!-- <div class="login-links">
            <p>
              <a href="http://admindesigns.com/demos/admin/theme/pages_login-alt.html" class="active" title="Sign In">Forgot Password?</a>
            </p>
            <p>Haven't yet Registered?
              <a href="http://admindesigns.com/demos/admin/theme/pages_login-alt.html" title="Sign In">Sign up here</a>
            </p>
          </div> -->

          <!-- Registration Links(alt) -->
          <!-- <div class="login-links hidden">
            <a href="pages_forgotpw(alt).html" class="active" title="Sign In">Sign In</a> |
            <a href="pages_register(alt).html" class="" title="Register">Register</a>
          </div> -->

        </div>

      </section>
      <!-- End: Content -->

    </section>
    <!-- End: Content-Wrapper -->

  </div>
  <!-- End: Main -->

  <!-- BEGIN: PAGE SCRIPTS -->

  <%@ include file="../include/js.jsp" %>
  
  
  <!-- CanvasBG Plugin(creates mousehover effect) -->
  <script src="<%=basePath %>/vendor/plugins/canvasbg/canvasbg.js"></script>
  <script src="<%=basePath %>/vendor/plugins/sha/sha512.js"></script>
  <script src="<%=basePath %>/vendor/plugins/jsencrypt/jsencrypt.min.js"></script>

  <!-- Page Javascript -->
  <script type="text/javascript">
  jQuery(document).ready(function() {

    "use strict";

    // Init Theme Core      
    Core.init();

    // Init Demo JS
    Demo.init();

    // Init CanvasBG and pass target starting location
    CanvasBG.init({
      Loc: {
        x: window.innerWidth / 2,
        y: window.innerHeight / 3.3
      },
    });
  });
  
  </script>

  <!-- END: PAGE SCRIPTS -->

</body>

</html>
