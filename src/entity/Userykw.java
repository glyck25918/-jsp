package entity;

public class Userykw
{
	private String admin;
	private String password;

	public Userykw()
	{
		super();
		// TODO 自动生成的构造函数存根
	}

	public Userykw(String admin, String password)
	{
		super();
		this.admin = admin;
		this.password = password;
	}

	public String getAdmin()
	{
		return admin;
	}

	public void setAdmin(String admin)
	{
		this.admin = admin;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}
