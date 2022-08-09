package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.common.GoodsVO;
import com.shop.common.JDBCConnection;
import com.shop.common.PaymentVO;

public class PaymentDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	
	public GoodsVO callByPay(int gno) {
		GoodsVO goods = new GoodsVO();
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from goods where gno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				goods.setGno(rs.getInt("gno"));
				goods.setGcategory(rs.getString("gcategory"));
				goods.setGname(rs.getString("gname"));
				goods.setGprice(rs.getInt("gprice"));
				goods.setGcolor(rs.getString("gcolor"));
				goods.setAmount(rs.getInt("amount"));
				goods.setGsize(rs.getString("gsize"));
				goods.setGcontent(rs.getString("gcontent"));
				goods.setGimage(rs.getString("gimage"));
				goods.setBest(rs.getInt("best"));
				goods.setRegdate(rs.getString("regdate"));
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return goods;
	}
	
	public ArrayList<PaymentVO> getPaymentList() {  //관리자용
		ArrayList<PaymentVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from payment";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<PaymentVO>();
			while(rs.next()) {
				PaymentVO vo = new PaymentVO();
				vo.setOno(rs.getInt("ono"));
				vo.setPaytype(rs.getString("paytype"));
				vo.setPayno(rs.getString("payno"));
				vo.setMoney(rs.getInt("money"));
				vo.setSdate(rs.getString("sdate"));
				vo.setGno(rs.getInt("gno"));
				vo.setAmount(rs.getInt("amount"));
				vo.setUserid(rs.getString("userid"));
				vo.setRname(rs.getString("rname"));
				vo.setTel(rs.getString("tel"));
				vo.setAddr1(rs.getString("addr1"));
				vo.setAddr2(rs.getString("addr2"));
				vo.setPostcode(rs.getString("postcode"));
				vo.setTransno(rs.getString("transno"));
				vo.setTransco(rs.getString("transco"));
				vo.setRstatus(rs.getString("rstatus"));
				vo.setRdate(rs.getString("rdate"));
				vo.setMemo(rs.getString("memo"));
				list.add(vo);
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return list;
	}
	public ArrayList<PaymentVO> getPaymentList(String userid) { //일반회원용
		ArrayList<PaymentVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from payment where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			list = new ArrayList<PaymentVO>();
			while(rs.next()) {
				PaymentVO vo = new PaymentVO();
				vo.setOno(rs.getInt("ono"));
				vo.setPaytype(rs.getString("paytype"));
				vo.setPayno(rs.getString("payno"));
				vo.setMoney(rs.getInt("money"));
				vo.setSdate(rs.getString("sdate"));
				vo.setGno(rs.getInt("gno"));
				vo.setAmount(rs.getInt("amount"));
				vo.setUserid(rs.getString("userid"));
				vo.setRname(rs.getString("rname"));
				vo.setTel(rs.getString("tel"));
				vo.setAddr1(rs.getString("addr1"));
				vo.setAddr2(rs.getString("addr2"));
				vo.setPostcode(rs.getString("postcode"));
				vo.setTransno(rs.getString("transno"));
				vo.setTransco(rs.getString("transco"));
				vo.setRstatus(rs.getString("rstatus"));
				vo.setRdate(rs.getString("rdate"));
				vo.setMemo(rs.getString("memo"));
				list.add(vo);
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public PaymentVO getPayment(int ono) {	// 결제 정보 불러오기
		PaymentVO payment = new PaymentVO();
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from payment where ono=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ono);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				payment.setOno(rs.getInt("ono"));
				payment.setPaytype(rs.getString("paytype"));
				payment.setPayno(rs.getString("payno"));
				payment.setMoney(rs.getInt("money"));
				payment.setSdate(rs.getString("sdate"));
				payment.setGno(rs.getInt("gno"));
				payment.setAmount(rs.getInt("amount"));
				payment.setUserid(rs.getString("userid"));
				payment.setRname(rs.getString("rname"));
				payment.setTel(rs.getString("tel"));
				payment.setAddr1(rs.getString("addr1"));
				payment.setAddr2(rs.getString("addr2"));
				payment.setPostcode(rs.getString("postcode"));
				payment.setTransno(rs.getString("transno"));
				payment.setTransco(rs.getString("transco"));
				payment.setRstatus(rs.getString("rstatus"));
				payment.setRdate(rs.getString("rdate"));
				payment.setMemo(rs.getString("memo"));
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return payment;
	}
	
	
	public int addPayment(PaymentVO vo, int bno) {  //결제 처리
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into payment values((select nvl(max(ono), 0)+1 from payment), ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPaytype()); //2
			pstmt.setString(2, vo.getPayno());	//3
			pstmt.setInt(3, vo.getMoney());	//4
			pstmt.setInt(4, vo.getGno()); //6
			pstmt.setInt(5, vo.getAmount()); //7
			pstmt.setString(6, vo.getUserid()); //8
			pstmt.setString(7, vo.getRname()); //9
			pstmt.setString(8, vo.getTel()); //10
			pstmt.setString(9, vo.getAddr1()); //11
			pstmt.setString(10, vo.getAddr2()); //12
			pstmt.setString(11, vo.getPostcode()); //13
			pstmt.setString(12, vo.getTransno()); //14 - null
			pstmt.setString(13, vo.getTransco()); //15 - null
			pstmt.setString(14, vo.getRstatus()); //16 - null
			pstmt.setString(15, vo.getRdate()); //17 - null
			pstmt.setString(16, vo.getMemo()); //18
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
	
	public int editPayment(PaymentVO vo) {  //배송지 수정
		try {
			conn = JDBCConnection.getConnection();
			sql = "update payment set rname=?, tel=?, addr1=?, addr2=?, postcode=?, memo=? where ono=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getRname());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getAddr1());
			pstmt.setString(4, vo.getAddr2());
			pstmt.setString(5, vo.getPostcode());
			pstmt.setString(6, vo.getMemo());
			pstmt.setInt(7, vo.getOno());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
	
	public int shippingAssign(PaymentVO vo) {  //택배 배정
		try {
			conn = JDBCConnection.getConnection();
			sql = "update payment set transno=?, transco=?, rstatus=?, rdate=? where ono=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTransno());
			pstmt.setString(2, vo.getTransco());
			pstmt.setString(3, vo.getRstatus());
			pstmt.setString(4, vo.getRdate());
			pstmt.setInt(5, vo.getOno());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
	
	public int delPayment(int num) {	//결제 정보 삭제 또는 결제 취소
		try {
			conn = JDBCConnection.getConnection();
			sql = "delete from payment where ono=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
}