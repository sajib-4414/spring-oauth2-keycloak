package com.springsecure.keycloak_auth;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is public endpoint, no auth needed";
    }

    @GetMapping("/secure")
    public String secureEndpoint(@AuthenticationPrincipal Jwt jwt) {
        return "This is secure endpoint. Hello user: " + jwt.getSubject();
    }
}
