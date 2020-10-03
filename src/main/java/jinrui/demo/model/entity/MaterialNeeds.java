package jinrui.demo.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * material_needs
 * @author 
 */
@Data
public class MaterialNeeds implements Serializable {
    private Integer idmaterialNeeds;

    private Date creatdate;

    private Date updatedate;

    private String remark;

    private String name;

    private Integer needCounts;

    /**
     * 0: don't deleted
1: deleted
     */
    private Byte isdel;

    /**
     * 0:don't buy
1:need  buy
2:.....

     */
    private Byte status;

    private static final long serialVersionUID = 1L;


}