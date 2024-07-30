package com.platzi.Market;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo")
public class Controller {

    @GetMapping("/hola")
    public String saluda(){
        return "hola ayudame mi codigo no corre";
    }
}
