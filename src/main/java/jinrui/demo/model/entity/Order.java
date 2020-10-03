package jinrui.demo.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * order
 * @author 
 */
@Data
public class Order implements Serializable {
    private Integer idorder;

    private Date creatdate;

    private Date updatedate;

    private String remark;

    private String name;

    /**
     * 0: don't deleted\\n1: deleted
     */
    private Byte isdel;

    /**
     * 1:normal
2.unsuccessed
3....
     */
    private Byte status;

    private static final long serialVersionUID = 1L;


}