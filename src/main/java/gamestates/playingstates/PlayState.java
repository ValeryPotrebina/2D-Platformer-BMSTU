package gamestates.playingstates;

import gamestates.GameState;
import gamestates.GameStateInterface;

public abstract class PlayState extends GameState implements GameStateInterface {

    abstract void loadBackgroundImg();

    abstract void calcBorder();

    abstract void createButtons();

}
