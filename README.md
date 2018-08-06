# RAS-Project

## Overview
Java Files:
SensorGrapher.java is used to graph a task, given raw sensor input. It also contains all of the times for the 12 videos.
SensorParser.java is used to transform raw sensor input into a more readable format, where each line of the output file is a binary array describing if a sensor is on or off at that time.
SensorCounter.java was used for the Sub-Activity classification method by having a double-length array (260) to keep track of how many tenths of a second it was on, and how many times it turned on or off during that short period.

Python Files:
Sensor Data Random Forest.py is used for the Sub-Activity classification method. It takes files outputted from SensorCounter.java to predict what class is a certain Sub-Activity using Leave One Out Cross-Validation.
CrawlerTry.py is used for the Window Crawler method. It takes a trimmed input file, (meaning it starts and end exactly at the correct times), formatted by SensorParser.java and uses KFold Cross-Validation to predict every tenth of a second if there is a transition in that window. Then, it uses a graph of the probabilities for predicting “yes”, and picks the correct number of transitions from local maxes on the graph, and prints an array containing the times (in tenths of seconds, so 84 = 8.4 seconds after start-time of video). 

Android Studio:
The app VideoTest contains a function that allows a full tutorial video to be included, but only plays a certain section of it, given by two integers that are in milliseconds. 


## Sensor Transition Rules
Walk The Dog
Start:
Bottom Sensors go off in descending order.=
At Least One Middle Sensor turns on, about three seconds before transition.
Often a few of the top sensors will turn on during the transition. The transition occurs right before some of these sensors turn off.
Get Umbrella:
Usually 3 or 4 descending top sensors. The middle of the last one is where the transition is.
Often 1 or 2 middle sensors that will end right before the transition.
Get Leash:
Usually a small break in the top sensors before starting again. The transition is usually a second or so after the sensors resume.
Usually 1 or 2 of the middle sensors will go off near the end of this period. The transition is usually at the beginning or middle of the longest sensor in the middle, and just after some of the smaller sensors if they are present.
Get Keys:
Top sensors go off in descending order. Slightly lower than the first segment.
The last top sensor that turns on usually goes a bit past the transition.
The middle sensors go off in an ascending order, with the very top middle sensor usually going about a second past the transition.
Get Dog:
1 or 2 sensors on top. Usually 3 distinct times it goes off. Sometimes when the third one starts, the transition occurs a second after that. Other times there is a large gap. In this case, the transition is right after the gap is over. 
On the middle sensors, there will usually be a break in the 1 or 2 sensors that are active. The transition usually occurs a couple of seconds after the break.
Open Door:
1 or 2 sensors go off on the top. The longer one usually ends right at the transition (door close) or about a second before.
Very similar behavior from the middle sensors. The 1 or 2 sensors usually end right at transition or a second or so before.
In general, go with the longer sensor (top or bottom) to determine when the door closes. 

Take Medication
Start:
Almost all of the bottom sensors go off in ascending order. Usually somewhere in the span of the highest bottom sensor is where the transition occurs. Usually if the highest bottom sensor is long, the transition will occur closer to the start of it, if it’s short, the transition will usually occur at the end of its span.
Sometimes 1 or 2 top sensors will go off for a little bit. If this happens, the higher of the two sensors will go off about a second before the transition.

