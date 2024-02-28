package com.cristian.trocalivrosonline.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping
    public String hello() {
        return "<h1> controller works :D</h1>";
    }
}
