import java.util.Random;
import java.util.Scanner;

public class test { 
    Random random = new Random();
    public static void main(String args[]){
        MaxHeap maxHeap = new MaxHeap(10);

        for(int i = 0; i < maxHeap.getSize();i ++ ){
            //maxHeap.maxHeapInsert(Random.nextInt());
        }


    StringBuilder sb = new StringBuilder();
    int max=0;
    for(int i=0;i<maxHeap.getSize();i++){
        for(int j=0;j<Math.pow(2,i)&&j+Math.pow(2,i)<10;j++){

            if(j>max){
                max=j;
            }
        }

    }

    for(int i=0;i<10;i++){
        for(int j=0;j<Math.pow(2,i)&&j+Math.pow(2,i)<10;j++){

            for(int k=0;(k<max/((int)Math.pow(2, i)));k++){
                sb.append(" ");
            }
            sb.append(maxHeap.getElement(i+(int)Math.pow(2,i)-1) + " ");

        }
        sb.append("\n");

    }



    System.out.println(sb.toString());

}

        
    }
