package FinalProject;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Action implements DAOFile {

	// display the main menu
	@Override
	public void mainOption() {
		try {
			Thread.sleep(500);
			System.out.println("\n===================================");
			Thread.sleep(500);
			System.out.println("Enter 1 for Student Login");
			Thread.sleep(500);
			System.out.println("Enter 2 for Admin Login");
			Thread.sleep(500);
			System.out.println("Enter 3 to Exit");
			Thread.sleep(500);
			System.out.println("===================================");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void adminOption() {
		try {
			Thread.sleep(500);
			System.out.println("\t\t\t\t\t\t**********************************");
			Thread.sleep(500);
			System.out.println("\n\t\t\t\t\t\t*   1.Enter Student details      *");
			Thread.sleep(500);
			System.out.println("\n\t\t\t\t\t\t*   2.Edit Student details       *");
			Thread.sleep(500);
			System.out.println("\n\t\t\t\t\t\t*   3.Display Student details    *");
			Thread.sleep(500);
			System.out.println("\n\t\t\t\t\t\t*   4.Delete Record              *");
			Thread.sleep(500);
			System.out.println("\n\t\t\t\t\t\t*   5.Check results of student   *");
			Thread.sleep(500);
			System.out.println("\n\t\t\t\t\t\t*   6.Exit                       *");
			Thread.sleep(500);
			System.out.println("\n\t\t\t\t\t\t**********************************");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void adminLogin() {
		// creating login id and password in database for admin
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch12", "root", "");
			Statement st = con.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Admin Name : ");
			String ad = sc.next();
			System.out.println("Enter Admin password : ");
			String adp = sc.next();
			ResultSet rs = st
					.executeQuery("select * from Admin_Login where User_Name='" + ad + "' and Password='" + adp + "'");
			if (rs.next()) {
				System.out.println("\nWelcome ::: " + ad);
				// call all method under admin-
				// adminOption,studentDetalis,editStudent,displayStudent,deleteStudent,displayresult,displayresult1
				Scanner sc1 = new Scanner(System.in);
				do {
					System.out.println("\nChoose Your Option: ");

					adminOption();

					int choice1;
					choice1 = sc1.nextInt();
					switch (choice1) {
					case 1:
						System.out.println("Enter Student Details");
						studentDetalis();
						break;
					case 2:
						System.out.println("Edit Student details");
						editStudent();
						break;
					case 3:
						System.out.println("Display Student details");
						displayStudent();
						break;
					case 4:
						System.out.println("\nEnter Rollno to delete");
						deleteStudent();
						break;
					case 5:
						// check result subject wise
						Thread.sleep(400);
						System.out.println("\t\t\t\t\t\t++++++++++++++++++++++++++++++++++");
						Thread.sleep(400);
						System.out.println("\t\t\t\t\t\t+   1.Core Java                  +");
						Thread.sleep(400);
						System.out.println("\t\t\t\t\t\t+                                +");
						Thread.sleep(400);
						System.out.println("\t\t\t\t\t\t+   2.HTML                       +");
						Thread.sleep(400);
						System.out.println("\t\t\t\t\t\t++++++++++++++++++++++++++++++++++");
						int ch1;
						System.out.println("Choose subject ");

						Scanner r = new Scanner(System.in);
						ch1 = r.nextInt();
						switch (ch1) {
						case 1:
							displayresult();
							break;
						case 2:
							displayresult1();
							break;

						}

						break;
					case 6:
						System.out.println("\t\t\t\t\t\t_______________________________________________");
						System.out.println("\t\t\t\t\t\t|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|");
						System.out.println("\t\t\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("\t\t\t\t\t\t            Thanks For Login !!                ");
						System.out.println("\t\t\t\t\t\t_______________________________________________");
						System.out.println("\t\t\t\t\t\t|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|");
						System.out.println("\t\t\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.exit(0);
						break;
					default:
						System.out.println("Please Enter A Valid Option");

					}

				} while (true);

			} else {
				System.out.println("Invalid user name and password");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void studentDetalis() {
		System.out.println("***********************************");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch12", "root", "");
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");
			Scanner sc = new Scanner(System.in);
			do {
				System.out.println("Enter RollNo:");
				int rollno = sc.nextInt();
				System.out.println("E	nter name:");
				String name = sc.next();
				System.out.println("Enter contact number:");
				String phone = sc.next();
				System.out.println("Enter address:");
				String address = sc.next();
				System.out.println("Enter Subject3:");

				ps.setInt(1, rollno);
				ps.setString(2, name);
				ps.setString(3, phone);
				ps.setString(4, address);

				int i = ps.executeUpdate();
				System.out.println(i + " Record Saved");

				System.out.println("Do you want to continue: y/n");
				String s = sc.next();
				if (s.startsWith("n")) {
					break;
				}

			} while (true);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void editStudent() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch12", "root", "");
			Scanner sc = new Scanner(System.in);

			do {
				Thread.sleep(500);
				System.out.println("\t\t\t\t\t\t***********************************");
				Thread.sleep(500);
				System.out.println("\n\t\t\t\t\t\t*   1.Modify Rollno               *");
				Thread.sleep(500);
				System.out.println("\n\t\t\t\t\t\t*   2.Modify Name                 *");
				Thread.sleep(500);
				System.out.println("\n\t\t\t\t\t\t*   3.Modify Contact              *");
				Thread.sleep(500);
				System.out.println("\n\t\t\t\t\t\t*   4.Modify Address              *");
				Thread.sleep(500);
				System.out.println("\n\t\t\t\t\t\t*   5.Exit                        *");
				Thread.sleep(500);
				System.out.println("\n\t\t\t\t\t\t***********************************");

				int choice;
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					PreparedStatement ps = con.prepareStatement("update student set s_roll_no=? where s_name=?");
					System.out.println("Enter name:");
					String name = sc.next();
					System.out.println("Enter Rollno:");
					int rollno = sc.nextInt();
					ps.setInt(1, rollno);
					ps.setString(2, name);
					int i0 = ps.executeUpdate();
					System.out.println(i0 + " Record Saved");
					break;
				case 2:
					PreparedStatement ps1 = con.prepareStatement("update student set s_name=? where s_roll_no=?");
					System.out.println("Enter RollNo:");
					int rollno1 = sc.nextInt();
					System.out.println("Enter name:");
					String name1 = sc.next();
					ps1.setString(1, name1);
					ps1.setInt(2, rollno1);
					int i1 = ps1.executeUpdate();
					System.out.println(i1 + " Record Saved");
					break;
				case 3:
					PreparedStatement ps2 = con.prepareStatement("update student set s_phone=? where s_roll_no=?");
					System.out.println("Enter RollNo:");
					int rollno2 = sc.nextInt();
					System.out.println("Enter contact:");
					String phone = sc.next();
					ps2.setString(1, phone);
					ps2.setInt(2, rollno2);
					int i2 = ps2.executeUpdate();
					System.out.println(i2 + " Record Saved");
					break;
				case 4:
					PreparedStatement ps3 = con.prepareStatement("update student set s_address=? where s_roll_no=?");
					System.out.println("Enter RollNo:");
					int rollno3 = sc.nextInt();
					System.out.println("Enter Address:");
					String address = sc.next();
					ps3.setString(1, address);
					ps3.setInt(2, rollno3);
					int i3 = ps3.executeUpdate();
					System.out.println(i3 + " Record Saved");
					break;
				case 5:

					System.out.println("\t\t\t\t\t\t_______________________________________________");
					System.out.println("\t\t\t\t\t\t|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|");
					System.out.println("\t\t\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("\t\t\t\t\t\t       Thanks For updating records!!           ");
					System.out.println("\t\t\t\t\t\t_______________________________________________");
					System.out.println("\t\t\t\t\t\t|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|");
					System.out.println("\t\t\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.exit(0);

					break;
				default:
					System.out.println("Please Enter A Valid Option");

				}
				System.out.println("Do you want to continue: y/n");
				String s = sc.next();
				if (s.startsWith("n")) {
					break;
				}
			} while (true);

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void displayStudent() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch12", "root", "");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select* from student");
			Thread.sleep(400);
			System.out.println("\t\t\t\t\t\t*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
			Thread.sleep(400);
			System.out.println(
					"\n\t\t\t\t\t\t* RollNo" + "  " + "Name" + "    " + "Contact" + "     " + "Address" + " *");
			Thread.sleep(400);
			System.out.println("\n\t\t\t\t\t\t*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
			Thread.sleep(400);
			while (rs.next()) {
				Thread.sleep(400);
				System.out.println("\t\t\t\t\t\t* " + rs.getInt(1) + "       " + rs.getString(2) + "   "
						+ rs.getString(3) + "    " + rs.getString(4) + " *");
				Thread.sleep(400);
				System.out.println("\n\t\t\t\t\t\t*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleteStudent() {
		System.out.println("***********************************");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch12", "root", "");
			PreparedStatement ps = con.prepareStatement("delete from student where s_roll_no=?");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter RollNo:");
			int rollno = sc.nextInt();

			ps.setInt(1, rollno);
			int k = ps.executeUpdate();
			System.out.println(k + "update sucessfully");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void questionPaper() {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			int correctAnsCount = 0;
			int wrongAnsCount = 0;
			int wrongAnsCount1 = 0;
			int correctAnsCount1 = 0;

			// try
			System.out.println("Enter your Roll No");
			Scanner n = new Scanner(System.in);
			int rollno = n.nextInt();
			System.out.println("Roll No : " + rollno);
			System.out.println("Enter your Name");
			String name1 = n.next();
			System.out.println(" Your Name : " + name1);
			// end

			int ch;
			System.out.println("\t\t\t\t++++++++++++++++++++");
			System.out.println("\t\t\t\t+   1.Core Java    +");
			System.out.println("\t\t\t\t+                  +");
			System.out.println("\t\t\t\t+   2.HTML         +");
			System.out.println("\t\t\t\t++++++++++++++++++++");
			System.out.println("Choose your subject ");
			ch = n.nextInt();
			switch (ch) {
			case 1:
				System.out.println("\n\t\t\t\t\t\tIT Vedant");
				System.out.println("\n\t\t\t\t    Post Graduation Examination-2022 ");
				System.out.println("\n\t\t\t Subject : Core Java                    Maximum Marks : 10");
				LocalDate curdate = LocalDate.now();
				LocalTime curtime = LocalTime.now();
				System.out.println("\t\t\t Date : " + curdate + "                      " + "Time : " + curtime);
				System.out.println("\n NOTE : Each question contain two marks ");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				Thread.sleep(1500);
				Questions q1 = new Questions(" \nWhich statement is true about Java?",
						"A. Java is a sequence-dependent programming language ",
						"B. Java is a code dependent programming language ",
						"C. Java is a platform-dependent programming language ",
						"D. Java is a platform-independent programming language ");
				Questions q2 = new Questions("\nWhat is the extension of java code files?", "A. .txt", "B. .pdf",
						"C. .sql", "D. .java");
				Questions q3 = new Questions("\nWho invented Java Programming? ", "A. Guido van Rossum",
						"B. James Gosling", "C. Dennis Ritchie", "D. Bjarne Stroustrup");
				Questions q4 = new Questions("\nWhich one of the following is not a Java feature?",
						"A. Object-oriented", "B. Use of pointers", "C. Portable", "D. Dynamic and Extensible");
				Questions q5 = new Questions("\nWhich of these cannot be used for a variable name in Java?",
						"A. identifier & keyword", "B. identifier", "C. Keyword", "D. none of the mentioned");

				Map<Questions, Character> hmap = new HashMap<>();
				hmap.put(q1, 'D');
				hmap.put(q2, 'D');
				hmap.put(q3, 'B');
				hmap.put(q4, 'B');
				hmap.put(q5, 'C');

				for (Map.Entry<Questions, Character> map : hmap.entrySet()) {
					System.out.println(map.getKey().getQuestion());
					System.out.println(map.getKey().getOption1());
					System.out.println(map.getKey().getOption2());
					System.out.println(map.getKey().getOption3());
					System.out.println(map.getKey().getOption4());

					System.out.println("Enter Your Answer: ");
					Character ans = sc.next().charAt(0);

					int cans = Character.compare(ans, map.getValue());
					if (cans == 0) {
						System.out.println("\n");
						correctAnsCount++;
					} else {
						System.out.println("\n");
						wrongAnsCount++;
					}

				}
				Thread.sleep(2000);
				System.out.println();
				System.out.println("--------Result---------");
				System.out.println("Total Questions: " + hmap.size());
				System.out.println("Correct Answered Questions : " + correctAnsCount);
				System.out.println("Wrong Answered Questions : " + wrongAnsCount);

				int totalMarks = (2 * correctAnsCount);
				System.out.println("Total Marks : " + totalMarks);
				int percentage = (100 * correctAnsCount) / hmap.size();
				System.out.println("Percentage : " + percentage);
				if (percentage < 35) {
					System.out.println("fail");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+++++++++++++++++++++++++ Fail ++++++++++++++++++++++++ ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+                                                     + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+   ++++++++      +         +++++++++++   +           + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+   +            + +             +        +           + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+   +           +   +            +        +           + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+   +++++++    +     +           +        +           + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+   +         +++++++++          +        +           + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+   +        +         +         +        +           + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+   +       +           +   +++++++++++   +++++++++   + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+                                                     + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+++++++++++++++++++++++++ Fail ++++++++++++++++++++++++ ");
				} else if (percentage >= 35 && percentage < 50) {
					System.out.println("Grade  D");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade D ++++++++++++++++++++++++++++++++++++++++ ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+     ++++++ ++++++++       +         ++++++++    +++++++        +++++++           + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   +        +       +     + +        +       +   +              +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +         +       +    +   +       +       +   +              +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +          +++++++++   +     +      +       +   ++++++++       +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +   ++++   + +        +++++++++     +       +   +              +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +    +    +   +     +         +    +       +   +              +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   + + +    +    +   +           +   ++++++++    ++++++++       +++++++           + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade D ++++++++++++++++++++++++++++++++++++++++ ");
				} else if (percentage >= 50 && percentage < 60) {
					System.out.println("Grade  c");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade C ++++++++++++++++++++++++++++++++++++++++ ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+     ++++++ ++++++++       +         ++++++++    +++++++        +++++++           + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   +        +       +     + +        +       +   +              +                 + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +         +       +    +   +       +       +   +              +                 + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +          +++++++++   +     +      +       +   ++++++++       +                 + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +   ++++   + +        +++++++++     +       +   +              +                 + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +    +    +   +     +         +    +       +   +              +                 + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   + + +    +    +   +           +   ++++++++    ++++++++       +++++++           + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade C ++++++++++++++++++++++++++++++++++++++++ ");
				} else if (percentage >= 60 && percentage < 75) {
					System.out.println("Grade  B");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade B ++++++++++++++++++++++++++++++++++++++++ ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+     ++++++ ++++++++       +         ++++++++    +++++++        +++++++           + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   +        +       +     + +        +       +   +              +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +         +       +    +   +       +       +   +              +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +          +++++++++   +     +      +       +   ++++++++       +++++++           + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +   ++++   + +        +++++++++     +       +   +              +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +    +    +   +     +         +    +       +   +              +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   + + +    +    +   +           +   ++++++++    ++++++++       +++++++           + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade B ++++++++++++++++++++++++++++++++++++++++ ");
				} else if (percentage >= 75 && percentage < 90) {
					System.out.println("Grade  A");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade A ++++++++++++++++++++++++++++++++++++++++ ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+     ++++++ ++++++++       +         ++++++++    ++++++++             +           + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   +        +       +     + +        +       +   +                   + +          + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +         +       +    +   +       +       +   +                  +   +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +          +++++++++   +     +      +       +   ++++++++          +     +        + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +   ++++   + +        +++++++++     +       +   +                +++++++++       + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +    +    +   +     +         +    +       +   +               +         +      + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   + + +    +    +   +           +   ++++++++    ++++++++       +           +     + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade A ++++++++++++++++++++++++++++++++++++++++ ");
				} else {
					System.out.println("Grade A+");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade A+ +++++++++++++++++++++++++++++++++++++++ ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                            +     + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+     ++++++ ++++++++       +         ++++++++    ++++++++             +   +++++   + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   +        +       +     + +        +       +   +                   + +    +     + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +         +       +    +   +       +       +   +                  +   +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +          +++++++++   +     +      +       +   ++++++++          +     +        + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +   ++++   + +        +++++++++     +       +   +                +++++++++       + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +    +    +   +     +         +    +       +   +               +         +      + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   + + +    +    +   +           +   ++++++++    ++++++++       +           +     + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade A+ +++++++++++++++++++++++++++++++++++++++ ");
				}

				// insert result into database

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch12", "root", "");

				if (rollno != 1 && rollno != 2) {
					PreparedStatement ps = con.prepareStatement("insert into student_marks values(?,?,?,?)");
					ps.setInt(1, rollno);
					ps.setString(2, name1);

					ps.setInt(3, totalMarks);
					ps.setInt(4, percentage);

					int i = ps.executeUpdate();
					System.out.println("\n" + i + " Record Saved");
				}
				PreparedStatement ps1 = con
						.prepareStatement("update student_marks set s_marks=?,s_per=? where  s_roll_no=?");
				ps1.setInt(1, totalMarks);
				ps1.setInt(2, percentage);
				ps1.setInt(3, rollno);

				int i1 = ps1.executeUpdate();
				System.out.println("\n" + i1 + " Record Saved");
				break;

			case 2:
				System.out.println("\n\t\t\t\t\t\tIT Vedant");
				System.out.println("\n\t\t\t\t    Post Graduation Examination-2022 ");
				System.out.println("\n\t\t\t Subject : HTML                         Maximum Marks : 10");
				LocalDate curdate1 = LocalDate.now();
				LocalTime curtime1 = LocalTime.now();
				System.out.println("\t\t\t Date : " + curdate1 + "                      " + "Time : " + curtime1);
				System.out.println("\n NOTE : Each question contain two marks ");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				Thread.sleep(1500);
				Questions q6 = new Questions("\nHow many sizes of headers are available in HTML by default? ", "A. 5 ",
						"B. 1 ", "C. 3 ", "D. 6 ");
				Questions q7 = new Questions("\nWhat are the types of lists available in HTML?",
						"A. Ordered and Unordered List.", "B. Bulleted,Numbered List. ", "C. Named,Unamed List",
						"D. None of the above");
				Questions q8 = new Questions("\nHTML files are saved by default with the extension? ", "A. .html",
						"B. .h", "C. .ht", "D. .htm");
				Questions q9 = new Questions("\nHow to display preformatted text in HTML?", "A. <p>", "B. <pre>",
						"C. <hr>", "D. All of the above");
				Questions q10 = new Questions("\nWhich attribute is used to provide a unique name to an HTML element?",
						"A. class", "B. type", "C. id", "D. none of the mentioned");

				Map<Questions, Character> hmap1 = new HashMap<>();
				hmap1.put(q6, 'D');
				hmap1.put(q7, 'A');
				hmap1.put(q8, 'A');
				hmap1.put(q9, 'B');
				hmap1.put(q10, 'C');

				for (Map.Entry<Questions, Character> map : hmap1.entrySet()) {
					System.out.println(map.getKey().getQuestion());
					System.out.println(map.getKey().getOption1());
					System.out.println(map.getKey().getOption2());
					System.out.println(map.getKey().getOption3());
					System.out.println(map.getKey().getOption4());

					System.out.println("Enter Your Answer: ");
					Character ans = sc.next().charAt(0);

					int cans = Character.compare(ans, map.getValue());
					if (cans == 0) {
						System.out.println("\n");
						correctAnsCount1++;
					} else {
						System.out.println("\n");
						wrongAnsCount1++;
					}

				}
				Thread.sleep(2000);
				System.out.println();
				System.out.println("--------Result---------");
				System.out.println("Total Questions: " + hmap1.size());
				System.out.println("Correct Answered Questions : " + correctAnsCount1);
				System.out.println("Wrong Answered Questions : " + wrongAnsCount1);

				int totalMarks1 = (2 * correctAnsCount1);
				System.out.println("Total Marks : " + totalMarks1);
				int percentage1 = (100 * correctAnsCount1) / hmap1.size();
				System.out.println("Percentage : " + percentage1);
				if (percentage1 < 35) {
					System.out.println("fail");

					Thread.sleep(300);
					System.out.println("\t\t\t\t+++++++++++++++++++++++++ Fail ++++++++++++++++++++++++ ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+                                                     + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+   ++++++++      +         +++++++++++   +           + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+   +            + +             +        +           + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+   +           +   +            +        +           + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+   +++++++    +     +           +        +           + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+   +         +++++++++          +        +           + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+   +        +         +         +        +           + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+   +       +           +   +++++++++++   +++++++++   + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+                                                     + ");
					Thread.sleep(300);
					System.out.println("\t\t\t\t+++++++++++++++++++++++++ Fail ++++++++++++++++++++++++ ");
				} else if (percentage1 >= 35 && percentage1 < 50) {
					System.out.println("Grade  D");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade D ++++++++++++++++++++++++++++++++++++++++ ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+     ++++++ ++++++++       +         ++++++++    +++++++        +++++++           + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   +        +       +     + +        +       +   +              +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +         +       +    +   +       +       +   +              +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +          +++++++++   +     +      +       +   ++++++++       +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +   ++++   + +        +++++++++     +       +   +              +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +    +    +   +     +         +    +       +   +              +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   + + +    +    +   +           +   ++++++++    ++++++++       +++++++           + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade D ++++++++++++++++++++++++++++++++++++++++ ");
				} else if (percentage1 >= 50 && percentage1 < 60) {
					System.out.println("Grade  c");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade C ++++++++++++++++++++++++++++++++++++++++ ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+     ++++++ ++++++++       +         ++++++++    +++++++        +++++++           + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   +        +       +     + +        +       +   +              +                 + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +         +       +    +   +       +       +   +              +                 + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +          +++++++++   +     +      +       +   ++++++++       +                 + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +   ++++   + +        +++++++++     +       +   +              +                 + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +    +    +   +     +         +    +       +   +              +                 + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   + + +    +    +   +           +   ++++++++    ++++++++       +++++++           + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade C ++++++++++++++++++++++++++++++++++++++++ ");
				} else if (percentage1 >= 60 && percentage1 < 75) {
					System.out.println("Grade  B");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade B ++++++++++++++++++++++++++++++++++++++++ ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+     ++++++ ++++++++       +         ++++++++    +++++++        +++++++           + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   +        +       +     + +        +       +   +              +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +         +       +    +   +       +       +   +              +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +          +++++++++   +     +      +       +   ++++++++       +++++++           + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +   ++++   + +        +++++++++     +       +   +              +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +    +    +   +     +         +    +       +   +              +       +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   + + +    +    +   +           +   ++++++++    ++++++++       +++++++           + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade B ++++++++++++++++++++++++++++++++++++++++ ");
				} else if (percentage1 >= 75 && percentage1 < 90) {
					System.out.println("Grade  A");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade A ++++++++++++++++++++++++++++++++++++++++ ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+     ++++++ ++++++++       +         ++++++++    ++++++++             +           + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   +        +       +     + +        +       +   +                   + +          + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +         +       +    +   +       +       +   +                  +   +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +          +++++++++   +     +      +       +   ++++++++          +     +        + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +   ++++   + +        +++++++++     +       +   +                +++++++++       + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +    +    +   +     +         +    +       +   +               +         +      + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   + + +    +    +   +           +   ++++++++    ++++++++       +           +     + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade A ++++++++++++++++++++++++++++++++++++++++ ");
				} else {
					System.out.println("Grade A+");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade A+ +++++++++++++++++++++++++++++++++++++++ ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                            +     + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+     ++++++ ++++++++       +         ++++++++    ++++++++             +   +++++   + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   +        +       +     + +        +       +   +                   + +    +     + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +         +       +    +   +       +       +   +                  +   +         + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +          +++++++++   +     +      +       +   ++++++++          +     +        + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+ +   ++++   + +        +++++++++     +       +   +                +++++++++       + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+  +    +    +   +     +         +    +       +   +               +         +      + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+   + + +    +    +   +           +   ++++++++    ++++++++       +           +     + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+                                                                                  + ");
					Thread.sleep(300);
					System.out.println(
							"\t\t\t\t+++++++++++++++++++++++++++++++++++ Grade A+ +++++++++++++++++++++++++++++++++++++++ ");
				}

				// insert result into database

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch12", "root", "");

				if (rollno != 1 && rollno != 2) {
					PreparedStatement ps2 = con1.prepareStatement("insert into student_marks1 values(?,?,?,?)");
					ps2.setInt(1, rollno);
					ps2.setString(2, name1);

					ps2.setInt(3, totalMarks1);
					ps2.setInt(4, percentage1);

					int i2 = ps2.executeUpdate();
					System.out.println("\n" + i2 + " Record Saved");
				}
				PreparedStatement ps3 = con1
						.prepareStatement("update student_marks1 set s_marks=?,s_per=? where  s_roll_no=?");
				ps3.setInt(1, totalMarks1);
				ps3.setInt(2, percentage1);
				ps3.setInt(3, rollno);

				int i3 = ps3.executeUpdate();
				System.out.println("\n" + i3 + " Record Saved");
				break;

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void studentLogin() {
		// creating login id and password in the database
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch12", "root", "");
			Statement st = con.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Student Name : ");
			String sl = sc.next();
			System.out.println("Enter the Student password : ");
			String sp = sc.next();
			ResultSet rs = st
					.executeQuery("select * from student_Login where User_Name='" + sl + "' and Password='" + sp + "'");
			if (rs.next()) {

				System.out.println("\nWelcome::: " + sl);

				System.out.println("\nDo you want give the test: y/n");
				String s = sc.next();
				if (s.startsWith("y")) {

					questionPaper();
				}
				if (s.startsWith("n")) {
					System.exit(0);

				}

			}

			else {
				System.out.println("Invalid user name and password");
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void displayresult() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch12", "root", "");
			Statement st2 = con2.createStatement();
			ResultSet rs2 = st2.executeQuery("select* from student_marks");
			Thread.sleep(400);
			System.out.println("\t\t\t\t\t\t*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
			Thread.sleep(400);
			System.out.println("\n\t\t\t\t\t\t* RollNo" + " " + " Name" + " " + " Marks" + " " + " Percentage" + " *");
			Thread.sleep(400);
			System.out.println("\n\t\t\t\t\t\t*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
			Thread.sleep(400);
			while (rs2.next()) {
				Thread.sleep(400);
				System.out.println("\n\t\t\t\t\t\t* " + rs2.getInt(1) + "       " + rs2.getString(2) + "    "
						+ rs2.getInt(3) + "       " + rs2.getInt(4) + "     *");
				Thread.sleep(400);
				System.out.println("\n\t\t\t\t\t\t*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void displayresult1() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch12", "root", "");
			Statement st2 = con2.createStatement();
			ResultSet rs2 = st2.executeQuery("select* from student_marks1");
			Thread.sleep(400);
			System.out.println("\t\t\t\t\t\t*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
			Thread.sleep(400);
			System.out.println("\n\t\t\t\t\t\t* RollNo" + " " + " Name" + " " + " Marks" + " " + " Percentage" + " *");
			Thread.sleep(400);
			System.out.println("\n\t\t\t\t\t\t*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
			Thread.sleep(400);
			while (rs2.next()) {
				Thread.sleep(400);
				System.out.println("\n\t\t\t\t\t\t* " + rs2.getInt(1) + "       " + rs2.getString(2) + "    "
						+ rs2.getInt(3) + "       " + rs2.getInt(4) + "     *");
				Thread.sleep(400);
				System.out.println("\n\t\t\t\t\t\t*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
