
import registerLogin.business.abstracts.LoginService;
import registerLogin.business.abstracts.UserService;
import registerLogin.business.adapters.GoogleServiceAdapter;
import registerLogin.business.concretes.GoogleLoginManager;
import registerLogin.business.concretes.LoginManager;
import registerLogin.business.concretes.UserManager;
import registerLogin.core.abstracts.MailService;
import registerLogin.core.concretes.MailManager;
import registerLogin.dataAccess.abstracts.UserDao;
import registerLogin.dataAccess.concretes.HibernateUserDao;
import registerLogin.entities.concretes.Login;
import registerLogin.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user = new User(1, "uğur", "Ölmez", "m.ugurolmez@hotmail.com", "123456");
		UserService userService = new UserManager();
		userService.singUp(user,new MailManager());
		
		MailService mailService =new MailManager();
		mailService.ClickApproveMembershipLink(user,new HibernateUserDao());
		
		System.out.println("-------------------------------------------------");
		Login login=new Login("m.ugurolmez@hotmail.com", "123456");
		LoginService loginService=new GoogleLoginManager();
		loginService.login(login, user);
	
	

	}
}
