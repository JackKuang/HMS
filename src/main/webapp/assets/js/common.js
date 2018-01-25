function showPNotify(data){
	var type;
	var title;
	if(data.success){
		type = "success";
		title = "成功";
	}else{
		type = "error";
		title = "失败";
	}
	new PNotify({
	    title: title,
	    text: data.msg,
	    type: type,
		delay: 1000
	});
}