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
    super(10, 10, 100, Color.gray,"background3.jpg");
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
   
    /*Actor actor = getOneActorAt(mainPlayer.getLocation(), Gold.class);  
    if(actor != null)
        goldAmount++;*/
    TextActor text = new TextActor("Anzahl Gold: "+goldAmount,Color.white,new Color(255,255,255,0),new Font("Arial",0,22));
    addActor(text, new Location(0,9));
      
    setTitle("Sammle alles Gold & Lass dich nicht erwischen!");
    
    countScore();
    addGold();
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
  public void addGold()
  {
      Actor gold = getOneActorAt(mainPlayer.getLocation(), Gold.class); 
      if (gold != null)
       {
          for (int n = 0; n < 1; n++)
              addActor(new Gold(), getRandomEmptyLocation());
       }
  }
}