package service;

import java.util.List;

import dao.Daoykw;
import entity.Material;
import entity.Proojectykw;
import entity.Userykw;

public class Serviceykw
{

	public List<Proojectykw> ajax()
	{
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		return new Daoykw().ajax();
	}

	public boolean zhucheajax(Userykw userykw)
	{
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		Userykw aUserykw = new Daoykw().zhucheajax(userykw.getAdmin());
		if (aUserykw == null)
		{
			return false;
		}
		else if (aUserykw.getAdmin().equals(userykw.getAdmin()))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	public boolean zhuce(Userykw userykw)
	{
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		return new Daoykw().zhuce(userykw) > 0 ? true : false;
	}

	public boolean zhucetj(Userykw userykw)
	{
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		return new Daoykw().zhucetj(userykw) > 0 ? true : false;
	}

	public boolean dengluykw(Userykw userykw)
	{
		Userykw aUserykw = new Daoykw().dengluykw(userykw.getAdmin());
		if (aUserykw == null)
		{
			return false;
		}
		else if (aUserykw.getAdmin().equals(userykw.getAdmin()))
		{
			if (aUserykw.getPassword().equals(userykw.getPassword()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	public List<Proojectykw> message(String admin)
	{
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		return new Daoykw().message(admin);
	}

	public boolean tjanjia(Proojectykw proojectykw)
	{
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		return new Daoykw().tianjia(proojectykw) > 0 ? true : false;
	}

	public boolean deleteykew(Userykw userykw)
	{
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		return new Daoykw().deleteykw(userykw) > 0 ? true : false;

	}

	public boolean getykw(Material material, String userykwadmin) {
		// TODO 自动生成的方法存根
		return new Daoykw().getykw(material,userykwadmin) > 0 ? true : false;
	}


}
