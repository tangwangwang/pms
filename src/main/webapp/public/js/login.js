$(function () {
    // 注册登录切换
    $("#register").click(function () {
        $("form:first").css("display", "none");
        $("form:first").next().css("display", "");
        $(this).parent().parent().find("strong").css("display", "");
        $(this).parent().css("display", "none");
    });
    $("#login").click(function () {
        $("form:first").css("display", "");
        $("form:first").next().css("display", "none");
        $(this).parent().parent().find("strong").css("display", "");
        $(this).parent().css("display", "none");
    });
    // 验证码对象
    var captcha;
    // 验证码部分
    vaptcha({
        // 配置参数(必选)
        // 验证单元id
        vid: '5d6f4df6fc650e9b80225898',
        // 显示类型 点击式
        type: 'click',
        // 按钮容器，可为Element 或者 selector
        container: '#vaptchaContainer',
        // 可选参数
        // 区域语言: 默认值【】可选值zh-CN,en,zh-TW
        lang: "zh-CN",
        // 协议类型，是否为https: 默认值【false】 布尔类型
        https: false,
        // 验证单元场景: 后台服务器验证时需要与这个一致
        scene: ""
    }).then(function (vaptchaObj) {
        captcha = vaptchaObj;
        // 调用验证实例 vaptchaObj 的 render 方法加载验证按钮
        vaptchaObj.render();
        // obj = vaptchaObj;//将VAPTCHA验证实例保存到局部变量中
        // 验证成功触发, 进行其他操作
        vaptchaObj.listen('pass', function () {
            var token = vaptchaObj.getToken();
            $("#login_captcha").val(token);
            $("#login_captcha-error").html('');
        });
        // 验证弹窗关闭触发
        vaptchaObj.listen('close', function () {
            // 验证失败时
            // _obj.reset(); //重置验证码
        });
    });

    // 登录验证
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#login_form").validate({
        ignore: [],
        rules: {
            username: "required",
            password: "required",
            token: "required"
        },
        messages: {
            username: icon + "请输入用户名",
            password: icon + "请输入密码",
            token: icon + "请进行人机验证"
        },
        submitHandler: function (form) {
            var load = layer.load();
            $.ajax({
                url: 'login'
                , method: "POST"
                , data: $("#login_form").serialize()
                , success: function (data) {
                    layer.close(load);
                    if (data["status"] !== "success") {
                        // 重置验证码
                        layer.msg(data["msg"]);
                        captcha.reset();
                    } else {
                        window.location.href = 'index';
                    }
                }
                , fail: function () {
                    layer.close(load);
                }
                , error: function () {
                    layer.close(load);
                }
            });
        }
    });

});