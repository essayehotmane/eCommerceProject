package com.ecom.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecom.bdd.Database_connection;
import com.ecom.dao.UserDao;
import com.ecom.models.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect("/authentification/login.jsp");
		this.getServletContext().getRequestDispatcher( "/authentification/login.jsp" ).forward( request, response );
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("uEmail");
		String pass=request.getParameter("uPass");
		UserDao ud=new UserDao(Database_connection.GetConnection());
		User u=ud.userSignIn(email, pass);
		//System.out.println(u.toString());
		if(u != null) {
			HttpSession session=request.getSession();
			session.setAttribute("user", u);
			response.sendRedirect("admin/adminHomePage.jsp");
		}
		else {
			request.setAttribute("error", "Email or password incorrecte!");
			this.getServletContext().getRequestDispatcher( "/authentification/login.jsp" ).forward( request, response );
//			PrintWriter pw=response.getWriter();
//			pw.print("not logged");
		}
	}
	

}
