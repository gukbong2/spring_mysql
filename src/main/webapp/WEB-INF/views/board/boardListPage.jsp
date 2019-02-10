<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST ALL PAGE</h3>
				</div>
				<div class="box-body">
				
<table class="table table-bordered">
	<tr>
		<th style="width: 80px">글 번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th style="width: 90px">조회수</th>
	</tr>


<c:forEach items="${BoardList}" var="BoardList">

	<tr>
		<td>${BoardList.bno}</td>
		<td><a href='/readPage?bno=${BoardList.bno}'>${BoardList.title}</a></td>
		<td>${BoardList.writer}</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
				value="${BoardList.regdate}" /></td>
		<td><span class="badge bg-red">${BoardList.viewcnt }</span></td>
	</tr>

</c:forEach>

</table>

				</div>

				<!-- /.box-body -->


				<div class="box-footer">

					<div class="text-center">
						<ul class="pagination">

							<c:if test="${pageMaker.prev}">
								<li><a href="listPage?page=${pagerMaker.startPage -1 }">&laquo;</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage }"
							end="${pageMaker.endPage }" var="idx">
								<li>
									<c:out value="${pageMaker.p.page == idx?'class=active':'' }"/>
									<a href="listPage?page=${idx} }">${idx }</a>
								</li>
							</c:forEach>
								
								<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
									<li><a href="listPage?page=${pageMaker.endPage +1 }">&raquo;</a></li>
								</c:if>
											
						</ul>
					</div>


					<%-- <div class="text-center">
						<ul class="pagination">

							<c:if test="${pageMaker.prev}">
								<li><a href="${pageMaker.startPage - 1}">&laquo;</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }" var="idx">
								<li
									<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
									<a href="${idx}">${idx}</a>
								</li>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a
									href="${pageMaker.endPage +1}">&raquo;</a></li>
							</c:if>

						</ul>
					</div> --%>


				</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->

<form id="jobForm">
  <input type='hidden' name="page" value=${pageMaker.cri.perPageNum}>
  <input type='hidden' name="perPageNum" value=${pageMaker.cri.perPageNum}>
</form>


<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
	
	$(".pagination li a").on("click", function(event){
		
		event.preventDefault(); 
		
		var targetPage = $(this).attr("href");
		
		var jobForm = $("#jobForm");
		jobForm.find("[name='page']").val(targetPage);
		jobForm.attr("action","/board/listPage").attr("method", "get");
		jobForm.submit();
	});
	
</script>

<%@include file="../include/footer.jsp"%>
