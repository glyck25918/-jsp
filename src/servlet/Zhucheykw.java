package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Serviceykw;
import entity.Userykw;

@WebServlet("/zhuche")
public class Zhucheykw extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		Userykw userykw = new Userykw(id, password);

		boolean isok = new Serviceykw().zhuce(userykw);

		boolean ok = false;
		if (isok == true)
		{
			ok = new Serviceykw().zhucetj(userykw);
		}

		PrintWriter out = response.getWriter();
		if (ok)
		{
			out.print(true);
		}
		else
		{
			out.print(false);
		}
		out.flush();
		out.close();
	}
}
