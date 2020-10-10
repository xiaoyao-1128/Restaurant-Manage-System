package jinrui.demo.controller.page.rear;

import com.alibaba.fastjson.JSONObject;
import jinrui.demo.model.dto.BaseResultStatus;
import jinrui.demo.model.dto.ResultData;
import jinrui.demo.model.entity.User;
import jinrui.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: jiaRu
 * @Date: 2020/10/2 15:40
 */
@Controller
@RequestMapping("/page/rear")
public class Register {

    @Resource
    private UserService userService;

    /**
     * 注册账户
     * @param  user
     * @return 1成功     2账户或者手机号重复  3：error
     */
    @GetMapping("/register")
    @ResponseBody
    public JSONObject register(User user){
        JSONObject jsonObject = new JSONObject();
        if(canNotRegister(user)){
            jsonObject.put("message", "注册信息不完善，清重新填写！");
            return jsonObject;
        }
        /*            插入操作。。。。。。。。。                  */
        int code = userService.register(user);
        System.out.println("=========="+code);
        switch (code){
            case 1 : jsonObject.put("message", BaseResultStatus.SUCCESS.getMessage()); break;
            case 2 :
            case 3 :
                jsonObject.put("message", BaseResultStatus.REPEAT.getMessage()); break;
            default: jsonObject.put("message", BaseResultStatus.ERROR.getMessage()); break;
        }
        return jsonObject;
    }

    /**
     *
     * @param user ..
     * @return 如果账号和手机号同时没有 ，或者没有输入密码，那么就无法注册
     */
    private boolean canNotRegister(User user){
        return (user.getAccount() == null && user.getPhoneNumber() == null) || user.getPassword() == null;
    }
}
