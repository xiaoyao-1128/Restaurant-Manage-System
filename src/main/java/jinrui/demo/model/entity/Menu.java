package jinrui.demo.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * menu
 * @author 
 */
@Data
public class Menu implements Serializable {
    private Integer idmenu;

    private Date creatdate;

    private Date updatedate;

    private String remark;

    private String name;

    /**
     * 0: don't deleted\\n1: deleted
     */
    private Byte isdel;

    /**
     * 1:normal food
...
     */
    private Byte status;

    /**
     * 0:user cant watch
1:user can watch
     */
    private String isview;

    private static final long serialVersionUID = 1L;


}