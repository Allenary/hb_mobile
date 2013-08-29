package home.alallenlab.homebuh;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class TPocketDataSource {
	private SQLiteDatabase database;
	private DbBasic dbHelper;
	//private String[] allColumns = { DbBasic.COLUMN_ID,    DbBasic.COLUMN_CATHEGORY };

	public TPocketDataSource(Context context){
		dbHelper= new DbBasic(context);
	}
	
	public void open(){
		database = dbHelper.getWritableDatabase();
	}
	
	public void close(){
		dbHelper.close();
	}
	
	public void createPocket (String name, String description, float countMoney, int isDefault){
	    ContentValues values = new ContentValues();
	    values.put(TPocket.COLUMN_NAME, name);
	    values.put(TPocket.COLUMN_DESCRIPTION, description);
	    values.put(TPocket.COLUMN_COUNT_MONEY, countMoney);
	    values.put(TPocket.COLUMN_IS_DEFAULT, isDefault);
	        
	    long insertId = database.insert(TPocket.TABLE_NAME, null,
	        values);
	}
}
