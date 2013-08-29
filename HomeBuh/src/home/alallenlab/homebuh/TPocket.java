package home.alallenlab.homebuh;

public class TPocket {
	private long id;
	private String name;
	private String description;
	private float count;  //i.e. how much money in pocket
	private int isDefaultPocket;
		
	final static String  COLUMN_ID="_id";
	final static String  COLUMN_NAME="name";
	final static String  COLUMN_DESCRIPTION="description";
	final static String  COLUMN_COUNT_MONEY="count_money";
	final static String  COLUMN_IS_DEFAULT="is_default"; //0= non-default, 1=default
	
	final static String  TABLE_NAME="pocket";
	
	final static String[] allColumns={COLUMN_ID,COLUMN_NAME,COLUMN_DESCRIPTION,COLUMN_COUNT_MONEY,COLUMN_IS_DEFAULT};
	
	@Override
	public String toString() {
		return name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getCount() {
		return count;
	}
	public void setCount(float count) {
		this.count = count;
	}
	public int getIsDefaultPocket() {
		return isDefaultPocket;
	}
	public void setIsDefaultPocket(int isDefaultPocket) {
		this.isDefaultPocket = isDefaultPocket;
	}
	
	
}
