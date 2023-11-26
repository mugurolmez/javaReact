package Concrate;

import Entities.Offer;
import Service.IOfferService;

public class OfferManager implements IOfferService {

	@Override
	public void add(Offer offer) {
		System.out.println("Kampanya Eklendi" + offer.getName());

	}

	@Override
	public void delete(Offer offer) {
		System.out.println("Kampanya silinidi");

	}

	@Override
	public void update(Offer offer) {
		System.out.println("Kampanya güncellendi");

	}

}
