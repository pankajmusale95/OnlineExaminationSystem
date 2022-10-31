package FinalProject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("\t\t\t\t\t\t****************************************************");
		System.out.println("\t\t\t\t\t\t******************* Welcome To *********************");
		System.out.println("\t\t\t\t\t\t********** Online Examination system ***************");
		System.out.println("\t\t\t\t\t\t****************************************************\n");

		System.out.print("\nCreated by:-");
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.print("P");
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.print("a");
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println(e);

		}
		System.out.print("n");
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.print("k");
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.print("a");
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.print("j\n");
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println(e);
		}

		Scanner sc = new Scanner(System.in);

		Action a = new Action();
		int choice;
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println(e);
		}

		a.mainOption();

		choice = sc.nextInt();

		switch (choice) {

		case 1:
			System.out.println("\nStudent Login");

			a.studentLogin();

			break;

		case 2:
			System.out.println("\nAdmin Login");
			do {
				a.adminLogin();

			} while (true);
		case 3:
			System.out.println("\t\t\t\t\t\t_______________________________________________");
			System.out.println("\t\t\t\t\t\t|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|");
			System.out.println("\t\t\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\t\t\t\t\t\t    Thank You For Visiting The Application!!   ");
			System.out.println("\t\t\t\t\t\t_______________________________________________");
			System.out.println("\t\t\t\t\t\t|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|");
			System.out.println("\t\t\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			System.exit(0);
			break;
		default:
			System.out.println("Please Enter A Valid Option");

		}

	}
}
