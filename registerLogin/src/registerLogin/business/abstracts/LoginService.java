package registerLogin.business.abstracts;

import registerLogin.entities.concretes.Login;
import registerLogin.entities.concretes.User;

public interface LoginService {
void login(Login login, User user);
}
