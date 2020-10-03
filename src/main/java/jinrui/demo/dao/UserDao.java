package jinrui.demo.dao;

import jinrui.demo.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    int deleteByPrimaryKey(Integer iduser);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer iduser);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByAccount(String account);

    User loginMethodByAccount(String account, String password);

    User selectByPhoneNumber(String phoneNumber);
}