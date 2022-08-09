<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 보기</title>
<jsp:include page="../common.jsp"></jsp:include>
<style>
#lst_tb th { min-width:140px; }
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content" class="content_wrap">
	<section class="con_wrap">
		<c:if test="${sid=='admin' }">
		<h2 class="page_tit">상품 정보 수정</h2>
		</c:if>
		<c:if test="${sid!='admin' }">
		<h2 class="page_tit">상품 정보 보기</h2>
		</c:if>
		<form action="${path1 }/EditPaymentCtrl" method="post">
			<table class="table" id="lst_tb">
				<tbody>
					<tr>
						<th>결제번호</th>
						<td>
							<input type="hidden" name="ono" value="${payment.ono }">
							<span>${payment.ono }</span>
						</td>
					</tr>
					<tr>
						<th>결제 방식</th>
						<td>
							<c:if test="${payment.paytype=='credit' }">
							<span>결제방식 : 카드결제 </span> /
							</c:if>
							<c:if test="${payment.paytype=='check' }">
							<span>결제방식 : 체크결제 </span> /
							</c:if>
							<c:if test="${payment.paytype=='account' }">
							<span>결제방식 : 계좌이체 </span> /
							</c:if>
							<input type="hidden" name="paytype" value="${payment.paytype }"> 
						</td>
					</tr>
					<tr>
						<th>판매금액</th>
						<td>
							<span>${payment.money }</span>
							<input type="hidden" name="money" value="${payment.money }">
						</td>
					</tr>
					<tr>
						<th>결제일</th>
						<td>
							<span>${payment.sdate }</span>
							<input type="hidden" name="sdate" value="${payment.sdate }">
						</td>
					</tr>
					<tr>
						<th>제품코드</th>
						<td>
							<span>${payment.gno }</span>
							<input type="hidden" name="gno" value="${payment.gno }">
						</td>
					</tr>
					<tr>
						<th>판매량</th>
						<td>
							<span>${payment.amount }</span>
							<input type="hidden" name="amount" value="${payment.amount }">
						</td>
					</tr>
					<tr>
						<th>구매자 아이디</th>
						<td>
							<span>${payment.userid }</span>
							<input type="hidden" name="userid" value="${payment.userid }">
						</td>
					</tr>
					<tr>
						<th>수신자</th>
						<td>
							<span>${payment.rname }</span>
							<input type="hidden" name="rname" value="${payment.rname }">
						</td>
					</tr>
					<tr>
						<th>연락처</th>
						<td>
							<span>${payment.tel }</span><br>
							<input type="hidden" name="tel" value="${payment.rdate }">
						</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<span>${payment.addr1 }</span><br>
							<span>${payment.addr2 }</span> <span>${payment.postcode }</span>
							<input type="hidden" name="addr1" value="${payment.addr1 }">
							<input type="hidden" name="addr2" value="${payment.addr2 }">
							<input type="hidden" name="postcode" value="${payment.postcode }">
						</td>
					</tr>
					<tr>
						<th>요청 메시지</th>
						<td>
							<span>${payment.memo }</span><br>
							<input type="hidden" name="memo" value="${payment.memo }">
						</td>
					</tr>
					<tr>
						<th>송장 번호</th>
						<td>
							<c:if test="${!empty payment.transno }">
							<input type="text" name="transno" value="${payment.transno }">
							</c:if>
							<c:if test="${empty payment.transno }">
							<input type="text" name="transno">
							</c:if>
						</td>
					</tr>
					<tr>
						<th>배송 회사</th>
						<td>
							<c:if test="${!empty payment.transco }">
							<input type="text" name="transco" value="${payment.transco }">
							</c:if>
							<c:if test="${empty payment.transco }">
							<input type="text" name="transco">
							</c:if>
						</td>
					</tr>
					<tr>
						<th>배송 상태</th>
						<td>
							<c:if test="${!empty payment.rstatus }">
							<input type="text" name="rstatus" value="${payment.rstatus }">
							</c:if>
							<c:if test="${empty payment.transno }">
								<select name="rstatus">
									<option value="배송시작">배송시작</option>
									<option value="배송중">배송중</option>
									<option value="배송완료">배송완료</option>
								</select>
							</c:if>
						</td>
					</tr>
					<tr>
						<th>도착일</th>
						<td>
							<c:if test="${!empty payment.rdate }">
							<input type="text" name="rdate" value="${payment.rdate }">
							</c:if>
							<c:if test="${empty payment.rdate }">
								<input type="date" name="rdate">
							</c:if>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="배송지 입력" class="button is-info"/>
							<input type="reset" value="취소" class="button is-info"/>
							<a href="${path1 }/DelPaymentCtrl?ono=${payment.ono }" class="button is-info">판매 정보 삭제</a>
							<a href="${path1 }/GetPaymentListCtrl" class="button is-info">목록</a>
						</td>
					</tr>
				</tbody>
			</table>
		</form>	
	</section>
	<script>
	$(document).ready(function(){
		$("#lst_tb_filter").css("display","none");
	});
	</script>	
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>