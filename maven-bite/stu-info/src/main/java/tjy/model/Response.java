package tjy.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author tjy
 * @Date 2020/7/26 12:16
 */
@Getter
@Setter
@ToString
public class Response {

    private boolean success;
    private String code;
    private String message;
    private Object data;
    private String stackTrace;

}
