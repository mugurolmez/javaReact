package Concrete;

import Abstract.BaseCustomerManager;
import Abstract.ICustomerCheckService;
import Entities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager {

	@Override
	public void save(Customer customer) {

		if (customer.getNationalityId() == "12345678910") {
			super.save(customer);
		} else {

			System.out.println("Not a valid person");
		}

	}

}
