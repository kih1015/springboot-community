package com.kang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ViewController {

    @GetMapping("/introduce")
    public String getHello(@RequestParam(name = "name", required = false, defaultValue = "강인화") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @ResponseBody
    @GetMapping("/json")
    public Map<String, Object> getJson() {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "최준호");
        user.put("age", 25);
        return user;
    }

}
