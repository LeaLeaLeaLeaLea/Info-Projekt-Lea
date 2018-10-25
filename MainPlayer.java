import ch.aplu.jgamegrid.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Point;
import ch.aplu.util.*;
import java.awt.*;

class MainPlayer extends Actor implements GGKeyListener
{
  public static int goldAmount = 0;
  private TextActor text = new TextActor("Anzahl Gold: "+goldAmount,Color.white,new Color(255,255,255,0),new Font("Arial",0,22));
  //MainPlayer mainPlayer;
  //public static int trapDamage = 5;
  
  public MainPlayer()
  {
      super(false, "wizard2.png");
  }

  public boolean keyPressed(KeyEvent evt)
  {
       
   Actor actor = gameGrid.getOneActorAt(getLocation(), MainPlayer.class);
   int xLoca = actor.getX();
   int yLoca = actor.getY();    
   switch (evt.getKeyCode())
        {
          case KeyEvent.VK_UP:
            setDirection(270);
            if (yLoca != 0)
                move(); 
            break;
          case KeyEvent.VK_RIGHT:
            setDirection(0);
            if (xLoca != 9)
                move(); 
            break;
          case KeyEvent.VK_LEFT:
            setDirection(180);
            if (xLoca != 0)
                move(); 
            break;
          case KeyEvent.VK_DOWN:
            setDirection(90);
            if (yLoca != 9)
                move(); 
            break;
        }
   
     tryToTake();
     activateTrap();
     showScore();
     changeDifficulty();
     
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
        actor.removeSelf();
        for (int n = 0; n < 1; n++)
              gameGrid.addActor(new Gold(), gameGrid.getRandomEmptyLocation());
    }
  }
  public void activateTrap()
  {
    Actor actor = gameGrid.getOneActorAt(getLocation(), Trap.class);
    if (actor != null)
    {
        goldAmount--;
        actor.removeSelf();
        for (int n = 0; n < 1; n++)
              gameGrid.addActor(new Trap(), gameGrid.getRandomEmptyLocation());
    }
  }
  public void showScore()
  {
      text.removeSelf();
      text = new TextActor("Anzahl Gold: "+goldAmount,Color.white,new Color(255,255,255,0),new Font("Arial",0,30));
      gameGrid.addActor(text, new Location(0,9));
  }
  public void changeDifficulty()
  {
   /*   if (goldAmount >= 20)
           gameGrid.setSimulationPeriod(160);
      if (goldAmount >= 40)
           gameGrid.setSimulationPeriod(110);
      if (goldAmount >= 60)
           gameGrid.setSimulationPeriod(80);  
      if (goldAmount >= 80)
           gameGrid.setSimulationPeriod(60);*/
           
      if (goldAmount >= 5)
           gameGrid.setSimulationPeriod(160);
      if (goldAmount >= 10)
           gameGrid.setSimulationPeriod(110);
      if (goldAmount >= 15)
           gameGrid.setSimulationPeriod(80);  
      if (goldAmount >= 20)
           gameGrid.setSimulationPeriod(60);      
  }
}