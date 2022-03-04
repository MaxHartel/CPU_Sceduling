import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxHeap<T extends Comparable<T>> {
private T[] heap;
private int heapSize;
private int capacity;

    public MaxHeap(int capacity){
        heapSize = 0;
        this.capacity = capacity;
        heap = null;
    }

    public void maxHeapInsert(T element){
        if (heap == null){
            heap = (T[]) Array.newInstance(element.getClass(), capacity);
        }

        if(heapSize == capacity){

            increaseCapacity();
        }

        heap[heapSize] = element;

        maxHeapifyUp(heapSize);
        heapSize++;

    }

    public T getElement(int i){
        return heap[i];
    }

    public void maxHeapifyUp(int index){
        int parent = (index - 1) / 2;

        if( heap[index].compareTo(heap[parent]) > 0){

            swap(parent, index);
            maxHeapifyUp(parent);
        }
    }

    public void maxHeapify(int index){
        int left = leftChild(index);
        int right = rightChild(index);
        int largest = 0;

        if( (left <= heapSize) && (heap[left].compareTo(heap[index]) > 0)){

            largest = left;
        }else{

            largest = index;
        }

        if((right <= heapSize) && (heap[right].compareTo(heap[largest]) > 0)){

            largest = right;
        }

        if (largest != index){

            swap(largest, index);

            maxHeapify(largest);

        }

    }

    public T extractHeapMax(){
        T retVal = heap[0];
        
        heapSize--;
        heap[0] = heap[heapSize];

        maxHeapify(0);

        return retVal;
    }

    public boolean isEmpty(){

        if(heapSize == 0){

            return true;
        }else{

            return false;
        }
    } 

    private void swap( int var1, int var2){
        T temp = heap[var2];
            heap[var2] = heap[var1];
            heap[var1] = temp;
    }

    private void increaseCapacity(){
        capacity *= 2;
        heap = Arrays.copyOf(heap, capacity);
    }

    private int leftChild(int i){
        i = i * 2 + 1;

        return i;
    }

    private int rightChild(int i){
        i = (2 * i) + 2;

        return i;
    }

    public int getSize(){
        return heapSize;
    }

    public int getCapicity(){
        return capacity;
    }
    }
    

    

