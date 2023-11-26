package Abstract;

import Entities.Game;
import Service.IGameService;

public interface BaseGameManager extends IGameService {

	public void add(Game game);

	public void delete(Game game);

	public void update(Game game);

}
