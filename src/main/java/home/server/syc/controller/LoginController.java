package home.server.syc.controller;

import home.server.syc.domain.MemberEntity;
import home.server.syc.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MemberService service;

    @GetMapping("/login")
    public String login() {
        logger.info("login() called");
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@ModelAttribute MemberEntity vo, Model model) {
        logger.info("loginPost() called");
        try{
            service.read(vo);
        }catch (Exception e){
            model.addAttribute("error", "로그인 실패");
            return "login";
        }
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String register() {
        logger.info("register() called");
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute MemberEntity vo, Model model) {
        logger.info("registerPost() called");
        try{
            service.create(vo);
        }catch (Exception e){
            model.addAttribute("error", "가입 실패");
            return "register";
        }
        return "login";
    }
}
