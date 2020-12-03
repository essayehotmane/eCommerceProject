package com.ecom.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecom.bdd.Database_connection;
import com.ecom.dao.UserDao;
import com.ecom.models.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher( "/authentification/register.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("uName");
		String email=request.getParameter("uEmail");
		String pass=request.getParameter("uPass");
		String address=request.getParameter("uaddress");
		int tel=Integer.parseInt(request.getParameter("utel"));
		
		User u=new User();
		u.setName(name);
		u.setEmail(email);
		u.setPassword(pass);
		u.setAddress(address);
		u.setTel(tel);
		u.setRole_id(1);
		
		UserDao ud=new UserDao(Database_connection.GetConnection());
		boolean r=ud.userRegister(u);
		if(r==true) {
			response.sendRedirect(request.getContextPath() +"/login");
		}
		else {
			PrintWriter p=response.getWriter();
			p.print("user failed to add");
		}
	}

}
