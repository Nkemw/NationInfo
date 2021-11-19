package Model;

public class SearchFilter {
	public static String RIGHT_OPER = "+";
	public static String NOT_OPER = "-";

	private String type;
	private String operation;
	private String content;

	public SearchFilter(String ty, String op, String con) {
		type = ty;
		operation = op;
		content = con;
	}

	public String getType() {
		return type;
	}

	public String getOper() {
		return operation;
	}

	public String getContent() {
		return content;
	}

	public String getSql() {
		String where_sql = String.format("%s {op} '%%%s%%'", getType(), getContent());

		if (operation.equals(SearchFilter.RIGHT_OPER)) {
			where_sql = where_sql.replace("{op}", "like");
		}
		else if (operation.equals(SearchFilter.NOT_OPER)) {
			where_sql = where_sql.replace("{op}", "not like");
		}

		return where_sql;
	}
}
