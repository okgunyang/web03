package com.shop.controller.payment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.PaymentDAO;

@WebServlet("/DelPaymentCtrl")
public class DelPaymentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DelPaymentCtrl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int ono = Integer.parseInt(request.getParameter("ono"));
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("sid");
		
		PaymentDAO dao = new PaymentDAO();
		int cnt = dao.delPayment(ono);
		if(sid.equals("admin")) {
			if(cnt>0) {
				response.sendRedirect("GetPaymentListCtrl");
			} else {
				response.sendRedirect("GetPaymentCtrl?ono="+ono);
			}
		} else {
			if(cnt>0) {
				response.sendRedirect("myPageCtrl");
			} else {
				response.sendRedirect("EditShippingCtrl?ono="+ono);
			}
		}
	}
}