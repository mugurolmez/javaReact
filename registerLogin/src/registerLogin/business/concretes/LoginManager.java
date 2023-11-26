package registerLogin.business.concretes;

import registerLogin.business.abstracts.LoginService;
import registerLogin.entities.concretes.Login;
import registerLogin.entities.concretes.User;

public class LoginManager implements LoginService {

	public void login(Login login, User user) {
		if(login.getLoginMail()==user.getEmail() && login.getLoginpasword()==user.getPassword()) {
			System.out.println("Giriş Başarılı Hoşgeldin "+user.getName());
			return;
			
		}else {
			
			System.out.println("Giriş Başarısız. Email ve Şifrenizi Kontrol Ediniz");
		}
	}

}
