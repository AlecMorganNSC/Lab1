package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Enter three scores to see their average score and grade!");
		System.out.println("Please only type whole numbers between 0 and 100.");
		System.out.println("Please don't type anything else, like letters or periods.");
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the first score: ");
		int score1 = input.nextInt();
		System.out.print("Please enter the second score: ");
		int score2 = input.nextInt();
		System.out.print("Please enter the third score: ");
		int score3 = input.nextInt();
	}
}
