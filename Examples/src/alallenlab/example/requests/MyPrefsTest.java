package alallenlab.example.requests;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class MyPrefsTest {
	private final String PREFERENCE_NAME="HomeBuhPref";
	private SharedPreferences preferences;
	
	private String paramUserSecretKey="UserSecretKey";
	private String paramUserId="UserId";
	private String paramBlowfish="blowfish";
	
	public MyPrefsTest(Context context){
		preferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
	}
	private void addParam(String name, String value){
		Editor ed = preferences.edit();
		ed.putString(name,value);
		ed.commit();
	}
	public void addBlowfish(){
		/*
		 * TODO
		 * value should be added from server answer
		 */
		addParam(paramBlowfish, "7LiWkbRg9OZghj4TSAx5YgkcjZsEF5PJauCP6aeAf6yLRWQFegQrkXIzBxOYPneF");
		Log.d(this.getClass().getSimpleName(),"blowfish added");
	}
	public void addUserId(){
		/*
		 * TODO
		 * value should be added from server answer
		 */
		addParam(paramUserId, "3");
		Log.d(this.getClass().getSimpleName(),"userId added");
	}
	
	public void addUserSecretKey(){
		/*
		 * TODO
		 * value should be added from server answer
		 */
		addParam(paramUserSecretKey, "T7SiPbidGSzTl{m2@@=:>{`s;[NIL5Op");
		Log.d(this.getClass().getSimpleName(),"UserSecretKey added");
	}
	
	/*
	 * this is stub. Will be removed in real app.
	 */
	public void addAll(){
		addUserSecretKey();
		addUserId();
		addBlowfish();
	}
	private String getSomething(String paramName){
		String str =  preferences.getString(paramName, "");
		Log.d(this.getClass().getSimpleName(),paramName+"="+str);
		return str;
	}
	public String getBlowfish(){
		return getSomething(paramBlowfish);
	}
	public String getUserId(){
		return getSomething(paramUserId);
	}
	public String getUserSecretKey(){
		return getSomething(paramUserSecretKey);
	}
	
}
