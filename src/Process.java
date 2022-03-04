public class Process implements Comparable<Process>{

int priorityLevel;
int remainingTime;
int timeNotProcessed;
int arrivalTime;

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

    public void incrementTimeNotProcessed(){
        timeNotProcessed++;
    }

    @Override
    public int compareTo(Process o) {
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

    public boolean finish() {

        if(remainingTime == 0){

            return true;
        }else{

            return false;
        }
        
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getPriority() {
        return priorityLevel;
    }

    public int getTimeRemaining() {
        return remainingTime;
    }

    public void incrementPriority(){
        priorityLevel++;
    }

    public void resetTimeNotProcessed() {
        timeNotProcessed = 0;
    }




}
