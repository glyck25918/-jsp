package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.entityLFY;

public class DaoLFY extends BaseDao{

	public List<entityLFY> getLFY() {
		List<entityLFY> eList = new ArrayList<>();
		String sql = "SELECT   id, admin, yu, source, date FROM  messige order by date desc";
		
		ResultSet rSet =null;
		try {
			rSet =  super.executeQuery(sql);
			while (rSet.next()) {
				entityLFY sLfy = new entityLFY();
				sLfy.setId(rSet.getInt("id"));
				sLfy.setAdmin(rSet.getString("admin"));
				sLfy.setYu(rSet.getString("yu"));
				sLfy.setSource(rSet.getString("source"));
				sLfy.setDate(rSet.getDate("date"));
				
				
				eList.add(sLfy);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally{
			closeResultSet(rSet);
		}
		
		return eList;
	}

}
