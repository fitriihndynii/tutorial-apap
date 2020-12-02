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

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
        int passValid = 0;
        boolean userValid = true;
        String username = user.getUsername();
        List<UserModel> listUser = userService.getListUser();
        for (int i =0; i<listUser.size(); i++){
            if(!(username.equals(listUser.get(i).getUsername()))){
                userValid = false;
            }
        }
        if(userValid && user.getPassword().length() >= 8) {
            boolean angka = false;
            boolean huruf = false;
            char[] charPass = user.getPassword().toCharArray();
            for (int i = 0; i < user.getPassword().length(); i++) {
                char ch = charPass[i];
                if (ch >= 'a' && ch <= 'z') {
                    huruf = true;
                } else if (!(ch >= 'a' && ch <= 'a')) {
                    angka = true;
                }
            }
            if (angka && huruf) {
                passValid = 1;
                userService.addUser(user);
            }else{
                passValid = 2;
            }
        }else{
            return "error-username";
        }
        model.addAttribute("passValid", passValid);
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
            if(passwordBaru.length() >= 8){
                boolean angka = false;
                boolean huruf = false;
                char[] charPass = passwordBaru.toCharArray();
                for(int i = 0; i< passwordBaru.length(); i++){
                    char ch = charPass[i];
                    if(ch >= 'a' && ch <= 'z'){
                        huruf = true;
                    }
                    else if(!(ch >= 'a' && ch <= 'a')){
                        angka = true;
                    }
                }
                if (angka && huruf && passwordBaru.equals(konfirmasiPassword)) {
                    userService.userUpdatedPassword(user, passwordBaru);
                    return "password-updated";
                }
            }
        }
        return "password-update-error";
    }
}