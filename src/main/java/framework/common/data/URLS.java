package framework.common.data;

public enum URLS {

	MAIN_PAGE("http://tut.by");
	
	
	private String url;
	
	URLS(String url){
		this.url = url;
	}
	
	public String getURL(){
		return url;
	}
	
	
	
}
