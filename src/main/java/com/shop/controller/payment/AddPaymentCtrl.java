package com.shop.controller.payment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
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

@WebServlet("/AddPaymentCtrl")
public class AddPaymentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServletContext application = null;   
    public AddPaymentCtrl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("sid"); //결제 회원아이디(O)
		String paytype = request.getParameter("paytype"); //결제방식(O)
		String payplace = request.getParameter("payplace"); //결제기관
		String payno = request.getParameter("payno");	//결제카드 및 계좌번호
		payno = payplace + " : " + payno;  //결제수단번호 -> 결제기관 : 카드번호(O)
		int gno = Integer.parseInt(request.getParameter("gno")); //상품번호(O)
		int bno = 0;
		if(request.getParameter("bno")!=null) {
			bno = Integer.parseInt(request.getParameter("bno")); //장바구니 번호
		}
		
		String gname = request.getParameter("gname");  //상품명
		int gprice = Integer.parseInt(request.getParameter("gprice")); //단가
		int amount = Integer.parseInt(request.getParameter("amount")); //주문수량(O)
		int money = gprice * amount;		//결제금액 -> 단가 * 수량 (O)
		String rname = request.getParameter("rname"); //수신자 이름(O)
		String tel = request.getParameter("tel"); //수신자 연락처(O)
		String addr1 = request.getParameter("addr1");  //기본주소(O)
		String addr2 = request.getParameter("addr2");	//상세주소(O)
		String postcode = request.getParameter("postcode"); //우편번호(O)
		String memo = request.getParameter("memo"); //남기는 말(O)
		
		PaymentVO vo = new PaymentVO();
		vo.setUserid(userid);
		vo.setPaytype(paytype);
		vo.setPayno(payno);
		vo.setGno(gno);
		vo.setAmount(amount);
		vo.setMoney(money);
		vo.setRname(rname);
		vo.setTel(tel);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		vo.setPostcode(postcode);
		vo.setMemo(memo);
		
		PaymentDAO dao = new PaymentDAO();
		int cnt = dao.addPayment(vo, bno);
		PrintWriter out = response.getWriter();
		GoodsDAO gds = new GoodsDAO();
		BasketDAO bas = new BasketDAO();
		int num = 0;
		int quan = 0;
		int resCnt = 0;
		int basCnt = 0;
		if(cnt>0) {
			response.sendRedirect("index.jsp");
			num = gds.countGoods(gno);
			quan = num - amount;	//남은 수량
//해당 상품의 레코드의 수량을 변경 또는 삭제			
//			if(quan==0) {
//				resCnt = gds.delGoods(gno);
//				application.setAttribute("goodsmsg", "제품정보삭제");
//				System.out.println("제품정보삭제");
//			} else {
//				resCnt = gds.editGoods(gno, quan);
//				application.setAttribute("goodsmsg", "제품정보갱신");
//				System.out.println("제품정보갱신");
//			}
			
			resCnt = gds.editGoods(gno, quan);
			
			if(resCnt>0) {
				System.out.println("제품정보갱신");
			} else {
				System.out.println("제품정보변경 실패");
			}
			if(bno!=0) {
				basCnt = bas.delBasket(bno);
				if(basCnt>0) {
					System.out.println("장바구니 삭제 성공");
				} else {
					System.out.println("장바구니 삭제 실패");
				}
			}
		} else {
			//out.println("<script>history.back();</script>");
		}
	}
}