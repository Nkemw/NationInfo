package Model;

import java.util.*;

public class NationDataModel {
	private Database DB_server;

	public NationDataModel() {
		DB_server = Database.getInstance();
	}

	public ArrayList<String> getData(String sq){
		ArrayList<String> al = new ArrayList<String>();
		//get Data use sq from database
		al.add("ù ��°");
		al.add("�� ��°");
		al.add("�� ��°");
		return al;
	}
}
