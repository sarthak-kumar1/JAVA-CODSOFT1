import java.util.Scanner;
import java.util.Random;
public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Random r=new Random();
        System.out.println("\nWelcome to Guess The Number! Here, the user has to guess a random number between 1 and 100 in 10 attempts!");
        int ch=0;
        int x,y;
        while(ch!=2){
            System.out.println("\n-----> Main Menu <-----");
            System.out.println("1) Play");
            System.out.println("2) Exit");
            System.out.print("Enter the number corresponding to your choice: ");
            ch=s.nextInt();
            if(ch==1) {
                System.out.println("A random number between 1 and 100 has been generated!\n");
                y=r.nextInt(0,100);
                int a=1;
                while(a<=10){
                    System.out.printf("Enter Guess %d: ",a);
                    x=s.nextInt();
                    if(x==y){
                        System.out.printf("Congratulations, you have guessed the correct number in %d attempts!\n",a);
                        break;
                    }
                    if(x>y){
                        System.out.println("The number entered is greater than the actual number.... try again...");
                    }
                    else{
                        System.out.println("The number entered is smaller than the actual number..... try again...");
                    }
                    a++;
                }
                if(a>10){
                    System.out.printf("Unfortunately..... you lost, the actual number was %d\n",y);
                }
            }
            else if(ch==2){
                System.out.println("Thanks for playing! Bye!!");
                break;
            }
            else{
                System.out.println("Invalid Choice.... Please try again...");
            }
        }
    }
}