package tjy.Dao;

import tjy.model.Classes;
import tjy.model.Student;
import tjy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/8/2 10:13
 */

public class ClassesDao {

    public static List<Classes> query() {
        Connection c = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        List<Classes> list = new ArrayList<>();
        try {
            c = DBUtil.getConnection();
            String sql = "select id,classes_name,classes_graduate_year,classes_major" +
                    " from classes;";
            pre = c.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Classes classes = new Classes();
                classes.setDictionaryTagKey(rs.getString("id"));
                classes.setDictionaryTagValue(rs.getString("classes_name"));
                classes.setClassesGraduateYear(rs.getString("classes_graduate_year"));
                classes.setClassesMajor(rs.getString("classes_major"));
                list.add(classes);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询数据字典出错！", e);
        } finally {
            DBUtil.colse(c, pre, rs);
        }
        return list;
    }
}
