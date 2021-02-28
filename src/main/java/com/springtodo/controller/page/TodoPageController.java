package com.springtodo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/page")
public class TodoPageController {

    @RequestMapping(path="/todo", method=RequestMethod.GET)
    public String TodoPage(Model model) {
        return "html/todo";
    }

}
