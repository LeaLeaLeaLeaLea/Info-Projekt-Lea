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
     countScore();
     tryToTake();
    
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
       actor.hide();
    }
  }
  public void countScore()
  {
      Actor actor1 = gameGrid.getOneActorAt(getLocation(), Gold.class);
      if (actor1 != null)
      {
        goldAmount++;
        gameGrid.setTitle("Gold: " + goldAmount);
        //gameGrid.setStatusText("Gold: " + goldAmount);
      }
  }
}