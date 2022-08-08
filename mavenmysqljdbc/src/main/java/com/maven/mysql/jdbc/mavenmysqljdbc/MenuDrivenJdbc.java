package com.maven.mysql.jdbc.mavenmysqljdbc;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Scanner;

public class MenuDrivenJdbc {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/dbsecond", "root", "root");
		Statement stmt = conn.createStatement();

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("(1) Add details");
			System.out.println("(2) Display Student details");
			System.out.println("(3) Update the Student details");
			System.out.println("(4) Delete the Student details");
			System.out.println("(5) Exit");
			System.out.println("Enter the choice : ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				Scanner sc1 = new Scanner(System.in);

				// Entering the values to Student table
				System.out.println("Enter the ID");
				int ID = sc1.nextInt();
				System.out.println("Enter the Name");
				String Name = sc1.next();
				System.out.println("Enter the City");
				String City = sc1.next();
				String sql;
				sql = "INSERT INTO Student(ID,Name,City) VALUES(?,?,?)";

				PreparedStatement preparedStatement = conn.prepareStatement(sql);

				// Setting the parameters
				preparedStatement.setInt(1, ID);
				preparedStatement.setString(2, Name);
				preparedStatement.setString(3, City);

				preparedStatement.executeUpdate();
				preparedStatement.close();
				break;
			case 2:
				PreparedStatement preparedStatement1 = conn.prepareStatement("select * from Student");
				ResultSet rs = stmt.executeQuery("select * from Student");
				while (rs.next()) {
					// Display values
					System.out.println("Student ID: " + rs.getInt("ID"));
					System.out.println("Student Name: " + rs.getString("Name"));
					System.out.println("Student City: " + rs.getString("City"));
					System.out.println(" ");
				}
				break;
			case 3:
				String sqlUpdate = "UPDATE Student set Name =? where ID=?";
				PreparedStatement preparedStatement2 = conn.prepareStatement(sqlUpdate);
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Enter ID ");
				int id = sc2.nextInt();
				System.out.println("Enter Name ");
				String name = sc2.next();

				preparedStatement2.setInt(2, id);
				preparedStatement2.setString(1, name);
				preparedStatement2.executeUpdate();
				System.out.println("Updation done : " + id);
				break;
			case 4:
				String sqlDelete = "DELETE FROM Student WHERE ID=? ";
				PreparedStatement preparedStatement3 = conn.prepareStatement(sqlDelete);
				Scanner sc3 = new Scanner(System.in);
				System.out.println("Enter ID ");
				int sid = sc3.nextInt();

				preparedStatement3.setInt(1, sid);
				preparedStatement3.executeUpdate();
				System.out.println("Deletion done : " + sid);
				break;

			case 5:
				System.exit(0);
			}
		}

	}

}
