****************
* CPUSceduler
* CS 321
* 3/4/2022
* Max Hartel
**************** 

OVERVIEW:

 CPUSceduler is a program that aims to give the correct processes the most time to run using a round robin sceduling algorithm. It does this by using a max priority queue implementation that is based on a MaxHeap abstract data type. 


INCLUDED FILES:

 CPUScheduling.java - source file
 Avrerager.java - source file
 MaxHeap.java - source file
 PQueue.java - source file
 Process.java - source file
 ProcessGenerator.java - source file
 README - this file


BUILDING AND RUNNING:

 From the directory containing all source files, compile the test
 class with the command:
 $ javac *.java

 Run the compiled CPUSceduling class with the command:
 $ java CPUSceduling <maxProcessTime> <maxPriorityLevel> <timeToInceremntPriority> <simulationTime> <processArrivalRate>

 - maxProcessTime: integer representing the largest possible amount of time units required to finish a process
 - maxPriorityLevel: integer representing the highest possible priority in the simulation
 - timeToIncrementPriority: integer, if a process did not get any CPU time for this amount of time, its priority level is increased

 - simulationTime: the total time units for the simulation
 - processArrivalRate: double, this rate is used to decide whether or not to generate a new process for each time unit

 
 

PROGRAM DESIGN:

 CPUSeduling uses max priority queue to organize and store the processes to be used in its round robin sceduling algorithm.
 This priority queue is in the class PQueue, and had process objects passed into it by CPUSceduling. 

 Process objects are instances of the class Process, and are created by the class ProcessGenerator in CPUSceduling.
 These processes contain attributes abount themselves such as their priority level and the time hey were created, that is in turn used by the max priority queue to organize them accordingly. 

 ProcessGenerator creates process objects with random attributes on the ratio of time units that is dependent on user input. 

 The max priority queue in the class Pqueue is implements a maxHeap abstract data type in order to store the Process objects that are contained in the max priority queue. It uses a maxHeap ADT because this is an efficient was to implement a max priority queue. The max priority queue ADT is contained in the MaxHeap class.


 

TESTING:

 This program was tested by a testing script run_test that can be found in:
 ~minlong/repos/cs321/lab2files/

 Scenarios being tested by the script include:
   - all ProcessArrivalRate probibilities between 0 and 1 accounting for doubles that oy extend to the tenths place
 
 Additional scenarios would be beneficial, such as designing a personalized testing suite to analyze the function of each class in the project, but time constraints prevented this.

 All tests are currently passing.


DISCUSSION:
 
 This project was a challenging one for me, but it was also a very worthwhile project to undertake as I feel like I learned a lot along the way. I felt that i was pretty sound on my conceptual knowledge of the max heap and priority queue, but there were two main challenges that made this progect paticularilay interesting, and one nasty bug that proved to be a big hurdle for this project as well. 

 The first main challenge is that I am still getting used to the instructions for a project not being very specififc or step by step, but more focused around producing a certian end goal and letting us find our own path to that end goal. I actually really agree with this format for projects and I beleive that it makes me a better programer and more prepared for the industry after college to practice creating solutions on my own with the skills learned in class. That being said though, a significant portion of the beginning of this project was just based on the arcitecture of the project and how I could design my classes to effectively work together. 

 The second main challenge was that I found that this project was much harder to test and debug than previous projects. On 221 projects, you could run the tests early and often as you completed each functin, and could clearly see when something you just did has a positive or negitive impact. But here I had to wait until the entire project was finished to start testing, which widened my scope for debugging considerably and made that process much harder.

 The bug that presented a big hurdle for me is that I found it very hard to compare Generic types in the maxHeap function. But I eventually figured out how to solve this by instantiating the array at runtime. 