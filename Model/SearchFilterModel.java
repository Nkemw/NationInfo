package Model;

import java.util.*;

public class SearchFilterModel {
	private ArrayList<SearchFilter> filter_list;
	
	public SearchFilterModel() {
		filter_list = new ArrayList<SearchFilter>();
	}
	
	//add
	public boolean add(SearchFilter new_ft) {
		for (SearchFilter ft : filter_list) {
			if (ft.equals(new_ft)) {
				return false;
			}
		}
		filter_list.add(new_ft);
		return true;
	}
	
	//delete
	public boolean delete(SearchFilter target_ft) {
		for (SearchFilter ft : filter_list) {
			if (ft.equals(target_ft)) {
				filter_list.remove(target_ft);
				return true;
			}
		}
		return false;
	}

	//create sql
	public String getSql() {
		String sql = "";
		for (SearchFilter filter : filter_list) {
			sql += filter.getSql();
			sql += " AND ";
		}
		sql = sql.substring(0, sql.length()-5); // 마지막 AND 문 삭제
		return sql;
	}

	//get filter
	public List<SearchFilter> getFilter() {
		return filter_list;
	}

	public boolean isFilter(String target) {
		for (SearchFilter filter : filter_list) {
			if (filter.equals(target)) {
				return true;
			}
		}
		return false;
	}
}
