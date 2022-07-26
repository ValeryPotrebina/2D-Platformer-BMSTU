package gamestates.playingstates;

import gamestates.GamePanelInterface;
import gamestates.GamePanelListenerInterface;
import gamestates.GameState;

public abstract class PlayState extends GameState implements GamePanelInterface, GamePanelListenerInterface {

    abstract void loadBackgroundImg();

    abstract void calcBorder();

    abstract void createButtons();

}
