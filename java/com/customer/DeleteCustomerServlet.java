package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ID = request.getParameter("cusid");//get user entered value
		boolean isTrue;
		
		isTrue = CustomerDBUtil.deletecustomer(ID);//call deleteCustomer method
		
		if (isTrue == true) {//if record deleted successfully
			RequestDispatcher dispatcher = request.getRequestDispatcher("customerinsert.jsp");//redirect to the customerinsert
			dispatcher.forward(request, response);
		}
		else {//if record not delete
			
			List<customer> cusDetails = CustomerDBUtil.gecustomerDetails(ID);//call getEmployee method and assign customer values to the arraylist
			request.setAttribute("cusDetails", cusDetails);//create attribute using cusDetails arraylist object 
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("useraccount.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
