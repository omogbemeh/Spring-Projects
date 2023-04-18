package dev.praiseo.ticketmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public Map<String, String> displayWelcom() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("result", "aloha");
        return map;
    }
}
