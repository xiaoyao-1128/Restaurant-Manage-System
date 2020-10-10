package jinrui.demo.service;

import ch.qos.logback.core.joran.util.beans.BeanDescriptionFactory;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jinrui.demo.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: jiaRu
 * @Date: 2020/10/10 12:48
 */
@Service
public class TokenService {


    public String getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;
        //一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(String.valueOf(user.getIduser())).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public String getTokenForVerificationCode(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;
        //一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(String.valueOf(user.getRemark())).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}