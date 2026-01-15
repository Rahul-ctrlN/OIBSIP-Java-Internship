package tasks;
import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		int op=0;
		do {
			System.out.println("🎲 Number Guessing Game 🎲");
			System.out.println("\nGuess a number between 1 and 100");
			int num=rand.nextInt(100)+1;
			int c=0;
			int guess;
			int points=100;
			do {
				System.out.println("\nEnter your guess: ");
				guess=sc.nextInt();
				if(guess<num)
				{
					System.out.println("Result: Too LOW 🔽");
					points-=10;
				}
				else if(guess>num)
				{
					System.out.println("Result: Too HIGH 🔼");
					points-=10;
				}
			    c++;
			    if(points==0)break;
			}while(num!=guess);
			
			if(num==guess)
			{
				System.out.println("🎉 Congratulations! You guessed the correct number 🎉");
				System.out.println("\nTotal Attempts: "+c);
				System.out.println("Total Points: "+points);	
			}
			else
			{
				System.out.println("Points = 0");
				System.out.println("Attempts Over");
			}
			switch(c)
			{
			case 1:System.out.println("Excellent you guessed in the first attempt 🔥");
			break;
			case 2: case 3:System.out.println("High score 👍");
			break;
			case 4: case 5: case 6: System.out.println("Average Score 🙂");
			break;
			case 7: case 8: case 9: System.out.println("Poor Score 😐");
			break;
			default: System.out.println("Keep practicing ! Better luck next time 💪");
			
			}
			System.out.println("Game Over. Thanks for playing !");
			System.out.println("\nDo you want to play again (yes/no):");
			String o=sc.next();
			if(o.equalsIgnoreCase("yes"))
				op=1;
			System.out.println("\n");
		}while(op!=0);

	}

}
