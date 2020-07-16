package com.yxl.magicbox.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
    public void hello(){
        boolean b = StringUtils.isEmpty("");
        System.out.println(b);
    }

}
