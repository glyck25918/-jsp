package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Add;
import entity.Jmj;

public class JmjDao extends BaseDao
{

	public List<Jmj> getQuery(int id)
	{
		// sql
		String sql;
		ResultSet rSet = null;
		List<Jmj> list = new ArrayList<>();
		try
		{
			sql = "SELECT id, admin, yu, source, date FROM messige where id = ?";
			rSet = super.executeQuery(sql,id);

			while (rSet.next())
			{
				Jmj jmj = new Jmj();
				jmj.setId(rSet.getInt("id"));
				jmj.setAdmin(rSet.getString("admin"));
				jmj.setYu(rSet.getString("yu"));
				jmj.setSource(rSet.getString("source"));
				jmj.setDate(rSet.getDate("date"));
				list.add(jmj);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeResultSet(rSet);
		}

		return list;
	}

	public List<Jmj> getAdd(String id)
	{
		// sql
		String sql;
		ResultSet rSet = null;
		List<Jmj> list = new ArrayList<>();
		try
		{
			sql = "SELECT id, admin, yu, source, date FROM messige where id = ?" ;
			rSet = super.executeQuery(sql,id);
			while (rSet.next())
			{
				Jmj jmj = new Jmj();
				jmj.setId(rSet.getInt("id"));
				jmj.setAdmin(rSet.getString("admin"));
				jmj.setYu(rSet.getString("yu"));
				jmj.setSource(rSet.getString("source"));
				jmj.setDate(rSet.getDate("date"));
				list.add(jmj);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeResultSet(rSet);
		}

		return list;
	}

	public int getAddP(Add add)
	{
		// sql
		String sql = "INSERT INTO chat(admin,comment) VALUES(?,?)";
		try
		{
			int rows = super.executeUpdate(sql,add.getAdmin(), add.getComment());
			return rows;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public List<Add> getQueryp()
	{
		String sql;
		ResultSet rSet = null;
		List<Add> aList = new ArrayList<>();
		try
		{
			sql = "SELECT id, admin, comment FROM chat";
			rSet = super.executeQuery(sql);
			while (rSet.next())
			{
				Add add = new Add();
				add.setAdmin(rSet.getString("admin"));
				add.setComment(rSet.getString("comment"));
				aList.add(add);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeResultSet(rSet);
		}

		return aList;
	}
}
