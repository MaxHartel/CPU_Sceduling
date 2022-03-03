public class MaxHeap<T extends Comparable<T>> {
private Comparable[] heap;
private int heapSize;
private int capacity;

    public MaxHeap(){
        heapSize = 0;
        heap = new Comparable[100];
    }

    public void heapInsert(T element){

        if(heapSize == capacity){

            increaseCapacity();
        }

        heap[heapSize] = element;

        maxHeapifyUp(heapSize);
        heapSize++;

    }

    public void maxHeapifyUp(int index){
        int parent = (int) Math.floor(index / 2);

        if( heap[index].compareTo(heap[parent]) < 0){

            swap(parent, index);
            maxHeapifyUp(index);
        }
    }

    public void maxHeapify(int index){
        int left = leftChild(index);
        int right = rightChild(index);
        int largest = 0;

        if( (left <= heapSize) && (heap[left].compareTo((T) heap[index]) > 0)){

            largest = left;
        }else{

            largest = index;
        }

        if((right <= heapSize) && (heap[right].compareTo((T) heap[index]) > 0)){

            largest = right;
        }

        if (largest != index){

            swap(largest, index);

            maxHeapify(largest);

        }

    }

    private void swap( int var1, int var2){
        T temp = (T) heap[var2];
            heap[var2] = heap[var1];
            heap[var1] = temp;
    }

    private void increaseCapacity(){
        Comparable<T>[] cpy = new Comparable[100];

        for( int i = 0; i < heapSize; i++){
            cpy[i] = heap[i];
        }

        heap = cpy;
        capacity *= 2;
    }

    private int leftChild(int i){
        i *= 2;

        return i;
    }

    private int rightChild(int i){
        i = (2 * i) + 1;

        return i;
    }
    }
    

    

