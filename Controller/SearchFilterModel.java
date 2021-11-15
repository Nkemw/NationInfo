package Controller;

import java.util.*;

public class SearchFilterModel{
	private ArrayList<SearchFilter> filter_list;
	
	public SearchFilterModel() {
		filter_list = new ArrayList<SearchFilter>();
	}
	
	//temporary method
	public String getSql() {
		return "This is SQL sentence";
	}
	
	//get filter(temporary Method)
	public List<SearchFilter> getFilter() {
		return filter_list;
	}
	public SearchFilter getFilter(int index) {
		return filter_list.get(index);
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
}
