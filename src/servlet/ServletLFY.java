package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceLFY;
import entity.entityLFY;
@WebServlet("/Query")
public class ServletLFY extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		List<entityLFY> eList = new ServiceLFY().getLFY();
		
		request.setAttribute("eList", eList);
		request.getRequestDispatcher("bk.jsp").forward(request, response);
	}
}
