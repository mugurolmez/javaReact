import java.time.LocalDate;

import Abstract.BaseCustomerManager;
import Adapters.MernisDogrulama;
import Concrate.BaseSalesManager;
import Concrate.CustomerManager;
import Concrate.GameManager;
import Concrate.OfferManager;
import Concrate.SalesManager;
import Entities.Customer;
import Entities.Game;
import Entities.Offer;

public class Main {

	public static void main(String[] args) {
		Customer customer = new Customer(1, "UĞUR", "ÖLMEZ", "12345678910", LocalDate.of(1987, 01, 01),
				"m.ugurolmez@hotmail.com");

		BaseCustomerManager customerManager = new CustomerManager(new MernisDogrulama());
		customerManager.add(customer);

		Game game = new Game(1, "Süper Oyun", 100);
		Offer offer = new Offer(1, "Yılbaşı", 10, 90);

		GameManager gameManager = new GameManager();
		gameManager.add(game);
		OfferManager offerManager = new OfferManager();
		offerManager.add(offer);

		System.out.println("-------------------------------");

		BaseSalesManager salesManager = new SalesManager();
		salesManager.sales(customer, game);

		System.out.println("-------------------------------");
		salesManager.offerSales(customer, game, offer);

	}
}
