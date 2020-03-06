package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Material;
import entity.Proojectykw;
import entity.Userykw;

public class Daoykw extends BaseDao
{

	public List<Proojectykw> ajax()
	{
		String sql = "select id,admin,yu,source,date from messige";
		ResultSet rSet = null;
		List<Proojectykw> list = new ArrayList<>();
		try
		{
			rSet = super.executeQuery(sql);
			while (rSet.next())
			{
				Proojectykw a = new Proojectykw(rSet.getInt("id"), rSet.getString("admin"), rSet.getString("yu"), rSet.getString("source"), rSet.getDate("date"));
				list.add(a);
			}
		}
		catch (SQLException e)
		{
			// TODO 鑷姩鐢熸垚鐨�catch 鍧�
			e.printStackTrace();
		}
		finally
		{
			super.closeResultSet(rSet);
		}
		return list;
	}

	public Userykw zhucheajax(String admin)
	{
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�

		String sql = "select admin from admin where admin = ?";
		ResultSet rSet = null;
		try
		{
			rSet = executeQuery(sql, admin);
			while (rSet.next())
			{
				Userykw userykw = new Userykw();
				userykw.setAdmin(rSet.getString("admin"));
				return userykw;
			}
		}
		catch (SQLException e)
		{
			// TODO 鑷姩鐢熸垚鐨�catch 鍧�
			e.printStackTrace();
		}
		finally
		{
			super.closeResultSet(rSet);
		}
		return null;
	}

	public int zhuce(Userykw userykw)
	{
		String sql = "insert into admin(admin,password) values(?,?)";
		int a = 0;
		try
		{
			a = super.executeUpdate(sql, userykw.getAdmin(), userykw.getPassword());
		}
		catch (SQLException e)
		{
			// TODO 鑷姩鐢熸垚鐨�catch 鍧�
			e.printStackTrace();
		}

		return a;
	}

	public int zhucetj(Userykw userykw)
	{
		String sql = "insert into material(admin) values(?)";
		int a = 0;
		try
		{
			a = super.executeUpdate(sql, userykw.getAdmin());
		}
		catch (SQLException e)
		{
			// TODO 鑷姩鐢熸垚鐨�catch 鍧�
			e.printStackTrace();
		}
		return a;
	}

	public Userykw dengluykw(String admin)
	{
		String sql = "select admin,password from admin where admin = ?";
		ResultSet rSet = null;
		try
		{
			rSet = executeQuery(sql, admin);
			while (rSet.next())
			{
				Userykw userykw = new Userykw();
				userykw.setAdmin(rSet.getString("admin"));
				userykw.setPassword(rSet.getString("password"));
				return userykw;
			}
		}
		catch (SQLException e)
		{
			// TODO 鑷姩鐢熸垚鐨�catch 鍧�
			e.printStackTrace();
		}
		finally
		{
			super.closeResultSet(rSet);
		}
		return null;
	}

	public List<Proojectykw> message(String admin)
	{
		String sql = "select id,admin,yu,source,date from messige where admin = ? order by date desc";
		ResultSet rSet = null;
		List<Proojectykw> list = new ArrayList<>();
		try
		{
			rSet = super.executeQuery(sql, admin);
			while (rSet.next())
			{
				Proojectykw a = new Proojectykw(rSet.getInt("id"), rSet.getString("admin"), rSet.getString("yu"), rSet.getString("source"), rSet.getDate("date"));
				list.add(a);
			}
		}
		catch (SQLException e)
		{
			// TODO 鑷姩鐢熸垚鐨�catch 鍧�
			e.printStackTrace();
		}
		finally
		{
			super.closeResultSet(rSet);
		}
		return list;
	}

	public int tianjia(Proojectykw proojectykw)
	{
		Date date = new Date(proojectykw.getDate().getTime());
		String sql = "insert into messige(admin,yu,source,date) values(?,?,?,?)";
		int a = 0;
		try
		{
			a = super.executeUpdate(sql, proojectykw.getAdmin(), proojectykw.getYu(), proojectykw.getSource(), date);
		}
		catch (SQLException e)
		{
			// TODO 鑷姩鐢熸垚鐨�catch 鍧�
			e.printStackTrace();
		}
		return a;
	}

	public int deleteykw(Userykw userykw)
	{
		String sql = "delete from messige where id = ?";
		int a = 0;
		try
		{
			a = super.executeUpdate(sql, userykw.getAdmin());
		}
		catch (SQLException e)
		{
			// TODO 鑷姩鐢熸垚鐨�catch 鍧�
			e.printStackTrace();
		}
		return a;
	}

	public int getykw(Material material, String userykwadmin) {
		Date date = new Date(material.getBirthday().getTime());
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append("UPDATE  material");
		sbBuffer.append("	SET ");
		sbBuffer.append("		gender =?,");
		sbBuffer.append("			 birthday =?,");
		sbBuffer.append("					 img =?,");
		sbBuffer.append("					 location =?,");
		sbBuffer.append("					  email =?");
		sbBuffer.append(" where admin=?");
		int a = 0;
		try
		{
			a = super.executeUpdate(sbBuffer.toString(),material.getGender(),date,material.getImg(),material.getLocation(),material.getEmail(),userykwadmin);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return a;
	}

	public List<Material> lfy(String id) {
		String sql = "select admin,gender,birthday,img,location,email from material where admin = ?";
		ResultSet rSet = null;
		List<Material> mList = new ArrayList<>();
		try
		{
			rSet = executeQuery(sql, id);
			while (rSet.next())
			{
				Material material = new Material(rSet.getString("admin"), rSet.getInt("gender"), rSet.getDate("birthday"), rSet.getString("img"), rSet.getString("location"), rSet.getString("email"));
				mList.add(material);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			super.closeResultSet(rSet);
		}
		return mList;
	}

	
}
