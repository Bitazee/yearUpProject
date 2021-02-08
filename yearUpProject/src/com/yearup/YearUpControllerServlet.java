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
@WebServlet("/YearUpControllerServlet")
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
			System.out.println("NEW BOOKS");
			addStudent(request,response);
		}
		else {
			System.out.println("LIST OF BOOKS");
			listStudent(request, response);
		}

	}
	private void addStudent(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		 if(action.equals("/insert")){
			 System.out.println("INSERTING BOOKS POST METHOD");
			insertStudent(request,response);
		}
	}
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) {
		String studentName = request.getParameter("booktitle");
		String studentCohort = request.getParameter("bookauthor");
		String studentTrack = request.getParameter("bookprice");
		String studentInternship = request.getParameter("");
		boolean converted = false;
		String studentEmail = request.getParameter("");
		
		Student newStudent = new Student(studentName, studentCohort, studentTrack,studentInternship,converted,studentInternship);
		
		studentDAO.insertStudent(newStudent);
			
	}
	

}
