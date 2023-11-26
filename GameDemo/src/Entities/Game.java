package Entities;

public class Game {
	private int id;
	private String game;
	private double gamePrice;

	public Game(int id, String game, double gamePrice) {
		super();
		this.id = id;
		this.game = game;
		this.gamePrice = gamePrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public double getGamePrice() {
		return gamePrice;
	}

	public void setGamePrice(double gamePrice) {
		this.gamePrice = gamePrice;
	}

}
