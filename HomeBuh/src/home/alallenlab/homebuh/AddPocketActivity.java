package home.alallenlab.homebuh;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import home.alallenlab.homebuh.TPocketDataSource;

public class AddPocketActivity extends Activity {
/*
 * TODO:
 * If datasource opened, it should be closed. You have to find how to do this.
 */
	private TPocketDataSource datasource;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_pocket);
		datasource = new TPocketDataSource(this);
		datasource.open();
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_pocket, menu);
		return true;
	}
	public void addPocket(View view){
		Log.d("addPocketActivity","just clicked");
		TextView name = (TextView) findViewById(R.id.tPocketName);
		TextView description = (TextView) findViewById(R.id.tDescription);
		TextView money = (TextView) findViewById(R.id.tCountMoney);
		CheckBox chDefault = (CheckBox)findViewById(R.id.chSetDefault);
		int isDefault;
		if(chDefault.isChecked()) isDefault=1;
		else isDefault=0;
		try{
			datasource.createPocket(name.getText().toString(), 
									description.getText().toString(),
									Integer.parseInt(money.getText().toString()),
									isDefault);
		}catch (Exception ex){Log.d("addPocketActivity", "insert unsuccesfull: "+ex.toString());}
	}

}
