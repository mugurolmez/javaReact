package Abstract;

import Entities.Customer;
import Service.ICustomerCheckService;

public abstract class BaseCustomerCheckManager implements ICustomerCheckService {
	public abstract boolean ifRealPerson(Customer customer);
}
