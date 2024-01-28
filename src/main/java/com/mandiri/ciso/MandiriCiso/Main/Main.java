package com.mandiri.ciso.MandiriCiso.Main;

import com.mandiri.ciso.MandiriCiso.Model.User;
import com.mandiri.ciso.MandiriCiso.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class Main {

    @GetMapping("/")
    public String login(Authentication user, Model model) {
        model.addAttribute("name", user.getName());
        model.addAttribute("footer", "Halo ini adalah footer brow!");

        model.addAttribute("userRole", user.getAuthorities().toString());
        return "dashboard";
    }

    private final UserService userService;

    @Autowired
    public Main(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("userList", userService.getList());
        model.addAttribute("siUser", userService.getUser());

        return "dashboard";
    }

    @GetMapping("/register")
    public String register() {
//        userService.newUser(
//                new User(
//                        "Mira",
//                        "mira"
//                )
//        );
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(User user, String alamat, RedirectAttributes redirectAttributes){
        System.out.println(user);
        userService.newUser(user);

        redirectAttributes.addFlashAttribute("success", "Berhasil menambahkan user baru!");

        return "redirect:/dashboard";
    }

}
