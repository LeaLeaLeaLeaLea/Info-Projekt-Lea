import ch.aplu.jgamegrid.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Point;
import ch.aplu.util.*;
import java.awt.*;

public class Villain extends Actor
{
  private MainPlayer mainPlayer;

  public Villain(MainPlayer mainPlayer)
  {
    super(true, "dragon2.png");
    this.mainPlayer = mainPlayer;
  }

  public void act()
  {
    if (nbCycles % 5 == 0 && !mainPlayer.isRemoved())
    {
      setDirection(getLocation().getCompassDirectionTo(mainPlayer.getLocation()));
      move();
    }
    Actor player = gameGrid.getOneActorAt(getLocation(), MainPlayer.class);
    if (player != null){
      gameGrid.getBg().setFont(new Font("SansSerif", Font.BOLD, 120));
      gameGrid.getBg().setPaintColor(Color.white);
      gameGrid.getBg().drawText("Game Over!", new Point(120, 500));
      
      gameGrid.getBg().setFont(new Font("SansSerif", Font.BOLD, 50));
      gameGrid.getBg().setPaintColor(Color.black);      
      gameGrid.getBg().drawText("Gold gesammelt: "+MainPlayer.goldAmount, new Point(210, 580));
      
      player.removeSelf();
    }
  }
} 