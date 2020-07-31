package tjy.servlet;

import tjy.Dao.DictionaryTagDao;
import tjy.model.DictionaryTag;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * @Author tjy
 * @Date 2020/7/31 19:36
 */

@WebServlet("/dict/tag/query")
public class DictionaryTagServlet extends AbstractBaseServlet {

    @Override
    Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String key = req.getParameter("dictionaryKey");
        List<DictionaryTag> list = DictionaryTagDao.query(key);
        return list;
    }
}
