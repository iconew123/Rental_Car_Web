package rentalServer.user.model;

public class User {
	private String id;
	private String name;
	private String idenNum;
	private String mail;
	private String phone;
	private String telecom;
	
	public User(String id, String name, String idenNum, String mail, String phone, String telecom) {
		super();
		this.id = id;
		this.name = name;
		this.idenNum = idenNum;
		this.mail = mail;
		this.phone = phone;
		this.telecom = telecom;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdenNum() {
		return idenNum;
	}

	public void setIdenNum(String idenNum) {
		this.idenNum = idenNum;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTelecom() {
		return telecom;
	}

	public void setTelecom(String telecom) {
		this.telecom = telecom;
	}

}
