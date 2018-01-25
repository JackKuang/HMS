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
  <div class="col-xs-12">
	<div class="row text-center">
	  <div class="col-xs-2">
	    <button type="button" class="btn btn-primary btn-block" onclick="addPermission()">添加父菜单</button>
	  </div>
	  <div class="col-xs-2">
	    <button type="button" class="btn btn-info btn-block"  onclick="initTreeGridData()">刷新</button>
	  </div>
	</div>
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
      	<form class="form-horizontal" role="form" data-toggle="validator" action="<%=basePath %>/system/permissions" method="post" id="permissionForm">
	      <div class="panel-body">
	      
	      	 <input type="hidden" id="permissionParCodeInput" name="permissionParCode"/>
	         <div class="form-group">
	            <label for="permissionTitleInput" class="col-lg-3 control-label">菜单名称</label>
	            <div class="col-lg-8">
	              <input type="text" id="permissionNameInput" name="permissionName" class="form-control" placeholder="菜单名称，例如：功能管理" required="124414">
  				  <div class="help-block with-errors"></div>
	            </div>
	          </div>
	          <div class="form-group">
	            <label for="permissionTitleInput" class="col-lg-3 control-label">菜单编码</label>
	            <div class="col-lg-8">
	              <input type="text" id="permissionCodeInput" name="permissionCode" class="form-control" placeholder="菜单编码，例如：功能管理" required="124414">
  				  <div class="help-block with-errors"></div>
	            </div>
	          </div>
	          <div class="form-group">
	            <label for="permissionUrlInput" class="col-lg-3 control-label">菜单路径</label>
	            <div class="col-lg-8">
	              <input type="text" id="permissionUrlInput" name="permissionUrl" pattern="^[_A-z0-9//]{1,}$" class="form-control" placeholder="菜单路径，例如：/system/permissionIndex"
	              required>
  				  <div class="help-block with-errors"></div>
	            </div>
	          </div>
	          <div class="form-group">
	            <label for="permissionStyleInput" class="col-lg-3 control-label">风格</label>
	            <div class="col-lg-8">
	              <input type="text" id="permissionStyleInput" name="permissionStyle" class="form-control" placeholder="风格，例如：fa fa-calendar" >
  				  <div class="help-block with-errors"></div>
	            </div>
	          </div>
	          <div class="form-group">
	            <label for="permissionStyleInput" class="col-lg-3 control-label">排序</label>
	            <div class="col-lg-8">
	              <input type="text" id="permissionOrderInput" name="permissionOrder" class="form-control" placeholder="风格，例如：fa fa-calendar" >
  				  <div class="help-block with-errors"></div>
	            </div>
	          </div>	
	          <div class="form-group">
	            <label class="col-lg-3 control-label" for="permissionDescInput">菜单描述</label>
	            <div class="col-lg-8">
	              <textarea class="form-control textarea-grow" id="permissionDescInput" name="permissionDesc" rows="4" placeholder="菜单描述，例如：用户登录系统所有功能管理"></textarea>
  				  <div class="help-block with-errors"></div>
	            </div>
	          </div>
	        </div>	
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
  
  <script src="<%=basePath %>/vendor/plugins/treegrid/js/jquery.treegrid.js"></script>
  <script src="<%=basePath %>/vendor/plugins/treegrid/js/jquery.treegrid.bootstrap3.js"></script>
  <script src="<%=basePath %>/vendor/plugins/treegrid/extension/jquery.treegrid.extension.js"></script>
  
  <!-- Page Plugins -->
  <script src="<%=basePath %>/vendor/plugins/magnific/jquery.magnific-popup.js"></script>
  <script src="<%=basePath %>/vendor/plugins/validator/bootstrap-validator.js"></script>
  <script src="<%=basePath %>/vendor/plugins/form/jquery.form.js"></script>
  <script src="<%=basePath %>/vendor/plugins/pnotify/pnotify.js"></script>
  <script src="<%=basePath %>/vendor/plugins/confirm/jquery.confirm.min.js"></script>

  <script type="text/javascript">

  var updateFlag = false;
  var permissionUuidGlobal = "";
  
  jQuery(document).ready(function() {
    	initSavePermission();
    	initTreeGridData();
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
  
  function initTreeGridData(){
	  $('#tb').html('');
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
	              title: '菜单编码',
	              field: 'permissionCode',
	              width: 180,
	          },
	          {
	              title: '菜单路径',
	              field: 'permissionUrl',
	              width: 250,
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
	              title: '菜单描述',
	              field: 'permissionDesc',
	              width: 250,
	          },
	          {
	              title: '操作',
	              field: 'permissionCode',
	              formatter: code_formatter,
	              width: 150
	          }
	      ]
	  });
  }
  
  /* formatter start */
  function style_formatter(index,value,row){
	  return '<span class="'+value+'"></span>';
  }

  function code_formatter(index,value,row){
	  var btn = '<div class="btn-group">';
	  btn += '<button type="button" class="btn btn-primary" onclick="addPermission(\''+row.permissionCode+'\')">添加子菜单</button>';
	  btn += '<button type="button" class="btn btn-warning" onclick="updatePermission(\''+row.permissionUuid+'\')">修改</button>';
	  btn += '<button type="button" class="btn btn-danger" onclick="deletePermission(\''+row.permissionUuid+'\')">删除</button>';
	  /* btn += '<button type="button" class="btn btn-info">上移</button>';
	  btn += '<button type="button" class="btn btn-info">下移</button>'; */
	  btn += '</div>';
	  return btn;
  }

  /* formatter end */
  
  /* model operate start */
  //弹窗，新增修改
  
  function addPermission(code){
	  updateFlag = false;
	  $('#permissionForm')[0].reset();
	  if(code == null){
		  $('#permissionTitle').text('添加父菜单');
	  }else{
		  $('#permissionParCodeInput').val(code);
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
  
  function updatePermission(uuid){
	  updateFlag = true;
	  permissionUuidGlobal = uuid;
	  $.ajax({
		    url:'<%=basePath %>/system/permissions/'+uuid,
		    type:'GET', //GET
		    async:true,    //或false,是否异步
		    dataType:'json',
		    success:function(data,textStatus,jqXHR){
			    if(data.success){
					var obj = data.obj;
					$("#permissionNameInput").val(obj.permissionName);
					$("#permissionCodeInput").val(obj.permissionCode);
					$("#permissionUrlInput").val(obj.permissionUrl);
					$("#permissionStyleInput").val(obj.permissionStyle);
					$("#permissionOrderInput").val(obj.permissionOrder);
					$("#permissionDescInput").val(obj.permissionDesc);
					$('#permissionParCodeInput').val(obj.permissionParCode);
					$("#permissionTitle").text("修改菜单");
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
		    }
		})
  }

  function deletePermission(uuid){
	  $.confirm({
	    text: "确定要删除该菜单？",
	    confirm: function() {
		  $.ajax({
			  type: 'delete',
			  url: "<%=basePath %>/system/permissions/"+uuid,
			  success: function(data) {
				  if(data.success){
					  $.magnificPopup.close();
					  initTreeGridData();
				  }
				  showPNotify(data);
			  }
		  });
	    },
	    cancel: function() {
	    }
	});
  }

  //关闭弹窗
  function closePermission(){
	  $('#permissionForm')[0].reset();
	  $.magnificPopup.close();
  }
    
  /* model operate end */

  </script>
  <!-- END: PAGE SCRIPTS -->

</body>

</html>
