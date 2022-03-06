/**
 * Defines a Process object and it's attributes, implements the comparable interface
 * @author Max Hartel
 */
public class Process implements Comparable<Process>{

int priorityLevel;
int remainingTime;
int timeNotProcessed;
int arrivalTime;

    /**
     * Instantiates the attributes for a process based on input
     * @param priorityLevel the priority level of the process
     * @param timeRemaining the time remaining for the process to be finished
     * @param arrivalTime the arrival time of the process
     */
    public Process(int priorityLevel, int timeRemaining, int arrivalTime ){
        this.priorityLevel = priorityLevel;
        this.remainingTime = timeRemaining;
        this.arrivalTime = arrivalTime;

    }

    /**
     * reduces the remaining time for this process by TIME_SLICE
     */
    public void reduceTimeRemaining(){
        remainingTime--;
        timeNotProcessed = 0;
    }

    /**
     * increments the timeNotProcessed attribute for a process by 1
     */
    public void incrementTimeNotProcessed(){
        timeNotProcessed++;
    }


    @Override
    public int compareTo(Process o) {

        //compares priority levels of the two processes, than compares the arrival times of the two processes if the priority levels are equal
        if(priorityLevel < o.priorityLevel){

            return -1;
        }else if(priorityLevel > o.priorityLevel){

            return 1;
        }else if( arrivalTime > o.arrivalTime){

            return -1;
        }else if( arrivalTime < o.arrivalTime){
            
            return 1;
        }else{

            return 0;
        }
    }

    /**
     * returns true if the Process has no time remaining left
     * @return if the process is finished
     */
    public boolean finish() {

        if(remainingTime == 0){

            return true;
        }else{

            return false;
        }
        
    }

    /**
     * returns the arrivalTime attribute for this process
     * @return the arrival time of the process
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * returns the priorityLevel attribute for this process
     * @return the priority level of the Process
     */
    public int getPriority() {
        return priorityLevel;
    }

    /**
     * returns the remainingTime attribute for this process
     * @return the remaining time of the process
     */
    public int getTimeRemaining() {
        return remainingTime;
    }

    /**
     * increments the priorityLevel attribute of the Process
     */
    public void incrementPriority(){
        priorityLevel++;
    }

    /**
     * resets the timeNotProcessed attribute of the Process to zero
     */
    public void resetTimeNotProcessed() {
        timeNotProcessed = 0;
    }




}
