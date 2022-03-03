import java.util.Scanner;

public class test {  
    public static void main(String args[]){
        double input;
        int scale = 0;

        System.out.println("Enter a number with trailing decimals");
        Scanner scan = new Scanner(System.in);

        input = Double.parseDouble(scan.nextLine());

        while(input % 1 != 0){
            if(((input % 1) - 1) < 0.000000001){
                
                input = Math.round(input);
            }
            
            input *= 10;
            System.out.println("Step: " + input);
            scale++;
        }

        System.out.println("Conclusion: " + input + " " + scale);
        
    }
}
