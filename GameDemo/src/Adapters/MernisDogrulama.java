package Adapters;

import Abstract.BaseCustomerCheckManager;
import Abstract.BaseCustomerManager;
import Entities.Customer;

//MERNİS SİMÜLASYONU
public class MernisDogrulama extends BaseCustomerCheckManager {
	public boolean ifRealPerson(Customer customer) {
		if (customer.getNationalityId() == "12345678910" && customer.getFirstName() == "UĞUR"
				&& customer.getLastName() == "ÖLMEZ" && customer.getDateOfBirth().getYear() == 1987) {

			System.out.println("Mernis Onaylandı");
			return true;

		} else {
			return false;
		}
	}

}
