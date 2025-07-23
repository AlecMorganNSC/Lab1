package main;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		boolean done = false;
		while (!done) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.println("Would you like to calculate test scores or bank charges?");
				System.out.print("Enter '1' for scores or '2' for bank charges: ");
				int choice = input.nextInt(); 
				switch (choice) {
					case 1: 
						scores();
						break;
					case 2:
						charges();
						break;
				}
				done = true;
				}
				catch (Exception e) {
					System.out.println("Sorry, I didn't understand that.");
				}
		}
	
	}
	
	public static void scores() {
		
		boolean done = false;
		while (!done) {
			try {
				System.out.println("Enter three scores to see their average score and grade!");
				System.out.println("Please only type whole numbers between 0 and 100.");
				System.out.println("Please don't type anything else, like letters or periods.");

				Scanner input = new Scanner(System.in);
				int N_SCORES = 3;
				int[] scores = new int[N_SCORES];
				for (int i = 0; i < scores.length; i ++) {
					System.out.print("Please enter score " + (i + 1) + ": ");
					int score = input.nextInt();
					if (score < 0) {
						throw new Exception("That number is too small!");
					} else if (score > 100) {
						throw new Exception("That number is too big!");
					} else {
						scores[i] = score;
					}
				}
		
				int avg_score = IntStream.of(scores).sum() / scores.length;
		
				System.out.println("Average score: " + avg_score);
		
				if (avg_score >= 90) {
					System.out.println("Average grade: A");
				} else if (avg_score >= 80) {
					System.out.println("Average grade: B");
				} else if (avg_score >= 70) {
					System.out.println("Average grade: C");
				} else if (avg_score >= 60) {
					System.out.println("Average grade: D");
				} else if (avg_score >= 0) {
					System.out.println("Average grade: F");
				} 
				done = true;
			}
			catch (Exception e) {
				//System.out.println("Sorry, I didn't understand that.");
				String error_message = e.getMessage();
				if (error_message == null) {
					System.out.println("Sorry, I didn't understand that.");
				} else {
					System.out.println(error_message);
				}
				System.out.println();
			}	
		}
	}
	
	public static void charges() {
		System.out.println("Placeholder");
	}
}
