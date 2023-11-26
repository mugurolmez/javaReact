package Service;

import Entities.Customer;
import Entities.Game;
import Entities.Offer;

public interface ISalesService {
	void sales(Customer customer, Game game);

	void offerSales(Customer customer, Game game, Offer offer);

}
