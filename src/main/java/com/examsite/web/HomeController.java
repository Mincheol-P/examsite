package com.examsite.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.Year;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("title", "홈");
        m.addAttribute("year", Year.now().getValue());
        return "index";
    }
}
