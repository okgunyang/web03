package com.shop.controller.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.GoodsDAO;

@WebServlet("/DelGoodsCtrl")
public class DelGoodsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DelGoodsCtrl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int gno = Integer.parseInt(request.getParameter("gno"));
		GoodsDAO dao = new GoodsDAO();
		int cnt = dao.delGoods(gno);
		if(cnt>0) {  //제품 삭제 성공
			response.sendRedirect("GetGoodsListCtrl");
		} else {  //제품 삭제 실패
			response.sendRedirect("GetGoodsCtrl?gno="+gno);
		}	
	}
}
