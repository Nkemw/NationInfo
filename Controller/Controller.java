package Controller;

import View.View;
import Model.NationDataModel;

import java.util.*;

//Class for test controller
public class Controller {
	//variable
	static private ArrayList<String> data_list; //temporary
	
	static private NationDataModel data_model;
	static private View view_client;
//	static private SearchFilterModel filter_model;
	
	//run project
	public static void main(String[] args) {
		data_model = new NationDataModel();
        view_client = new View();
	}

	//find data
	public void search() {
		//just test print
		for(String data : data_list)
			//output the imported data on the screen
			System.out.print(data + "\n");
	}

	public void addFilter(String type, String oper, String text) {
		SearchFilter filter = new SearchFilter(type, oper, text);
//		filter_model.add(filter);
		
		//System.out.print(filter_model.getFilter(0).getType() + "\n");
	}

	public void deleteFilter() {
//		filter_model.delete(filter);
	}

	public void setEventListener() {
		//For now, pass
	}

}
