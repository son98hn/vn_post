<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<title>Bưu chính chuyển phát</title>
</head>
<body>
	<div class="main">
		<div class="main-title">
			<span>BƯU CHÍNH CHUYỂN PHÁT</span>
		</div>
		<div class="main-content">
			<div class="main-content-items">
				<c:forEach var="item" items="${model.listResult}">
					<div class="main-content-item">
						<img src="${item.thumbnail}"> <a
							href='<c:url value ="chi-tiet-bai-viet?id=${item.id }"/>'
							style="text-decoration: none;"><span
							style="font-size: 14px; font-weight: bold; color: orange">
								${item.title}</span></a> <span style="font-size: 13px;">${item.shortDescription}</span>
					</div>
				</c:forEach>
			</div>

			<ul class="pagination" id="pagination"></ul>
			<input type="hidden" value="" id="page" name="page" /> <input
				type="hidden" value="" id="maxPageItem" name="maxPageItem" /> <input
				type="hidden" value="" id="sortName" name="sortName" /> <input
				type="hidden" value="" id="sortBy" name="sortBy" />
		</div>
	</div>
</body>
<script>
	var totalPages = $
	{
		model.totalPage
	};
	var currentPage = $
	{
		model.page
	};
	var limit = 6;
	$(function() {
		window.pagObj = $('#pagination').twbsPagination({
			totalPages : totalPages,
			visiblePages : 2,
			startPage : currentPage,
			onPageClick : function(event, page) {
				if (currentPage != page) {
					$('#maxPageItem').val(limit);
					$('#page').val(page);
					$('#sortName').val('createddate');
					$('#sortBy').val('desc');
				}
			}
		});
	});
</script>
</html>