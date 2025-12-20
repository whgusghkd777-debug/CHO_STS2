package com.mysite.sbb.music.controller;  // 너의 패키지 경로에 맞게 수정

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @GetMapping("/api/current-user")
    public Map<String, Object> currentUser(Authentication auth) {
        Map<String, Object> response = new HashMap<>();
        
        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getName())) {
            response.put("username", auth.getName());
            // 만약 UserDetails에 nickname이 있다면 여기서 추가 가능
            // 예: UserDetails userDetails = (UserDetails) auth.getPrincipal();
            //     response.put("nickname", userDetails.getNickname());  // 닉네임 있으면
        } else {
            response.put("username", null);
        }
        
        return response;
    }
}