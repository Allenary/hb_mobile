package alallenlab.example.requests;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.util.Log;

public class negotiationsTask extends AsyncTask<Void, Void, Void>{

	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost("http://hb.resscode.org.ua/api/package");

	    try {
	        
	        // Execute HTTP Post Request
	        HttpResponse response = httpclient.execute(httppost);
	        HttpEntity ent= response.getEntity();
	        Log.d("POST OK",EntityUtils.toString(ent));
	        
	        	        	        
	    } catch (Exception e) {
	        Log.d("POST NOT OK",e.toString());
	    }
		return null;
	}

}
