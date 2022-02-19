package io.javabrains.inbox.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import io.javabrains.inbox.folders.Folder;
import io.javabrains.inbox.folders.FolderRepository;

import org.springframework.security.oauth2.core.user.OAuth2User;


@Controller
public class InboxController {

    @Autowired
	private FolderRepository folderRepository;
 
    @GetMapping(value = "/")
    public String homePage(@AuthenticationPrincipal OAuth2User principal, Model model) {
        System.out.println(principal);
        if(principal == null || !StringUtils.hasText(principal.getAttribute("login")) ){ // change name to login
            return "index";
        }
        
        int userId = principal.getAttribute("id");
        List<Folder> userFolders = (List<Folder>) folderRepository.findAllById(userId);
        model.addAttribute("userFolders", userFolders);
        return "inbox-page";
    }
    
}
