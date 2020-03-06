package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Serviceykw;
import entity.Proojectykw;

@WebServlet("/messageykw")
public class Messageykw extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String admin = request.getParameter("admin");

		List<Proojectykw> list = new Serviceykw().message(admin);

		request.setAttribute("list", list);
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}
}
