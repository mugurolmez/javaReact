package registerLogin.business.abstracts;

import registerLogin.core.abstracts.MailService;
import registerLogin.entities.concretes.User;

public interface UserService {
void singUp(User user,MailService mailService);




}
