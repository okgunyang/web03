<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매 목록</title>
<jsp:include page="../common.jsp"></jsp:include>
<style>
.page_tit { border-bottom:1px solid #cdcdcd; margin-bottom:25px; }
#lst_tb2 { width:1280px; margin:20px; auto; }
#lst_tb2 li { float:left; width:300px; height:400px; margin-right:15px; margin-top:15px; 
overflow:hidden; }
#lst_tb2 li img { display:block; width:100%; }
#lst_tb2 li.nothing { width:100%; clear:both; text-align:center; font-weight:bold; 
height:60px; line-height:60px; border-top:1px solid #cdcdcd; border-bottom:1px solid #cdcdcd;
margin-top:20px; margin-bottom:15px; }
#btn_group { clear:both; }
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content" class="content_wrap">
	<section class="con_wrap">
		<div>
			
		</div>	
		<h2 class="page_tit">판매 상품 목록</h2>
		<table class="pro_lst" id="lst_tb">
			<thead>
				<tr>
					<th>순번</th>
					<th>아이디</th>
					<th>상품코드</th>
					<th>결제금액</th>
					<th>결제일</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list }" var="vo" varStatus="status">
				<tr>
					<td><a href="${path1 }/GetPaymentCtrl?ono=${vo.ono }">${vo.ono }</a></td>
					<td><a href="${path1 }/GetMemberCtrl?userid=${vo.userid }" target="_blank">${vo.userid }</a></td>
					<td><a href="${path1 }/GetGoodsCtrl?gno=${vo.gno }" target="_blank">${vo.gno }</a></td>
					<td>${vo.money }</td>
					<td>${vo.sdate }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5">
					<c:if test="${vo==null }">
						<span class="nothing">더 이상 상품이 존재하지 않습니다.</span>
					</c:if>
				</td>
			</tr>
			</tbody>
		</table>
	</section>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>