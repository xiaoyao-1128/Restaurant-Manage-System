package jinrui.demo.service;

import jinrui.demo.dao.UserDao;
import jinrui.demo.model.entity.User;

/**
 * @Author: jiaRu
 * @Date: 2020/10/2 14:11
 */
public interface UserService {


    /**
     * 根据手机号查询用户
     * @param phoneNumber
     * @return userId
     */
    User findUserByPhoneNumber(String phoneNumber);


    /**
     * 登录检验
     * @param account :账号
     * @param password ：密码
     * @return 返回true表示密码正确，返回false表示错误
     */
    User loginMethod(String account, String password);
//    boolean loginMethod(Integer phoneNumber, String password);

    /**
     * 注册
     * @param user 传入对象
     * @return 1：成功插入 2：账号已存在 3：手机号已存在
     *             0:数据库操作失败
     */
    Integer register(User user);

    /**
     * 根据id查询
     * @param iduser id
     * @return 对象
     */
    public User findUserById(Integer iduser);

}
