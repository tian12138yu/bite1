package tjy.servlet;

import tjy.model.Response;
import tjy.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author tjy
 * @Date 2020/7/26 12:22
 */
@WebServlet("/web")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter pw = resp.getWriter();
        Response r = new Response();
        r.setCode("OK200");
        r.setMessage("操作成功！");
        pw.println(JSONUtil.write(r));
        pw.flush();
    }
}
