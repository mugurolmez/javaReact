import java.time.LocalDate;

import Abstract.BaseCustomerManager;
import Abstract.ICustomerService;
import Adapters.MernisServiceAdapter;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) {
		BaseCustomerManager customerManager = new StarbucksCustomerManager();
		customerManager.save(new Customer(1, "MUHAMMET UĞUR", "ÖLMEZ", LocalDate.of(2000, 01, 01), "12345678910"));
	}

}
