package home.alallenlab.homebuh;

import java.io.File;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

public class DbBasic extends SQLiteOpenHelper{

	public final static String  DB_NAME="test1.db";
	public final static String FILE_DIR="HomeBuh";
	public final static int  DB_VERSION=1;
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_CATHEGORY = "cathegory_name";
	public static final String TABLE_CATHEGORY = "cathegory";
	
	private static final String TABLE_CREATE_CATHEGORY = "create table "
			  + TABLE_CATHEGORY + "(" + COLUMN_ID
		      + " integer primary key autoincrement, " 
		      + COLUMN_CATHEGORY+" text not null);";
	
	private static final String TABLE_CREATE_OUT_TRANSACTION = "create table "
			  + TOutTransaction.TABLE_NAME + "(" + TOutTransaction.COLUMN_ID
		      + " integer primary key autoincrement, " 
		      + TOutTransaction.COLUMN_ID_POCKET +" integer, "
		      + TOutTransaction.COLUN_ID_CATHEGORY+" integer, "
		      + TOutTransaction.COLUMN_TITLE+" text not null, "
		      + TOutTransaction.COLUMN_DESCRIPTION+" text, "
		    //  + TOutTransaction.COLUMN_DATE_TRANSACTION
		      + TOutTransaction.COLUMN_TOTAL_COUNT+" real);";
	public static final String FULL_DB_PATH=Environment.getExternalStorageDirectory()
            + File.separator + FILE_DIR
            + File.separator +DB_NAME;
	
	public DbBasic(Context context) {
		super(context, FULL_DB_PATH, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(TABLE_CREATE_CATHEGORY);
		db.execSQL(TABLE_CREATE_OUT_TRANSACTION);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DbBasic.class.getName(),
		        "Upgrading database from version " + oldVersion + " to "
		        + newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATHEGORY);
		onCreate(db);
		
	}

}
