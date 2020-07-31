package tjy.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author tjy
 * @Date 2020/7/31 19:17
 */
@Data
public class Classes {

    private Integer id;
    private String ClassesName;
    private String classesGraduateYear;
    private String classesMajor;
    private String classesDesc;
    private Date createTime;
}
