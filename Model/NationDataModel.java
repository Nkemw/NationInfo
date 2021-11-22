package Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class NationDataModel {
	public final static String SQL_BASIC = "select contry_code from nation";
	public final static String SQL_ALL = "select * from nation";

	//특정 열 정보 전달
	public ArrayList<String> getList() {
		return null;
	}

	//특정 행 정보 전달
	public HashMap<String, String> getColumn_contry(String contry) {
		ResultSet sql_res = null; //sql 작업 리턴값
		HashMap<String, String> res_data = new HashMap<>(); //최종 결과값
		String sql = String.format(SQL_ALL + " where contry='%s'", contry);

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
	
	public HashMap<String, String> getColumn(String contry_code) {
		ResultSet sql_res = null; //sql 작업 리턴값
		HashMap<String, String> res_data = new HashMap<>(); //최종 결과값
		String sql = String.format(SQL_ALL + " where contry_code='%s'", contry_code);

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
	public ArrayList<String> find_contry(String type, String value) {
		ResultSet sql_res = null; //sql 작업 리턴값
		ArrayList<String> finded = new ArrayList<>();
		String sql = String.format(SQL_ALL + " where %s like '%%%s%%'", type, value);
		System.out.println(sql);

		try {
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
	
	public ArrayList<String> find_contry(SearchFilterModel filter) {
		String sql = String.format(SQL_ALL + " where %s", filter.getSql());
		System.out.println(sql);

		ResultSet sql_res = null; //sql 작업 리턴값
		ArrayList<String> finded = new ArrayList<>();
		try {
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
	
	public ArrayList<String> find(String type, String value) {
		ResultSet sql_res = null; //sql 작업 리턴값
		ArrayList<String> finded = new ArrayList<>();
		String sql = String.format(SQL_BASIC + " where %s like '%%%s%%'", type, value);
		System.out.println(sql);

		try {
			sql_res = Database.getInstance().executeSql(sql);
			while (sql_res.next()) {
				finded.add(sql_res.getString("contry_code"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return finded;
	}

	public ArrayList<String> find(SearchFilter filter) {
		String sql = String.format(SQL_BASIC + " where %s", filter.getSql());
		System.out.println(sql);

		ResultSet sql_res = null; //sql 작업 리턴값
		ArrayList<String> finded = new ArrayList<>();
		try {
			sql_res = Database.getInstance().executeSql(sql);
			while (sql_res.next()) {
				finded.add(sql_res.getString("contry_code"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return finded;
	}

	public ArrayList<String> find(SearchFilterModel filter_model) {
		String sql = String.format(SQL_BASIC + " where %s", filter_model.getSql());
		System.out.println(sql);

		ResultSet sql_res = null; //sql 작업 리턴값
		ArrayList<String> finded = new ArrayList<>();
		try {
			sql_res = Database.getInstance().executeSql(sql);
			while (sql_res.next()) {
				finded.add(sql_res.getString("contry_code"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return finded;
	}

	public String getName(String contry_code) {
		String contry_name = null;

		ResultSet sql_res = null;
		String sql = String.format("select contry from nation where contry_code='%s'", contry_code);
		try {
			sql_res = Database.getInstance().executeSql(sql);
			sql_res.next();
			contry_name = sql_res.getString("contry");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return contry_name;
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
