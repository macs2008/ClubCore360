package com.clubcore360.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class EscuelaForwardController {

    @GetMapping(value = "/{slug}", produces = "text/html")
    public String forwardToAngular(@PathVariable("slug") String slug, HttpServletRequest request) {
        if ("escuela".equals(slug)) {
            return "forward:/index.html";
        }
        return "forward:/index.html";
    }
}