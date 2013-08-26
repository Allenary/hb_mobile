package home.alallenlab.homebuh;

import java.sql.Date;

import android.content.ContentValues;
import android.content.Context;
//import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import home.alallenlab.homebuh.TOutTransaction;

public class TOutTransactionDataSource {
	private SQLiteDatabase database;
	private DbBasic dbHelper;
	//private String[] allColumns = { DbBasic.COLUMN_ID,    DbBasic.COLUMN_CATHEGORY };

	public TOutTransactionDataSource(Context context){
		dbHelper= new DbBasic(context);
	}
	
	public void open(){
		database = dbHelper.getWritableDatabase();
	}
	
	public void close(){
		dbHelper.close();
	}
	
	public void createOutTransaction (String title, String description, float totalCount, long idCathegory){
	    ContentValues values = new ContentValues();
	    values.put(TOutTransaction.COLUMN_TITLE, title);
	    values.put(TOutTransaction.COLUMN_DESCRIPTION, description);
	    //values.put(TOutTransaction.COLUMN_DATE_TRANSACTION, transactionDate);
	    values.put(TOutTransaction.COLUMN_TOTAL_COUNT, totalCount);
	    values.put(TOutTransaction.COLUN_ID_CATHEGORY,idCathegory);
	    
	    long insertId = database.insert(TOutTransaction.TABLE_NAME, null,
	        values);
	    /*Cursor cursor = database.query(DbBasic.TABLE_CATHEGORY,
	        allColumns, DbBasic.COLUMN_ID + " = " + insertId, null,
	        null, null, null);
	    cursor.moveToFirst();*/
	    //TCathegory newCathegory = cursorToCathegory(cursor);
	   // cursor.close();
	   // return newCathegory;
	}
	public void delete—athegory(TCathegory cathegory) {
	    long id = cathegory.getId();
	    System.out.println("Comment deleted with id: " + id);
	    database.delete(DbBasic.TABLE_CATHEGORY, DbBasic.COLUMN_ID
	        + " = " + id, null);
	    }
	/*private TCathegory cursorToCathegory(Cursor cursor) {
		TCathegory cathegory = new TCathegory();
		cathegory.setId(cursor.getLong(0));
		cathegory.setCathegoryName(cursor.getString(1));
	    return cathegory;
	}*/
}
