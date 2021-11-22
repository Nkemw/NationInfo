package Control;

import Model.NationDataModel;
import Model.SearchFilter;
import Model.SearchFilterModel;
import Model.SortModel;
import View.ViewFrame;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.text.View;



public class Controller {
	public NationDataModel data_model;
	//private SearchFilterModel filter_model;
	//private ViewFrame view_client;*/
	
	static String field_str = "";

	public Controller() {
		data_model = new NationDataModel();
		//filter_model = new SearchFilterModel();
		//view_client = new ViewFrame();
	}
	
	public void set_str(String str) {
		field_str = str;
	}
	public HashMap<String, String> get_ColumnInfo() {
		HashMap<String, String> temp = data_model.getColumn_contry(field_str);
		return temp;
	}
	
	public ArrayList<String> detail_search(String[] key, ArrayList<String> value){
		ArrayList<String> result = new ArrayList<>();
		SortModel sort = new SortModel();
		SearchFilterModel filter = new SearchFilterModel();
		NationDataModel nation = new NationDataModel();
		
		
		for(int i = 0; i < 5; i++) {
			if(!(value.get(i) == null)) {
				filter.add(new SearchFilter(key[i], SearchFilter.RIGHT_OPER, value.get(i)));
			}
		}
		result = nation.find_contry(filter);
		result = sort.sort(result);
		return result;
		
	}

	public static void main(String args[]) {

		Controller con = new Controller();
		
		String[] key = {"climate", "religion", "contry_code", "location", "area"};
		ArrayList<String> value = new ArrayList<>();
		value.add(null);
		value.add("기독교");
		value.add(null);
		value.add("아시아");
		value.add(null);
		
		ArrayList<String> result = con.detail_search(key, value);
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}