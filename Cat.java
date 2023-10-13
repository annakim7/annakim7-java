import java.util.*;

public class Cat extends Creature{
    int timeSinceFed = 50;

    public Cat(int x, int y, City city, Random rnd){
        super(x,y,city, rnd);
        this.lab = 'y';
        stepLen = 2;
    }

    public void step(){
        // checks if cat did not eat 
        if(timeSinceFed == 0){
            this.dead = true;
            return;
        }
        // keep track of how long it has been since cat has eaten
        timeSinceFed--;
        if(rand.nextInt(100) < 5){
            randomTurn();
        }
        // calls creature step
        super.step();
    }

    public void takeAction(){
        //checks if this is cat
        if(this instanceof Cat == true){
            // iterates through city creature
            for(Creature creature : city.creatures){
                // checksif current creature is mouse
                if(creature instanceof Mouse == true){
                    // checks if mouse is at same points as cat
                if(this.dist(creature) == 0){
                    // mouse is eaten
                    timeSinceFed = 50;
                    creature.dead = true;
                    return;
                }
            }
        }
    }
        search();
    }



    public Creature findClosest(Creature cat){
        int closestDist = Integer.MAX_VALUE;
        Creature closest = null;
        // interate to find closest mouse (use dist function)
        for(Creature creature : city.creatures){
            // checks if creature at index i is a mouse
            if(creature instanceof Mouse == true){  
                int distance = cat.dist(creature) ;          
             // checks if mouse is within 20 blocks from cat
                  if(distance < closestDist && distance <20){
                    closest = creature;
                    closestDist = distance;
                 }
               
            }
        }
        return closest;
    }

    public void search(){
        Creature closest = findClosest(this);
        if(closest != null){
            lab = 'c';
            // gets the difference in coordinates between cat and mouse
            int x = closest.getX() - this.getX();
            int y = closest.getY() - this.getY();
            int newD;
            // determines which direciton to go
            if(Math.abs(x) >= Math.abs(y)){
                if(x > 0){
                    newD = Creature.EAST;
                }
                else {
                    newD = Creature.WEST;
                }
            }
            else{
                if(y>0){
                    newD = Creature.SOUTH;
                }
                else{
                    newD = Creature.NORTH;
                }
            }
            setDir(newD);
        }
        else{
            lab = 'y';
        }
    }

}


