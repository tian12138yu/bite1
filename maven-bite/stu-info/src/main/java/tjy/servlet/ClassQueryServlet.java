package tjy.servlet;

import tjy.Dao.ClassesDao;
import tjy.model.Classes;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author tjy
 * @Date 2020/8/2 10:04
 */
@WebServlet("/classes/queryAsDict")
public class ClassQueryServlet extends AbstractBaseServlet{


    @Override
    Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return ClassesDao.query();
    }
}
