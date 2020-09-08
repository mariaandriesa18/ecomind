package ro.utcn.project.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/articles")
public class ArticlesController {

    @GetMapping
    public ModelAndView getArticlesPage(ModelAndView modelAndView){
        return modelAndView;
    }
}
