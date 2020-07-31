package tjy.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author tjy
 * @Date 2020/7/31 19:20
 */
@Data
public class Dictionary {
    private Integer id;
    private String dictionaryKey;
    private String dictionaryValue;
    private String dictionaryDesc;
    private Date createTime;
}
