package ac.kr.jejunu.web;

import ac.kr.jejunu.common.entity.User;
import ac.kr.jejunu.common.domain.LoginUserDetails;
import ac.kr.jejunu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Boobby on 17-5-19.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/mypage", produces = "text/html")
    public String mypage(@AuthenticationPrincipal LoginUserDetails userDetails) {
        return "mypage";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "/registerProcessing", method = RequestMethod.POST)
    public String registerProcessing(@ModelAttribute("user") User user) {

        userService.register(user);

        return "redirect:/login";
    }
}
