import ch.aplu.jgamegrid.*;
import java.awt.Color;
import java.awt.event.KeyEvent;

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
    Actor aPlayer = gameGrid.getOneActorAt(getLocation(), MainPlayer.class);
    if (aPlayer != null)
      aPlayer.removeSelf();
  }
} 