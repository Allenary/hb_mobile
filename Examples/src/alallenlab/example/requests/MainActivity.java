package alallenlab.example.requests;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void CheckInternetState(View view){
		ConnectivityManager cm =
		        (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		    NetworkInfo netInfo = cm.getActiveNetworkInfo();
		    TextView tv = (TextView)findViewById(R.id.tInternetState);
		    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
		        tv.setText("Net ok");
		    }
		    else tv.setText("no Net ");
	}
	public void postData(View view) {
		//TextView tv = (TextView)findViewById(R.id.tInternetState);
	    // Create a new HttpClient and Post Header
	    try{
	    	new negotiationsTask().execute();
	    }catch(Exception e){Log.d("MAIN", e.toString());}
	} 

}
