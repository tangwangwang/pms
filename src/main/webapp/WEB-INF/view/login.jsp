<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>登录</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <link href="css/vaptcha.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>

<body class="signin">
<div class="signinpanel tab-content">
    <div class="row" style="min-height: 400px;">
        <div class="col-sm-7">
            <div class="signin-info">
                <div class="logopanel m-b">
                    <h1>Smile</h1>
                </div>
                <div class="m-b"></div>
                <h4>欢迎登录 <strong>pms</strong></h4>
                <%--<ul class="m-b">
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势一</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势二</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势三</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势四</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势五</li>
                </ul>--%>
                <strong>还没有账号？ <a id="register" href="javascript:">立即注册&raquo;</a></strong>
                <strong style="display: none;">已有账号？ <a id="login" href="javascript:">立即登录&raquo;</a></strong>
            </div>
        </div>
        <div class="col-sm-5">
            <form id="login_form" method="post">
                <h4 class="no-margins">登录：</h4>
                <%--<p class="m-t-md">登录到H+后台主题UI框架</p>--%>
                <input id="login_username" name="username" type="text" class="form-control uname" placeholder="账号/手机号/邮箱"/>
                <label id="login_username-error" class="error login-error" for="login_username">
                </label>
                <input id="login_password" name="password" type="password" class="form-control pword" placeholder="密码" style="margin-top: 20px;"/>
                <label id="login_password-error" class="error login-error" for="login_password">
                </label>
                <!-- 点击式按钮建议高度介于36px与46px  -->
                <!-- 嵌入式仅需设置宽度，高度根据宽度自适应，最小宽度为200px -->
                <!-- 自动初始化使用添加属性: data-config='{"vid": "5d6f4df6fc650e9b80225898","type": "click"}' -->
                <div id="vaptchaContainer" class="vaptcha-container" style="width: 233px; height: 34px; margin-top: 20px;">
                    <!--vaptcha-container是用来引入VAPTCHA的容器，下面代码为预加载动画，仅供参考-->
                    <div class="vaptcha-init-main">
                        <div class="vaptcha-init-loading">
                            <a href="javascript:;" target="_blank">
                                <img src="https://cdn.vaptcha.com/vaptcha-loading.gif"/>
                            </a>
                            <span class="vaptcha-text">人机验证启动中...</span>
                        </div>
                    </div>
                </div>
                <input type="hidden" id="login_captcha" name="token"/>
                <label id="login_captcha-error" class="error login-error" for="login_captcha">
                </label>
                <div style="margin-top: 20px;">
                    <a href="">忘记密码了？</a>
                </div>
                <button type="submit" id="login_button" class="btn btn-success btn-block">登录</button>
            </form>
            <form method="post" action="/login" style="display: none;">
                <h4 class="no-margins">注册：</h4>
                <p class="m-t-md">注册到H+后台主题UI框架</p>
                <input name="username" type="text" class="form-control uname" placeholder="用户名"/>
                <input name="password" type="password" class="form-control pword m-b" placeholder="密码"/>
                <input type="checkbox" class="checkbox" id="agree" name="agree"> 我已经认真阅读并同意《使用协议》
                <button type="submit" class="btn btn-success btn-block">注册</button>
            </form>
        </div>
    </div>

    <div class="signup-footer">
        <div class="pull-left">
            &copy; 2015 All Rights Reserved. H+
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
<!-- layerUI -->
<script src="js/plugins/layer/layer.min.js"></script>
<!-- jQuery Validation plugin javascript-->
<script src="js/plugins/validate/jquery.validate.min.js"></script>
<script src="js/plugins/validate/messages_zh.min.js"></script>
<!-- 自定义的 JS -->
<script src="js/login.js" charset="UTF-8"></script>
<script src="js/common.js" charset="UTF-8"></script>
<!-- 点击式验证码JS -->
<script src="js/plugins/vaptcha.v2.js" charset="UTF-8"></script>
</body>

</html>
