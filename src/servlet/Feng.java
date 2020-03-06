package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import service.ServiceLFY;
import entity.Material;
@WebServlet("/fen")
public class Feng extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		
		List<Material> mList = new ServiceLFY().lfy(id);
		String b = JSON.toJSONStringWithDateFormat(mList, "yyyy-MM-dd");

		PrintWriter out = response.getWriter();
		out.print(b);
		out.flush();
		out.close();
	}
}
