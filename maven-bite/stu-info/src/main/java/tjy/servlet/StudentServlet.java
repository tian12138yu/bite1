package tjy.servlet;

import tjy.Dao.StudentDao;
import tjy.model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/7/31 21:18
 */
@WebServlet("/student/query")
public class StudentServlet extends AbstractBaseServlet{
    @Override
    Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Student> students = StudentDao.query();
        return students;
    }
}
