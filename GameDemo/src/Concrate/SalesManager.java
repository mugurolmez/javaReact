package Concrate;

import Entities.Customer;
import Entities.Game;
import Entities.Offer;

public class SalesManager extends BaseSalesManager {

	public void sales(Customer customer, Game game) {

		System.out.println(customer.getFirstName() + " isimli üyeye " + game.getGame() + " satışı yapıldı");
	}

	public void offerSales(Customer customer, Game game, Offer offer) {

		System.out.println(
				offer.getName() + customer.getFirstName() + " isimli üyeye " + game.getGame() + " satışı yapıldı");

	}

}
