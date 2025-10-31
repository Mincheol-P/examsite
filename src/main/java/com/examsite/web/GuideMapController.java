package com.examsite.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuideMapController {

    @GetMapping("/guidemap")
    public String guideMap(Model m) {
        m.addAttribute("title", "오시는 길");
        return "guidemap/guidemap"; // templates/guidemap/guidemap.mustache
    }
}
