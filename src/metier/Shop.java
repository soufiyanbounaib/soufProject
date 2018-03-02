package metier;

public class Shop {
 
	private int ids;
	private String designation;
	public int getIds() {
		return ids;
	}
	public void setIds(int ids) {
		this.ids = ids;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Shop(){}
	public Shop(int ids, String designation) {
		super();
		this.ids = ids;
		this.designation = designation;
	}
}
