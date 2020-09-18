import java.util.*;
public class NewInstrument implements Instrument {

    // Initialized int to be used in frequency formula in a for loop
    // Created a linked list within a array to store all of the information

    int CONCERT_A = 440;
    ArrayList<LinkedList<Double>> guitarStrings = new ArrayList<LinkedList<Double>>();

    // Created a string variable to include the alphabet layout from a keyboard
    // Stored it into an array, 1 index = 1 letter
    ArrayList<Character> key = new ArrayList<Character>();
    String alphas = "qwertyuiopasdfghjklzxcvbnm";

    public NewInstrument() {
        // Made a for each loop to read in each string and add it to array
        for (Character c : alphas.toCharArray()) {
            key.add(c);
        }

        // Created another linked list called bufferSize to temporarily store
        // the information before adding it to guitarStrings.
        for (int i = 0; i < key.size(); i++) {
            double frequency = CONCERT_A * Math.pow(2.0, (i - 24) / 12.0);
            double size = 44100 / frequency;
            LinkedList<Double> bufferSize = new LinkedList<Double>();

            // Created a for loop that reads in the randomized size of the buffer
            // After reading it in, it will loop, adding X amount of 0s equal to the size
            for (int j = 0; j < size; j++) {
                bufferSize.add(0.0);
            }
            guitarStrings.add(bufferSize);
            // Then it exits the for loop and then the information is stored into bufferSize
            // and sent to its final destination, guitarStrings.

        }
    }

    public void pluck(char key) {
       
        // Created int to store the position of the key that is being searched in the String alphas.
        // Used the int to get its index from guitarStrings and storing it into a new LinkedList.
       int Index = alphas.indexOf(key); 
       LinkedList<Double> keys = guitarStrings.get(Index);
    
       // Made a for-loop to traverse through all of the values of the new LinkedList
       // to replace its values with random numbers from -0.5,0.5.
        for(int w = 0; w < keys.size(); w++)
        {
            double randoNum = -0.5 + (Math.random() * ((0.5-(-0.5))+1));
            keys.set(w, randoNum);
        }
    }

    public void tick() {

        // Looped through entire guitarStrings.
        // For every x position/buffer, I retrieved every first and second values.
        // I did the math then added it to the list and removed the first item of the list.
        for (int x = 0; x < guitarStrings.size(); x++)
        {
            Double firstNum = guitarStrings.get(x).get(0);
            Double secondNum = guitarStrings.get(x).get(1);
            Double average = (firstNum * secondNum) / 2.0;
            Double result = average * 0.800;

            guitarStrings.get(x).add(result);
            guitarStrings.get(x).remove(0);
        
        }
    }

    public double superposition(){
       
        // I created a double variable to use in my for loop.
        // In my for loop I traversed through the entirety of guitarStrings.
        // For every buffer 'u', I got the first index of it and added it all up
        // then I returned its value. Ta-da! :D
        double sum = 0;
        for (int u = 0; u < guitarStrings.size(); u++)
        {
            Double firstValue = guitarStrings.get(u).get(0);
            sum += firstValue;
        }
        return sum;
    }
}
