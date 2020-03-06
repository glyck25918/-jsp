package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.JmjService;
import entity.Add;
import entity.Jmj;

@WebServlet("/add")
public class AddServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 缂栫爜璁剧疆
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 鍒ゆ柇鏌ヨ閭ｄ釜
		String id = request.getParameter("id");
		// 璋冪敤閫昏緫灞�
		JmjService jService = new JmjService();
		List<Jmj> list = jService.getAdd(id);
		List<Add> aList = jService.getQueryp();

		request.setAttribute("list", list);
		request.setAttribute("aList", aList);
		request.getRequestDispatcher("particularAdd.jsp").forward(request, response);
	}
}
