package DataPackage;

import java.util.*;

public class DataDriver {

	public static void main(String[] args) {
		//Data data = new Data();
		DataExploration data_ex = new DataExploration();
		ControllerForFilter cont = new ControllerForFilter();
		ArrayList<String> str_a;
		
		//for(String[] i : data.table_data)
		//	System.out.print(i[0] + " " + i[1] + " " + i[2] + "\n");
		//for(String i : data_ex.str)
		//	System.out.print(i + "\n");
		
		//ArrayList<String> str = data_ex.getNames();
		//for(String s : str)
		//	System.out.print(s + "\n");
		

		/*
		String[] str = data_ex.getData("���Ҷ�");
		//data_ex.getData("Ÿ�̿�");
		if(str != null)
			for(String i : str)
				System.out.print(i + " ");
		else
			System.out.print("�����Ͱ� �����ϴ�.");
		*/
		
		/*
		//time check
		long beforeTime = System.currentTimeMillis(); //�ڵ� ���� ���� �ð� �޾ƿ���
        
		//������ �ڵ� �߰�
		String[] str = data_ex.getData("�����̽þ�");
		//data_ex.getData("Ÿ�̿�");
		if(str != null) {
			for(String i : str)
				System.out.print(i + " ");
			System.out.print("\n");
		} else
			System.out.print("�����Ͱ� �����ϴ�.\n"); 
		
		long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
		long secDiffTime = (afterTime - beforeTime); //�� �ð��� �� ���
		System.out.println("�ð����� : "+ secDiffTime);		
		*/
		
		/*
		ArrayList<Integer> i = new ArrayList<Integer>();
		i.add(1);
		i.add(5);
		i.add(10);
		ArrayList<String> str = data_ex.getNames(i);
		for(String k : str)
			System.out.print(k + " ");
		System.out.print("\n");
		*/
		
		long beforeTime = System.currentTimeMillis(); //�ڵ� ���� ���� �ð� �޾ƿ���
		
		String[] str = data_ex.getData("���Ҷ�");
		//data_ex.getData("Ÿ�̿�");
		if(str != null) {
			for(String i : str)
				System.out.print(i + " ");
			System.out.print("\n");
		} else
			System.out.print("�����Ͱ� �����ϴ�.\n"); 
		
		cont.addFilter("����", "�ƿ��뼺");
		cont.addFilter("����", "�ұ�");
		ArrayList<Integer> result = cont.search();
		for(int i : result)
			System.out.print(i + " ");
		System.out.print("\n");
		
		str_a = data_ex.getNames(result);
		for(String i : str_a)
			System.out.print(i + " ");
		System.out.print("\n");
		
		long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
		long secDiffTime = (afterTime - beforeTime); //�� �ð��� �� ���
		System.out.println("�ð�����(ms) : "+ secDiffTime);
	}
}
