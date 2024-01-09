package com.example.chattingtest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/ws")
        .setAllowedOriginPatterns("*")
        .withSockJS();
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    // 서버 -> 클라이언트로 발행하는 메시지에 대한 endpoint 설정 : 구독
    registry.enableSimpleBroker("/sub");

    // 클라이언트 -> 서버로 발행하는 메시지에 대한 endpoint 설정 : 구독에 대한 메시지
    registry.setApplicationDestinationPrefixes("/pub");

  }
}
