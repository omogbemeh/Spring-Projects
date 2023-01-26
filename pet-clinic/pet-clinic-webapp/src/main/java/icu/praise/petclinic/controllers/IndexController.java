package icu.praise.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "/", "index", "index.html"})
public class IndexController {
    @GetMapping
    public String displayIndexPage() {
        return "index";
    }
}
