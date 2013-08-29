package home.alallenlab.homebuh;

public class TCathegory {
	private long id;
	private String cathegoryName;
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id=id;
	}
	
	public String getCathegoryName(){
		return this.cathegoryName;
	}
	
	public void setCathegoryName(String cathegoryName){
		this.cathegoryName=cathegoryName;
	}
	
	@Override
	public String toString(){
		return cathegoryName;
	}
}
