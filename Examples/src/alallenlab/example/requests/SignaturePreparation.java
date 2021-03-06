package alallenlab.example.requests;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
//import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

//import android.content.SharedPreferences;
//import android.preference.PreferenceManager;
import android.util.Log;
import android.content.Context;

public class SignaturePreparation {
	
	//private static String userSecretKey="T7SiPbidGSzTl{m2@@=:>{`s;[NIL5Op";
	//private static String blowfish = "7LiWkbRg9OZghj4TSAx5YgkcjZsEF5PJauCP6aeAf6yLRWQFegQrkXIzBxOYPneF";
	//private static String USER_ID="3";
	private MyPrefsTest myPrefs;
	
	public SignaturePreparation(Context context){
		myPrefs = new MyPrefsTest(context);
	}
	

	protected String getAuthKey(String params){
		String blowfish=myPrefs.getBlowfish();
		String userSecretKey = myPrefs.getUserSecretKey();
		Log.d("Auth before md5",blowfish+params+userSecretKey);
		String strMd5 = md5(blowfish+params+userSecretKey);
		Log.d ("MD5 auth", strMd5);
		return strMd5;
	}
	public static final String md5(final String s) {
	    try {
	        // Create MD5 Hash
	        MessageDigest digest = java.security.MessageDigest
	                .getInstance("MD5");
	        digest.update(s.getBytes());
	        byte messageDigest[] = digest.digest();
	 
	        // Create Hex String
	        StringBuffer hexString = new StringBuffer();
	        for (int i = 0; i < messageDigest.length; i++) {
	            String h = Integer.toHexString(0xFF & messageDigest[i]);
	            while (h.length() < 2)
	                h = "0" + h;
	            hexString.append(h);
	        }
	        return hexString.toString();
	 
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return "";
	}
	public static JSONObject getSimpleJSON(){
		JSONObject obj = new JSONObject();
		try {
			obj.put("stuff","some stuff");
			obj.put("answerFormat", "json");
			obj.put("compression", "none");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	public  ArrayList<NameValuePair> getAllPostParams(){
		String param = getSimpleJSON().toString();
		
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("userId", myPrefs.getUserId()));
        nameValuePairs.add(new BasicNameValuePair("authKey", getAuthKey(param)));
        nameValuePairs.add(new BasicNameValuePair("parameters", param));
		
		
		return nameValuePairs;
	}
	
}
