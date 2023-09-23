package CodSoft;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
import static CodSoft.Quiz.score;
import static java.lang.System.exit;
class CountdownTimer {
    Timer t;

    CountdownTimer(int s) {
        t = new Timer();
        t.schedule(new rt(), s * 1000L);
    }

    class rt extends TimerTask {
        public void run() {
            System.out.println("Time Up! Your Score is: "+score);
            t.cancel();
            exit(0);
        }
    }
}
public class Quiz {
    public static int score=0;
    static boolean validate(int q_no,int ch){
        if(q_no==1 && ch==1){
            return true;
        }
        else if(q_no==2 && ch==2){
            return true;
        }
        else if(q_no==3 && ch==2){
            return true;
        }
        else if(q_no==4 && ch==1){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        int choice;
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Java GK Quiz, you would be asked 5 questions with 4 options and would get 10 seconds to answer each question!");
        System.out.println("Each Correct answer would add 10 points to your score. User would get 10 seconds to answer each question." +
                "Good Luck!!");
        String[][] q = {{"What is the Capital of South Africa?", "Cape Town", "St. Johannesburg", "New Delhi", "None of These"},
                {"What is the tallest mountain in the world?", "Mt. K2", "Mt. Everest", "Matterhorn", "Mt. Fuji"},
                {"Who was the First President of India?", "Jawaharlal Nehru", "Dr. Rajendra Prasad", "Dr. APJ Abdul Kalam", "Indira Gandhi"},
                {"Which country is the world's biggest Democracy?", "India", "Russia", "United States of America", "China"}
        };
        System.out.print("Enter 1 to play, or any other key to exit: ");
        choice = s.nextInt();
        if (choice == 1) {
            for (int i = 0; i < q.length; i++) {
                new CountdownTimer(10);
                System.out.println("\n" + q[i][0]);
                System.out.printf("%d) %s\t%d) %s\n%d) %s\t%d) %s\n", 1, q[i][1], 2, q[i][2], 3, q[i][3], 4, q[i][4]);
                System.out.print("Enter the number corresponding to your choice: ");
                choice = s.nextInt();
                if (validate((i + 1), choice)) {
                    score += 10;
                    System.out.println("Congratulations! You got it right!! Score: " + score);
                } else {
                    System.out.println("Oops! That was the wrong answer.....");
                }
            }
            System.out.println("\nThanks for playing!! Your final score is: " + score);
        }
        else{
            System.out.println("\n\nPlayer quit the game.....");
        }
    }
}