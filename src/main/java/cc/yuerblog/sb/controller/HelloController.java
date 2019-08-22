package cc.yuerblog.sb.controller;

import cc.yuerblog.sb.entity.User;
import cc.yuerblog.sb.mapper.userdb.UserMapper;
import cc.yuerblog.sb.service.ArticleService;
import cc.yuerblog.sb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String Hello() {
        return "Hello world";
    }

    @RequestMapping("/exception")
    public String exception() {
        int a = 2 / 0;
        return "exception";
    }

    @RequestMapping("/getUser")
    public User getUser(int id) {
        User user = userMapper.getUserById(id);
        return user;
    }

    @RequestMapping("/insertUser")
    public String insert(String name, int age) {
        userMapper.insertUser(name, age);
        return "success";
    }

    @RequestMapping("/login")
    public String login() {
        userService.login();
        return "success";
    }

    @RequestMapping("/edit")
    public String edit() {
        articleService.edit();
        return "success";
    }
}
