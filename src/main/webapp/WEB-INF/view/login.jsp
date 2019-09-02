<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>H+ 后台主题UI框架 - 登录</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/login.css" rel="stylesheet">
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
                    <h1>[ H+ ]</h1>
                </div>
                <div class="m-b"></div>
                <h4>欢迎使用 <strong>H+ 后台主题UI框架</strong></h4>
                <ul class="m-b">
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势一</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势二</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势三</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势四</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势五</li>
                </ul>
                <strong>还没有账号？ <a id="register" href="javascript:">立即注册&raquo;</a></strong>
                <strong style="display: none;">已有账号？ <a id="login" href="javascript:">立即登录&raquo;</a></strong>
            </div>
        </div>
        <div class="col-sm-5">
            <form method="post" action="/login">
                <h4 class="no-margins">登录：</h4>
                <p class="m-t-md">登录到H+后台主题UI框架</p>
                <input name="username" type="text" class="form-control uname" placeholder="用户名"/>
                <input name="password" type="password" class="form-control pword m-b" placeholder="密码"/>
                <a href="">忘记密码了？</a>
                <button type="submit" class="btn btn-success btn-block">登录</button>
            </form>
            <form method="post" action="/login" style="display: none;">
                <h4 class="no-margins">注册：</h4>
                <p class="m-t-md">注册到H+后台主题UI框架</p>
                <input name="username" type="text" class="form-control uname" placeholder="用户名"/>
                <input name="password" type="password" class="form-control pword m-b" placeholder="密码"/>
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

<script src="/js/jquery.min.js"></script>

<script type="text/javascript">
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
</script>
</body>

</html>
