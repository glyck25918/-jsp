package service;

import java.util.List;

import dao.DaoLFY;
import dao.Daoykw;
import entity.Material;
import entity.entityLFY;

public class ServiceLFY {

	public List<entityLFY> getLFY() {
		// TODO �Զ����ɵķ������
		return new DaoLFY().getLFY();
	}

	public List<Material> lfy(String id) {
		// TODO �Զ����ɵķ������
		return new Daoykw().lfy(id);
	}

}
