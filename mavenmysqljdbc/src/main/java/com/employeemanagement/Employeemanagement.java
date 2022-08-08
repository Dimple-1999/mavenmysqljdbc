package com.employeemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employeemanagement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = null;
		con = DriverManager.getConnection("jdbc:mysql://localhost/employeedatabase", "root", "root");
		Statement statement = con.createStatement();

		// scanner class
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println(" ");
			System.out.println("(1) Add Employee details");
			System.out.println("(2) Display the Employee details");
			System.out.println("(3) Update the Employee details");
			System.out.println("(4) Delete the Employee details");
			System.out.println("(5) Exit");
			System.out.println("Enter the choice : ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				//Adding Employee details
				Scanner scanner1 = new Scanner(System.in);

				// Entering the values to Employee table
				System.out.println("Enter the EMPID");
				int EMPID = scanner1.nextInt();
				System.out.println("Enter the FIRSTNAME");
				String FIRSTNAME = scanner1.next();
				System.out.println("Enter the LASTNAME");
				String LASTNAME = scanner1.next();
				System.out.println("Enter the DEPARTMENT");
				String DEPARTMENT = scanner1.next();
				System.out.println("Enter the SALARY");
				int SALARY = scanner1.nextInt();
				String sql;
				sql = "INSERT INTO Employee(EMPID,FIRSTNAME,LASTNAME,DEPARTMENT,SALARY) VALUES(?,?,?,?,?)";

				PreparedStatement preparedStatement1 = con.prepareStatement(sql);

				// Setting the parameters
				preparedStatement1.setInt(1, EMPID);
				preparedStatement1.setString(2, FIRSTNAME);
				preparedStatement1.setString(3, LASTNAME);
				preparedStatement1.setString(4, DEPARTMENT);
				preparedStatement1.setInt(5, SALARY);

				preparedStatement1.executeUpdate();
				preparedStatement1.close();
				break;
			case 2:
				//Displaying the Employee details
				PreparedStatement preparedStatement2 = con.prepareStatement("select * from Employee");
				ResultSet rs = statement.executeQuery("select * from Employee");
				while (rs.next()) {
					// Display values
					System.out.println("EMPID      : " + rs.getInt("EMPID"));
					System.out.println("FIRSTNAME  : " + rs.getString("FIRSTNAME"));
					System.out.println("LASTNAME   : " + rs.getString("LASTNAME"));
					System.out.println("DEPARTMENT : " + rs.getString("DEPARTMENT"));
					System.out.println("SALARY     : " + rs.getString("SALARY"));
					System.out.println(" ");
				}
				break;
			case 3:
				//Updation
				String sqlUpdate = "UPDATE Employee set DEPARTMENT =? where EMPID=?";
				PreparedStatement preparedStatement3 = con.prepareStatement(sqlUpdate);
				Scanner scanner3 = new Scanner(System.in);

				System.out.println("Enter EMPID ");
				int empid = scanner3.nextInt();
				System.out.println("Enter DEPARTMENT ");
				String department = scanner3.next();

				preparedStatement3.setInt(2, empid);
				preparedStatement3.setString(1, department);

				preparedStatement3.executeUpdate();
				System.out.println("Updation done : " + empid);
				break;
			case 4:
				//Deletion
				String sqlDelete = "DELETE FROM Employee WHERE EMPID=? ";
				PreparedStatement preparedStatement4 = con.prepareStatement(sqlDelete);
				Scanner scanner4 = new Scanner(System.in);
				System.out.println("Enter EMPID ");
				int empid1 = scanner4.nextInt();

				preparedStatement4.setInt(1, empid1);
				preparedStatement4.executeUpdate();
				System.out.println("Deletion done : " + empid1);
				break;
				case 5:
				//Exit
				System.exit(0);
                break;
			}

		}
	}

}
