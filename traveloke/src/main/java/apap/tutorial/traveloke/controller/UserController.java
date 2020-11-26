package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/updatePassword")
    public String changePasswordForm(
    ){
        return "form-update-password";
    }

    @PostMapping("/passwordUpdated")
    public String changePasswordFormSubmit(
            @RequestParam(value = "passwordLama") String passwordLama,
            @RequestParam(value = "passwordBaru") String passwordBaru,
            @RequestParam(value = "konfirmasiPassword") String konfirmasiPassword,
            Model model
    ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UserModel user = userService.getUserByUsername(username);
        String pass = user.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean passValid = passwordEncoder.matches(passwordLama, pass);
        if (passValid){
            if (passwordBaru.equals(konfirmasiPassword)) {
                userService.userUpdatedPassword(user, passwordBaru);
                return "password-updated";
            }
        }
        return "password-update-error";
    }
}