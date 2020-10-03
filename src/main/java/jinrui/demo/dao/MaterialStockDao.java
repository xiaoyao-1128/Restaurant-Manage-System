package jinrui.demo.dao;

import jinrui.demo.model.entity.MaterialStock;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MaterialStockDao {
    int deleteByPrimaryKey(Integer idmaterialStock);

    int insert(MaterialStock record);

    int insertSelective(MaterialStock record);

    MaterialStock selectByPrimaryKey(Integer idmaterialStock);

    int updateByPrimaryKeySelective(MaterialStock record);

    int updateByPrimaryKey(MaterialStock record);
}