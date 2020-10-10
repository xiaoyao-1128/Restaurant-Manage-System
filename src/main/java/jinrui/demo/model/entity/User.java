package jinrui.demo.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    private String iduser;

    private Date creatdate;

    private Date updatedate;

    private String remark;

    private String name;

    /**
     * 0: don't deleted\\n1: deleted
     */
    private Byte isdel;

    /**
     * 0:tempuser
1:normal
2:VIP
3:.....
     */
    private Byte status;

    private String phoneNumber;

    private String password;

    private String account;

    private static final long serialVersionUID = 1L;

    public User(){ }

    public User(String iduser, Date creatdate, Date updatedate, String remark, String name, Byte isdel, Byte status, String phoneNumber, String password, String account) {
        this.iduser = iduser;
        this.creatdate = creatdate;
        this.updatedate = updatedate;
        this.remark = remark;
        this.name = name;
        this.isdel = isdel;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.account = account;
    }
}