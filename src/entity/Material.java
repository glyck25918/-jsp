package entity;

import java.util.Date;

public class Material
{
	private String admin;
	private int gender;
	private Date birthday;
	private String img;
	private String location;
	private String email;

	public Material()
	{
		super();
		// TODO 鑷姩鐢熸垚鐨勬瀯閫犲嚱鏁板瓨鏍�
	}

	public Material(String admin, int gender, Date birthday, String img, String location, String email)
	{
		super();
		this.admin = admin;
		this.gender = gender;
		this.birthday = birthday;
		this.img = img;
		this.location = location;
		this.email = email;
	}

	public String getAdmin()
	{
		return admin;
	}

	public void setAdmin(String admin)
	{
		this.admin = admin;
	}

	public int getGender()
	{
		return gender;
	}

	public void setGender(int gender)
	{
		this.gender = gender;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public String getImg()
	{
		return img;
	}

	public void setImg(String img)
	{
		this.img = img;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
}
