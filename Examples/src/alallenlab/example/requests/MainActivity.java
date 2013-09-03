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
import alallenlab.example.requests.SignaturePreparation;

public class MainActivity extends Activity {
	
	public void displayResult(String result) {
		TextView tv = (TextView)findViewById(R.id.tInternetState);
		tv.setText(result);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*try{
	    	new NegotiationsTask(this).execute();
	    }catch(Exception e){Log.d("MAIN", e.toString());}*/
	   
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
	public void  postData(View view){
		try{
	    	new NegotiationsTask(this).execute();
	    }catch(Exception e){Log.d("MAIN", e.toString());}
		
		
	}
	

}
