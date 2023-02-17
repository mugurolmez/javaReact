package registerLogin.core.concretes;

import registerLogin.core.abstracts.MailService;
import registerLogin.dataAccess.abstracts.UserDao;
import registerLogin.entities.concretes.User;

public class MailManager implements MailService {
	
	

	



	@Override
	public void SendConfirmationMail() {
	System.out.println("Aktivasyon Maili Gonderildi Üyeliği Tamamlamak İçin Mail Adresinizdeki Linki Tıklayın");
		
	}
	
	
	

	@Override
	public void ClickApproveMembershipLink(User user,UserDao userDao) {
		
	
		
		System.out.println("Link Tıklandı");
		userDao.add();
		System.out.println(user.getEmail()+" Üyelik İşleminiz Onaylanmıştır");
		
		
		

		
		
	}

}
