import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Simulator {
	
    public static void main(String[] args) {

        final String USAGE = "java Simulator numMice numCats numZombieCats rounds [randSeed]";

        boolean DEBUG = false;
        
        //parse arguments
        if(args.length < 4){
            System.out.println("ERROR: missing arguments");
            System.out.println(USAGE);
            System.exit(1);
        }
        int numMice = Integer.parseInt(args[0]);
        int numCats = Integer.parseInt(args[1]);
        int numZombieCats = Integer.parseInt(args[2]);
        int rounds = Integer.parseInt(args[3]);

        Random rand;
        if(args.length > 4)
            rand = new Random(Integer.parseInt(args[4]));
        else
            rand = new Random(100);

        if(args.length > 5 && args[5].equals("--DEBUG")){
            DEBUG=true;
        }

        // Populate city with walls, bunnies, zombies, and mice
        City city= new City(rand,numMice,numCats,numZombieCats);
        int count = 0;

        //TODO ...
        /*
         * Every 100 rounds, a mouse is added to a random location in the city
        Every 25 rounds, a cat is added to a random location in the city. 
        To pass the unit tests, random turning should be implemented by assigning the 
        nextInt(4) from the creature’s Random object (that is set in the constructor). 
        Recall the entire simulation shares the same Random object 
        across all creatures in the city.

         */
        int N = 100;
        int M = 25;
        //END TODO

        while (count < rounds) {
            count++;

            //TODO...
            //
            // Every N rounds, add a mouse
            if(count % N == 0){
                city.addMouse();
            }
            
            //Every M rounds, add a Cat
            if(count % M == 0){
                city.addCat();
            }
            //END TODO
            
            city.simulate();
            System.out.println("done "+count);
            System.out.flush();

            if(DEBUG){
                System.err.print("Enter anything to continue: ");
                try{
                    (new BufferedReader(new InputStreamReader(System.in))).readLine();
                }catch(Exception e){
                    System.exit(1);
                }
            }
            
        }
    }
}
