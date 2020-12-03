package com.ecom.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecom.bdd.Database_connection;
import com.ecom.dao.CategoryDao;
import com.ecom.models.Category;


/**
 * Servlet implementation class addCategoryServlet
 */
@WebServlet("/addCategory")
public class addCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/content/addCategory.jsp");
	        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category c = new Category();
		c.setName(request.getParameter("Cname"));
		CategoryDao cd=new CategoryDao(Database_connection.GetConnection());
		if(cd.categoryAdd(c)==true) {
			response.sendRedirect("/ecommerce-jee/Categories");
		}
    
	}

}
