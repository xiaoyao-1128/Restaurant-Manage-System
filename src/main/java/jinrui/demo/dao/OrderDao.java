package jinrui.demo.dao;

import jinrui.demo.model.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {
    int deleteByPrimaryKey(Integer idorder);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer idorder);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}