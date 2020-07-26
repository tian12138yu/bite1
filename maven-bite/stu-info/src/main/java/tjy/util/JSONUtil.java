package tjy.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * @Author tjy
 * @Date 2020/7/26 11:59
 */

public class JSONUtil {

    private static final ObjectMapper m = new ObjectMapper();
    static {
        m.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static <T> T read(InputStream is, Class<T> clazz){
        try {
            return m.readValue(is, clazz);
        } catch (IOException e) {
            throw new RuntimeException("JSON反序列化失败。",e);
        }
    }

    public static String write(Object o){
        try {
            return m.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON序列化失败。",e);
        }
    }

}
