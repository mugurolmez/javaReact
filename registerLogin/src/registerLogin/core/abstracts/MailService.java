package registerLogin.core.abstracts;

import registerLogin.dataAccess.abstracts.UserDao;
import registerLogin.entities.concretes.User;

public interface MailService {	
	void SendConfirmationMail();
	void ClickApproveMembershipLink(User User,UserDao userdao);
	
}
