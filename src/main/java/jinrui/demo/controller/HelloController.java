package jinrui.demo.controller;

import jinrui.demo.dao.UserDao;
import jinrui.demo.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author DELL
 */
@Controller
public class HelloController {

    @Resource
    UserDao userDao;

    @RequestMapping("/")
    @ResponseBody
    public User world(){
        User user = userDao.selectByPrimaryKey(1);
        return  user;
    }
}