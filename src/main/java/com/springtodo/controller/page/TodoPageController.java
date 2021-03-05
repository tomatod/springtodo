package com.springtodo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoPageController {

    @RequestMapping(path="/page/todo", method=RequestMethod.GET)
    public String TodoPage(Model model) {
        return "html/todo";
    }

    @RequestMapping(path="/", method=RequestMethod.GET)
    public String RedirectTodoPage(Model model) {
        return "redirect:/page/todo";
    }

}
