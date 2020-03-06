package service;

import java.util.List;

import dao.JmjDao;
import entity.Add;
import entity.Jmj;

public class JmjService
{

	public List<Jmj> getQuery(int id)
	{
		// TODO Auto-generated method stub
		return new JmjDao().getQuery(id);
	}

	public List<Jmj> getAdd(String id)
	{
		// TODO Auto-generated method stub
		return new JmjDao().getAdd(id);
	}

	public boolean getAddP(Add add)
	{
		// TODO Auto-generated method stub
		return new JmjDao().getAddP(add) > 0 ? true : false;
	}

	public List<Add> getQueryp()
	{
		// TODO Auto-generated method stub
		return new JmjDao().getQueryp();
	}

}
