package Model;

import java.util.*;

public class SearchFilterModel {
	private ArrayList<SearchFilter> filter_list;
	
	public SearchFilterModel() {
		filter_list = new ArrayList<SearchFilter>();
	}
	
	//add
	public boolean add(SearchFilter new_ft) {
		if (isIncluded(new_ft)) {
			return false;
		}
		filter_list.add(new_ft);
		return true;
	}
	
	//delete
	public boolean delete(SearchFilter target_ft) {
		if (!isIncluded(target_ft)) {
			return false;
		}
		filter_list.remove(target_ft);
		return true;
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
	public ArrayList<SearchFilter> getFilterList() {
		return filter_list;
	}

	public boolean isIncluded(SearchFilter target) {
		for (SearchFilter filter : filter_list) {
			if (filter.equals(target)) {
				return true;
			}
		}
		return false;
	}
}
