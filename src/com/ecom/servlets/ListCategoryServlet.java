package com.ecom.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/Categories")
public class ListCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		CategoryDao cd = new CategoryDao(Database_connection.GetConnection());
		
        List<Category> categoryList = cd.getAllCategories();
        request.setAttribute("categories", categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/content/listCategories.jsp");
        requestDispatcher.forward(request, response);
      
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
