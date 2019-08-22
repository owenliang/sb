package cc.yuerblog.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {
    @RequestMapping("/")
    public String index(ModelMap model) {
        model.addAttribute("content", "this is thymeleaf");

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        model.addAttribute("list", list);

        return "index";
    }
}
