<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-district" />
<c:url var="DistrictURL" value="/admin-district" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Chỉnh sửa quận, huyện</title>
</head>

<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<li class="active">Chỉnh sửa quận, huyện</li>
				</ul>
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty messageResponse}">
							<div class="alert alert-${alert}">${messageResponse}</div>
						</c:if>
						<form id="formSubmit">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tỉnh, thành phố</label>
								<div class="col-sm-9">
									<select class="form-control" id="provin_id" name="provin_id">
										<c:if test="${empty model.provin_id}">
											<option value="">Chọn tỉnh, thành phố</option>
											<c:forEach var="item" items="${provins}">
												<option value="${item.id}">${item.name}</option>
											</c:forEach>
										</c:if>
										<c:if test="${not empty model.provin_id}">
											<option value="">Chọn tỉnh, thành phố</option>
											<c:forEach var="item" items="${provins}">
												<option value="${item.id}"
													<c:if
                                                            test="${item.id == model.provin_id}">
                                                            selected="selected"
                                                </c:if>>
													${item.name}</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tên
									quận, huyện</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="name" name="name"
										value="${model.name}" />
								</div>
							</div>
							<br /> <br />

							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty model.id}">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Cập nhật quận, huyện" id="btnAddOrUpdateDistrict" />
									</c:if>
									<c:if test="${empty model.id}">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Thêm quận, huyện" id="btnAddOrUpdateDistrict" />
									</c:if>
								</div>
							</div>
							<input type="hidden" value="${model.id}" id="id" name="id" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#btnAddOrUpdateDistrict').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});

			var id = $('#id').val();
			if (id == "") {
				addDistrict(data);
			} else {
				updateDistrict(data);
			}
		});
		function addDistrict(data) {
			$
					.ajax({
						url : '${APIurl}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${DistrictURL}?type=edit&id="
									+ result.id + "&message=insert_success";
						},
						error : function(error) {
							window.location.href = "${DistrictURL}?type=list&maxPageItem=6&page=1&message=error_system";
						}
					});
		}
		function updateDistrict(data) {
			$
					.ajax({
						url : '${APIurl}',
						type : 'PUT',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${DistrictURL}?type=edit&id="
									+ result.id + "&message=update_success";
						},
						error : function(error) {
							window.location.href = "${DistrictURL}?type=list&maxPageItem=6&page=1&message=error_system";
						}
					});
		}
	</script>
</body>

</html>