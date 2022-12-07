Problem Statement You can find here: https://codu.ai/coding-problem/train

Train
Context

There are 2 super fast trains, Train A and Train B. Train A travels from Chennai to New Delhi. Train B travels from Trivandrum to Guwahati.

1. Passengers can board these trains only at the source station.
2. The trains have only reserved bogies and each bogie will only have passengers to a specific station.
3. When the train arrives at a station, the entire bogie with passengers is detached from the train, and the train continues its journey.

The routes with station code and distances of each station from originating station are as follows
(STATION (CODE) - DISTANCE ) :
Train A                                  Train B

CHENNAI (CHN) - 0		            TRIVANDRUM (TVC) - 0
SALEM (SLM) - 350		            SHORANUR (SRR) - 300
BANGALORE (BLR) - 550 - 0	        MANGALORE (MAQ) - 600
KURNOOL (KRN) - 900		            MADGAON (MAO) - 1000
HYDERABAD (HYB) - 1200		        PUNE (PNE) - 1400
NAGPUR (NGP) - 1600		            HYDERABAD (HYB) - 2000
ITARSI (ITJ) - 1900		             NAGPUR (NGP) - 2400
BHOPAL (BPL) - 2000		            ITARSI (ITJ) - 2700
AGRA (AGA) - 2500		            BHOPAL (BPL) - 2800
NEW DELHI (NDL) - 2700		        PATNA (PTA) - 3800
                                    NEW JALPAIGURI (NJP) - 4200
                                     GUWAHATI (GHY) - 4700

The Merger
During a part of their journey, these trains follow the same route and travel as one train - Train AB.
1. Trains start from their respective source stations and meet at Hyderabad.
2. Trains travel as TrainAB from Hyderabad to Bhopal as a single train.
3. From Bhopal the trains travel again as two independent trains, Train A and Train B.
4. Train A can have passengers in the route for Train B and vice versa. Eg: People can board from Chennai in Train A and travel to Guwahati.


Merging Rules
1. First, both the engines are attached.
2. The remaining bogies from Hyderabad are attached in the descending order of distances they have to travel further from Hyderabad.
3. When the merged train reaches a station, the bogie for that station will be the last one and it can be detached quickly.


Goal
Given the initial bogie order of both trains, your program should print -
1. The bogie order of arrival of Train A and Train B at Hyderabad
2. Train AB's departure bogie order from Hyderabad


Assumptions
1. The passengers board only from the source station.
2. If there are no passenger bogies to travel from Hyderabad station, then train should stop there. In such a case it should print JOURNEY_ENDED
3. The distances are in kilometers.
4. If there are multiple bogies with same station as its destination, then they can be arranged next to each other when the Train AB leaves Hyderabad.

Input format
Your program should take as input the order of bogies of each train from the source station.
TRAIN_A
ENGINE
BOGIE_1
BOGIE_2
BOGIE_3
BOGIE_4
BOGIE_5
TRAIN_B
ENGINE
BOGIE_1
BOGIE_2
BOGIE_3
BOGIE_4
BOGIE_5
Example
TRAIN_A
ENGINE
NDL
NDL
KRN
GHY
SLM
NJP
NGP
BLR
TRAIN_B
ENGINE
NJP
GHY
AGA
PNE
MAO
BPL
PTA


Output format
The output should be
1. The order of bogies for train A while arriving at Hyderabad.
2. The order of bogies for train B while arriving at Hyderabad.
3. The order of bogies for train AB (merged train) while departing from Hyderabad.

Example
TRAIN_A
ENGINE
NDL
NDL
GHY
NJP
NGP
TRAIN_B
ENGINE
NJP
GHY
AGA
BPL
PTA
TRAIN_AB
ENGINE
ENGINE
ENGINE
GHY
GHY
NJP
NJP
PTA
NDL
NDL
AGA
BPL
NGP



Sample Input/Output 1
INPUT
TRAIN_A ENGINE SLM BLR KRN HYB SLM NGG ITJ
TRAIN_B ENGINE SSR MAO NJP PNE PTA
OUTPUT
ARRIVAL TRAIN_A ENGINE HYB NGP ITJ
ARRIVAL TRAIN_B ENGINE NJP PTA
DEPARTURE TRAIN_AB ENGINE ENGINE NJP PTA ITJ NGP
Sample Input/Output 2
INPUT
TRAIN_A ENGINE NDL NDL KRN GHY SLM NJP NGP BLR
TRAIN_B ENGINE NJP GHY AGA PNE MAO BPL PTA
OUTPUT
ARRIVAL TRAIN_A ENGINE NDL NDL GHY NJP NGP
ARRIVAL TRAIN_B ENGINE NJP GHY AGA BPL PTA
DEPARTURE TRAIN_AB ENGINE ENGINE GHY GHY NJP NJP PTA NDL NDL AGA BPL NGP


Input needs to be read from a text file, and output should be printed to console. Your program should execute and take the location to the test file as parameter.

You can refer our help documents here - https://help.geektrust.com

You can read build instructions here - https://github.com/geektrust/coding-problem-artefacts