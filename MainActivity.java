import ch.aplu.jgamegrid.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Point;
import ch.aplu.util.*;
import java.awt.*;

public class MainActivity extends GameGrid
{
  public int goldAmount = 0;  
  MainPlayer mainPlayer;
  Gold gold;
  
  public MainActivity()
  {
    super(10, 10, 100, Color.gray,"background5.jpg");
    mainPlayer = new MainPlayer();
    addActor(mainPlayer, new Location(0,0));
    addKeyListener(mainPlayer);
    
    Villain villain = new Villain(mainPlayer);
    addActor(villain, new Location(10,10));
    
    for (int i = 0; i < 6; i++)
    {
        gold = new Gold();
        addActor(gold, getRandomEmptyLocation());
    }
      
    setTitle("Sammle Gold & Lass dich nicht erwischen!");
    
    countScore();
    show();
    doRun();
  }
  public static void main(String[] args)
  {
    new MainActivity();
  }
    public void countScore()
  {
      Actor actor1 = getOneActorAt(mainPlayer.getLocation(), Gold.class);
      if (actor1 != null)
      {
        goldAmount++;
      }
  }
  //TO DO:
  //Pro 10(?) Münzen immer schneller
  //Spieler nicht aus Spielfeld laufen
  //Game Over Screen?
}