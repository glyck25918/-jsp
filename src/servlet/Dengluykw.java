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

@WebServlet("/dengluykw")
public class Dengluykw extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String admin = request.getParameter("admin");
		String password = request.getParameter("password");

		Userykw userykw = new Userykw(admin, password);

		boolean isok = new Serviceykw().dengluykw(userykw);

		PrintWriter out = response.getWriter();
		if (isok)
		{
			request.getSession().setAttribute("userykwadmin", userykw.getAdmin());
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