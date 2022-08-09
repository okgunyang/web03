package com.shop.controller.payment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.GoodsVO;
import com.shop.model.PaymentDAO;

@WebServlet("/SailFormCtrl")
public class SailFormCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SailFormCtrl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int gno = Integer.parseInt(request.getParameter("gno"));
		int bno = 0;
		if(request.getParameter("bno")!=null) bno = Integer.parseInt(request.getParameter("bno"));
//		String gcolor = request.getParameter("gcolor");
//		String gsize = request.getParameter("gsize");
		
		PaymentDAO dao = new PaymentDAO();
		GoodsVO goods = dao.callByPay(gno);
		if(goods != null) {
			request.setAttribute("goods", goods);
			if(bno!=0) request.setAttribute("bno", bno);
			RequestDispatcher view = request.getRequestDispatcher("./payment/saleForm.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetGoodsListCtrl");
		}
	}
}