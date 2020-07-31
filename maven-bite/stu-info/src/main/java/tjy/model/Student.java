package tjy.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author tjy
 * @Date 2020/7/31 19:23
 */
@Data
public class Student {
    private  Integer id;
    private String studentName;
    private String studentNo;
    private String idCard;
    private String studentEmail;
    private Integer classesId;
    private Date createTime;
    private Classes classes;
}