Collect Granola:
Usually 2 of the top bottom sensors go off. There is about a five second break between when the last one stops and the transition.
Collect Cup & Fill:
Usually 3 or 4 of the top bottom sensors will go off in a descending order. The transition usually occurs a couple of seconds after the last one stops. 
Set Down Water & Granola:
There are 2 important bottom sensors for this section that are two sensors apart. It will go lower and then higher, and the transition is usually near the beginning of the second one.
Retrieve Medication:
Usually the 2 important bottom sensors go off in this segment, but in the opposite order (descending). The transition typically occurs around the middle of the lower sensor.
Set Down Medication:
There is usually only 1 bottom sensor on this section that will end right at the transition.
Sit Down:
This section is often blank. If that is the case, the section will typically last about 10 seconds. If there is a small bottom sensor, and it is fairly close, than that might be halfway through the section. If it is far away, the transition is much closer.
Eat Granola:
It is possible this section is blank too. If it is, this section will usually last around 8 seconds. If not, a lower sensor will go off, on average about 4 seconds before the transition. 
Take Medication:
Again, most are blank. If not, there will be a middle bottom sensor that goes off a couple seconds before the transition.
Drink Water:
If this section is blank, it usually lasts about 8 seconds. If not, usually 1 bottom sensor will go off about 5 seconds before the transition.
Push In Chair:
If this one is blank (rare), it will last about 10 seconds. If not, there is usually 1 middle bottom sensor that will go off. The transition is usually about 5 seconds after the sensor starts, regardless of the length. 
Pick Up Items:
The biggest indicator is the same sensor in “Drink Water” (middle of the bottom sensors) will be activated about 2 seconds before the transition.
Put Back Medication:
Usually two side-by-side top bottom sensors go off in ascending order. Typically, the second sensor first goes off about halfway through the section.
Put Back Cup:
Usually about 3 lower sensors go off in an ascending order. The top one will often go off twice, and the second one starts about a second before the transition.

Water Plants
Start:
Usually 3 or 4 bottom sensors that generally go off in a descending order. The transition occurs around the middle of the third sensor that goes off.
Get Watering Can:
About 7 bottom sensors go off in ascending order near the beginning of the section. The transition occurs about 3 seconds after the last sensor is done.
Fill Can:
The same sensors will go off in a descending order. Once it gets to the first firing of the bottom sensor, it is about halfway through the section. 
Water Plant on Coffee Table:
Usually 3 or 4 of the lower sensors go off early in this section. If this is all that happens, then the end of the last sensor is about halfway through the section. If not, then the end of the first burst is about ⅓ of the way through the section. 
Water Plant on Side Table:
Usually about 7 lower sensors that go off quickly in an ascending order. There might be a few sensors after, but the start of the very top sensor is about halfway through the section. 
Empty Watering Can:
All of the sensors go off again but in a descending order. The transition (end) occurs just before it finishes the downward descent. 




## Video Times for Handwritten Test
Video 9 (1/28/18)
Walk the Dog Start: 10:04:52
Walk the Dog End: 10:05:21

Take Medication Start: 10:13:04
Take Medication End: 10:16:06

Water Plants Start: 10:46:55
Water Plants End: 10:48:21

Video 10 (1/29/18)
Walk the Dog Start: 12:22:15
Walk the Dog End: 12:22:57
Mean Squared Error: 3.22 Seconds

Take Medication Start: 12:29:54
Take Medication End: 12:32:05
Mean Squared Error: 6.23 Seconds

Water Plants Start: 12:52:57
Water Plants End: 12:54:11
Mean Squared Error: 2.58 Seconds

Video 11 (1/29/18)
Water Plants Start: 14:39:34
Water Plants End: 14:40:32
Mean Squared Error: 2.06 Seconds

Video 12 (5/31/18)
Walk the Dog Start: 10:23:24
Walk the Dog End: 10:24:08
Mean Squared Error: 1.3 Seconds

Take Medication Start: 10:39:34
Take Medication End: 10:42:15
Mean Squared Error: 6.01 Seconds

Water Plants Start: 11:00:34
Water Plants End: 11:02:06
Mean Squared Error: 2.73 Seconds

## Classification Success Rates
SVM (C = .1):
Walk The Dog: 95.83%
Take Medication: 47.32%
Water Plants: 64.58%

Logistic Regression (C = .01):
Walk The Dog: 89.58%
Take Medication: 41.96%
Water Plants: 66.67%

