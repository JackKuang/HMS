var alertModel = {
	iconType:{
		"success":1,
		"fail":2,
		"question":3,
		"lock":4,
		"smile":5,
		"cry":6,
		"mark":7
	},
	alertData: function(data){
		if(data.success){
			icon = alertModel.iconType["success"];
		}else{
			icon = alertModel.iconType["fail"];
		}
		layer.msg(data.msg, {
			icon: icon,
			time: 3000,
			btn: ['确认']
		});
	},
	alertMsg: function(iconType,msg){
		var icon = alertModel.iconType[iconType];
		layer.msg(msg, {
			icon: icon,
			//1成功，2问号，3错误，4锁，5笑脸，6苦脸，7感叹号
			time: 3000, //20s后自动关闭
			btn: ['确认']
		});
	}
}

var loadingModel = {
	showLoading:function(){
		layer.load();
	},
	hideLoading:function(){
		layer.closeAll('loading');
	}
}

var pageModel = {
	request: {
		pageName: 'pageNum',//页码的参数名称，默认：page
		limitName: 'pageSize' //每页数据量的参数名，默认：limit
	},
	response: {
		statusName: 'code', //数据状态的字段名称，默认：code
		statusCode: 200, //成功的状态码，默认：0
		msgName: 'msg', //状态信息的字段名称，默认：msg
		countName: 'total', //数据总数的字段名称，默认：count
		dataName: 'list' //数据列表的字段名称，默认：data
	} 
}

var formModel = {
	initCheckbox:function(id,url,reqData,key,value,isMuti){
		$.ajax({
			type: 'get',
			url: url,
			data: reqData,
			success: function(data) {
				if(data.success){
					$('#'+id).html('');
					console.log(data);
					var list = data.obj;
					$('#'+id).append("");
					var options = '';
					options += '<option value=""></option>';
					for(var i = 0 ; i < list.length ; i++){
						var row = list[i];
						if(row.selected){
							options += '<option value="'+row[key]+'" selected >'+row[value]+'</option>';
						}else{
							options += '<option value="'+row[key]+'">'+row[value]+'</option>';
						}
					}
					$('#'+id).html(options);
					layui.selMeltiple($);
					/*layui.use(['form', 'jquery'], function(){
					    var form = layui.form;
					    var $ = layui.jquery;
					    layui.selMeltiple($);
					});*/
				}
			}
		});
	}
}

var root = getRootUrl();

function getRootUrl(){
	//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return (localhostPaht + projectName);
}
