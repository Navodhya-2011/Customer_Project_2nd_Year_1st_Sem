package com.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerInsert
 */
@WebServlet("/CustomerInsert")
public class CustomerInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get user entered values to variables
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String username = request.getParameter("uid");
		String password = request.getParameter("psw"); 
		
		boolean isTrue;
		
		isTrue = CustomerDBUtil.Insertcustomer(name, email, phone, username, password);
		//call insertCustomer method and return value
		if(isTrue == true) {//if data insertion is successful
			
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");//redirect to the login.jsp
			dis.forward(request, response);
		} else {//if data insertion unsuccessful
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");//redirect to the unsuccess.jsp
			dis2.forward(request, response);
		}
	}

}