Decision Tree
Walk The Dog: 85.42%
Take Medication: 58.04%
Water Plants: 64.58%

SGDClassifier (Loss = hinge)
Walk The Dog: 72.92%
Take Medication: 34.82%
Water Plants: 56.25%

SGDClassifier (Loss = log)
Walk The Dog: 83.33%
Take Medication: 31.25%
Water Plants: 66.66%

## Window Crawler Success Rates (KFold, n_splits = 8)
SVM (C = .1):
Walk the Dog: 89.23%
Take Medication: 91.92%
Water Plants: 93.79%

SVM (Weights: no: .15, yes: .85, kernel = linear)
Walk the Dog: 73.56%
	Average Yesses: 97.625
Take Medication: 88.67%
	Average Yesses: 59.25
Water Plants: 88.83%
	Average Yesses: 48.25

Logistic Regression (Weights: no: .15, yes: .85, kernel = linear)
Walk the Dog: 71.13%
	Average Yesses: 108.375
Take Medication: 87.04%
	Average Yesses: 98.125
Water Plants: 88.45%
	Average Yesses: 55.75

Decision Tree (Weights: no: .15, yes: .85)
Walk the Dog: 80.89%
	Average Yesses: 53.25
Take Medication: 83.61
	Average Yesses: 153.25
Water Plants: 87.01%
	Average Yesses: 59.075

## Highest Points Mean Squared Error (SVM)
Video 1
Walk the Dog: 
1: 11 - 6.6
2: 18 - 10.5
3: 23 - 14.7
4: 33 - 21.8
5: 39 - 29.4
MSE: 8.51

Take Medication:
1: 12 - 8.1
2: 27 - 17.5
3: 41 - 35.7
4: 46 - 40.2
5: 52 - 45.8
6: 60 - 50.8
7: 69 - 52.9
8: 89 - 58.5
9: 95 - 102.6
10: 107 - 105.4
11: 116 - 121.1
12: 123 - 126.2
13: 135 - 144.6
MSE: 11.04

Water Plants:
1: 6 - 6.3
2: 26 - 9.9
3: 47 - 18.1
4: 62 - 22.2
5: 76 - 72.1
MSE: 23.21

Video 2
Walk the Dog:
1: 7 - 10.7
2: 13 - 15.4
3: 19 - 21.7
4: 26 - 29.8
5: 32 - 42.0
MSE: 5.31

Take Medication
1: 10 - 7.5
2: 26 - 22.1
3: 38 - 29.9
4: 45 - 44.7
5: 51 - 49.1
6: 58 - 72.3
7: 67 - 92.8
8: 73 - 107.0
9: 88 - 109.2
10: 103 - 120.1
11: 111 - 123.7
12: 117 - 127.3
13: 127 - 135.4
MSE: 15.68

Water Plants:
1: 3 - 16.6
2: 15 - 27.7
3: 30 - 54.0
4: 41 - 65.4
5: 54 - 72.2
MSE: 19.23

Video 3
Walk the Dog:
1: 6 - .6
2: 12 - 2.7
3: 17 - 6.0
4: 22 - 26.9
5: 29 - 42.0
MSE: 9.27

Take Medication:
1: 9 - 8.6
2: 22 - 14.7
3: 27 - 19.6
4: 33 - 24.7
5: 38 - 59.7
6: 43 - 62.5
7: 54 - 72.6
8: 64 - 92.1
9: 87 - 95.2
10: 104 - 97.8
11: 110 - 107.2
12: 113 - 117.7
13: 115 - 141.4
MSE: 15.18

Water Plants:
1: 4 - 3.1
2: 15 - 11.9
3: 28 - 38.0
4: 47 - 55.9
5: 57 - 64.1
MSE: 6.93

Video 4
Walk the Dog:
1: 12 - .4
2: 24 - 23.1
3: 35 - 26.4
4: 48 - 37.5
5: 64 - 41.2
MSE: 12.96

