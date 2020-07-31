package tjy.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author tjy
 * @Date 2020/7/31 19:24
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private Date createTime;
}
