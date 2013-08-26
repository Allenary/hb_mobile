package home.alallenlab.homebuh;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_out_transaction);
		TextView tDate= (TextView) findViewById(R.id.tTransactionDate);
		Calendar c = Calendar.getInstance();
		tDate.setText(c.getTime().toString());
		datasource = new TOutTransactionDataSource(this);
        datasource.open();
	}
	public void ShowAddCathegoryScreen(View view){
		//Class targetActivity=ManageCathegoryActivity.class;
		Intent second = new Intent(this, ManageCathegoryActivity.class);
		//second.putExtra("SelectedCathegory", "");
		startActivityForResult(second,1);
	}
	
	public void addOutTransaction(View view){
		EditText tTitle = (EditText) findViewById(R.id.tTitle);
		EditText tTotalCount = (EditText) findViewById(R.id.tTotalCount);
		datasource.createOutTransaction(tTitle.getText().toString(), "description1", Integer.parseInt(tTotalCount.getText().toString()), 1);
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
	    TextView t= (TextView)findViewById(R.id.tSelectedCathegory);
	    t.setText(cath);
	  } 
}
