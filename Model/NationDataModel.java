package Model;

import java.io.UnsupportedEncodingException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NationDataModel {
	public NationDataModel() {

	}

	//특정 열 정보 전달
	public ArrayList<String> getList() {
		return null;
	}

	//특정 행 정보 전달
	public HashMap<String, String> getColumn(String contry_name) {
		ResultSet sql_res = null; //sql 작업 리턴값
		HashMap<String, String> res_data = new HashMap<>(); //최종 결과값
		String sql = String.format("select * from nation where contry='%s'", contry_name);

		try {
			//sql 작업
			sql_res = Database.getInstance().executeSql(sql);
			sql_res.next();
			ResultSetMetaData sql_meta = sql_res.getMetaData();

			//sql한 결과를 Map 리스트에 저장
			for (int i = 1; i <= sql_meta.getColumnCount(); i++) {
				res_data.put(sql_meta.getColumnName(i), sql_res.getString(i));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return res_data;
	}
	
	//해당 값이 포함되어 있는 나라들을 추출
	public ArrayList<String> find(String type, String value) {
		ResultSet sql_res = null; //sql 작업 리턴값
		ArrayList<String> finded = new ArrayList<>();
		String sql = String.format("select contry, %s from nation where %s like '%%%s%%'", type, type, value);

		try {
			//sql 작업
			sql_res = Database.getInstance().executeSql(sql);
			while (sql_res.next()) {
				finded.add(sql_res.getString("contry"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return finded;
	}

	public ResultSet sqlData(String sql) {
		ResultSet sql_result = null;
		try {
			sql_result = Database.getInstance().executeSql(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return sql_result;
	}
}
