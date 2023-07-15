package br.com.lucasmancan.medtech.api.infraestructure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("public")
@RestController
public class Public {

    @ResponseBody
    @GetMapping("")
    public String getMessage() {
        return "OK";
    }
}
