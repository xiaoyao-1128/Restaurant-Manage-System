package jinrui.demo.dao;

import jinrui.demo.model.entity.TransactionRecords;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransactionRecordsDao {
    int deleteByPrimaryKey(Integer idtransactionRecords);

    int insert(TransactionRecords record);

    int insertSelective(TransactionRecords record);

    TransactionRecords selectByPrimaryKey(Integer idtransactionRecords);

    int updateByPrimaryKeySelective(TransactionRecords record);

    int updateByPrimaryKey(TransactionRecords record);
}