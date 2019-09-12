var websocket = null;
$(function () {
    var host = window.location.host;
    var port = window.location.port;
    port = (port === "") ? "80" : port;
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://" + host + ":" + port + "/websocket/webSocket");
    } else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://" + host + ":" + port + "/websocket/webSocket");
    } else {
        websocket = new SockJS("http://" + host + ":" + port + "/websocket/socketJS");
    }
    // 连接建立时触发【绑定默认方法, 需要更改请重新绑定方法】
    websocket.onopen = onOpen;
    // 客户端接收服务端数据时触发【绑定默认方法, 需要更改请重新绑定方法】
    websocket.onmessage = onMessage;
    // 通信发生错误时触发【绑定默认方法, 需要更改请重新绑定方法】
    websocket.onerror = onError;
    // 连接关闭时触发【绑定默认方法, 需要更改请重新绑定方法】
    websocket.onclose = onClose;

    function onOpen(openEvt) {
        console.log("[websocket]开启连接.");
    }

    function onMessage(evt) {
        console.log("[websocket]收到消息:" + evt.data)
    }

    function onError() {
        console.log("[websocket]通信发生错误.");
    }


    function onClose() {
        console.log("[websocket]关闭连接.");
    }
    // 当窗口关闭后，断开websocket连接.
    window.close = function () {
        websocket.onclose();
    };
});
