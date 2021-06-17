<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@include file="/common/taglib.jsp" %>
		<c:url var="APIurl" value="/api-admin-role" />
		<c:url var="RoleURL" value="/admin-role" />
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>

		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Danh sách quyền</title>
		</head>

		<body>
			<div class="main-content">
				<form action="<c:url value='/admin-role'/>" id="formSubmit" method="GET">
					<div class="main-content-inner">
						<div class="breadcrumbs ace-save-state" id="breadcrumbs">
							<ul class="breadcrumb">
								<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
										chủ</a></li>
							</ul>
						</div>
						<div class="page-content">
							<div class="row">
								<div class="col-xs-12">
									<c:if test="${not empty messageResponse}">
										<div class="alert alert-${alert}">${messageResponse}</div>
									</c:if>
									<div class="widget-box table-filter">
										<div class="table-btn-controls">
											<div class="pull-right tableTools-container">
												<div class="dt-buttons btn-overlap btn-group">

													<a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary
														btn-bold" data-toggle="tooltip" title='Thêm quyền' href='
														<c:url value="/admin-role?type=edit" />' <c:if
														test="${userModel.listRoleDetailCode.indexOf('add-role') == -1}">
														style="visibility: hidden;"</c:if>> <span>
															<i class="fa fa-plus-circle bigger-110 purple"></i>
														</span>
													</a>
													<button id="btnDelete" type="button" <c:if
														test="${userModel.listRoleDetailCode.indexOf('delete-role') == -1}">
														style="visibility: hidden;"</c:if>
														class="dt-button buttons-html5 btn btn-white btn-primary
														btn-bold"
														data-toggle="tooltip" title='Xóa quyền'>
														<span> <i class="fa fa-trash-o bigger-110 pink"></i>
														</span>
													</button>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-12">
											<div class="table-responsive">
												<table class="table table-bordered">
													<thead>
														<tr>
															<th><input type="checkbox" id="checkAll"></th>
															<th>Quyền</th>
															<th>Chi tiết quyền</th>
															<th>Thao tác</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${model.listResult}" varStatus="loop">
															<tr>
																<td><input type="checkbox" id="checkbox_${item.id}"
																		value="${item.id}"></td>

																<td>
																	${item.name}
																</td>
																<td>
																		${model.listRoleDetail[loop.index]}
																</td>
																<td>
																	<c:url var="editURL" value="/admin-role">
																		<c:param name="type" value="edit" />
																		<c:param name="id" value="${item.id}" />
																	</c:url> <a class="btn btn-sm btn-primary btn-edit"
																		data-toggle="tooltip"
																		title="Cập nhật quyền" <c:if
																		test="${userModel.listRoleDetailCode.indexOf('edit-role') == -1}">
																		style="visibility: hidden;"</c:if>
																		href='${editURL}'><i
																			class="fa fa-pencil-square-o"
																			aria-hidden="true"></i> </a>
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
												<ul class="pagination" id="pagination"></ul>
												<input type="hidden" value="" id="page" name="page" /> <input
													type="hidden" value="" id="maxPageItem" name="maxPageItem" />
												<input type="hidden" value="" id="sortName" name="sortName" />
												<input type="hidden" value="" id="sortBy" name="sortBy" /> <input
													type="hidden" value="" id="type" name="type" />
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>

			<script>
				var totalPages = ${ model.totalPage };
				var currentPage = ${ model.page };
				var limit = 6;
				$(function () {
					window.pagObj = $('#pagination').twbsPagination({
						totalPages: totalPages,
						visiblePages: 10,
						startPage: currentPage,
						onPageClick: function (event, page) {
							if (currentPage != page) {
								$('#maxPageItem').val(limit);
								$('#page').val(page);
								$('#sortName').val('id');
								$('#sortBy').val('desc');
								$('#type').val('list');
								$('#formSubmit').submit();
							}
						}
					});
				});

				$("#btnDelete").click(function () {
					var data = {};
					var ids = $('tbody input[type=checkbox]:checked').map(function () {
						return $(this).val();
					}).get();
					data['ids'] = ids;
					deleteRole(data);
				});

				function deleteRole(data) {
					$
						.ajax({
							url: '${APIurl}',
							type: 'DELETE',
							contentType: 'application/json',
							data: JSON.stringify(data),
							success: function (result) {
								window.location.href = "${RoleURL}?type=list&maxPageItem=6&page=1&message=delete_success";
							},
							error: function (error) {
								window.location.href = "${RoleURL}?type=list&maxPageItem=6&page=1&message=error_system";
							}
						});
				}
			</script>
		</body>

		</html>