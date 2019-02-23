package com.huiketong.catshopkeeper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    /**
     * 404页面
     */
    @RequestMapping(value = "/404")
    public String error_404() {
        return "error/error_404";
    }

    /**
     * 500页面
     */
    @RequestMapping(value = "/500")
    public String error_500() {

        return "error/error_500";
    }

}
