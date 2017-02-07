import java.util.ArrayList;

/**
 * Created by Das on 2/6/17.
 */

public class pizzabot {

    public static ArrayList<Coords> coordList = new ArrayList<Coords>();
    public static Coords origin = new Coords(0,0);
    public static String USAGE = "Usage: 'size' 'coordinates'";

    public static void main(String[] args) {

        //Checks number of arguments

        //parses inputs and adds them to an ArrayList
        parseInputs(args);

        //sorts the coordinates array lists based on distance from origin
        sortByDistance();

        //printCoordinates();

        //add origin to the beginning of the list
        coordList.add(0, origin);

        //prints directions from one coordinate to the next
        for(int i = 0; i < coordList.size()-1; i++){
            findPath(coordList.get(i), coordList.get(i+1));
        }


    }

    //prints array list of coordinates
    public static void printCoordinates(){
        for(int i = 0; i < coordList.size(); i++){
            System.out.println("(" + coordList.get(i).x + "," + coordList.get(i).y + ")");
        }
    }

    //parses arguments
    public static void parseInputs(String[] args){
        //checks for enough arguments
        if(args.length < 2){
            System.out.println(USAGE);
            return;
        }

        //first argument is size of grid
        String size = args[0];
        //parses remaining coordinates
        for(int i = 1; i < args.length; i++){
            String coordinate = args[i];
            int comma = coordinate.indexOf(',');
            int x = Integer.parseInt(coordinate.substring(1,comma)); //x coordinate
            int y = Integer.parseInt(coordinate.substring(comma+2,coordinate.length()-1)); //y coordinate
            Coords coord = new Coords(x,y);
            coordList.add(coord); //add pair to list
        }
    }

    public static double dist(Coords c1, Coords c2){
        int xdist = (int) Math.pow(c2.x - c1.x, 2);
        int ydist = (int) Math.pow(c2.y - c1.y, 2);
        double distance = Math.sqrt(xdist + ydist);
        return distance;
    }

    //prints path from c1 to c2
    public static void findPath(Coords c1, Coords c2){
        int xdist = c2.x - c1.x; //net x distance
        int ydist = c2.y - c1.y; //net y distance

        while(xdist != 0){
            if(xdist > 0){
                System.out.print("E");
                xdist--;
            }else{
                System.out.print("W");
                xdist++;
            }
        }
        while(ydist != 0){
            if(ydist > 0){
                System.out.print("N");
                ydist--;
            }else{
                System.out.print("S");
                ydist++;
            }
        }
        System.out.print("D");
    }

    //BUBBLESORT - by distance from origin
    public static void sortByDistance() {
        boolean swapped = true; // indicates if a swap has occurred. true on first pass
        double temp; //temp variable for distance swap
        Coords temp2; //temp variable for coordinate list swap
        ArrayList<Double> distances = new ArrayList<Double>(); //array list - distance from origin

        for(int i = 0; i < coordList.size(); i++){
            distances.add(dist(coordList.get(i), origin));
        }

        while (swapped){
            swapped = false; //set flag to false awaiting a possible swap
            for(int j=0; j<distances.size()-1;j++ ){
                if (distances.get(j) > distances.get(j+1)){ // swap if element(j) > element(j+1)
                    temp = distances.get(j);
                    distances.set(j,distances.get(j+1));
                    distances.set(j+1,temp);
                    temp2 = coordList.get(j);
                    coordList.set(j, coordList.get(j+1));
                    coordList.set(j+1, temp2);
                    swapped = true; //shows a swap occurred
                }
            }
        }
    }

}

