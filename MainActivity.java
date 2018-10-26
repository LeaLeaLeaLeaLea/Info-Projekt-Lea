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
  Trap trap;
  
  public MainActivity()
  {
    super(10, 10, 100, null,"background5.jpg");
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
      
        for (int i = 0; i < 1; i++)
    {
        trap = new Trap();
        addActor(trap, getRandomEmptyLocation());
    }
    
    setTitle("Sammle Gold, vermeide Gift & Lass dich nicht erwischen!");
    
    show();
    doRun();
  }
  public static void main(String[] args)
  {
    new MainActivity();
  }
}