/**
 * A max priority queue of processes implemented on a max heap
 */
public class PQueue{
    private MaxHeap<Process> maxHeap;

    /**
     * creates a new max heap to be used for a max priority queue
     */
    public PQueue(){
         maxHeap = new MaxHeap<>(100);

    }

     /**
     * returns whether or not the Pqueue contains any elements
     * @return returns true if the heap is empty
     */
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    /**
     * extracts and returns the top element in the priority queue
     * @return the top element in the priority queue
     */
    public Process dePQueue() {
        return maxHeap.extractHeapMax();
    }

    /**
     * Updates the time not processed and the priority attributes of the Processes in the queue 
     * @param timeToIncrementLevel the time that hass to pass without a Processs getting any CPU time before its priority is updated
     * @param maxLevel the max priority level for a process
     */
    public void update(int timeToIncrementLevel, int maxLevel) {
        for(int i = 0; i < maxHeap.getSize(); i++){
            maxHeap.getElement(i).incrementTimeNotProcessed();

            if( maxHeap.getElement(i).timeNotProcessed >= timeToIncrementLevel){

                maxHeap.getElement(i).resetTimeNotProcessed();

                if(maxHeap.getElement(i).getPriority() < maxLevel){

                    maxHeap.getElement(i).incrementPriority();
                    maxHeap.maxHeapifyUp(i);
                }
            }
        }
    }

    /**
     * adds a new Process to the priority queue
     * @param next the Process to be added to the Priority queue
     */
    public void enPQueue(Process next) {
        maxHeap.maxHeapInsert(next);
    }
    
}
