import java.awt.*;
import java.util.*;
import java.io.*;

public class SensorGrapher {

   public static void main(String[] args) throws FileNotFoundException {
      DrawingPanel p = new DrawingPanel(3000,700);
      Graphics g = p.getGraphics();
      
      // Input file to be graphed here
      File sensorData = new File("video12_water_plants.txt");
      Scanner input = new Scanner(sensorData);
      
      int sensorNumber = 0;
      double time = 0;
      double firstTime = 0;
      int counter = 0;
      int sensorStatus[] = new int[130];
      
      //Times for events are after they are completed
      
      /*
      Times for Video1 -- Walk the Dog
      
      Start: 12:15:14 -- 36.6
      Get Umbrella: 12:15:25 -- 47.6
      Get Leash: 12:15:32 -- 54.6
      Get Keys: 12:15:37 -- 59.6
      Get Dog: 12:15:47 -- 69.6
      Open Door: 12:15:53 -- 75.6
      Close Door: 12:15:55 -- 77.6
      
      Times for Video1 -- Take Medication
        
      Start: 12:34:01 -- 3.5
      Collect Granola: 12:34:13 -- 15.5
      Collect Cup & Fill: 12:34:28 -- 30.5
      Set Down Water & Granola: 12:34:42 -- 44.5
      Retrieve Medication: 12:34:47 -- 49.5
      Set Down Medication: 12:34:53 -- 55.5
      Sit Down: 12:35:01 -- 63.5
      Eat Granola: 12:35:10 -- 72.5
      Take Medication: 12:35:30 -- 92.5
      Drink Water: 12:35:36 -- 98.5
      Push in Chair: 12:35:48 -- 110.5
      Pick up Items: 12:35:57 -- 119.5
      Put Back Medication: 12:36:04 -- 126.5
      Put Back Cup: 12:36:16 -- 138.5
      Put Back Granola: 12:36:27 -- 149.5
      
      Times for Video1 -- Water Plants
      
      Start: 12:56:34 -- 35.2
      Get Watering Can: 12:56:40 -- 41.2
      Fill Can: 12:57:00 -- 61.2
      Water Plant on Coffee Table: 12:57:21 -- 82.2
      Water Plant on Side Table: 12:57:36 -- 97.2
      Empty Watering Can: 12:57:50 -- 111.2
      Return Watering Can: 12:58:00 -- 121.2    
      
      _______________________________________
      
      Times for Video2 -- Walk the Dog
      
      Start: 10:10:48 -- 73.5
      Get Umbrella: 10:10:55 -- 80.5
      Get Leash: 10:11:01 -- 86.5
      Get Keys: 10:11:07 -- 92.5
      Get Dog: 10:11:14 -- 99.5
      Open Door: 10:11:20 -- 105.5
      Close Door: 10:11:23 -- 108.5
      
      Times for Video2 -- Take Medication
      
      Start: 10:21:36 -- 28.1
      Collect Granola: 10:21:46 -- 38.1
      Collect Cup & Fill: 10:22:02 -- 54.1
      Set Down Water & Granola: 10:22:14 -- 66.1
      Retrieve Medication: 10:22:21 -- 73.1
      Set Down Medication: 10:22:27 -- 79.1
      Sit Down: 10:22:34 -- 86.1
      Eat Granola: 10:22:43 -- 95.1
      Take Medication: 10:22:49 -- 101.1
      Drink Water: 10:23:04 -- 116.1
      Push in Chair: 10:23:12 -- 124.1
      Pick up Items: 10:23:19 -- 131.1
      Put Back Medication: 10:23:25 -- 137.1
      Put Back Cup: 10:23:35 -- 147.1
      Put Back Granola: 10:23:45 -- 157.1
      
      Times for Video2 -- Water Plants
      
      Start: 10:36:39 -- 56.3
      Get Watering Can: 10:36:42 -- 59.3
      Fill Can: 10:36:54 -- 71.3
      Water Plant on Coffee Table: 10:37:09 -- 86.3
      Water Plant on Side Table: 10:37:20 -- 97.3
      Empty Watering Can: 10:37:33 -- 110.3
      Return Watering Can: 10:37:39 -- 116.3
      
      _______________________________________
      
      Times for Video3 -- Walk the Dog
      
      Start: 12:07:54 -- 28.1
      Get Umbrella: 12:08:00 -- 34.1
      Get Leash: 12:08:06 -- 40.1
      Get Keys: 12:08:11 -- 45.1
      Get Dog: 12:08:16 -- 50.1
      Open Door: 12:08:23 -- 57.1
      Close Door: 12:08:26 -- 60.1
      
      Times for Video3 -- Take Medication
      
      Start: 12:19:45 -- 43
      Collect Granola: 12:19:54 -- 52
      Collect Cup & Fill: 12:20:07 -- 65
      Set Down Water & Granola: 12:20:12 -- 70
      Retrieve Medication: 12:20:18 -- 76
      Set Down Medication: 12:20:23 -- 81
      Sit Down: 12:20:28 -- 86
      Eat Granola: 12:20:39 -- 97
      Take Medication: 12:20:49 -- 107
      Drink Water: 12:21:12 -- 130
      Push in Chair: 12:21:29 -- 147
      Pick up Items: 12:21:35 -- 153
      Put Back Medication: 12:21:38 -- 156
      Put Back Cup: 12:21:40 -- 158
      Put Back Granola: 12:21:41 -- 159
      
      Times for Video3 -- Water Plants
      
      Start: 12:36:56 -- 59.1
      Get Watering Can: 12:37:00 -- 63.1
      Fill Can: 12:37:11 -- 74.1
      Water Plant on Coffee Table: 12:37:24 -- 87.1
      Water Plant on Side Table: 12:37:43 -- 106.1
      Empty Watering Can: 12:37:53 -- 116.1
      Return Watering Can: 12:37:59 -- 122.1
      
       _______________________________________
      
      Times for Video4 -- Walk the Dog
      
      Start: 09:24:47 -- 26.1
      Get Umbrella: 09:24:59 -- 38.1
      Get Leash: 09:25:11 -- 50.1
      Get Keys: 09:25:22 -- 61.1
      Get Dog: 09:25:35 -- 74.1
      Open Door: 09:25:51 -- 90.1
      Close Door: 09:25:54 -- 93.1
      
      Times for Video4 -- Take Medication
      
      Start: 09:41:57 -- 43.4
      Collect Granola: 09:42:10 -- 56.4
      Collect Cup & Fill: 09:42:34 -- 80.4
      Set Down Water & Granola: 09:42:49 -- 95.4
      Retrieve Medication: 09:42:59 -- 105.4
      Set Down Medication: 09:43:06 -- 112.4
      Sit Down: 09:43:14 -- 120.4
      Eat Granola: 09:43:24 -- 130.4
      Take Medication: 09:43:43 -- 149.4
      Drink Water: 09:43:53 -- 159.4
      Push in Chair: 09:44:04 -- 170.4
      Pick up Items: 09:44:10 -- 176.4
      Put Back Medication: 09:44:21 -- 187.4
      Put Back Cup: 09:44:40 -- 206.4
      Put Back Granola: 09:44:58 -- 224.4
      
      Times for Video4 -- Water Plants
      
      Start: 10:12:23 -- 25.1
      Get Watering Can: 10:12:29 -- 31.1
      Fill Can: 10:12:43 -- 45.1
      Water Plant on Coffee Table: 10:13:10 -- 72.1
      Water Plant on Side Table: 10:13:29 -- 91.1
      Empty Watering Can: 10:13:46 -- 108.1
      Return Watering Can: 10:13:58 -- 120.1
      
      _______________________________________
      
      Times for Video5 -- Walk the Dog
      
      Start: 13:12:57 -- 13.8
      Get Umbrella: 13:13:05 -- 21.8
      Get Leash: 13:13:17 -- 33.8
      Get Keys: 13:13:21 -- 37.8
      Get Dog: 13:13:30 -- 46.8
      Open Door: 13:13:37 -- 53.8
      Close Door: 13:13:40 -- 56.8
      
      Times for Video5 -- Take Medication
      
      Start: 13:24:43 -- 81.7
      Collect Granola: 13:24:54 -- 92.7
      Collect Cup & Fill: 13:25:13 -- 111.7
      Set Down Water & Granola: 13:25:25 -- 123.7
      Retrieve Medication: 13:25:33 -- 131.7
      Set Down Medication: 13:24:40 -- 138.7
      Sit Down: 13:25:50 -- 148.7
      Eat Granola: 13:25:59 -- 157.7
      Take Medication: 13:26:16  -- 174.7
      Drink Water: 13:26:26 -- 184.7
      Push in Chair: 13:26:35 -- 193.7
      Pick up Items: 13:26:41 -- 199.7
      Put Back Medication: 13:26:48 -- 206.7
      Put Back Cup: 13:27:02 -- 220.7
      Put Back Granola: 13:27:16 -- 134.7
      
      Times for Video5 -- Water Plants
      
      Start: 13:44:15 -- 70.3
      Get Watering Can: 13:44:20 -- 75.3 
      Fill Can: 13:44:38 -- 93.3
      Water Plant on Coffee Table: 13:44:57 -- 112.3
      Water Plant on Side Table: 13:45:09 -- 124.3
      Empty Watering Can: 13:45:26 -- 141.3
      Return Watering Can: 13:45:36 -- 151.3
       
      _______________________________________
      
      Times for Video6 -- Walk the Dog
      
      Start: 12:36:59 -- 87.7
      Get Umbrella: 12:37:08 -- 96.7
      Get Leash: 12:37:18 -- 106.7
      Get Keys: 12:37:27 -- 115.7
      Get Dog: 12:37:36 -- 124.7
      Open Door: 12:37:47 -- 135.7
      Close Door: 12:37:50 -- 138.7
      
      Times for Video6 -- Take Medication
      
      Start: 12:55:43 -- 62.4
      Collect Granola: 12:55:55 -- 74.4 
      Collect Cup & Fill: 12:56:22 -- 101.4
      Set Down Water & Granola: 12:56:32 -- 111.4
      Retrieve Medication: 12:56:39 -- 118.4
      Set Down Medication: 12:56:50 -- 129.4
      Sit Down: 12:57:03 -- 142.4
      Eat Granola: 12:57:17 -- 156.4
      Take Medication: 12:57:33 -- 172.4
      Drink Water: 12:57:47 -- 186.4
      Push in Chair: 12:57:58 -- 197.4
      Pick up Items: 12:58:03 -- 202.4
      Put Back Medication: 12:58:16 -- 215.4
      Put Back Cup: 12:58:32 -- 231.4
      Put Back Granola: 12:58:50 -- 249.4
      
      Times for Video6 -- Water Plants
      
      Start: 13:25:47 -- 61.3
      Get Watering Can: 13:25:53 -- 67.3
      Fill Can: 13:26:07 -- 81.3
      Water Plant on Coffee Table: 13:26:24 -- 98.3
      Water Plant on Side Table: 13:26:35 -- 109.3
      Empty Watering Can: 13:26:55 -- 129.3
      Return Watering Can: 13:27:04 -- 138.3

      _______________________________________
      
      Times for Video7 -- Walk the Dog
      
      Start: 12:35:59 -- 83.5
      Get Umbrella: 12:36:07 -- 91.5
      Get Leash: 12:36:13 -- 97.5
      Get Keys: 12:36:19 -- 103.5
      Get Dog: 12:36:27 -- 111.5
      Open Door: 12:36:32 -- 116.5
      Close Door: 12:36:35 -- 119.5
      
      Times for Video7 -- Take Medication
      
      Start: 12:48:26 -- 81.7
      Collect Granola: 12:48:37 -- 92.7
      Collect Cup & Fill: 12:48:54 -- 109.7
      Set Down Water & Granola: 12:49:04 -- 119.7
      Retrieve Medication: 12:49:12 -- 127.7
      Set Down Medication: 12:49:17 -- 132.7
      Sit Down: 12:49:24 -- 139.7
      Eat Granola: 12:49:35 -- 150.7
      Take Medication: 12:49:51 -- 166.7
      Drink Water: 12:50:01 -- 176.7
      Push in Chair: 12:50:10 -- 185.7
      Pick up Items: 12:50:18 -- 193.7
      Put Back Medication: 12:50:25 -- 200.7
      Put Back Cup: 12:50:38 -- 213.7
      Put Back Granola: 12:50:51 -- 226.7
      
      Times for Video7 -- Water Plants
      
      Start: 13:06:07 -- 38.2
      Get Watering Can: 13:06:12 -- 43.2
      Fill Can: 13:06:25 -- 56.2
      Water Plant on Coffee Table: 13:06:41 -- 72.2
      Water Plant on Side Table: 13:06:54 -- 85.2
      Empty Watering Can: 13:07:11 -- 102.2
      Return Watering Can: 13:07:19 -- 110.2

      _______________________________________
      
      Times for Video8 -- Walk the Dog
      
      Start: 15:45:41 -- 9.2
      Get Umbrella: 15:45:50 -- 18.2
      Get Leash: 14:45:56 -- 24.2
      Get Keys: 14:46:04 -- 32.2
      Get Dog: 15:46:11 -- 39.2
      Open Door: 15:46:18 -- 46.2
      Close Door: 15:46:21 -- 49.2
      
      Times for Video8 -- Take Medication
      
      Start: 15:58:30 -- 5.2
      Collect Granola: 15:58:37 -- 12.2
      Collect Cup & Fill: 12:58:46 -- 21.2
      Set Down Water & Granola: 12:58:57 -- 32.2
      Retrieve Medication: 12:59:01 -- 36.2
      Set Down Medication: 12:59:06 -- 41.2
      Sit Down: 12:59:13 -- 48.2
      Eat Granola: 12:59:22 -- 57.2
      Take Medication: 12:59:29 -- 64.2
      Drink Water: 12:59:35 -- 70.2
      Push in Chair: 12:59:45 -- 80.2
      Pick up Items: 12:59:50 -- 85.2
      Put Back Medication: 12:59:56 -- 91.2
      Put Back Cup: 16:00:07 -- 102.2
      Put Back Granola: 16:00:19 -- 114.2
      
      Times for Video8 -- Water Plants
      
      Start: 16:12:21 -- 32.5
      Get Watering Can: 16:12:24 -- 35.5 
      Fill Can: 16:12:34 -- 45.5
      Water Plant on Coffee Table: 16:12:48 -- 59.5
      Water Plant on Side Table: 16:12:57 -- 68.5
      Empty Watering Can: 16:13:07 -- 98.5
      Return Watering Can: 16:13:15 -- 106.5
      
      _______________________________________
      
      Times for Video10 -- Walk the Dog
      
      Start: 12:22:15
      Get Umbrella: 12:22:22 -- Didn't Actually Happen
      Get Leash: 12:22:24
      Get Keys: 12:22:32
      Get Dog: 12:22:43
      Open Door: 12:22:53
      Close Door: 12:22:57
      
      Times for Video10 -- Take Medication
      
      Start: 12:29:54
      Collect Granola: 12:30:11
      Collect Cup & Fill: 12:30:20
      Set Down Water & Granola: 12:30:32
      Retrieve Medication: 12:30:45
      Set Down Medication: 12:30:54
      Sit Down: 12:31:01
      Eat Granola: 12:21:11
      Take Medication: 12:31:24
      Drink Water: 12:31:31
      Push in Chair: 12:31:42
      Pick up Items: 12:31:43
      Put Back Medication: 12:31:52
      Put Back Cup: 12:32:02 -- Switches Order
      Put Back Granola: 12:32:05
      
      Times for Video10 -- Water Plants
      
      Start: 12:52:57
      Get Watering Can: 12:53:03
      Fill Can: 12:53:15 -- Waters an additional plant in the kitchen
      Water Plant on Coffee Table: 12:53:38
      Water Plant on Side Table: 12:53:51
      Empty Watering Can: 12:54:02
      Return Watering Can: 12:54:11
      
      _______________________________________
      
      Times for Video11 -- Water Plants
      
      Start: 14:39:34
      Get Watering Can: 14:39:38
      Fill Can: 14:39:53 -- Didn't Fill Can, Watered Plant in Kitchen
      Water Plant on Coffee Table: 14:40:05
      Water Plant on Side Table: 14:40:15
      Empty Watering Can: 14:40:24
      Return Watering Can: 14:40:32

      _______________________________________
      
      Times for Video12 -- Walk the Dog
      
      Start: 10:23:24
      Get Umbrella: 10:23:33
      Get Leash: 10:23:42
      Get Keys: 10:23:51
      Get Dog: 10:23:57
      Open Door: 10:24:02
      Close Door: 10:24:08
      
      Times for Video12 -- Take Medication
      
      Start: 10:39:34
      Collect Granola: 10:39:46
      Collect Cup & Fill: 10:40:04
      Set Down Water & Granola: 10:40:17
      Retrieve Medication: 10:40:26
      Set Down Medication: 10:40:33
      Sit Down: 10:40:40
      Eat Granola: 10:40:52
      Take Medication: 10:41:07
      Drink Water: 10:41:19
      Push in Chair: 10:41:28
      Pick up Items: 10:41:37
      Put Back Medication: 10:41:43
      Put Back Cup: 10:41:55
      Put Back Granola: 10:42:15
      
      Times for Video12 -- Water Plants
      
      Start: 11:00:34
      Get Watering Can: 11:00:43
      Fill Can: 11:01:03
      Water Plant on Coffee Table: 11:01:23
      Water Plant on Side Table: 11:01:40
      Empty Watering Can: 11:01:56
      Return Watering Can: 11:02:06
      */
      
      // Parses the raw sensor data
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
               System.out.println(firstTime);
            }       
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
         
