package tjy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Author tjy
 * @Date 2020/7/31 19:11
 */
@ToString
@Getter
@Setter
public class DictionaryTag {

    private Integer id;
    private String dictionaryTagKey;
    private String dictionaryTagValue;
    private Integer dictionaryId;
    private Date createTime;

}
