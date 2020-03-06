package service;

import java.util.List;

import dao.DaoLFY;
import dao.Daoykw;
import entity.Material;
import entity.entityLFY;

public class ServiceLFY {

	public List<entityLFY> getLFY() {
		// TODO 自动生成的方法存根
		return new DaoLFY().getLFY();
	}

	public List<Material> lfy(String id) {
		// TODO 自动生成的方法存根
		return new Daoykw().lfy(id);
	}

}
