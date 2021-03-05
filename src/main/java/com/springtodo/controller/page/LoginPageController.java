package com.springtodo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/page")
public class LoginPageController {

    @RequestMapping(path="/login", method=RequestMethod.GET)
    public String LoginPage(Model model) {
        return "html/login";
    }

}
