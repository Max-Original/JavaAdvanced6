package hw.domain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.el.ELException;

public class RegistrationServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
//	private UserService userService = UserService.getUserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse responce) throws IOException {
		responce.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(firstName.length()<1 || lastName.length() <1 || email.length() <5 || password.length()<6 ) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			throw new ServletException("not valid");
		}
		
	//	userService.saveUser(new UserAccount(firstName,lastName,email,password));
		request.setAttribute("userEmail", email);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