         for (int i = 0; i < sensorStatus.length; i++) {
            if (sensorStatus[i] == 1) {
               //fill black
               g.setColor(Color.BLACK);
               g.fillRect((int)round((time - firstTime)*10,0), 600 - (i*9), 500, 8);
            } else {
               //fill white
               g.setColor(Color.WHITE);
               g.fillRect((int)round((time - firstTime)*10,0), 600 - (i*9), 500, 8);
            }
         }
         
         counter++;
      }
      
      g.setColor(Color.BLUE);
      
      // Only uncomment one section at a time, will graph if the correct input file is given
      
      /*
      //Lines for Video1 -- Walk the Dog
      g.drawLine(366,0,366,700);
      g.drawLine(476,0,476,700);
      g.drawLine(546,0,546,700);
      g.drawLine(596,0,596,700);
      g.drawLine(696,0,696,700);
      g.drawLine(756,0,756,700);
      g.drawLine(776,0,776,700);
      */
      
      /*
      //Lines for Video1 -- Take Medication
      g.drawLine(35,0,35,700);
      g.drawLine(155,0,155,700);
      g.drawLine(305,0,305,700);
      g.drawLine(365,0,365,700);
      g.drawLine(415,0,415,700);
      g.drawLine(475,0,475,700);
      g.drawLine(555,0,555,700);
      g.drawLine(645,0,645,700);
      g.drawLine(845,0,845,700);
      g.drawLine(905,0,905,700);
      g.drawLine(1025,0,1025,700);
      g.drawLine(1115,0,1115,700);
      g.drawLine(1185,0,1185,700);
      g.drawLine(1305,0,1305,700);
      g.drawLine(1415,0,1415,700);
      */
      
      /*
      //Lines for Video1 -- Water Plants
      g.drawLine(352,0,352,700);
      g.drawLine(412,0,412,700);
      g.drawLine(612,0,612,700);
      g.drawLine(822,0,822,700);
      g.drawLine(972,0,972,700);
      g.drawLine(1112,0,1112,700);
      g.drawLine(1212,0,1212,700);
      */
      
      /*
      //Lines for Video2 -- Walk the Dog
      g.drawLine(735,0,735,700);
      g.drawLine(805,0,805,700);
      g.drawLine(865,0,865,700);
      g.drawLine(925,0,925,700);
      g.drawLine(995,0,995,700);
      g.drawLine(1055,0,1055,700);
      g.drawLine(1085,0,1085,700);   
      */
      
      /*
      //Lines for Video2 -- Take Medication
      g.drawLine(281,0,281,700);
      g.drawLine(381,0,381,700);
      g.drawLine(541,0,541,700);
      g.drawLine(661,0,661,700);
      g.drawLine(731,0,731,700);
      g.drawLine(791,0,791,700);
      g.drawLine(861,0,861,700);
      g.drawLine(951,0,951,700);
      g.drawLine(1011,0,1011,700);
      g.drawLine(1161,0,1161,700);
      g.drawLine(1241,0,1241,700);
      g.drawLine(1311,0,1311,700);
      g.drawLine(1371,0,1371,700);
      g.drawLine(1471,0,1471,700);
      g.drawLine(1571,0,1571,700);
      */
      
      /*
      //Lines for Video2 -- Water Plants
      g.drawLine(563,0,563,700);
      g.drawLine(593,0,593,700);
      g.drawLine(713,0,713,700);
      g.drawLine(863,0,863,700);
      g.drawLine(973,0,973,700);
      g.drawLine(1103,0,1103,700);
      g.drawLine(1163,0,1163,700);
      */
      
      /*
      //Lines for Video3 -- Walk the Dog
      g.drawLine(201,0,201,700);
      g.drawLine(341,0,341,700);
      g.drawLine(401,0,401,700);
      g.drawLine(451,0,451,700);
      g.drawLine(501,0,501,700);
      g.drawLine(571,0,571,700);
      g.drawLine(601,0,601,700);   
      */
      
      /*
      //Lines for Video3 -- Take Medication
      g.drawLine(430,0,430,700);
      g.drawLine(520,0,520,700);
      g.drawLine(650,0,650,700);
      g.drawLine(700,0,700,700);
      g.drawLine(760,0,760,700);
      g.drawLine(810,0,810,700);
      g.drawLine(860,0,860,700);
      g.drawLine(970,0,970,700);
      g.drawLine(1070,0,1070,700);
      g.drawLine(1300,0,1300,700);
      g.drawLine(1470,0,1470,700);
      g.drawLine(1530,0,1530,700);
      g.drawLine(1560,0,1560,700);
      g.drawLine(1580,0,1580,700);
      g.drawLine(1590,0,1590,700);
      */
      
      /*
      //Lines for Video3 -- Water Plants
      g.drawLine(591,0,591,700);
      g.drawLine(631,0,631,700);
      g.drawLine(741,0,741,700);
      g.drawLine(871,0,871,700);
      g.drawLine(1061,0,1061,700);
      g.drawLine(1161,0,1161,700);
      g.drawLine(1221,0,1221,700);
      */
      
      /*
      //Lines for Video4 -- Walk the Dog
      g.drawLine(261,0,261,700);
      g.drawLine(381,0,381,700);
      g.drawLine(501,0,501,700);
      g.drawLine(611,0,611,700);
      g.drawLine(741,0,741,700);
      g.drawLine(901,0,901,700);
      g.drawLine(931,0,931,700);   
      */
      
      /*
      //Lines for Video4 -- Take Medication
      g.drawLine(434,0,434,700);
      g.drawLine(564,0,564,700);
      g.drawLine(804,0,804,700);
      g.drawLine(954,0,954,700);
      g.drawLine(1054,0,1054,700);
      g.drawLine(1124,0,1124,700);
      g.drawLine(1204,0,1204,700);
      g.drawLine(1304,0,1304,700);
      g.drawLine(1394,0,1394,700);
      g.drawLine(1494,0,1494,700);
      g.drawLine(1604,0,1604,700);
      g.drawLine(1664,0,1664,700);
      g.drawLine(1774,0,1774,700);
      g.drawLine(1964,0,1964,700);
      g.drawLine(2144,0,2144,700);
      */
      
      /*
      //Lines for Video4 -- Water Plants
      g.drawLine(251,0,251,700);
      g.drawLine(311,0,311,700);
      g.drawLine(451,0,451,700);
      g.drawLine(721,0,721,700);
      g.drawLine(891,0,891,700);
      g.drawLine(1061,0,1061,700);
      g.drawLine(1181,0,1181,700);
      */

      /*
      //Lines for Video5 -- Walk the Dog
      g.drawLine(138,0,138,700);
      g.drawLine(218,0,218,700);
      g.drawLine(338,0,338,700);
      g.drawLine(378,0,378,700);
      g.drawLine(468,0,468,700);
      g.drawLine(538,0,538,700);
      g.drawLine(568,0,568,700);   
      */
      
      /*
      //Lines for Video5 -- Take Medication
      g.drawLine(817,0,817,700);
      g.drawLine(927,0,927,700);
      g.drawLine(1117,0,1117,700);
      g.drawLine(1237,0,1237,700);
      g.drawLine(1317,0,1317,700);
      g.drawLine(1387,0,1387,700);
      g.drawLine(1487,0,1487,700);
      g.drawLine(1567,0,1567,700);
      g.drawLine(1737,0,1737,700);
      g.drawLine(1837,0,1837,700);
      g.drawLine(1927,0,1927,700);
      g.drawLine(1987,0,1987,700);
      g.drawLine(2057,0,2057,700);
      g.drawLine(2197,0,2197,700);
      g.drawLine(1337,0,1337,700);
      */
            
      /*
      //Lines for Video5 -- Water Plants
      g.drawLine(703,0,703,700);
      g.drawLine(753,0,753,700);
      g.drawLine(933,0,933,700);
      g.drawLine(1123,0,1123,700);
      g.drawLine(1243,0,1243,700);
      g.drawLine(1393,0,1393,700);
      g.drawLine(1493,0,1493,700);
      */
      
      /*
      //Lines for Video6 -- Walk the Dog
      g.drawLine(877,0,877,700);
      g.drawLine(967,0,967,700);
      g.drawLine(1067,0,1067,700);
      g.drawLine(1157,0,1157,700);
      g.drawLine(1247,0,1247,700);
      g.drawLine(1357,0,1357,700);
      g.drawLine(1387,0,1387,700);   
      */
      
      /*
      //Lines for Video6 -- Take Medication
      g.drawLine(624,0,624,700);
      g.drawLine(744,0,744,700);
      g.drawLine(1014,0,1014,700);
      g.drawLine(1114,0,1114,700);
      g.drawLine(1184,0,1184,700);
      g.drawLine(1294,0,1294,700);
      g.drawLine(1424,0,1424,700);
      g.drawLine(1564,0,1564,700);
      g.drawLine(1724,0,1724,700);
      g.drawLine(1864,0,1864,700);
      g.drawLine(1974,0,1974,700);
      g.drawLine(2024,0,2024,700);
      g.drawLine(2154,0,2154,700);
      g.drawLine(2314,0,2314,700);
      g.drawLine(2494,0,2494,700);
      */
      
      /*
      //Lines for Video6 -- Water Plants
      g.drawLine(613,0,613,700);
      g.drawLine(673,0,673,700);
      g.drawLine(813,0,813,700);
      g.drawLine(983,0,983,700);
      g.drawLine(1093,0,1093,700);
      g.drawLine(1293,0,1293,700);
      g.drawLine(1383,0,1383,700);
      */
      
      /*
      //Lines for Video7 -- Walk the Dog
      g.drawLine(835,0,835,700);
      g.drawLine(915,0,915,700);
      g.drawLine(975,0,975,700);
      g.drawLine(1035,0,1035,700);
      g.drawLine(1115,0,1115,700);
      g.drawLine(1165,0,1165,700);
      g.drawLine(1195,0,1195,700);   
      */
      
      /*
      //Lines for Video7 -- Take Medication
      g.drawLine(817,0,817,700);
      g.drawLine(927,0,927,700);
      g.drawLine(1097,0,1097,700);
      g.drawLine(1197,0,1197,700);
      g.drawLine(1277,0,1277,700);
      g.drawLine(1327,0,1327,700);
      g.drawLine(1397,0,1397,700);
      g.drawLine(1507,0,1507,700);
      g.drawLine(1667,0,1667,700);
      g.drawLine(1767,0,1767,700);
      g.drawLine(1857,0,1857,700);
      g.drawLine(1937,0,1937,700);
      g.drawLine(2007,0,2007,700);
      g.drawLine(2137,0,2137,700);
      g.drawLine(2267,0,2267,700);
      */
      
      /*
      //Lines for Video7 -- Water Plants
      g.drawLine(382,0,382,700);
      g.drawLine(432,0,432,700);
      g.drawLine(562,0,562,700);
      g.drawLine(722,0,722,700);
      g.drawLine(852,0,852,700);
      g.drawLine(1022,0,1022,700);
      g.drawLine(1102,0,1102,700);
      */
      
      /*
      //Lines for Video8 -- Walk the Dog
      g.drawLine(92,0,92,700);
      g.drawLine(182,0,182,700);
      g.drawLine(242,0,242,700);
      g.drawLine(322,0,322,700);
      g.drawLine(392,0,392,700);
      g.drawLine(462,0,462,700);
      g.drawLine(492,0,492,700);   
      */
      
      /*
      //Lines for Video8 -- Take Medication
      g.drawLine(52,0,52,700);
      g.drawLine(122,0,122,700);
      g.drawLine(212,0,212,700);
      g.drawLine(322,0,322,700);
      g.drawLine(362,0,362,700);
      g.drawLine(412,0,412,700);
      g.drawLine(482,0,482,700);
      g.drawLine(572,0,572,700);
      g.drawLine(642,0,642,700);
      g.drawLine(702,0,702,700);
      g.drawLine(802,0,802,700);
      g.drawLine(852,0,852,700);
      g.drawLine(912,0,912,700);
      g.drawLine(1022,0,1022,700);
      g.drawLine(1142,0,1142,700);
      */
      
      /*
      //Lines for Video8 -- Water Plants
      g.drawLine(325,0,325,700);
      g.drawLine(355,0,355,700);
      g.drawLine(455,0,455,700);
      g.drawLine(595,0,595,700);
      g.drawLine(685,0,685,700);
      g.drawLine(985,0,985,700);
      g.drawLine(1065,0,1065,700);
      */
      
 
      
      /*
      //Lines for Video10 -- Walk the Dog (PREDICTED)
      g.setColor(Color.BLACK);
      g.drawLine(220,0,220,700);
      
      g.setColor(Color.GREEN);
      g.drawLine(310,0,310,700);
      g.drawLine(330,0,330,700);
      g.drawLine(370,0,370,700);
      g.drawLine(480,0,480,700);
      g.drawLine(540,0,540,700);
      
      g.setColor(Color.BLACK);
      g.drawLine(640,0,640,700);
      */
      
      /*
      //Lines for Video10 -- Walk the Dog (ACTUAL)
      g.setColor(Color.BLUE);
      g.drawLine(220,0,220,700);
      g.drawLine(290,0,290,700);
      g.drawLine(310,0,310,700);
      g.drawLine(390,0,390,700);
      g.drawLine(500,0,500,700);
      g.drawLine(600,0,600,700);
      g.drawLine(640,0,640,700);
      
      */
      
      /*
      //Lines for Video10 -- Take Medication (PREDICTED)
      g.setColor(Color.BLACK);
      g.drawLine(230,0,230,700);
      
      g.setColor(Color.GREEN);
      g.drawLine(320,0,320,700);
      g.drawLine(500,0,500,700);
      g.drawLine(610,0,610,700);
      g.drawLine(670,0,670,700);
      g.drawLine(820,0,820,700);
      g.drawLine(890,0,890,700);
      g.drawLine(940,0,940,700);
      g.drawLine(1020,0,1020,700);
      g.drawLine(1120,0,1120,700);
      g.drawLine(1270,0,1270,700);
      g.drawLine(1400,0,1400,700);
      g.drawLine(1480,0,1480,700);
      
      g.setColor(Color.BLACK);
      g.drawLine(1540,0,1540,700);
      */
      
      /*
      //Lines for Video10 -- Take Medication (ACTUAL)
      g.setColor(Color.BLUE);
      g.drawLine(230,0,230,700);
      g.drawLine(400,0,400,700);
      g.drawLine(490,0,490,700);
      g.drawLine(610,0,610,700);
      g.drawLine(740,0,740,700);
      g.drawLine(830,0,830,700);
      g.drawLine(900,0,900,700);
      g.drawLine(1000,0,1000,700);
      g.drawLine(1130,0,1130,700);
      g.drawLine(1200,0,1200,700);
      g.drawLine(1310,0,1310,700);
      g.drawLine(1320,0,1320,700);
      g.drawLine(1410,0,1410,700);
      g.drawLine(1540,0,1540,700);
      */
      
      /*
      //Lines for Video10 -- Water Plants (PREDICTED)
      g.setColor(Color.BLACK);
      g.drawLine(806,0,806,700);
      
      g.setColor(Color.GREEN);
      g.drawLine(880,0,880,700);
      g.drawLine(1000,0,1000,700);
      g.drawLine(1200,0,1200,700);
      g.drawLine(1300,0,1300,700);
      g.drawLine(1480,0,1480,700);
      
      g.setColor(Color.BLACK);
      g.drawLine(1546,0,1546,700);
      */
      
      /*
      //Lines for Video10 -- Water Plants (ACTUAL)
      g.setColor(Color.BLUE);
      g.drawLine(806,0,806,700);
      g.drawLine(866,0,866,700);
      g.drawLine(986,0,986,700);
      g.drawLine(1216,0,1216,700);
      g.drawLine(1346,0,1346,700);
      g.drawLine(1456,0,1456,700);
      g.drawLine(1546,0,1546,700);
      */
      
      /*
      //Lines for Video11 -- Water Plants (PREDICTED)
      g.setColor(Color.BLACK);
      g.drawLine(261,0,261,700);
      
      g.setColor(Color.GREEN);
      g.drawLine(310,0,310,700);
      g.drawLine(430,0,430,700);
      g.drawLine(580,0,580,700);
      g.drawLine(670,0,670,700);
      g.drawLine(800,0,800,700);
      
      g.setColor(Color.BLACK);
      g.drawLine(841,0,841,700);
      */
      
      /*
      //Lines for Video11 -- Water Plants (ACTUAL)
      g.setColor(Color.BLUE);
      g.drawLine(261,0,261,700);
      g.drawLine(301,0,301,700);
      g.drawLine(451,0,451,700);
      g.drawLine(571,0,571,700);
      g.drawLine(671,0,671,700);
      g.drawLine(761,0,761,700);
      g.drawLine(841,0,841,700);
      */
      
      /*
      //Lines for Video12 -- Walk the Dog (PREDICTED)
      g.setColor(Color.BLACK);
      g.drawLine(517,0,517,700);
      
      g.setColor(Color.GREEN);
      g.drawLine(600,0,600,700);
      g.drawLine(690,0,690,700);
      g.drawLine(760,0,760,700);
      g.drawLine(850,0,850,700);
      g.drawLine(900,0,900,700);
      
      
      g.setColor(Color.BLACK);
      g.drawLine(957,0,957,700);
      */
      
      /*
      //Lines for Video12 -- Walk the Dog (ACTUAL)
      g.setColor(Color.BLUE);
      g.drawLine(517,0,517,700);
      g.drawLine(607,0,607,700);
      g.drawLine(697,0,697,700);
      g.drawLine(787,0,787,700);
      g.drawLine(847,0,847,700);
      g.drawLine(897,0,897,700);
      g.drawLine(957,0,957,700);
      */
      
      /*
      //Lines for Video12 -- Take Medication (PREDICTED)
      g.setColor(Color.BLACK);
      g.drawLine(497,0,497,700);
      
      g.setColor(Color.GREEN);
      g.drawLine(620,0,620,700);
      g.drawLine(810,0,810,700);
      g.drawLine(910,0,910,700);
      g.drawLine(950,0,950,700);
      g.drawLine(1020,0,1020,700);
      g.drawLine(1150,0,1150,700);
      g.drawLine(1250,0,1250,700);
      g.drawLine(1330,0,1330,700);
      g.drawLine(1460,0,1460,700);
      g.drawLine(1540,0,1540,700);
      g.drawLine(1640,0,1640,700);
      g.drawLine(1720,0,1720,700);
      g.drawLine(1880,0,1880,700);
      
      g.setColor(Color.BLACK);
      g.drawLine(2107,0,2107,700);
      */
      
      /*
      //Lines for Video12 -- Take Medication (ACTUAL)
      g.setColor(Color.BLUE);
      g.drawLine(497,0,497,700);
      g.drawLine(617,0,617,700);
      g.drawLine(797,0,797,700);
      g.drawLine(927,0,927,700);
      g.drawLine(1017,0,1017,700);
      g.drawLine(1087,0,1087,700);
      g.drawLine(1157,0,1157,700);
      g.drawLine(1277,0,1277,700);
      g.drawLine(1427,0,1427,700);
      g.drawLine(1547,0,1547,700);
      g.drawLine(1637,0,1637,700);
      g.drawLine(1727,0,1727,700);
      g.drawLine(1787,0,1787,700);
      g.drawLine(1907,0,1907,700);
      g.drawLine(2107,0,2107,700);
      */
      
      /*
      //Lines for Video12 -- Water Plants (PREDICTED)
      g.setColor(Color.BLACK);
      g.drawLine(785,0,785,700);
      
      g.setColor(Color.GREEN);
      g.drawLine(850,0,850,700);
      g.drawLine(1040,0,1040,700);
      g.drawLine(1250,0,1250,700);
      g.drawLine(1410,0,1410,700);
      g.drawLine(1610,0,1610,700);
            
      g.setColor(Color.BLACK);
      g.drawLine(1705,0,1705,700);
      */
      
      /*
      //Lines for Video12 -- Water Plants (ACTUAL)
      g.setColor(Color.BLUE);
      g.drawLine(785,0,785,700);
      g.drawLine(875,0,875,700);
      g.drawLine(1075,0,1075,700);
      g.drawLine(1275,0,1275,700);
      g.drawLine(1445,0,1445,700);
      g.drawLine(1605,0,1605,700);
      g.drawLine(1705,0,1705,700);
      */
      
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