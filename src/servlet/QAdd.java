package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceLFY;
import entity.Material;
@WebServlet("/qadd")
public class QAdd extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		
		List<Material> mList = new ServiceLFY().lfy(id);
		request.setAttribute("mList", mList);
		request.getRequestDispatcher("filesupload.jsp").forward(request, response);
	}
}
