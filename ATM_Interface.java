package CodSoft;
import java.util.Objects;
import java.util.Scanner;
class ATM{
    static double balance=10000;
    int a_no=1234,a_entered;
    int pin;
    String name;
    ATM(int a,int p,String n){
        a_entered=a;
        pin=p;
        name=n;
    }
    boolean validate(){
        return (a_entered==a_no) && (pin == 2342) && (Objects.equals(name, "Rudraksh"));
    }
    double getBalance(){
        return balance;
    }
    void withdraw(double x){
        if(x<=0){
            System.out.println("Invalid amount entered.... try again!");
        }
        else if(x>balance){
            System.out.println("Entered amount exceeds total account balance... Transaction not possible!");
        }
        else{
            balance-=x;
            System.out.println("Amount Successfully withdrawn!!");
        }
    }
    void deposit(double x){
        if(x<=0){
            System.out.println("Invalid amount entered! Please try again...");
        }
        else{
            balance+=x;
            System.out.println("Amount successfully credited!");
        }
    }
}
public class ATM_Interface {
    public static void main(String[] args) {
        double amt;
        int acno;
        int pin,ch=0;
        String n;
        Scanner s=new Scanner(System.in);
        System.out.println("Welcome to the Interface for the personal account of Rudr***h!");
        while(ch!=2){
            System.out.println("-----> MAIN MENU <-----");
            System.out.println("1) Login");
            System.out.println("2) Exit");
            System.out.print("Enter the number corresponding to your choice: ");
            ch=s.nextInt();
            if(ch==1){
                System.out.println("-----> VERIFICATION PORTAL <------");
                System.out.print("Enter the last 4 digits of the Account number: ");
                acno=s.nextInt();
                System.out.print("Enter the name: ");
                n=s.next();
                System.out.print("Enter the PIN: ");
                pin=s.nextInt();
                ATM a=new ATM(acno,pin,n);
                if(!a.validate()){
                    System.out.println("Login has failed due to incorrect credentials! Try again!!");
                }
                else{
                    int l_ch=0;
                    System.out.println("LOGIN SUCCESSFUL!");
                    while(l_ch!=4){
                        System.out.println("-----> YOUR ACCOUNT <-----");
                        System.out.println("1) Check Balance");
                        System.out.println("2) Withdraw Money");
                        System.out.println("3) Deposit Money");
                        System.out.println("4) Exit");
                        System.out.print("Enter the number corresponding to your choice: ");
                        l_ch=s.nextInt();
                        if(l_ch==1){
                            System.out.println("Your Current account balance is: "+a.getBalance()+" rupees");
                        }
                        else if(l_ch==2){
                            System.out.print("Enter the amount to be withdrawn: ");
                            amt=s.nextDouble();
                            a.withdraw(amt);
                        }
                        else if(l_ch==3){
                            System.out.print("Please deposit the currency notes into the machine and enter the amount: ");
                            amt=s.nextDouble();
                            a.deposit(amt);
                        }
                        else if(l_ch==4){
                            System.out.println("Thanks for using this interface! Bye!!");
                            break;
                        }
                        else{
                            System.out.println("Invalid Choice.... try again!");
                        }
                    }
                }
            }
            else if (ch==2){
                System.out.println("Thanks for using this program!! Bye!!!");
                break;
            }
            else{
                System.out.println("Invalid Choice.... try again");
            }
        }
    }
}
