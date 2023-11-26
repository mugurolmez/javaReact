package registerLogin.business.concretes;

import registerLogin.business.abstracts.LoginService;
import registerLogin.entities.concretes.Login;
import registerLogin.entities.concretes.User;

public class GoogleLoginManager implements LoginService {

	@Override
	public void login(Login login, User user) {
		if(login.getLoginMail()==user.getEmail() && login.getLoginpasword()==user.getPassword()) {
			System.out.println("Google ile Giriş Başarılı Hoşgeldin "+user.getName());
			return;
			
		}else {
			
			System.out.println("Google ile Giriş Başarısız. Email ve Şifrenizi Kontrol Ediniz");
		}
		
	}

}
