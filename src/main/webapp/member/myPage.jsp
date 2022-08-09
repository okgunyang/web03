<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path1" value="${pageContext.request.contextPath }" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<title>회원 구매 보기</title>
<jsp:include page="../common.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<section class="con_wrap">
		<h2 class="page_tit">구매 정보 목록</h2>
		<form action="" method="post">
			<table class="table" id="lst_tb">
				<thead>
					<tr>
						<th>번호</th>
						<th>상품코드</th>
						<th>구입수량</th>
						<th>결제금액</th>
						<th>결제내용</th>
						<th>배송정보</th>
						<th>도착지수정</th>
					</tr>
				</thead>
				<tbody>
			<c:forEach items="${payList }" var="vo" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td><a target="_blank" href="${path1 }/GetGoodsCtrl?gno=${vo.gno }">${vo.gno }</a></td>
					<td>${vo.amount }</td>
					<td>${vo.money }</td>
					<td>
						<c:if test="${vo.paytype=='credit' }">
						<span>결제방식 : 카드결제 </span> /
						</c:if>
						<c:if test="${vo.paytype=='check' }">
						<span>결제방식 : 체크결제 </span> /
						</c:if>
						<c:if test="${vo.paytype=='account' }">
						<span>결제방식 : 계좌이체 </span> /
						</c:if> 
						<span>결제번호 : ${vo.payno }</span> / 
						<span>결제일 : ${vo.sdate }</span>
					</td>
					<td>
						<c:if test="${empty vo.transno}">
							<span>아직 배송 준비중</span>
						</c:if>
						<c:if test="${!empty vo.transno}">
							<span>배송 코드  : ${vo.transno }</span> / 
							<span>배송 회사 : ${vo.transno }</span> / 
							<span>배송 상태 : ${vo.rstatus }</span> /
							<span>도착일 : ${vo.rdate }</span>
						</c:if>
					</td>
					<td>
						<c:if test="${empty vo.transno }">
						<a href="${path1 }/EditShippingCtrl?ono=${vo.ono }" class="button is-danger is-small">도착지 수정</a>
						<a href="${path1 }/DelPaymentCtrl?ono=${vo.ono }" class="button is-warning is-small" style="margin-top:20px; ">결제 취소</a>
						</c:if>
						<c:if test="${!empty vo.transno }">
						<a href="" class="button is-light">수정 불가능</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
				</tbody>
			</table>
		</form>	
	</section>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>