package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import apap.tutorial.traveloke.service.RoleService;


@Controller
public class PageController{
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("listRole", roleService.getRoleList());
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}