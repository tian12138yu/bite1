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
 * @Date 2020/7/31 21:19
 */

public class StudentDao {


    public static List<Student> query() {
        Connection c = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        try {
            c = DBUtil.getConnection();
            String sql = "select s.id, s.student_name, s.student_no, s.id_card, s.student_email, s.classes_id, s.create_time," +
                    "       c.id, c.classes_name, c.classes_graduate_year, c.classes_major, c.classes_desc, c.create_time from" +
                    " student s,classes c where s.classes_id = c.id;";
            pre = c.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                Classes classes = new Classes();
                student.setId(rs.getInt("id"));
                student.setStudentName(rs.getString("student_name"));
                student.setStudentNo(rs.getString("student_no"));
                student.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                classes.setClassesName(rs.getString("classes_name"));
                student.setClasses(classes);
                list.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询数据字典出错！", e);
        } finally {
            DBUtil.colse(c, pre, rs);
        }
        return list;
    }

}
