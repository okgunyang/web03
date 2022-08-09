package com.shop.controller.payment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.PaymentVO;
import com.shop.model.PaymentDAO;

@WebServlet("/EditShippingCtrl")
public class EditShippingCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditShippingCtrl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int ono = Integer.parseInt(request.getParameter("ono"));
		
		PaymentDAO dao = new PaymentDAO();
		PaymentVO payment = dao.getPayment(ono);
		if(payment != null) {
			request.setAttribute("payment", payment);
			RequestDispatcher view = request.getRequestDispatcher("./payment/editShipping.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("myPageCtrl");
		}
	}
}