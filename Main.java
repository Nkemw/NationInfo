import Controller.Controller;
import Model.NationDataModel;
import Model.SearchFilter;
import Model.SearchFilterModel;
import View.Lessons;

public class Main {

    //run project
    public static void main(String[] args) {
        NationDataModel data_model = new NationDataModel();
        SearchFilterModel filter_model = new SearchFilterModel();
        Lessons view_client = new Lessons();
        Controller control = new Controller(data_model, filter_model, view_client);
    }
}
