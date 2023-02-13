package Concrate;

import Abstract.BaseCustomerCheckManager;
import Entities.Customer;

public class CheckPersonManager extends BaseCustomerCheckManager {

	public boolean ifRealPerson(Customer customer) {
		System.out.println("Tc Onaysız");
		return true;
	}

}
