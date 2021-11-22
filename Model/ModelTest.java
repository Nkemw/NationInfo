package Model;

import Control.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ModelTest {
    NationDataModel data_model = new NationDataModel();

    //test code
    public static void main(String[] arg) throws SQLException {
        ModelTest test = new ModelTest();
        test.testFilter();
    }

    public void testGetColumn() {
        HashMap<String, String> res = data_model.getColumn("AD");
        res.entrySet().stream().forEach(entry -> {
            System.out.printf("%s : %s\n", entry.getKey(), entry.getValue());
        });
        System.out.println("====================");
    }

    public void testFind() {
        String test_content = "지중해";
        System.out.println("search climate: " + test_content);
        ArrayList<String> nations;
//        nations = data_model.find("climate", res.get("climate")); //find 메소드
        nations = data_model.find(new SearchFilter("climate", SearchFilter.RIGHT_OPER, test_content)); //SearchFilter find 메소드
        nations.stream().forEach(nation -> {System.out.println(nation);});
    }

    public void testFilter() {
        SearchFilterModel filterModel = new SearchFilterModel();
        filterModel.add(new SearchFilter("location", SearchFilter.RIGHT_OPER, "유럽"));
        filterModel.add(new SearchFilter("religion", SearchFilter.NOT_OPER, "가톨릭"));
        System.out.println(filterModel.getSql());
        ArrayList<String> nations = data_model.find(filterModel);
        nations.stream().forEach(nation -> {System.out.println(data_model.getName(nation) + " : " + nation);});
    }


    public void testSort() {
        String[] arr = {"뷁", "궳쉗", "답섭궨", "뷁가", "난동", "다람쥐", "라일락", "마즙", "바보", "사과", "아저씨", "자석", "차", "카레", "타조", "하마"};
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr));
        System.out.println("===");
        list = SortModel.sort(list);
        System.out.println("===");
        list.stream().forEach(item -> {System.out.print(item + " ");});
    }

}
