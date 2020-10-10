package jinrui.demo.controller.page.front;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import jinrui.demo.model.dto.BaseResultStatus;
import jinrui.demo.model.entity.User;
import jinrui.demo.service.TokenService;
import jinrui.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: jiaRu
 * @Date: 2020/10/10 16:47
 */
@RestController
@RequestMapping("/page/front")
public class GetVerificationCode {

    @Resource
    private UserService userService;
    @Autowired
    TokenService tokenService;


    @ApiOperation(value = "登陆", notes = "登陆")
    @GetMapping("/getVerificationCode")
    @ResponseBody
    public JSONObject test(@RequestParam String phoneNumber, HttpServletResponse response){
        //用户选择使用验证码登录,发送验证码到所填手机号上
        if(phoneNumber == null){
            return (JSONObject) new JSONObject().put("message",BaseResultStatus.ERROR);
        }

        String verificationCode = String.valueOf((int)((Math.random()*9+1)*1000));
        /*
         * 未完成的发送验证码的部分
         *
         * */
        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.findUserByPhoneNumber(phoneNumber);
        userForBase.setRemark(verificationCode);
        jsonObject.put("message", BaseResultStatus.SUCCESS.getMessage());
        jsonObject.put("手机号", phoneNumber);
        jsonObject.put("验证码",verificationCode);

        String token = tokenService.getTokenForVerificationCode(userForBase);
        jsonObject.put("token", token);
        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/");
        response.addCookie(cookie);

        return jsonObject;
    }
}
