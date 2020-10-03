package jinrui.demo.dao;

import jinrui.demo.model.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuDao {
    int deleteByPrimaryKey(Integer idmenu);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer idmenu);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}