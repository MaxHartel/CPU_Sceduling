import java.lang.reflect.Array;
import java.util.Arrays;

/** 
 * Array based implementation of a max heap data structure
 * @author Max Hartel
 * @param T generic type
 */
public class MaxHeap<T extends Comparable<T>> {
private T[] heap;
private int heapSize;
private int capacity;

    /**
     * creates a new max heap of a given capacity
     * @param capacity the capacity of the max heap
     */
    public MaxHeap(int capacity){
        heapSize = 0;
        this.capacity = capacity;
        heap = null;
    }

    /**
     * inserts an element into the max heap and then puts it in the correct spot in the heap
     * @param element the element to be inserted into the heap
     */
    public void maxHeapInsert(T element){

        //creates a new heap if there is not one created
        if (heap == null){
            heap = (T[]) Array.newInstance(element.getClass(), capacity);
        }

        //increases the capacity of the heap if it is full
        if(heapSize == capacity){

            increaseCapacity();
        }

        //inserts the element as a leaf on the max heap
        heap[heapSize] = element;

        //puts the element at the correct spot on the heap
        maxHeapifyUp(heapSize);
        heapSize++;

    }

    /**
     * returns an elemnt of the requested index
     * @param i the index of the element to be returned
     * @return the element at index i
     */
    public T getElement(int i){
        return heap[i];
    }

    /**
     * rearranges the max heap above the element at index to restore the max heap property to the heap
     * @param index the index of the element of which will be maxHeapified Up
     */
    public void maxHeapifyUp(int index){
        int parent = (index - 1) / 2;

        if( heap[index].compareTo(heap[parent]) > 0){

            swap(parent, index);
            maxHeapifyUp(parent);
        }
    }

    /**
     * rearranges the elemnts of the heap to maintain the max heap property of the subtree starting at the root i 
     * @param index the index of the element being max heapified
     */
    public void maxHeapify(int index){
        int left = leftChild(index);
        int right = rightChild(index);
        int largest = 0;

        //sets largest to the the left child's index of the designated index if the left child's value is greater than that of the index's
        if( (left <= heapSize) && (heap[left].compareTo(heap[index]) > 0)){

            largest = left;
        }else{

            largest = index;
        }

        //sets largest to the the right child's index of the designated index if the right child's value is greater than that of the index's
        if((right <= heapSize) && (heap[right].compareTo(heap[largest]) > 0)){

            largest = right;
        }

        //exchanges the value at the index largest with the designated index if the designated index is not largest
        if (largest != index){

            swap(largest, index);

            //recursively maxHeapifies the new child 
            maxHeapify(largest);

        }

    }

    /**
     * removes and returns the root of the max heap
     * fixes the heap after removal to maintain the max heap property
     * @return the element at the root of the max heap
     */
    public T extractHeapMax(){
        T retVal = heap[0];
        
        heapSize--;
        heap[0] = heap[heapSize];

        maxHeapify(0);

        return retVal;
    }

    /**
     * returns whether or not the max heap contains any elements
     * @return returns true if the heap is empty
     */
    public boolean isEmpty(){

        if(heapSize == 0){

            return true;
        }else{

            return false;
        }
    } 

    /**
     * swapps the values of two indicies
     * @param var1 the index of the first value to be swapped
     * @param var2 the index of the second value to be swapped
     */
    private void swap( int var1, int var2){
        T temp = heap[var2];
            heap[var2] = heap[var1];
            heap[var1] = temp;
    }

    /**
     * doubles the capacicity of the array the heap is based on
     */
    private void increaseCapacity(){
        capacity *= 2;
        heap = Arrays.copyOf(heap, capacity);
    }

    /** 
     * returns the index of the left child of the given index
     * @param i the index of the designated element
     * @return i the index of the left child of the given index
     */
    private int leftChild(int i){
        i = i * 2 + 1;

        return i;
    }

    /** 
     * returns the index of the right child of the given index
     * @param i the index of the designated element
     * @return i the index of the left child of the given index
     */
    private int rightChild(int i){
        i = (2 * i) + 2;

        return i;
    }

    /**
     * returns the number of elements in the heap
     * @return heapSize the number of elements in the heap
     */
    public int getSize(){
        return heapSize;
    }

    /**
     * Returns the size of the array the heap is based on
     * @return capacity the size of the array the heap is based on
     */
    public int getCapicity(){
        return capacity;
    }
    }
    

    

