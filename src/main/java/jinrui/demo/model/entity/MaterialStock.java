package jinrui.demo.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * material_stock
 * @author 
 */
@Data
public class MaterialStock implements Serializable {
    private Integer idmaterialStock;

    private Date creatdate;

    private Date updatedate;

    private String remark;

    private String name;

    /**
     * 0: don't deleted\n1: deleted
     */
    private Byte isdel;

    /**
     * 0:empty
1:full
2:.....\n
     */
    private Byte status;

    private Integer stockCounts;

    private static final long serialVersionUID = 1L;


}