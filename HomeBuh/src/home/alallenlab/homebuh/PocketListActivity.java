package home.alallenlab.homebuh;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PocketListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pocket_list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pocket_list, menu);
		return true;
	}

}
