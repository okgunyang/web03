package com.shop.controller.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.shop.common.GoodsVO;
import com.shop.model.GoodsDAO;

@WebServlet("/AddGoodsCtrl")
public class AddGoodsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddGoodsCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String saveFolder = "D:/kim3/jsp1/web03/src/main/webapp/upload";
		String encType = "UTF-8";
		int maxSize = 10 * 1024 * 1024;	// 10MB
		
		MultipartRequest multi = new MultipartRequest(request,
				saveFolder, maxSize, encType);
		
		String gcategory = multi.getParameter("gcategory");
		String gname = multi.getParameter("gname");
		int gprice = Integer.parseInt(multi.getParameter("gprice"));
		String gcolor = multi.getParameter("gcolor");
		int amount = Integer.parseInt(multi.getParameter("amount"));
		String gsize = multi.getParameter("gsize");
		String gcontent = multi.getParameter("gcontent");
		String gimage = "";
		int best = Integer.parseInt(multi.getParameter("best"));
		
		try {			
			if (multi.getFilesystemName("gimage") != null) {
				String name = multi.getFilesystemName("gimage");
				gimage = name;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		GoodsVO vo = new GoodsVO();
		vo.setGcategory(gcategory);
		vo.setGname(gname);
		vo.setGprice(gprice);
		vo.setGcolor(gcolor);
		vo.setAmount(amount);
		vo.setGsize(gsize);
		vo.setGcontent(gcontent);
		vo.setGimage(gimage);
		vo.setBest(best);
		
		GoodsDAO dao = new GoodsDAO();
		int cnt = dao.addGoods(vo);
		if(cnt>0) {  //제품 등록 성공
			response.sendRedirect("GetGoodsListCtrl");
		} else {  //제품 등록 실패
			response.sendRedirect("./goods/addGoodsForm.jsp");
		}		
	}
}