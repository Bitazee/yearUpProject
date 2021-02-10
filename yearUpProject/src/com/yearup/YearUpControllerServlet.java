package com.yearup;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class YearUpControllerServlet
 */
@WebServlet("/YearUpControllerServlet/*")
public class YearUpControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private StudentDAO studentDAO;

    /**
     * Default constructor. 
     */
    public YearUpControllerServlet() {
    	super();
    	studentDAO = new StudentDAO();
    	studentDAO.connect();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		if(action.equals("/new")) {
			System.out.println("NEW STUDENT ENTRY");
			addStudent(request,response);
		}
		else {
			System.out.println("LIST OF STUDENTS");
			listStudent(request, response);
		}

	}
	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/StudentForm.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		ArrayList<Student> studentList = studentDAO.listAllStudents();
		request.setAttribute("student_list", studentList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/StudentList.jsp");

		dispatcher.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		 if(action.equals("/insert")){
			 System.out.println("INSERTING STUDENT POST METHOD");
			insertStudent(request,response);
		}
	}
	// insert student method
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) {
		String studentName = request.getParameter("studentname");
		String studentCohort = request.getParameter("studentcohort");
		String studentTrack = request.getParameter("studenttrack");
		String studentInternship = request.getParameter("studentinternship");
		String converted = request.getParameter("converted");
		String studentEmail = request.getParameter("");
		
		Student newStudent = new Student(studentName, studentCohort, studentTrack,studentInternship,converted,studentInternship);
		
		studentDAO.insertStudent(newStudent);
			
	}
	

}
