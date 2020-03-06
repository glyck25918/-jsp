package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Serviceykw;
import entity.Proojectykw;

@WebServlet("/tianjia")
public class MessageAdd extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String yu = request.getParameter("yu");
		String source = request.getParameter("name");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		String admin = request.getParameter("admin");

		Proojectykw proojectykw = new Proojectykw();
		proojectykw.setAdmin(admin);
		proojectykw.setYu(yu);
		proojectykw.setSource(source);
		try
		{
			proojectykw.setDate(df.parse(date));
		}
		catch (ParseException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		boolean isok = new Serviceykw().tjanjia(proojectykw);

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