package tjy.Dao;

import tjy.model.DictionaryTag;
import tjy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/7/31 19:47
 */

public class DictionaryTagDao {

    public static List<DictionaryTag> query(String key) {
        Connection c = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        List<DictionaryTag> list = new ArrayList<>();
        try{
            c = DBUtil.getConnection();
            String sql = "select concat(d.dictionary_key, dt.dictionary_tag_key) dictionary_tag_key," +
                    "       dt.dictionary_tag_value" +
                    " from dictionary d" +
                    "         join dictionary_tag dt on d.id = dt.dictionary_id where dictionary_key = ?";
            pre = c.prepareStatement(sql);
            pre.setString(1,key);
            rs = pre.executeQuery();
            while (rs.next()){
                DictionaryTag dic = new DictionaryTag();
                dic.setDictionaryTagKey(rs.getString("dictionary_tag_key"));
                dic.setDictionaryTagKey(rs.getString("dt.dictionary_tag_value"));
                list.add(dic);
            }
        }catch (Exception e ){
            throw new RuntimeException("查询数据字典出错！",e);
        }finally {
            DBUtil.colse(c,pre,rs);
        }
        return list;

    }
}
