package Model;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class TestControl {
    NationDataModel data_model = new NationDataModel();

    //test code
    public static void main(String[] arg) throws SQLException {
        TestControl test = new TestControl();
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
}
