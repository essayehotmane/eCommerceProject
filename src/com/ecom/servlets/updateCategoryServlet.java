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
 * Servlet implementation class updateCategoryServlet
 */
@WebServlet("/updateCategory")
public class updateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CategoryDao cd = new CategoryDao(Database_connection.GetConnection());
		Category c=cd.getCategoryById(id) ;
		   request.setAttribute("category", c);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/content/updateCategory.jsp");
		    requestDispatcher.forward(request, response);
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category c = new Category();
		c.setId(Integer.parseInt( request.getParameter("Cid")));
        c.setName(request.getParameter("Cname"));
    	CategoryDao cd = new CategoryDao(Database_connection.GetConnection());
        if(cd.editCategory(c)) {
        	System.out.println("chi haja nchoufoha mrigla");
        	response.sendRedirect("/ecommerce-jee/Categories");
        }
        else {
        	System.out.println("chi haja nchoufoha");
        }
        
        
        
		
		
	}

}
