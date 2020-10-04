package jinrui.demo.controller;

import jinrui.demo.dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;

/**
 * @author DELL
 */
@Controller
public class HelloController {


    @RequestMapping("/")
    public String world(){
        return "index";
    }
}