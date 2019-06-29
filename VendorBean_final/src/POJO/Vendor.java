package POJO;
import javax.persistence.*;

@Entity
@Table(name="Vendor2")
public class Vendor {
	
	private Integer vid;
	private String vname,email,password,city,phoneno;
	
	//constructor
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="vid")
	public Integer getVid() {
		return vid;
	}
	
	public Vendor(String name, String email, String password, String city, String phoneno) {
		super();
		this.vname = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.phoneno = phoneno;
	}

	
	public Vendor() {
		super();
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}
	
	@Column(length=20,unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(length=20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(length=20)

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(length=20)

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", email=" + email + ", password=" + password + ", city=" + city + ", phoneno="
				+ phoneno + "]";
	}

	
	@Column(length=20)
	public String getName() {
		return vname;
	}

	public void setName(String name) {
		this.vname = name;
	}
	
	//to string
	
	
	
	

}
