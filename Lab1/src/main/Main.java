package main;

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		boolean done = false;
		while (!done) {
			// Try-catch in case the user enters something that can't be parsed. 
			try {
				// Ask the user if they want to calculate scores or grades. 
				Scanner input = new Scanner(System.in);
				System.out.println("Would you like to calculate test scores or bank charges?");
				System.out.print("Enter '1' for scores or '2' for bank charges: ");
				int choice = input.nextInt(); 
				switch (choice) {
					case 1: 
						// Calculate scores if the user wants to calculate scores. 
						scores();
						done = true; // Stop asking the user to choose. 
						break;
					case 2:
						// Calculate charges if the user wants to calculate charges. 
						charges();
						done = true; // Stop asking the user to choose. 
						break;
					default: 
						throw new Exception();
				}
			} catch (Exception e) {
				// Generic error message for all unhandled user inputs. 
				System.out.println("Sorry, I didn't understand that.");
			}
			System.out.println(); // Visually separate the last attempt from the new one. 
		}
	
	}
	
	public static void scores() {
		boolean done = false;
		while (!done) {
			try {
				// Give the user instructions on using the program. 
				System.out.println();
				System.out.println("Enter three scores to see the average score and grade!");
				System.out.println("Please only type whole numbers between 0 and 100.");
				System.out.println("Please don't type anything else, like letters or periods.");

				// Collect scores from user. 
				Scanner input = new Scanner(System.in);
				final int N_SCORES = 3;
				int[] scores = new int[N_SCORES];
				for (int i = 0; i < scores.length; i ++) {
					// "Please enter score 1, 2, 3, etc..."
					System.out.print("Please enter score " + (i + 1) + ": ");
					int score = input.nextInt();
					// If score is below 0 or above 100 throw a helpfully specific error. 
					if (score < 0) {
						throw new Exception("That number is too small!");
					} else if (score > 100) {
						throw new Exception("That number is too big!");
					} else {
						scores[i] = score;
					}
				}
		
				// Calculate and show the average of all scores. 
				int avg_score = IntStream.of(scores).sum() / scores.length;
				System.out.println("Average score: " + avg_score);
		
				// Show the corresponding average letter grade. 
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
				done = true; // Stop asking the user to input scores. 
			} catch (Exception e) {
				// Check the message attached to the Exception, if any. 
				String error_message = e.getMessage();
				if (error_message == null) {
					// If we don't have a specific helpful error message say something generic. 
					System.out.println("Sorry, I didn't understand that.");
				} else {
					// If we have a specific helpful error message say that. 
					System.out.println(error_message);
				}
			}	
		}
	}
	
	public static void charges() {
		boolean done = false;
		while (!done) {
			// Try-catch in case the user enters something that can't be parsed. 
			try { 
				Scanner input = new Scanner(System.in);
				// Give the user instructions on using the program.
				System.out.println();
				System.out.println("How many checks did you write in the last month?");
				System.out.println("Please only type numbers between 0 and 999.");
				System.out.print("Please don't type anything else, like letters or periods: ");
				// Find out how many checks the user wrote last month. 
				int num_checks = input.nextInt();
				final double BASE_FEE = 10.0f; // base fee is always the same. 
				// Check fee is never actually 0, but it must be prematurely initialized to avoid crashes. 
				float check_fee = 0.0f; 
				// Figure out the check fee. 
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
				// Calculate the total from the base fee and check fees. 
				float total = (float) BASE_FEE + (check_fee * num_checks);
				// Formatter to present numbers in localized currency style. 
				NumberFormat formatter = NumberFormat.getCurrencyInstance();
				// Explain all fees to the user. 
				System.out.println("Base fee: " + formatter.format(BASE_FEE));
				System.out.println("Check fee: " + formatter.format(check_fee));
				System.out.println("Total service charge: " + formatter.format(total));
				done = true; // Stop asking the user how many checks they've written. 
			} catch (Exception e) {
				// Check the message attached to the Exception, if any. 
				String error_message = e.getMessage();
				if (error_message == null) {
					// If we don't have a specific helpful error message say something generic. 
					System.out.println("Sorry, I didn't understand that.");
				} else {
					// If we have a specific helpful error message say that. 
					System.out.println(error_message);
				}
			}
		}
	}
}
