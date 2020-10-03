package jinrui.demo.dao;

import jinrui.demo.model.entity.MaterialNeeds;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MaterialNeedsDao {
    int deleteByPrimaryKey(Integer idmaterialNeeds);

    int insert(MaterialNeeds record);

    int insertSelective(MaterialNeeds record);

    MaterialNeeds selectByPrimaryKey(Integer idmaterialNeeds);

    int updateByPrimaryKeySelective(MaterialNeeds record);

    int updateByPrimaryKey(MaterialNeeds record);
}