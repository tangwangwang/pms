// 获取项目的根路径
function getRootPath() {
    //获得根目录
    var protocol = window.location.protocol;
    var host = window.location.host;
    var port = window.location.port;
    port = (port === "") ? "80" : port;
    return protocol + "//" + host + ":" + port + "/";
}

function getRootPath(servletContext) {
    if (servletContext.substring(0, 1) === "/") {
        return getRootPath() + servletContext.substring(1);
    } else {
        return getRootPath() + servletContext;
    }
}