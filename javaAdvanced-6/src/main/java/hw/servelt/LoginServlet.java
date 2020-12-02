package hw.servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw.domain.UserAccount;
import hw.service.UserAccountService;
import hw.service.impl.UserAccountServiceImpl;

public class LoginServlet extends HttpServlet{

	 
	private static final long serialVersionUID = 1L;
	private UserAccountService userService = UserAccountServiceImpl.getUserAccountService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("login");
		String password = request.getParameter("password");

		UserAccount user = userService.getUserAccountByEmail(email);
	
		if (user != null && user.getPassword().equals(password)) {
			request.setAttribute("userEmail", email);
			request.getRequestDispatcher("welcomeToTheCabinet.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
		
	}


