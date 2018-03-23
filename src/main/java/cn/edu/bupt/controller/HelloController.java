package cn.edu.bupt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CZX on 2018/3/23.
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String index(){
        return "welcome";
    }
}
