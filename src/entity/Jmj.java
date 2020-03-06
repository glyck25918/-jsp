package entity;

import java.util.Date;

public class Jmj
{
	private int id;
	private String admin;
	private String yu;
	private String source;
	private Date date;

	public Jmj()
	{
		super();
	}

	public Jmj(int id, String admin, String yu, String source, Date date)
	{
		super();
		this.id = id;
		this.admin = admin;
		this.yu = yu;
		this.source = source;
		this.date = date;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getAdmin()
	{
		return admin;
	}

	public void setAdmin(String admin)
	{
		this.admin = admin;
	}

	public String getYu()
	{
		return yu;
	}

	public void setYu(String yu)
	{
		this.yu = yu;
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

}
