package Model;

public class SetupModel {
    private final int[] SIZE_LIST = {8, 10, 12};
    private final String[] LANG_LIST = {"korean", "english"};

    private int font_size;
    private String lang_type;

    public SetupModel() {
        font_size = 10;

    }

    public void setFontSize(int size) {
        font_size = size;
    }

    public void setLangType(String type) {
        lang_type = type;
    }
}
