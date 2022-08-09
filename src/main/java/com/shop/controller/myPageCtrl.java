package com.shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.PaymentVO;
import com.shop.model.PaymentDAO;

@WebServlet("/myPageCtrl")
public class myPageCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public myPageCtrl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("sid");
		PaymentDAO dao = new PaymentDAO();
		ArrayList<PaymentVO> payList = dao.getPaymentList(userid);
		if(payList != null) {
			request.setAttribute("payList", payList);
			RequestDispatcher view = request.getRequestDispatcher("./member/myPage.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}
}