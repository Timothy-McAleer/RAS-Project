import java.io.*;
import java.util.*;

public class SensorCounter {

   public static void main(String[] args) throws FileNotFoundException {
      // This takes in a sub-activity cleaned sensor data file
      File sensorData = new File("v8_walk_dog4.txt");
      Scanner input = new Scanner(sensorData);
      // Name of the output file
      File outputFile = new File("v8_walk_dog4_output.txt");
      PrintStream output = new PrintStream(outputFile);

      int counter = 0;
      int sensorStatus[] = new int[260];
      String lines[] = new String[400];

      // Saves the count of each sensor into new array at same index
      while (input.hasNextLine()) {
         lines[counter] = input.nextLine();

         for (int i = 10; i < lines[0].length(); i++) {
            if ((i % 3) == 0) {
               if (lines[counter].charAt(i) == '1') {
                  sensorStatus[(i - 1)/3 - 3]++;
               }
            }
         }
                  
         counter++;
      }
      
      // Saves the number of times that sensor is on at the index + 130
      for (int j = 1; j < counter; j++) {
         for (int k = 10; k < lines[0].length(); k++) {
            if ((k % 3) == 0) {
               if ((lines[j].charAt(k) == '1') && (lines[j - 1].charAt(k) == '0')) {
                  sensorStatus[(k - 1)/3 + 127]++; 
               }
            }
         }
      }
      
      // Outputs the array -- one line that represents each input file
      output.print(sensorStatus[0]);
      for (int m = 1; m < sensorStatus.length; m++) {
         output.print(", " + sensorStatus[m]);
      }
      output.println();

   }
   
 
}