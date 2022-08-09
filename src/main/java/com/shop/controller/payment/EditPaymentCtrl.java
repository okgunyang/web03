package com.shop.controller.payment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.PaymentVO;
import com.shop.model.BasketDAO;
import com.shop.model.GoodsDAO;
import com.shop.model.PaymentDAO;

@WebServlet("/EditPaymentCtrl")
public class EditPaymentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditPaymentCtrl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("sid");
		
		int ono = Integer.parseInt(request.getParameter("ono")); //상품번호(O)
		String paytype = request.getParameter("paytype"); //결제방식(O)
		String payplace = request.getParameter("payplace"); //결제기관
		String payno = request.getParameter("payno");	//결제카드 및 계좌번호
		int gno = Integer.parseInt(request.getParameter("gno")); //상품번호(O)
		int amount = Integer.parseInt(request.getParameter("amount")); //주문수량(O)
		int money = Integer.parseInt(request.getParameter("money"));//결제금액(O)
		String rname = request.getParameter("rname"); //수신자 이름(O)
		String tel = request.getParameter("tel"); //수신자 연락처(O)
		String addr1 = request.getParameter("addr1");  //기본주소(O)
		String addr2 = request.getParameter("addr2");	//상세주소(O)
		String postcode = request.getParameter("postcode"); //우편번호(O)
		String memo = request.getParameter("memo"); //남기는 말(O)
		String transno = request.getParameter("transno");
		String transco = request.getParameter("transco");
		String rstatus = request.getParameter("rstatus");
		String rdate = request.getParameter("rdate");
		String userid = request.getParameter("userid");
		
		PaymentVO vo = new PaymentVO();
		vo.setOno(ono);
		vo.setUserid(userid);
		vo.setPaytype(paytype);
		vo.setPayno(payno);
		vo.setGno(gno);
		vo.setAmount(amount);
		vo.setTel(tel);
		vo.setMoney(money);
		vo.setRname(rname);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		vo.setPostcode(postcode);
		vo.setMemo(memo);
		vo.setTransno(transno);
		vo.setTransco(transco);
		vo.setRdate(rdate);
		vo.setRstatus(rstatus);
		
		int cnt = 0;
		PaymentDAO dao = new PaymentDAO();
		if(sid.equals("admin")) {
			cnt = dao.shippingAssign(vo);
			if(cnt>0) {
				response.sendRedirect("GetPaymentListCtrl");
			} else {
				response.sendRedirect("GetPaymentCtrl?ono="+ono);
			}
		}
		if(!sid.equals("admin")) {
			cnt = dao.editPayment(vo);
			if(cnt>0) {
				response.sendRedirect("myPageCtrl");
			} else {
				response.sendRedirect("EditShippingCtrl?ono="+ono);
			}
		}		
	}
}