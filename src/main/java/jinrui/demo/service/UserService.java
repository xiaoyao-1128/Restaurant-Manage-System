package jinrui.demo.service;

import jinrui.demo.model.entity.User;

/**
 * @Author: jiaRu
 * @Date: 2020/10/2 14:11
 */
public interface UserService {

    /**
     * 登录检验
     * @param account :账号
     * @param password ：密码
     * @return 返回true表示密码正确，返回false表示错误
     */
    boolean loginMethod(String account, String password);
//    boolean loginMethod(Integer phoneNumber, String password);

    /**
     * 注册
     * @param user 传入对象
     * @return 1：成功插入 2：账号已存在 3：手机号已存在
     *             0:数据库操作失败
     */
    Integer register(User user);

}
