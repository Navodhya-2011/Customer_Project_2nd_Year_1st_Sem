package com.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServrlet
 */
@WebServlet("/LoginServrlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isTrue;
		
		isTrue = CustomerDBUtil.validate(userName, password);//call validate and get the boolean method
		
		if (isTrue == true) {//if validation is successful
			
			HttpSession session = request.getSession();//create http session object
			session.setAttribute("username", userName);//create new session assigning username value
			
			List<customer> cusDetails = CustomerDBUtil.getcustomer(userName);//create an arraylist and get all the values calling getCustomer method
			request.setAttribute("cusDetails", cusDetails);//create attribute assigning object
			
			RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");//redirect to the useraccount.jsp
			dis.forward(request, response);
		} else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='login.jsp'");
			out.println("</script>");
		}
		
	}

}
