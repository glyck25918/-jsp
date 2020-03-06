package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.Serviceykw;
import entity.Material;

@WebServlet("/wenjian")
public class Wenjiansc extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		FileItemFactory factory = new DiskFileItemFactory(1024 * 1024 * 10, new File("F:/学习/temp"));
		ServletFileUpload upload = new ServletFileUpload(factory);

		String admin="",gender="",birthday="",img="",location="",email="",userykwadmin="";
		List<FileItem> list;
		try
		{
			list = upload.parseRequest(request);
			for (FileItem fileItem : list)
			{
				if (fileItem.isFormField())
				{
					switch (fileItem.getFieldName())
					{
					case "admin":
						admin = fileItem.getString("utf-8");
						break;
					case "gender":
						gender = fileItem.getString("utf-8");
						break;
					case "birthday":
						birthday = fileItem.getString("utf-8");
						break;
					case "location":
						location = fileItem.getString("utf-8");
						break;
					case "email":
						email = fileItem.getString("utf-8");
						break;
					case "wa":
						userykwadmin = fileItem.getString("utf-8");
						break;
					}
				}
				else
				{
					//先截取后缀名
					int houzui = fileItem.getName().lastIndexOf(".");
					String name = fileItem.getName().substring(houzui);
					
					//依据日期+随机码 ,生成文件名
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
					String date = df.format(new Date());		
					
					String dasjdas = date+name;
					
					img = dasjdas;
					String parent = request.getServletContext().getRealPath("upload");
					File aFile = new File(parent, dasjdas);
					fileItem.write(aFile);
				}
			}
		}
		catch (FileUploadException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		Material material = new Material();
		material.setAdmin(admin);
		material.setGender(Integer.parseInt(gender));
		try {
			material.setBirthday(sFormat.parse(birthday));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		material.setImg(img);
		material.setLocation(location);
		material.setEmail(email);
		
		boolean isok = new Serviceykw().getykw(material,userykwadmin);

		PrintWriter out = response.getWriter();
		
		if (isok)
		{
			out.write("<script>alert(\"修改成功，\"); window.location.href = \"index.jsp\";</script>");
			out.flush();
			out.close();
		}
		else
		{
			out.write("<script>alert(\"保存失败！\"); window.location.href = \"index.jsp\";</script>");
			out.flush();
			out.close();
		}
	}
}
