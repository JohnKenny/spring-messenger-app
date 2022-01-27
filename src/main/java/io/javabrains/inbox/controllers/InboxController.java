package io.javabrains.inbox.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.oauth2.core.user.OAuth2User;


@Controller
public class InboxController {

    
    @GetMapping(value = "/")
    public String homePage(@AuthenticationPrincipal OAuth2User principal) {
        if(principal == null || !StringUtils.hasText(principal.getAttribute("login")) ){ // change name to login
            return "index";
        }
        else return "inbox-page";
    }
    
}
