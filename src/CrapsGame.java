import java.util.Random;
import java.util.Scanner;

public class CrapsGame {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int die1, die2, sum;
        int roll = 1;
        int point = 0;
        String playAgain;

        System.out.printf("%-8s %-8s %-8s %-8s %-8s%n", "Roll", "Die1", "Die2", "Sum", "Point");
        do {
            roll = 1;
            point = 0;

            die1 = rand.nextInt(6) + 1;
            die2 = rand.nextInt(6) + 1;
            sum = die1 + die2;

            System.out.printf("%-8d %-8d %-8d %-8d %-8d%n", roll, die1, die2, sum, point);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You crapped out. The game is over. You lose!");
            } else if (sum == 7 || sum == 11) {
                System.out.println("It's a natural. The game is over. You win!");
            } else {
                point = sum;
                System.out.println("Point is " + point);
                do {
                    roll++;

                    die1 = rand.nextInt(6) + 1;
                    die2 = rand.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.printf("%-8d %-8d %-8d %-8d %-8d%n", roll, die1, die2, sum, point);
                    if (sum != point && sum != 7) {
                        System.out.println("Trying for point");
                    }
                } while (sum != point && sum != 7);
                if (sum == point) {
                    System.out.println("You made point. You won!");
                } else {
                    System.out.println("You got a seven. You lost!");
                }
            }
            System.out.print("Would you like to play again? (Y/N): ");
            playAgain = in.nextLine();
        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing");
        in.close();
    }
}