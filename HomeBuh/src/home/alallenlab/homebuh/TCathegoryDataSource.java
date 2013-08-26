package home.alallenlab.homebuh;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import home.alallenlab.homebuh.DbBasic;

public class TCathegoryDataSource {
	private SQLiteDatabase database;
	private DbBasic dbHelper;
	private String[] allColumns = { DbBasic.COLUMN_ID,
		      DbBasic.COLUMN_CATHEGORY };
	
	public TCathegoryDataSource(Context context){
		dbHelper= new DbBasic(context);
	}
	
	public void open(){
		database = dbHelper.getWritableDatabase();
	}
	
	public void close(){
		dbHelper.close();
	}
	
	public TCathegory createCathegory (String cathegoryName){
	    ContentValues values = new ContentValues();
	    values.put(DbBasic.COLUMN_CATHEGORY, cathegoryName);
	    long insertId = database.insert(DbBasic.TABLE_CATHEGORY, null,
	        values);
	    Cursor cursor = database.query(DbBasic.TABLE_CATHEGORY,
	        allColumns, DbBasic.COLUMN_ID + " = " + insertId, null,
	        null, null, null);
	    cursor.moveToFirst();
	    TCathegory newCathegory = cursorToCathegory(cursor);
	    cursor.close();
	    return newCathegory;
	}
	public void delete—athegory(TCathegory cathegory) {
	    long id = cathegory.getId();
	    System.out.println("Comment deleted with id: " + id);
	    database.delete(DbBasic.TABLE_CATHEGORY, DbBasic.COLUMN_ID
	        + " = " + id, null);
	    }
	public void deleteCathegory(String cathegoryName){
		System.out.println("Comment deleted with name: " + cathegoryName);
	    /*database.delete(DBbasic.TABLE_CATHEGORY, DBbasic.COLUMN_CATHEGORY
	        + " = ' " + cathegoryName+"'", null);*/
	    database.execSQL("delete from "+DbBasic.TABLE_CATHEGORY
	    				+ " where "+DbBasic.COLUMN_CATHEGORY+" like '"+cathegoryName+"'");
	}
	private TCathegory cursorToCathegory(Cursor cursor) {
		TCathegory cathegory = new TCathegory();
		cathegory.setId(cursor.getLong(0));
		cathegory.setCathegoryName(cursor.getString(1));
	    return cathegory;
	}
	
	public List<TCathegory> getAllCathegories() {
	    //List<String> cathegories = new ArrayList<String>();
		List<TCathegory> cathegories = new ArrayList<TCathegory>();
	    Cursor cursor = database.query(DbBasic.TABLE_CATHEGORY,
	    		allColumns, null, null, null, null, null);

	    cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
	      TCathegory cathegory = cursorToCathegory(cursor);
	      //cathegories.add(cathegory.getCathegoryName());
	      cathegories.add(cathegory);
	      cursor.moveToNext();
	    }
	    // Make sure to close the cursor
	    cursor.close();
	    return cathegories;
	  }
	
}

