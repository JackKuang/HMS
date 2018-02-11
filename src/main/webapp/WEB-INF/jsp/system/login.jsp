<%@ page language="java" isThreadSafe="true" pageEncoding="utf-8" %>  
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
  <title>HMS 后台管理平台</title>
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

  <!-- Admin Forms CSS -->
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/assets/admin-tools/admin-forms/css/admin-forms.css">
  
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
              <img src="../assets/img/logos/logo.png" title="HMS Logo" class="center-block img-responsive" style="max-width: 275px;">
            </a>
          </div>

          <!-- Login Panel/Form -->
          <div class="panel mt30 mb25">
            <form method="post" action="<%=basePath %>/system/login " id="contact">
              <div class="panel-body bg-light p25 pb15">
              	<c:if test="${error != null }">
	                <div class="section">
	                	<div class="alert alert-danger alert-border-left alert-dismissable mv30">
	                	  <b>${error }</b>
	                	</div>
	                </div>
                </c:if>
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
                <!-- 涉及权限问题，cookie被盗 -->
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

  <!-- jQuery -->
  <script src="<%=basePath %>/vendor/jquery/jquery-1.11.1.min.js"></script>
  <script src="<%=basePath %>/vendor/jquery/jquery_ui/jquery-ui.min.js"></script>
    
  <!-- Theme Javascript -->
  <script src="<%=basePath %>/assets/js/utility/utility.js"></script>
  <script src="<%=basePath %>/assets/js/demo/demo.js"></script>
  <script src="<%=basePath %>/assets/js/main.js"></script>
  
  <!-- CanvasBG Plugin(creates mousehover effect) -->
  <script src="<%=basePath %>/vendor/plugins/canvasbg/canvasbg.js"></script>
  <script src="<%=basePath %>/vendor/plugins/sha/sha512.js"></script>
  <script src="<%=basePath %>/vendor/plugins/jsencrypt/jsencrypt.min.js"></script>
  
  <!-- Page Javascript -->
  <script type="text/javascript">
  var publicKey = "${publicKey}";
  jQuery(document).ready(function() {

    "use strict";

    // Init Theme Core      
    Core.init();

    // Init Demo JS
    Demo.init();

    initForm();
    
    // Init CanvasBG and pass target starting location
    CanvasBG.init({
      Loc: {
        x: window.innerWidth / 2,
        y: window.innerHeight / 3.3
      },
    });
  
  });
  function initForm(){
	  //密码加密方案
	    $('#login').on('submit', function(e) {
	      //阻止元素发生默认的行为
	      //e.preventDefault;
	      //alert('Your form has submitted!');

	      //hash加密
	      var shaObj = new jsSHA("SHA-512", "TEXT");
	      var password = $("#password").val();
	      //salt
//	      alert(password)
	      shaObj.update(password);
//	      shaObj.update("HMS");
	      var hash = shaObj.getHash("HEX");
	      //$('#password').val(hash);
	      //RSA加密
//	      alert(hash)
	      var encrypt = new JSEncrypt();
//	      alert(publicKey)
	      //公钥
	      encrypt.setPublicKey(publicKey);
	      var encrypted = encrypt.encrypt(hash);
	      $('#password').val(encrypted);
	      return true;
	    });
	  }
  
  </script>

  <!-- END: PAGE SCRIPTS -->

</body>

</html>
