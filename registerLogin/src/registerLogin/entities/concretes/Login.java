package registerLogin.entities.concretes;

public class Login {
	private String loginMail;
	private String loginpasword;
	public Login(String loginMail, String loginpasword) {
		super();
		this.loginMail = loginMail;
		this.loginpasword = loginpasword;
	}
	public String getLoginMail() {
		return loginMail;
	}
	public void setLoginMail(String loginMail) {
		this.loginMail = loginMail;
	}
	public String getLoginpasword() {
		return loginpasword;
	}
	public void setLoginpasword(String loginpasword) {
		this.loginpasword = loginpasword;
	}

}
