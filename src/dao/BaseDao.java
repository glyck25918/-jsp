package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC的操作类
 * 
 * @author 
 * 
 */
public class BaseDao
{
	// 配置信息
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://xfzn.xyz:1433;DatabaseName=ExamDB";// 数据库名：SchoolDB
	private String uid = "sa";
	private String pwd = "xxxxxx";
	// 加载驱动
	static
	{
		try
		{
			Class.forName(driver);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 获取：连接对象
	 * 
	 * @return 数据库连接对象
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url, uid, pwd);
	}

	/**
	 * 释放：连接资源...
	 * 
	 * @param statement 执行对象
	 * @param connection 连接对象
	 */
	private void closeConnection(Statement statement, Connection connection)
	{
		// 有序关闭：先执行对象，再连接对象
		try
		{
			if (statement != null)
				statement.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		try
		{
			if (connection != null)
				connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	// ---------------------------------------
	/**
	 * 执行：增删改
	 * 
	 * @param sql 要执行SQL命令
	 * @param ages SQL携带的参数
	 * @return 受影响的行数
	 * @throws SQLException 可能会有SQL异常
	 */
	// --------------------------------------
	// 执行：增删改
	public int executeUpdate(String sql, Object... ages) throws SQLException
	{
		Connection connection = null;
		PreparedStatement statement = null;
		try
		{
			connection = getConnection();
			statement = connection.prepareStatement(sql); // 带参SQL的执行，Statement子类
			// 配置参数
			for (int i = 0; i < ages.length; i++)
			{
				statement.setObject(i + 1, ages[i]);
			}
			// 执行
			return statement.executeUpdate();
		}
		finally
		{
			closeConnection(statement, connection);
		}
	}

	/**
	 * 执行：查
	 * 
	 * @param sql 待执行SQL
	 * @param ages SQL参数
	 * @return ResultSet结果集
	 * @throws SQLException
	 */
	// 执行：查
	public ResultSet executeQuery(String sql, Object... ages) throws SQLException
	{
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		// 配置参数
		for (int i = 0; i < ages.length; i++)
		{
			statement.setObject(i + 1, ages[i]);
		}
		// 执行
		return statement.executeQuery();
	}

	// 释放资源：查询相关
	// 释放资源：查询相关
	public void closeResultSet(ResultSet rSet)
	{
		Statement statement = null;
		Connection connection = null;
		try
		{
			if (rSet != null)
			{
				statement = rSet.getStatement();
				connection = statement.getConnection();
				// 先：关闭结果集
				rSet.close();
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			// 在，需要关闭执行对象、连接对象
			closeConnection(statement, connection);
		}

	}
}
