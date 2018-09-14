import ch.aplu.jgamegrid.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Point;
import ch.aplu.util.*;
import java.awt.*;

class MainPlayer extends Actor implements GGKeyListener
{
  public static int goldAmount = 0;
  public MainPlayer()
  {
      super(false, "wizard2.png");
  }

  public boolean keyPressed(KeyEvent evt)
  {
    switch (evt.getKeyCode())
    {
      case KeyEvent.VK_UP:
        setDirection(270);
        break;
      case KeyEvent.VK_RIGHT:
        setDirection(0);
        break;
      case KeyEvent.VK_LEFT:
        setDirection(180);
        break;
      case KeyEvent.VK_DOWN:
        setDirection(90);  
        break;
    }
     move();
     tryToTake();
     showScore();
    
    return true;
  }

  public boolean keyReleased(KeyEvent evt)
  {
    return true;
  }
  public void tryToTake()
  {
    Actor actor = gameGrid.getOneActorAt(getLocation(), Gold.class);
    if (actor != null)
    {
        goldAmount++;
        gameGrid.setTitle("Gold: " + goldAmount);
        actor.removeSelf();
        for (int n = 0; n < 1; n++)
              gameGrid.addActor(new Gold(), gameGrid.getRandomEmptyLocation());
    }
  }
  public void showScore()
  {
      TextActor text = new TextActor("Anzahl Gold: "+goldAmount,Color.white,new Color(255,255,255,0),new Font("Arial",0,22));
      gameGrid.addActor(text, new Location(0,9));
      
  }
}