package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

//Class for test controller
public class Controller {
	//variable
	static private ArrayList<String> data_list; //temporary
	
	static private NationDataModel data_model;
	static private SearchFilterModel filter_model;
	static private View view_client;
	
	//run project
	public static void main(String[] args) {
		data_model = new NationDataModel();
		filter_model = new SearchFilterModel();
        view_client = new View();

        //view_client.run();
        
        /*
        //test code
        Controller controll = new Controller();
        controll.addFilter("����", "?", "�³�");
        controll.deleteFilter("����", "?", "�³�");
        controll.search();
        //ButtonListener button = new ButtonListener(controll);
        //button.pushButton();
        System.out.print("����\n");
        */
	}

	//find data
	public void search() {	
		//get SQL sentence to get data
		String sql = filter_model.getSql();
		data_list = data_model.getData(sql);
		//Iterator<String> i = data_list.iterator();
		
		//just test print
		for(String data : data_list)
			//output the imported data on the screen
			System.out.print(data + "\n");
	}
	
	//add filter
	public void addFilter(String type, String oper, String text) {
		SearchFilter filter = new SearchFilter(type, oper, text);
		filter_model.add(filter);
		
		//System.out.print(filter_model.getFilter(0).getType() + "\n");
	}
	
	//delete filter
	public void deleteFilter(String type, String oper, String text) {
		SearchFilter filter = new SearchFilter(type, oper, text);
		filter_model.delete(filter);
	}
	
	//����
	public void setEventListener() {
		//For now, pass
	}
	
	//set bookmark - temporary
	public void setBookmark() {
	}
}
