package com.mills.rachelpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rachelmills on 24/6/19.
 */
@Controller
public class IndexController {

    @RequestMapping({"", "/", "index.html"})
    public String index() {
        return "index";
    }
}
