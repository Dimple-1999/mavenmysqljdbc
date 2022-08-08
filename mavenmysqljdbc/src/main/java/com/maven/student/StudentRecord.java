package com.maven.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StudentRecord {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<Student> l = new ArrayList<Student>();
		l.add(new Student(1, "Mahi", "MBA", "Hyderabad"));
		l.add(new Student(2, "Vinay", "MBA", "Jagityal"));
		l.add(new Student(3, "Arun", "MCA", "Jagityal"));
		l.add(new Student(4, "Akhil", "MSC", "Karimnagar"));
		l.add(new Student(5, "Srinu", "MSC", "Warangal"));
		String sql;
		sql = "INSERT INTO Student(sId,sName,sGroup,sCity) values(?,?,?,?)";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/dbthird", "root", "root");
		Statement stmt = conn.createStatement();
		System.out.println("Database is connected");
		PreparedStatement preStatement = conn.prepareStatement(sql);
		conn.setAutoCommit(false);
		for (Iterator<Student> iterator = l.iterator(); iterator.hasNext();) {
			Student s = (Student) iterator.next();
			preStatement.setInt(1, s.getsId());
			preStatement.setString(2, s.getsName());
			preStatement.setString(3, s.getsGroup());
			preStatement.setString(4, s.getsCity());
			preStatement.addBatch();
		}
		int[] updateCounts = preStatement.executeBatch();
		System.out.println(Arrays.toString(updateCounts));
		conn.commit();
		conn.setAutoCommit(true);
		preStatement.close();
	}

}
