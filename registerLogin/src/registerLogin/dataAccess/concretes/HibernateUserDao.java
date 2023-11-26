package registerLogin.dataAccess.concretes;

import registerLogin.dataAccess.abstracts.UserDao;

public class HibernateUserDao implements UserDao {

	@Override
	public void add() {
		
System.out.println("hibernate ile eklendi");		
	}
	
}