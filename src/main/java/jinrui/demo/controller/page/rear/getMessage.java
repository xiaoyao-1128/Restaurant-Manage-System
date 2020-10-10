package jinrui.demo.controller.page.rear;

import io.swagger.annotations.ApiOperation;
import jinrui.demo.annotation.UserLoginToken;
import jinrui.demo.util.TokenUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: jiaRu
 * @Date: 2020/10/10 15:20
 */
@Controller
@RequestMapping("/page/rear")
public class getMessage {
    /***
     * 这个请求需要验证token才能访问
     * @return String 返回类型
     */
    @UserLoginToken
    @ApiOperation(value = "获取信息", notes = "获取信息")
    @GetMapping(value = "/getMessage")
    @ResponseBody
    public String getMessage() {

        // 取出token中带的用户id 进行操作
        System.out.println("=======getMessage"+ TokenUtil.getTokenUserId());


        return "您已通过验证";
    }
}