Take Medication:
1: 13 - 6.3
2: 37 - 13.7
3: 52 - 15.8
4: 62 - 20.9
5: 69 - 26.2
6: 77 - 28.3
7: 87 - 75.8
8: 106 - 77.9
9: 116 - 93.5
10: 127 - 96.4
11: 133 - 98.5
12: 144 - 103.1
13: 163 - 122.3
MSE: 33.59

Water Plants:
1: 6 - 24.6
2: 20 - 28.0
3: 47 - 32.8
4: 66 - 35.1
5: 83 - 51.9
MSE: 22.51

Video 5
Walk the Dog:
1: 8 - 10.4
2: 20 - 19.3
3: 24 - 25.6
4: 33 - 32.2
5: 40 - 39.1
MSE: 1.43

Take Medication:
1: 11 - .8
2: 30 - 5.6
3: 42 - 26.5
4: 50 - 35.4
5: 57 - 39.3
6: 67 - 44.7
7: 76 - 52.5
8: 93 - 54.8
9: 103 - 72.2
10: 112 - 92.4
11: 118 - 97.5
12: 125 - 113.9
13: 139 - 117.6
MSE: 22.03

Water Plants:
1: 5 - 1.6
2: 23 - 13.3
3: 42 - 15.9
4: 54 - 36.4
5: 71 - 50.9
MSE: 17.32

Video 6
Walk the Dog:
1: 9 - 0
2: 19 - 10.9
3: 28 - 18.0
4: 37 - 27.8
5: 48 - 37.9
MSE: 9.31

Take Medication:
1: 12 - 16.9
2: 39 - 40.9
3: 49 - 44.2
4: 56 - 48.9
5: 67 - 51.2
6: 80 - 54.6
7: 94 - 59.3
8: 110 - 61.9
9: 124 - 71.5
10: 135 - 74.1
11: 140 - 95.3
12: 153 - 128.4
13: 169 - 135.4
MSE: 33.64

Water Plants:
1: 6 - 8.5
2: 20 - 20.8
3: 37 - 25.1
4: 48 - 36.1
5: 68 - 38.6
MSE: 15.2

Video 7
Walk the Dog:
1: 8 - 5.1
2: 14 - 8.1
3: 20 - 23.0
4: 28 - 35.2
5: 33 - 38.7
MSE: 5.23

Take Medication:
1: 11 - 3.7
2: 28 - 7.8
3: 38 - 9.9
4: 46 - 26.7
5: 51 - 44.7
6: 58 - 72.4
7: 69 - 75.0
8: 85 - 80.2
9: 95 - 82.4
10: 104 - 86.7
11: 112 - 89.4
12: 119 - 92.8
13: 132 - 136.9
MSE: 16.66

Water Plants:
1: 5 - 10.5
2: 18 - 14.1
3: 34 - 20.9
4: 47 - 24.2
5: 64 - 28.7
MSE: 19.91

Video 8
Walk the Dog:
1: 9 - .6
2: 15 - 8.0
3: 23 - 17.7
4: 30 - 23.5
5: 37 - 32.7
MSE: 6.46

Take Medication:
1: 7 - .6
2: 16 - 4.7
3: 27 - 7.9
4: 31 - 10.5
5: 36 - 31.0
6: 43 - 60.2
7: 52 - 67.9
8: 59 - 71.4
9: 65 - 77.8
10: 75 - 106.7
11: 80 - 108.8
12: 86 - 110.9
13: 97 - 122.8
MSE: 19.54

Water Plants:
1: 3 - 12.5
2: 13 - 19.0
3: 27 - 22.4
4: 36 - 32.7
5: 66 - 65.5
MSE: 5.63

Average MSE for Walk the Dog: 7.31
Average MSE for Take Medication: 20.92
Average MSE for Water Plants: 16.24

Average MSE for all tasks: 14.82

