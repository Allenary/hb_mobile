package home.alallenlab.homebuh;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
	
	public List<TPocket> getAllPockets() {
	    //List<String> cathegories = new ArrayList<String>();
		List<TPocket> pockets = new ArrayList<TPocket>();
	    Cursor cursor = database.query(TPocket.TABLE_NAME,
	    		TPocket.allColumns, null, null, null, null, null);

	    cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
	    	TPocket pocket = cursorToPocket(cursor);
	      //cathegories.add(cathegory.getCathegoryName());
	      pockets.add(pocket);
	      cursor.moveToNext();
	    }
	    // Make sure to close the cursor
	    cursor.close();
	    return pockets;
	  }
	private TPocket cursorToPocket(Cursor cursor) {
		TPocket pocket = new TPocket();
		pocket.setId(cursor.getLong(0));
		pocket.setName(cursor.getString(1));
		pocket.setDescription(cursor.getString(2));
		pocket.setCount(cursor.getFloat(3));
		pocket.setIsDefaultPocket(cursor.getInt(4));
	    return pocket;
	}
}
