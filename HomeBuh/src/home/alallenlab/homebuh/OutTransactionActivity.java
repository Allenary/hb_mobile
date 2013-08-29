package home.alallenlab.homebuh;

import java.sql.Date;
import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
//import android.widget.Button;
import home.alallenlab.homebuh.ManageCathegoryActivity;

public class OutTransactionActivity extends Activity {

	private TOutTransactionDataSource datasource;
	private Intent pageCathegory;
	private long cathegoryId=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_out_transaction);
		TextView tDate= (TextView) findViewById(R.id.tTransactionDate);
		Calendar c = Calendar.getInstance();
		//tDate.setText(c.getTime().toString());
		long lNow=c.getTimeInMillis();
		Date dNow = new Date(lNow);
		tDate.setText(dNow.toString());
		/*Dialog dialog = new Dialog(this);
		dialog.setTitle("test dial");
		dialog.show();*/
		datasource = new TOutTransactionDataSource(this);
        datasource.open();
	}
	public void ShowAddCathegoryScreen(View view){
		//Class targetActivity=ManageCathegoryActivity.class;
		pageCathegory = new Intent(this, ManageCathegoryActivity.class);
		startActivityForResult(pageCathegory,1);
	}
	
	public void addOutTransaction(View view){
		long selectedDate=Calendar.getInstance().getTimeInMillis();
		Log.d("OutTransactionActivity", "Cathegory id = "+cathegoryId);
		EditText tTitle = (EditText) findViewById(R.id.tTitle);
		EditText tTotalCount = (EditText) findViewById(R.id.tTotalCount);
		datasource.createOutTransaction(tTitle.getText().toString(), 
										"description1",
										Integer.parseInt(tTotalCount.getText().toString()),
										cathegoryId,
										selectedDate);
		Log.d("out trs", "out transaction added to db");
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.out_transaction, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (data == null) {return;}
	    String cath = data.getStringExtra("exCathegoryName");
	    cathegoryId=data.getLongExtra("exCathegoryId",0); //not the best way, but now i don't how to do better
	    TextView t= (TextView)findViewById(R.id.tSelectedCathegory);
	    t.setText(cath);
	  } 
}
