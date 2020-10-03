package jinrui.demo.controller.page.rear;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jinrui.demo.model.dto.ResultData;
import jinrui.demo.model.entity.User;
import jinrui.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/register")
    @ResponseBody
    public ResultData register(@RequestBody JSONObject param){

        JSONObject userJson = param.getJSONObject("user");
        User user = JSON.toJavaObject(userJson,User.class);

        ResultData resultData;

        if(canNotRegister(user)){
            return  new ResultData(ResultData.error());
        }
        int code = userService.register(user);

        switch (code){
            case 1 : resultData = new ResultData(ResultData.success()); break;
            case 2 :
            case 3 :
                resultData = new ResultData(ResultData.repeat()); break;
            default: resultData = new ResultData(ResultData.error()); break;
        }

        return resultData;
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
