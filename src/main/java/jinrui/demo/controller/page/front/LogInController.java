package jinrui.demo.controller.page.front;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import io.swagger.annotations.ApiOperation;
import jinrui.demo.annotation.UserLoginToken;
import jinrui.demo.model.dto.BaseResultStatus;
import jinrui.demo.model.entity.User;
import jinrui.demo.service.TokenService;
import jinrui.demo.service.UserService;
import jinrui.demo.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: jiaRu
 * @Date: 2020/10/2 10:37
*/

@RestController
@RequestMapping("/page/front")
public class LogInController {
    @Resource
    private UserService userService;
    @Autowired
    TokenService tokenService;

    /**
     *          登录
     *         返回使用jsonObject
     * @param  account 账号 phoneNumber 手机号 password 密码
     * @return 成功 /密码错误 /错误请求 /未知错误
     */
    @ApiOperation(value = "登陆", notes = "登陆")
    @GetMapping("/login")
    @ResponseBody
    public JSONObject loginByPassword(@RequestParam String account, String password, HttpServletResponse response){

        JSONObject jsonObject = new JSONObject();
        User userForBase = null;

        if(account != null){
            userForBase = userService.loginMethod(account, password);
        }
        if(userForBase != null){
            jsonObject.put("message",BaseResultStatus.SUCCESS.getMessage());
        }else{
            jsonObject.put("message",BaseResultStatus.ERROR_PASSWORD.getMessage());
            return jsonObject;
        }

        String token = tokenService.getToken(userForBase);
        System.out.println(token);
        jsonObject.put("token", token);
        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/");
        response.addCookie(cookie);

        return jsonObject;
    }

    @ApiOperation(value = "登陆", notes = "登陆")
    @GetMapping("/loginByVerificationCode")
    @ResponseBody
    public JSONObject loginByVerificationCode(@RequestParam String verificationCode, @RequestHeader("X-Access-Token") String token){
        JSONObject jsonObject = new JSONObject();
        String codeInToken = JWT.decode(token).getAudience().get(0);
        if(verificationCode.equals(codeInToken)){
            jsonObject.put("message", BaseResultStatus.SUCCESS.getMessage());
            jsonObject.put("code", BaseResultStatus.SUCCESS.getCode());
        }else{
            jsonObject.put("message", "验证码错误");
        }
        return jsonObject;
    }

}
