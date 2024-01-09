package com.example.chattingtest.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity(name = "chat_message")
public class ChatMessage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long chattingId;

  @ManyToOne
  @JoinColumn(name = "chatroom_id")
  private ChatRoom chatRoom;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  private String content; //내용

  private LocalDateTime createdAt; //입력 시간
}
