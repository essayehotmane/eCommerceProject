package com.ecom.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecom.bdd.Database_connection;
import com.ecom.dao.BuyDao;
import com.ecom.dao.ProductDao;
import com.ecom.models.Buy;
import com.ecom.models.Product;
import com.ecom.models.User;


/**
 * Servlet implementation class orderOrSigninServlet
 */
@WebServlet(name = "order", urlPatterns = { "/order" })
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s1=request.getSession();
		HttpSession s2=request.getSession();
		
		int pID = Integer.parseInt(request.getParameter("id"));
		int pQuantity = Integer.parseInt(request.getParameter("quantity"));
		
		if (s1.getAttribute("user") == null) {
			ProductDao pd=new ProductDao(Database_connection.GetConnection());
			s2.setAttribute("product",pd. getProductById(pID));
			
			Product p = pd.getProductById(pID);
			System.out.println("id "+pID);
			
			//test cockies:
			Cookie pName=new Cookie("productName", p.getName());//creating cookie object 
			Cookie pPrice=new Cookie("productPrice", String.valueOf(p.getPrice()));
			response.addCookie(pName);//adding cookie in the response 
			response.addCookie(pPrice);//adding cookie in the response 
			
			
			response.sendRedirect("/ecommerce-jee/login");
		} else {
			
			BuyDao od=new BuyDao(Database_connection.GetConnection());
			User user = (User)s1.getAttribute("user");
			Buy o = new Buy(pQuantity, pQuantity, user.getId(), pID);
			
			if(od.orderAdd(o) ==true ) {
				System.out.println("order ok");
			}
			
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shopPages/orderProduct.jsp");
			requestDispatcher.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		int pID = Integer.parseInt(request.getParameter("id"));
//		ProductDao pd=new ProductDao(Database_connection.GetConnection());
//		Product p = pd.getProductById(pID);
//		System.out.println("post product: "+p.getName());
	}

}
