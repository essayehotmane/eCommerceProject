package com.ecom.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecom.bdd.Database_connection;
import com.ecom.dao.ProductDao;
import com.ecom.models.Product;

/**
 * Servlet implementation class HomeDetailsProduct
 */
@WebServlet(name = "detailsPage", urlPatterns = { "/detailsPage" })
public class HomeDetailsProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeDetailsProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idstring = request.getParameter("id");
		if(idstring==null) {
			
			HttpSession session=request.getSession();
			Product p=(Product)session.getAttribute("product");
			System.out.println("product: "+p);
			request.setAttribute("productt", p);
		}
		else {
		int id = Integer.parseInt(idstring);
		ProductDao pd = new ProductDao(Database_connection.GetConnection());
		Product product = pd.getProductById(id);
		request.setAttribute("product", product);
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shopPages/productDetail.jsp");
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
