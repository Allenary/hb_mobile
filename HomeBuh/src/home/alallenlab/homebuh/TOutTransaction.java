package home.alallenlab.homebuh;

import java.sql.Date;

import org.json.JSONException;
import org.json.JSONObject;


public class TOutTransaction {
	private long id;
	private long idCathegory;
	private long idPocket;
	private long dateTransaction;
	private String title;
	private String description;
	private float totalCount;
	
	final static String  COLUMN_ID="_id";
	final static String  COLUMN_ID_CATHEGORY="id_cathegory";
	final static String  COLUMN_ID_POCKET="id_pocket";
	final static String  COLUMN_DATE_TRANSACTION="date_transaction";
	final static String  COLUMN_TITLE="title";
	final static String  COLUMN_DESCRIPTION="description";
	final static String  COLUMN_TOTAL_COUNT="total_count";
	final static String  TABLE_NAME="out_transaction";
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdCathegory() {
		return idCathegory;
	}
	public void setIdCathegory(long idCathegory) {
		this.idCathegory = idCathegory;
	}
	public long getIdPocket() {
		return idPocket;
	}
	public void setIdPocket(long idPocket) {
		this.idPocket = idPocket;
	}
	public long getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(long dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(float totalCount) {
		this.totalCount = totalCount;
	}
	public JSONObject getObjectAsJson(){
		JSONObject outTransactionJson = new JSONObject();
		try {
			outTransactionJson.put(COLUMN_ID_CATHEGORY, idCathegory);
			outTransactionJson.put(COLUMN_ID_POCKET, idPocket);
			outTransactionJson.put(COLUMN_DATE_TRANSACTION, dateTransaction);
			outTransactionJson.put(COLUMN_TITLE, title);
			outTransactionJson.put(COLUMN_DESCRIPTION, description);
			outTransactionJson.put(COLUMN_TOTAL_COUNT, totalCount);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return outTransactionJson;
	}

}
