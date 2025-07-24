package main;

import java.text.NumberFormat;
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
					default: 
						throw new Exception();
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
		boolean done = false;
		while (!done) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.println("How many checks did you write in the last month?");
				System.out.println("Please only type numbers between 0 and 999.");
				System.out.print("Please don't type anything else, like letters or periods: ");
				int num_checks = input.nextInt();
				final double BASE_FEE = 10.0f;
				float check_fee = 0.0f;
				if (num_checks >= 1000) {
					throw new Exception("That's too many checks!");
				} else if (num_checks >= 60) {
					check_fee = 0.04f;
				} else if (num_checks >= 40) {
					check_fee = 0.06f;
				} else if (num_checks >= 20) {
					check_fee = 0.08f;
				} else if (num_checks >= 0) {
					check_fee = 0.1f;
				} else if (num_checks < 0) {
					throw new Exception("That's too few checks!");
				}
				float total = (float) BASE_FEE + (check_fee * num_checks);
				NumberFormat formatter = NumberFormat.getCurrencyInstance();
				System.out.println("Base fee: " + formatter.format(BASE_FEE));
				System.out.println("Check fee: " + formatter.format(check_fee));
				System.out.println("Total service charge: " + formatter.format(total));
				done = true; 
			} catch (Exception e) {
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
}
