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

@WebServlet("/deleteykw")
public class Deleteykw extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id = request.getParameter("id");

		Userykw userykw = new Userykw();
		userykw.setAdmin(id);

		boolean isok = new Serviceykw().deleteykew(userykw);

		PrintWriter out = response.getWriter();
		if (isok)
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