package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Enter three scores to see their average score and grade!");
		System.out.println("Please only type whole numbers between 0 and 100.");
		System.out.println("Please don't type anything else, like letters or periods.");
		
		Scanner input = new Scanner(System.in);
		final int N_SCORES = 3;
		int[] scores = new int[3];
		for (int i = 0; i < scores.length; i ++) {
			System.out.print("Please enter score " + (i + 1) + ": ");
			scores[i] = input.nextInt();
		}
	}
}
