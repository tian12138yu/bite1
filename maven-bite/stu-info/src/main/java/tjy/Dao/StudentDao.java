package tjy.Dao;

import tjy.model.Classes;
import tjy.model.Student;
import tjy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        try{
            c = DBUtil.getConnection();
            String sql = "select * from" +
                    " student,classes where student.classes_id = classes_id;";
            pre = c.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()){
                Student student = new Student();
                Classes classes = new Classes();
                student.setId(rs.getInt("student.id"));
                student.setStudentName(rs.getString("student_name"));
                list.add(student);
            }
        }catch (Exception e ){
            throw new RuntimeException("查询数据字典出错！",e);
        }finally {
            DBUtil.colse(c,pre,rs);
        }
        return list;
    }
}
