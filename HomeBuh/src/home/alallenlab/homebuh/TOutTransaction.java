package home.alallenlab.homebuh;

import java.sql.Date;


public class TOutTransaction {
	private long id;
	private long idCathegory;
	private long idPocket;
	private Date dateTransaction;
	private String title;
	private String description;
	private float totalCount;
	
	final static String  COLUMN_ID="_id";
	final static String  COLUN_ID_CATHEGORY="id_cathegory";
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
	public Date getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(Date dateTransaction) {
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

}
