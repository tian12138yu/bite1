package tjy.servlet;

import tjy.Dao.DictionaryTagDao;
import tjy.model.DictionaryTag;
import tjy.model.Response;
import tjy.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author tjy
 * @Date 2020/7/31 21:00
 */

public abstract class AbstractBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter pw = resp.getWriter();
        Response r = new Response();
        try {
            Object o = process(req,resp);
            r.setData(o);
            r.setSuccess(true);
            r.setCode("OK200");
            r.setMessage("操作成功！");
        } catch (Exception e) {
            r.setCode("ERR500");
            r.setSuccess(false);
            r.setMessage(e.getMessage());
        }


        pw.println(JSONUtil.write(r));
        pw.flush();
    }

    abstract Object process(HttpServletRequest req, HttpServletResponse resp)throws Exception;

}
