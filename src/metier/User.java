package metier;

public class User {
 
	private int idu;
	private String email;
	private String password;
	public int getIdu() {
		return idu;
	}
	public void setIdu(int idu) {
		this.idu = idu;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
		public User(){}
	public User(String email, String password) {
		
		this.email = email;
		this.password = password;
	}

}
