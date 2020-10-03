package jinrui.demo.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * transaction_records
 * @author 
 */
@Data
public class TransactionRecords implements Serializable {
    private Integer idtransactionRecords;

    private Date creatdate;

    private Date updatedate;

    private String remark;

    private String name;

    /**
     * 0: don't deleted\\n1: deleted
     */
    private Byte isdel;

    /**
     * 1:normal\n2.unsuccessed\n3....
     */
    private Byte status;

    private static final long serialVersionUID = 1L;


}