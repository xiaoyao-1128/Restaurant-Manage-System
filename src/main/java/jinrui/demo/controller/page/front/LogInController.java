package jinrui.demo.controller.page.front;

import com.alibaba.fastjson.JSONObject;
import jinrui.demo.model.dto.ResultData;
import jinrui.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jiaRu
 * @Date: 2020/10/2 10:37
*/

@Controller
@RequestMapping("/page/front")
public class LogInController {
    /**USE_P 表示使用密码登录*/
    private static final Integer USE_PASSWORD = 1;
    /**USE_V 表示使用验证码登录*/
    private static final Integer USE_V = 2;
    @Resource
    private UserService userService;

    /**
     * 登录
     * @param param account 账号 phoneNumber 手机号 password 密码
     * @return 成功 /密码错误 /错误请求 /未知错误
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResultData login(@RequestBody JSONObject param){

        //返回结果对象
        ResultData resultData;
        //如果没有账号，直接返回错误信息
        String account = param.getString("account");
        Integer phoneNumber = param.getInteger("phoneNumber");
        String password = param.getString("password");
        /*获取json中要用的数据
         *如果loginMethod返回1代表使用密码登录
         * 如果loginMethod返回2代表使用验证码登录*/
        Integer loginMethod = param.getInteger("loginMethod");
        if(loginMethod == null){
            return new ResultData(ResultData.error());
        }
        else if(loginMethod.equals(USE_V)){
            //用户选择使用验证码登录,发送验证码到所填手机号上
            String verificationCode = String.valueOf((int)((Math.random()*9+1)*1000));
            Map<String, Object> data = new HashMap<>(1);
            data.put("验证码",verificationCode);
            resultData = new ResultData(ResultData.success());
            resultData.setData(data);
            return resultData;
        } else if(loginMethod.equals(USE_PASSWORD)){
            /*
             * 用户选择使用密码登录
             * 使用密码登录，只能用账号来操作
             */
            boolean loginSuccess;
            if(account != null){
                loginSuccess = userService.loginMethod(account, password);
            }else {
                return new ResultData(ResultData.errorRequest());
            }
            if(loginSuccess){
                resultData = new ResultData(ResultData.success());
            }else{
                resultData = new ResultData(ResultData.errorPassword());
            }
        }else{
            //未知参数
            resultData = new ResultData(ResultData.errorRequest());
        }

        return resultData;
    }
}
