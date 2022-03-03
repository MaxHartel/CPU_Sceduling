public class MaxHeap<T extends Comparable<T> > {
private HeapNode<T>[] heap = new HeapNode[100];
private int heapSize;
private int capacity;

    public MaxHeap(){
        heapSize = 0;

    }

    public void heapInsert(T element){
        HeapNode<T> node = new HeapNode(element);

        if(heapSize == capacity){
            increaseCapacity(heap);
        }

        heapSize++;

        heap[heapSize] = node;
    }

    public void maxHeapifyUp(int index, T element){



    }

    public void maxHeapify(int index){
        int left = leftChild(index);
        int right = rightChild(index);
        int largest = 0;

        if( (left <= heapSize) && (heap[left].getKey() > heap[index].getKey())){

            largest = left;
        }else{

            largest = index;
        }

        if((right <= heapSize) && (heap[right].getKey() > heap[index].getKey())){

            largest = right;
        }

        if (largest != index){

            HeapNode<T> temp = heap[largest];
            heap[largest] = heap[index];
            heap[index] = temp;
        }

        maxHeapify(largest);
    }

    private void increaseCapacity(HeapNode<T>[] arr){
        HeapNode<T>[] cpy = new HeapNode[capacity * 2];

        for( int i = 0; i < heapSize; i++){
            cpy[i] = heap[i];
        }

        heap = cpy;
        capacity *= 2;
    }


    public T extractMax(){

        return null;
    }

    private int leftChild(int i){
        i *= 2;

        return i;
    }

    private int rightChild(int i){
        i = (2 * i) + 1;

        return i;
    }

    




    private class HeapNode<T extends Comparable<T> >{
        private T node;
        int key;
    
        private HeapNode(T process){
            this.node = process;
            
        }

        public T getObject(){
            return node;
        }

        public void setObject(T process){
            this.node = process;
        }

        public int getKey(){
            return key;
        }

        public void setKey(int key){
            this.key = key;
        }

        }



        
    }
    

    
}
