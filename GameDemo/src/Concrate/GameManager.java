package Concrate;

import Abstract.BaseGameManager;
import Entities.Game;

public class GameManager implements BaseGameManager {

	@Override
	public void delete(Game game) {
		System.out.println("Oyun Silindi");

	}

	@Override
	public void update(Game game) {
		System.out.println("Oyun Güncellendi");

	}

	@Override
	public void add(Game game) {
		System.out.println("Oyun Eklendi" + game.getGame());
	}

}
