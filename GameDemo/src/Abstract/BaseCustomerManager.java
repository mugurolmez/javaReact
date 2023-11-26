package Abstract;

import Entities.Customer;
import Service.ICustomerService;

public interface BaseCustomerManager extends ICustomerService {
	void add(Customer customer);

}
