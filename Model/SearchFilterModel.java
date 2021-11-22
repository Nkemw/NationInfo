package Model;

import Model.SearchFilter;

import java.util.*;

public class SearchFilterModel {
	public final static String ORDER_ASCEND = "ASC";
	public final static String ORDER_DESCEND = "DESC";

	private ArrayList<SearchFilter> filter_list;
	private HashMap<String, String> sort_setting; //type과 order를 키로 가지며, 각각 정렬할 타입과 정렬 방향을 결정한다.
	
	public SearchFilterModel() {
		filter_list = new ArrayList<SearchFilter>();
		sort_setting = new HashMap<String, String>() {{
			put("type", "contry_code");
			put("order", ORDER_ASCEND);
		}};
	}
	
	//filter list modification
	public boolean add(SearchFilter new_ft) {
		if (isIncluded(new_ft)) {
			return false;
		}
		filter_list.add(new_ft);
		return true;
	}

	public boolean delete(SearchFilter target_ft) {
		if (!isIncluded(target_ft)) {
			return false;
		}
		filter_list.remove(target_ft);
		return true;
	}

	//filter_list 배열을 반환
	public ArrayList<SearchFilter> getFilterList() {
		return filter_list;
	}

	//매개변수인 filter와 내용(type, oper, content)이 같은 filter가 존재하는지 확인
	public boolean isIncluded(SearchFilter target) {
		for (SearchFilter filter : filter_list) {
			if (filter.equals(target)) {
				return true;
			}
		}
		return false;
	}

	//정렬 기준 설정
	public void setSort(String type, String order) {
		sort_setting.put("type", type);
		sort_setting.put("order", order);
	}

	//create sql
	public String getSql() {
		String sql = "";
		for (SearchFilter filter : filter_list) {
			sql += filter.getSql();
			sql += " AND ";
		}
		sql = sql.substring(0, sql.length()-5); // 마지막 AND 문 삭제
		sql += String.format(" order by %s %s", sort_setting.get("type"), sort_setting.get("order"));
		return sql;
	}

}
