package alallenlab.example.requests;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;


public class NegotiationsTask extends AsyncTask<Void, Void, Void>{
	private MainActivity answ;
	private String responseResult;
	public NegotiationsTask(MainActivity answer){
		this.answ=answer;
	}
	
	@Override
	protected Void doInBackground(Void... params) {

		HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost("http://hb.resscode.org.ua/api/package");

	    try {
	        
	        // Execute HTTP Post Request
	        HttpResponse response = httpclient.execute(httppost);
	        HttpEntity ent= response.getEntity();
	        String strJson=EntityUtils.toString(ent);
	        JSONObject json = new JSONObject(strJson);
	        int resultCode = json.getInt("result");
	        responseResult= json.getString("result");
	        Log.d("POST OK",Integer.toString(resultCode));
	        
	        	        	        
	    } catch (Exception e) {
	        Log.d("POST NOT OK",e.toString());
	    }
		return null;
	}
	@Override
    protected void onPostExecute(Void params) {
		super.onPostExecute(params);
        answ.displayResult(responseResult);
        Log.d("negotiations", "responseResult="+responseResult);
        Log.d("negotiations","response sended to activity");
    }

}
