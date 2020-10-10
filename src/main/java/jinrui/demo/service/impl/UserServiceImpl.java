package jinrui.demo.service.impl;


import jinrui.demo.dao.UserDao;
import jinrui.demo.model.entity.User;
import jinrui.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author jiaRu
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User findUserByPhoneNumber(String phoneNumber){
        return userDao.selectByPhoneNumber(phoneNumber);
    }


    @Override
    public User findUserById(Integer iduser) {
        return userDao.selectByPrimaryKey(iduser);
    }


    /**
     *
     * @param account 账号
     * @param password 密码
     * @return 返回是否成功
     */
    @Override
    public User loginMethod(String account, String password){
        return (userDao.loginMethodByAccount(account, password));
    }

    /**
     *
     * @param user 传入user对象
     * @return 1：成功插入 2：账号已存在 3：手机号已存在 4:沒有密碼
     *          0:数据库操作失败
     */
    @Override
    public Integer register(User user){

        if (userDao.selectByAccount(user.getAccount()) != null){
            return 2;
        }
        if(userDao.selectByPhoneNumber(user.getPhoneNumber()) != null){
            return 3;
        }
        user.setCreatdate(new Date());
        user.setIsdel((byte)0);
        user.setStatus((byte)1);
        if(userDao.insert(user) > 0){
            return 1;
        }
        return 0;
    }
}
