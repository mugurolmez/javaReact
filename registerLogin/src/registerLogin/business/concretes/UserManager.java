package registerLogin.business.concretes;

import registerLogin.business.abstracts.UserService;
import registerLogin.core.abstracts.MailService;
import registerLogin.entities.concretes.User;

public class UserManager implements UserService {
	String namesPattern = "^[a-zA-ZğĞçÇşŞüÜöÖıİ]{2,}";
	String passwordPattern = "([\\S]{6,})";
	String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

	
	



	public void singUp(User user,MailService mailService) {

		if (user.getName().matches(namesPattern)) {

		} else {
			System.out.println(user.getName() + " Geçersiz Lütfen Geçerli bir isim giriniz.");
			return;
		}

		if (user.getPassword().matches(passwordPattern)) {

		} else {
			System.out.println("Şifre alanı En az 6 haneli Olmalıdır lütfen geçerli bir şifre giriniz.");
			return;
		}

		if (user.getEmail().matches(emailPattern)) {

		} else {

			System.out.println("Lütfen Geçerli Bir email adresi giriniz");
			return;
		}

		
		mailService.SendConfirmationMail();

	}



	


}
