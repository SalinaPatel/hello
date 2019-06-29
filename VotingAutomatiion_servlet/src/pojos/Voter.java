package pojos;


public class Voter{
	private int vid;
	private String name;
	private String email;
	private String password;
	private int status;
	public Voter(int vid, String name, String email, String password, int status) {
		super();
		this.vid = vid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
		
		
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
} 