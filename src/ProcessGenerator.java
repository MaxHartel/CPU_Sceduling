import java.util.Random;

/**
 * Randomly generates processes with a given probibility 
 * @author max hartel
 */
public class ProcessGenerator {
    private double probability;
    Random random = new Random();

    /**
     * Intantiates the probibility variable to parameter
     * @param probability
     */
    public ProcessGenerator(double probability) {
        this.probability = probability;

    }

    /**
     * returns true with the probibility provided by 'probibility'
     * @return
     */
    public boolean query() {

        if( random.nextDouble() < probability){

            return true;
        }else{

            return false;
        }
    }

    /**
     * Creates a new process instance with random attributes
     * @param currentTime the current 'time' which is the current iteration of the for loop
     * @param maxProcessTime the top end of the range for a randomly generated time it takes for the process to finish
     * @param maxLevel the top end of the range for a randomly generated priority level for a process
     * @return newProcess, a new process created with random attributes
     */
    public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {

        //Assigns priorityLevel and timeRemaining their random values from the desired range
        int priorityLevel = random.nextInt(maxLevel) + 1;
        int timeRemaining = random.nextInt(maxProcessTime) + 1;

        //creates a new process
        Process newProcess = new Process(priorityLevel, timeRemaining, currentTime);

        return newProcess;
    }
    
}
