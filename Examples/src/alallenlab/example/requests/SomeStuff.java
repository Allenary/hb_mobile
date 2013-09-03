package alallenlab.example.requests;

public class SomeStuff {
	private String stuffString;
	private int stuffInt;
	
	public SomeStuff(String s, int i){
		this.stuffString=s;
		this.stuffInt=i;
	}
	
	public String getStuffString() {
		return stuffString;
	}
	public void setStuffString(String stuffString) {
		this.stuffString = stuffString;
	}
	public int getStuffInt() {
		return stuffInt;
	}
	public void setStuffInt(int stuffInt) {
		this.stuffInt = stuffInt;
	}
}
