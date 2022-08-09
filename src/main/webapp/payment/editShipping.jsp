<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path1" value="${pageContext.request.contextPath }" /> 
<%
	String uid = "";
	if(uid != null) uid = (String) application.getAttribute("uid");
	int bno = 0;
	if(request.getParameter("bno")!=null) { bno = Integer.parseInt(request.getParameter("bno")); } 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<title>상품 구매 하기</title>
<jsp:include page="../common.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<section class="con_wrap">
		<h2 class="page_tit">배송 도착지 정보 수정</h2>
		<form action="${path1 }/EditPaymentCtrl" method="post" name="payment_form">
			<table class="table" id="lst_tb">
				<tbody>
					<tr>
						<th>결제번호</th>
						<td>
							<input type="text" name="ono" value="${payment.ono }" readonly required>
							<input type="hidden" name="paytype" value="${payment.paytype }">
							<input type="hidden" name="payno" value="${payment.payno }">
							<input type="hidden" name="sdate" value="${payment.sdate }">
							<input type="hidden" name="amount" value="${payment.sdate }">
							<input type="hidden" name="userid" value="${payment.userid }">
							<input type="hidden" name="transno" value="${vo.transno }">
							<input type="hidden" name="transco" value="${vo.transco }">
							<input type="hidden" name="rstatus" value="${vo.rstatus }">
							<input type="hidden" name="rdate" value="${vo.rdate }">
						</td>
					</tr>
					<tr>
						<th>상품코드</th>
						<td>
							<input type="text" name="gno" value="${payment.gno }" readonly required>
						</td>
					</tr>
					<tr>
						<th>결제 금액</th>
						<td>
							<input type="text" name="amount" value="${payment.money }" readonly required>
						</td>
					</tr>
					<tr>
						<th>수신자명</th>
						<td>
							<input type="text" name="rname" value="${payment.rname }" required>
						</td>
					</tr>
					<tr>
						<th>수신자 연락처</th>
						<td>
							<input type="text" name="tel" value="${payment.tel }" required>
						</td>
					</tr>
					<tr>
						<th>수신자 주소</th>
						<td>
							<input type="text" name="addr1" id="addr1" value="${payment.addr1 }" required><br>
							<input type="text" name="addr2" id="addr2" value="${payment.addr2 }" placeholder="상세주소 입력" required><br>
							<input type="text" name="postcode" id="postcode" value="${payment.postcode }" required>
							<input type="button" value="주소찾기" onclick="findAddr()" class="button is-info">
						</td>
					</tr>
					<tr>
						<th>배송장에 남길 말씀</th>
						<td>
							<c:if test="${!empty payment.memo }">
							<input type="text" name="memo" id="memo" value="${payment.memo }">
							</c:if>
							<c:if test="${empty payment.memo }">
							<input type="text" name="memo" id="memo" value="">
							</c:if>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="도착지 수정" class="button is-info"/>
							<input type="reset" value="취소" class="button is-info"/>
							<p>모든 항목은 필수항목으로 꼭 입력하셔야 합니다.</p>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<script>
		function findAddr() {
			new daum.Postcode({
				oncomplete: function(data) {
					console.log(data);
					var roadAddr = data.roadAddress;
					var jibunAddr = data.jibunAddress;
					document.getElementById("postcode").value = data.zonecode;
					if(roadAddr !== '') {
						document.getElementById("addr1").value = roadAddr;				
					} else if(jibunAddr !== ''){
						document.getElementById("addr1").value = jibunAddr;
					}
				}
			}).open();
		}
		</script>
		<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>	
	</section>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>