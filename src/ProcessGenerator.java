import java.util.Random;

public class ProcessGenerator {
    private double probability;
    Random random = new Random(5);

    public ProcessGenerator(double probability) {
        this.probability = probability;

    }


    public boolean query() {

        if( random.nextDouble() < probability){

            return true;
        }else{

            return false;
        }
    }

    public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {

        int priorityLevel = random.nextInt(maxLevel) + 1;
        int timeRemaining = random.nextInt(maxProcessTime) + 1;

        Process newProcess = new Process(priorityLevel, timeRemaining, currentTime);

        return newProcess;
    }
    
}
