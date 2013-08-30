package home.alallenlab.homebuh;

import java.util.List;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;

public class PocketListActivity extends ListActivity {
	private TPocketDataSource datasource;
	ArrayAdapter<TPocket> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pocket_list);
		datasource = new TPocketDataSource(this);
        datasource.open();

        List<TPocket> values = datasource.getAllPockets();
        adapter = new ArrayAdapter<TPocket>(this, android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pocket_list, menu);
		return true;
	}
	 public void openAddPocketView(View view){
		 Intent i = new Intent(this, AddPocketActivity.class);
	     startActivity(i);
	 }

}
