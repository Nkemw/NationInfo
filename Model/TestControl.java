package Model;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class TestControl {
        //test code
        public static void main(String[] arg) throws SQLException {
            NationDataModel nation_data = new NationDataModel();
            HashMap<String, String> res = nation_data.getColumn("불가리아");
            res.entrySet().stream().forEach(entry -> {
                System.out.printf("%s : %s\n", entry.getKey(), entry.getValue());
            });
            ArrayList<String> nations = nation_data.find("climate", res.get("climate"));
            nations.stream().forEach(nation -> {System.out.println(nation);});
        }
}
