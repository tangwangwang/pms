package com.fyj.pms.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author T2W
 * @version V1.0.0
 * @email tang.wangwang@qq.com
 * @date 2019-09-10 20:52
 * @name com.fyj.pms.handler.WebSocketHandler.java
 * @see describing WebSocket 处理器
 */
@Slf4j
@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>(100);

    /**
     * @see describing 建立连接后触发
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.debug("建立连接");
        users.put(session.getAttributes().get("userId").toString(), session);
        super.afterConnectionEstablished(session);
    }

    /**
     * @see describing js调用 websocket.send 时触发
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        log.debug("收到消息:{}", message);
        // TODO 可以在这里把消息发送给目标人、把消息存入缓存等

        super.handleMessage(session, message);
    }

    /**
     * @see describing 传输发生异常时触发
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.debug("发生异常");
        // TODO 可以在这里提示发送消息者发送失败

        super.handleTransportError(session, exception);
    }

    /**
     * @see describing 断开连接后触发
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.debug("断开连接");
        // TODO 可以将该用户的Session移除，不能再向该用户发送任何消息

        users.remove(session.getAttributes().get("userId"));
        super.afterConnectionClosed(session, status);
    }


    @Override
    public boolean supportsPartialMessages() {
        return super.supportsPartialMessages();
    }

    /**
     * @param userId  接收消息的用户ID
     * @param message 消息信息
     * @date 2019-09-11 10:19
     * @see describing 向某个用户发送消息
     */
    public void sendMessage(Object userId, TextMessage message) {
        try {
            WebSocketSession user = users.get(userId.toString());
            if (user != null && user.isOpen()) {
                user.sendMessage(message);
            }
        } catch (Exception e) {
            log.error("单发消息失败, 用户ID:{}, 消息:{}, 异常:{}", userId, message, e.toString());
        }
    }

    /**
     * @param message 消息信息
     * @date 2019-09-11 10:20
     * @see describing 向所有用户发送消息
     */
    public void sendMessage(TextMessage message) {
        for (String userId : users.keySet()) {
            try {
                WebSocketSession user = users.get(userId);
                user.sendMessage(message);
            } catch (Exception e) {
                log.error("群发消息失败, 用户ID:{}, 消息:{}, 异常:{}", userId, message, e.toString());
            }
        }
    }

}
