package registerLogin.business.adapters;

import registerLogin.core.abstracts.MailService;
import registerLogin.dataAccess.abstracts.UserDao;
import registerLogin.entities.concretes.User;

public class GoogleServiceAdapter implements MailService{

	@Override
	public void SendConfirmationMail() {
		System.out.println("Google ile Aktivasyon Maili Gonderildi Üyeliği Tamamlamak İçin Mail Adresinizdeki Linki Tıklayın");
	}

	@Override
	public void ClickApproveMembershipLink(User User, UserDao userdao) {

		System.out.println("Link Tıklandı");
		userdao.add();
		System.out.println(User.getEmail()+" Google hesabınız ile Üyelik İşleminiz Onaylanmıştır");
		
	}

}
