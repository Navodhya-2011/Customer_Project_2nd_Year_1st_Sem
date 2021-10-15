package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//assign user entered values to the variables
		String ID = request.getParameter("cusid");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone  = request.getParameter("phone");
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		boolean isTrue;
		
		isTrue = CustomerDBUtil.updatecustomer(ID, name, email, phone, username, password);
		//call updatecustomer method and assign boolean value to the variable
		if(isTrue == true) {//if update is successful
			
			List<customer> cusDetails = CustomerDBUtil.gecustomerDetails(ID);//create an arraylist get data calling getcustomer details method
			request.setAttribute("cusDetails", cusDetails); //create attribute assigning object
			
			RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");//redirect to the useraccount.jsp page
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");//redirect to the unsuccess.jsp page
			dis.forward(request, response);
		}
	}

}
