package com.yearup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.yearup.Student;

public class StudentDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/?user=root";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	
	private Connection jdbcConnection;
	
	public void connect() {
		
		try {
			if(jdbcConnection == null || jdbcConnection.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				useDatabase();
				System.out.println("Connection Successful");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void disconnect() {
		try {
			if(jdbcConnection != null && !jdbcConnection.isClosed())
			jdbcConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void useDatabase() {
		try {
			String sqlStatement = "USE students";
			Statement statment = jdbcConnection.createStatement();
			statment.executeUpdate(sqlStatement);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Student> listAllStudents(){
		ArrayList<Student> studentList = new ArrayList<>();
		
		try {
			Statement statement = jdbcConnection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
			while(resultSet.next()) {
				String name = resultSet.getString("studentName");
				String cohort = resultSet.getString("studentCohort");
				String track = resultSet.getString("studentTrack");
				String internship = resultSet.getString("studentInternShip");
				String converted = resultSet.getString("converted");
				String email = resultSet.getString("studentEmail");
				
				
				Student student = new Student(name,cohort,track,internship,converted,email);
				studentList.add(student);
				
				
				statement.close();
				resultSet.close();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return studentList;
	
	}
	
	public void insertStudent(Student newStudent) {
		// TODO Auto-generated method stub
		
	}

}
