package com.ejercicio1.criss.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrissController {
    @GetMapping("/")
    String hola(){
    return"hola mundo";
    }
}
