public class PQueue{
    private MaxHeap<Process> maxHeap;

    public PQueue(){
         maxHeap = new MaxHeap<>(100);

    }

    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    public Process dePQueue() {
        return maxHeap.extractHeapMax();
    }

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

    public void enPQueue(Process next) {
        maxHeap.maxHeapInsert(next);
    }
    
}
