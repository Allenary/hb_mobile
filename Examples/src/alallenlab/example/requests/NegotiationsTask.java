package alallenlab.example.requests;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;


public class NegotiationsTask extends AsyncTask<Void, Void, Void>{
	private MainActivity answ;
	private String responseResult;
	private final String URL="http://hb.resscode.org.ua/api/package";
	public NegotiationsTask(MainActivity answer){
		this.answ=answer;
	}
	
	@Override
	protected Void doInBackground(Void... params) {

		HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost(URL);
	    

	    try {
	    	
	    	httppost.setEntity(new UrlEncodedFormEntity(new SignaturePreparation(answ).getAllPostParams()));
	    }
	    catch(Exception e){Log.d("setEntity",e.toString());}
	    try{
	        // Execute HTTP Post Request
	        HttpResponse response = httpclient.execute(httppost);
	        HttpEntity ent= response.getEntity();
	        String strJson=EntityUtils.toString(ent);
	        JSONObject json = new JSONObject(strJson);
	        responseResult= json.getString("result");
	        Log.d("POST OK",strJson);
	        
	        	        	        
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
