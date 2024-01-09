package com.example.chattingtest.service;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
public class ChatHandler extends TextWebSocketHandler {

  private static List<WebSocketSession> list = new ArrayList<>();

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    String payload = message.getPayload(); // 페이로드 : 전송되는 순수한 데이터
    log.info("payload: {}", payload);

    for(WebSocketSession sess : list){
      sess.sendMessage(message);
    }
  }

  /**
   * Client가 접속 시 호출되는 메서드
   */
  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception{
    list.add(session);
    log.info("client: {} 접속",session);
  }

  /**
   * Client가 접속 해제시 호출되는 메서드
   */
  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    log.info("client: {} 접속 해제", session);
    list.remove(session);
  }
}
