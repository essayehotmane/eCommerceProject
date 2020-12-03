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
import com.ecom.dao.ProductDao;
import com.ecom.models.Product;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet(name = "updateProduct", urlPatterns = { "/updateProduct" })
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ProductDao pd = new ProductDao(Database_connection.GetConnection());
		Product p=pd.getProductById(id) ;
		request.setAttribute("product", p);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/content/updateProduct.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product p = new Product();
		p.setId(Integer.parseInt( request.getParameter("Pid")));
        p.setName(request.getParameter("Pname"));
        p.setPrice(Float.parseFloat(request.getParameter("Pprice")));
        p.setQuantity(Integer.parseInt(request.getParameter("Pquantity")));
        p.setCategory_id(Integer.parseInt(request.getParameter("Pcategory_id")));
        ProductDao pd = new ProductDao(Database_connection.GetConnection());
        if(pd.editProduct(p)) {
        	System.out.println("chi haja nchoufoha mrigla");
        	response.sendRedirect("/ecommerce-jee/Products");
        }
        else {
        	System.out.println("chi haja nchoufoha");
        }
	}

}
