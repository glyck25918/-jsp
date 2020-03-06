package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Serviceykw;

import com.alibaba.fastjson.JSON;

import entity.Proojectykw;

@WebServlet("/indexykw")
public class Servletykw extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Proojectykw> list = new Serviceykw().ajax();

		String b = JSON.toJSONString(list);

		PrintWriter out = response.getWriter();
		out.print(b);
		out.flush();
		out.close();
	}
}
