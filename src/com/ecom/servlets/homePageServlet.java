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
import com.ecom.dao.ProductDao;
import com.ecom.models.Category;
import com.ecom.models.Product;

/**
 * Servlet implementation class homePageServlet
 */
@WebServlet("/homePage")
public class homePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		ProductDao pd = new ProductDao(Database_connection.GetConnection());
		CategoryDao cd = new CategoryDao(Database_connection.GetConnection());
		List<Product> productList = pd.getAllProducts();
		List<Category> categoryList = cd.getAllCategories();
		request.setAttribute("products", productList);
		request.setAttribute("categories", categoryList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shopPages/homePage.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
