package com.example.chattingtest.controller;

import com.example.chattingtest.entity.User;
import com.example.chattingtest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ChatController {

  private final UserRepository userRepository;

  @GetMapping("/chat")
  public String chatGet(@RequestParam(value = "u", required = false, defaultValue = "0") Long userId, Model model) {
    User user = userRepository.findById(userId)
        .orElse(new User(-1L, "none"));
    log.info("chat start USER: {}", user.getUsername());
    model.addAttribute("name", user.getUsername());
    return "chat";
  }
}
