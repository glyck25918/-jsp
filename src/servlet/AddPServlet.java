package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.JmjService;
import entity.Add;

@WebServlet("/addp")
public class AddPServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 缂栫爜璁剧疆
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 鎺ユ敹
		String admin = request.getParameter("admin");
		String comment = request.getParameter("comment");
		// 灏佽
		Add add = new Add();
		add.setAdmin(admin);
		add.setComment(comment);

		// 璋冪敤閫昏緫灞�
		JmjService jService = new JmjService();
		boolean isok = jService.getAddP(add);

		PrintWriter out = response.getWriter();

		if (isok)
		{
			out.print("<script>alert('发布成功!');window.location.href='add'</script>");

		}
		else
		{
			out.print("<script>alert('发布失败!');window.location.href='particularAdd.jsp'</script>");
		}
		out.flush();
		out.close();
	}
}
