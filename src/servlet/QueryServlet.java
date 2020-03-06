package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.JmjService;
import entity.Jmj;

@WebServlet("/querys")
public class QueryServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 缂栫爜璁剧疆
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 鍒ゆ柇鏌ヨ閭ｄ釜
		String obj = request.getParameter("id");
		int id = -1;
		if (obj != null)
		{
			id = Integer.parseInt(obj);
		}
		
		JmjService jService = new JmjService();
		List<Jmj> list = jService.getQuery(id);

		request.setAttribute("list", list);
		request.getRequestDispatcher("particular.jsp").forward(request, response);
	}
}
