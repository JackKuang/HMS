<%@ page language="java" isThreadSafe="true" pageEncoding="utf-8"%>
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
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>HMS-后台管理系统</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">

<style rel="stylesheet" type="text/css">
    .layui-tab-title li:first-child > i {
        display: none;
    }
</style>

<link rel="stylesheet" type="text/css"
	href="<%=basePath %>/layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo" id="navSorH">HMS-后台管理系统</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<!-- <ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">控制台</a></li>
				<li class="layui-nav-item"><a href="">商品管理</a></li>
				<li class="layui-nav-item"><a href="">用户</a></li>
			</ul> -->
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img">admin
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全退出</a>
						</dd>
					</dl></li>
			</ul>
		</div>
		
		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="left-menu">
					<c:forEach items="${permissionList }"  var="item1">
			          	<c:if test="${item1.list == null }">
			          		<li class="layui-nav-item">
			          			<a href="javascript:addTab('${item1.permissionUuid }','${item1.permissionName }','${item1.permissionUrl }')">${item1.permissionName }</a>
			          		</li>
			          	</c:if>
			          	<c:if test="${item1.list != null }">
			          		<li class="layui-nav-item"><a href="javascript:;">${item1.permissionName }</a>
				          		<dl class="layui-nav-child">
									<!-- 二级菜单循环开始  -->
									<c:forEach items="${item1.list }"  var="item2">
							          	<dd id="${item2.permissionUuid }" name="${item2.permissionUrl }">
											<a href="javascript:;" >${item2.permissionName }</a>
										</dd>
						          </c:forEach>
					          </dl>
			          		</li>
				        </c:if>
			          </c:forEach>
				</ul>
			</div>
		</div>
			
		<div class="layui-body" style="bottom: 0px;">
	        <div style="padding-left: 15px">
	            <!-- 内容主体区域 -->
	            <div class="layui-tab" lay-allowClose="true" lay-filter="tab-switch">
	                <ul class="layui-tab-title">
	                    <li class="layui-this" >首页</li>
	                </ul>
	                <div class="layui-tab-content">
	                    <div class="layui-tab-item layui-show">
	                		<p>这里是首页！</p>
	                	</div>
	                </div>
	            </div>
	        </div>
	    </div>
		
		<!-- <div class="layui-footer">
    底部固定区域
    © layui.com - 底部固定区域
  </div> -->
	</div>
	<script src="<%=basePath %>/layui/layui.js" charset="utf-8"></script>
	<script>
	//JavaScript代码区域
	var element;
	var $;
	var i;
	layui.use(['element','jquery'],function(){
	    element = layui.element;
	    $ = layui.jquery;
	    i = 0;
	    $('#navSorH').click(function(){
			if(i==0){
				$(".layui-side").animate({width:'0px'});
				$(".layui-body").animate({left:'0px'});
				i++;
			}else{
				$(".layui-side").animate({width:'200px'});
				$(".layui-body").animate({left:'200px'});
				i--;
			}		

		});	
	    //监听左侧菜单点击
	    element.on('nav(left-menu)', function(elem){
	        addTab(elem[0].innerText,elem[0].attributes[1].nodeValue,elem[0].id);
	    });
	});
	/**
	 * 新增tab选项卡，如果已经存在则打开已经存在的，不存在则新增
	 * @param tabTitle 选项卡标题名称
	 * @param tabUrl 选项卡链接的页面URL
	 * @param tabId 选项卡id
	 */
	function addTab(tabTitle,tabUrl,tabId){
	    if ($(".layui-tab-title li[lay-id=" + tabId + "]").length > 0) {
	        element.tabChange('tab-switch', tabId);
	    }else{
	        element.tabAdd('tab-switch', {
	            title: tabTitle
	            ,content: '<iframe src=<%=basePath %>'+tabUrl+' width="100%" style="min-height: 800px" frameborder="0" scrolling="auto" onload="setIframeHeight(this)"></iframe>' // 选项卡内容，支持传入html
	            ,id: tabId //选项卡标题的lay-id属性值
	        });
	        element.tabChange('tab-switch', tabId); //切换到新增的tab上
	    }
	}
	
	/**
	 * ifrme自适应页面高度，需要设定min-height
	 * @param iframe
	 */
	function setIframeHeight(iframe) {
	    if (iframe) {
	        var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
	        if (iframeWin.document.body) {
	            iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
	        }
	    }
	};
		
	</script>
</body>
</html>
