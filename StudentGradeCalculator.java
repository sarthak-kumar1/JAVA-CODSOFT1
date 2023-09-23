package CodSoft;
import java.util.Scanner;
public class StudentGradeCalculator {
    static double sum(double[] y,int r){
        double s=0d;
        for(int i=0;i<r;i++){
            s+=y[i];
        }
        return s;
    }
    static boolean isValid(double m,double max){
        return m >= 0 && m <= max;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n,max;
        System.out.print("Enter the number of subjects: ");
        n=s.nextInt();
        System.out.print("Enter the maximum marks per subject: ");
        max=s.nextInt();
        double[] marks = new double[n];
        for(int i=0;i<n;i++){
            double t;
            System.out.printf("Enter Marks in Subject %d: ",i+1);
            t=s.nextDouble();
            while(!isValid(t,max)){
                System.out.print("Invalid Entry for Subject "+(i+1)+".... Try again: ");
                t=s.nextDouble();
            }
            marks[i]=t;
        }
        double total=sum(marks,n);
        double percentage=(total*100/(n*max));
        System.out.println("Total Marks obtained are: "+total+" out of "+max*n);
        System.out.println("Average percentage = "+percentage+"%");
        if(percentage<=100 && percentage>=90){
            System.out.println("You Passed with grade A+!!");
        }
        else if(percentage>=80){
            System.out.println("You Passed with grade A!");
        }
        else if(percentage>=65){
            System.out.println("You Passed with grade B.");
        }
        else if(percentage>=55){
            System.out.println("You Passed with grade C.");
        }
        else if(percentage>=33){
            System.out.println("You Passed with grade D...");
        }
        else{
            System.out.println("Unfortunately... You have failed.....");
        }
    }
}
