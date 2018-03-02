layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;

    //登录按钮
    form.on("submit(login)",function(data){
        $(this).text("登录中...").addClass("layui-disabled");
        var shaObj = new jsSHA("SHA-512", "TEXT");
        var password = $("#password").val();
        shaObj.update(password);
        var hash = shaObj.getHash("HEX");
        var encrypt = new JSEncrypt();
        var publicKey = $('#publicKey').val();
        encrypt.setPublicKey(publicKey);
        var encrypted = encrypt.encrypt(hash);
        $('#passwordEncrypt').val(encrypted);
        return true;
    })

    //表单输入效果
    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() != ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    })
})
