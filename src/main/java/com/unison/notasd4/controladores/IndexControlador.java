package com.unison.notasd4.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class IndexControlador {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}