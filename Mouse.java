import java.util.*;

public class Mouse extends Creature{

    private int round = 0;

    public Mouse(int x, int y, City city, Random rnd){
        super(x,y,city, rnd);
        this.lab = 'b';
        this.stepLen = 1;
        round = 0;
    }

    //add step
  public void step(){
    round++;
      if(round == 23){
          this.dead = true;
          return;
      }
      if (this.rand.nextInt(10) < 2){
          randomTurn();}
      super.step();
  }


//make takeAction
   public void takeAction(){
    // checks if round is at 20 to make a new mouse
    if(round == 20){
        this.city.birthMouse(this.getX(), this.getY());
        return;
    }
}

}