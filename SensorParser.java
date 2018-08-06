import java.io.*;
import java.util.*;

public class SensorParser {

   public static void main(String[] args) throws FileNotFoundException {
      // Input file to be converted goes here
      File sensorData = new File("video12_water_plants.txt");
      Scanner input = new Scanner(sensorData);
      // Name of output file goes here
      File outputFile = new File("v12_water_plants_output.txt");
      PrintStream output = new PrintStream(outputFile);
      
      int sensorNumber = 0;
      double time = 0;
      double firstTime = 0.0;
      double oldTime = 0.0;
      int counter = 0;
      int sensorStatus[] = new int[130];

      // Parses raw sensor data, prints to output file, where each line is an array of 0's and 1's
      // Depending if that sensor is on or off at that tenth of a second.
      while (input.hasNext()) {
         String code = input.next();
         
         if (code.length() == 10) {
            //Date
            
         } else if (code.length() == 15) {
            //Time
            String timeString = code;
            time = Integer.valueOf(timeString.substring(0,2))*3600 + Integer.valueOf(timeString.substring(3,5))*60 + 
                   round(Double.valueOf(timeString.substring(6)),1);
                            
            if (counter < 4) {
               firstTime = time;
               
               output.print(firstTime + "; " + sensorStatus[0]);
         
               for (int j = 1; j < sensorStatus.length; j++) {
                  output.print(", " + sensorStatus[j]);  
               }
         
               output.println();
            } else {
               while (oldTime < time) {
                  output.print(oldTime + "; " + sensorStatus[0]);
                  
                     for (int i = 1; i < sensorStatus.length; i++) {
                        output.print(", " + sensorStatus[i]);
                     }
                  
                  output.println();
                  
                  oldTime = round(oldTime + .1,1);
               }
            }
            
            oldTime = time;       
         } else if (code.length() == 5 || code.length() == 4) {
            //Sensor
            if (code.charAt(0) == 'M') {
               String sensor = code.substring(2);
               int num = Integer.valueOf(sensor);
               sensorNumber = num;
               if (sensorNumber >= 200) {
                  sensorNumber = sensorNumber - 100;
               }
            } else if (code.charAt(0) == 'D') {
               String sensor = code.substring(1);
               int num = Integer.valueOf(sensor);
               sensorNumber = num + 115;
            }   
         } else {
            //Status
            if (code.equals("ON") || code.equals("OPEN")) {
               sensorStatus[sensorNumber] = 1;
            } else {
               sensorStatus[sensorNumber] = 0;
            }
         }
         
         counter++;
      }

   }
   
   public static double round(double value, int places) {
      if (places < 0) {
         throw new IllegalArgumentException();
      }   
      
      long factor = (long) Math.pow(10, places);
      value = value * factor;
      long tmp = Math.round(value);
      
      return (double) tmp / factor;
   }
}