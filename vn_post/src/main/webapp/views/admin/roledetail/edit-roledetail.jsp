<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/common/taglib.jsp" %>
        <c:url var="APIurl" value="/api-admin-roledetail" />
        <c:url var="RoleDetailURL" value="/admin-roledetail" />
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <title>Chỉnh sửa quyền</title>
        </head>

        <body>
            <div class="main-content">
                <div class="main-content-inner">
                    <div class="breadcrumbs" id="breadcrumbs">
                        <script type="text/javascript">
                            try { ace.settings.check('breadcrumbs', 'fixed') } catch (e) { }
                        </script>
                        <ul class="breadcrumb">
                            <li>
                                <i class="ace-icon fa fa-home home-icon"></i>
                                <a href="#">Trang chủ</a>
                            </li>
                            <li class="active">Chỉnh sửa quyền</li>
                        </ul>
                    </div>
                    <div class="page-content">
                        <div class="row">
                            <div class="col-xs-12">
                                <c:if test="${not empty messageResponse}">
                                    <div class="alert alert-${alert}">
                                        ${messageResponse}
                                    </div>
                                </c:if>
                                <form id="formSubmit">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Nhóm quyền</label>
                                        <div class="col-sm-9">
                                            <select class="form-control" id="roleId" name="roleId">
                                                <c:if test="${empty model.roleId}">
                                                    <option value="">Chọn loại quyền</option>
                                                    <c:forEach var="item" items="${role}">
                                                        <option value="${item.id}">${item.name}</option>
                                                    </c:forEach>
                                                </c:if>
                                                <c:if test="${not empty model.roleId}">
                                                    <option value="">Chọn loại quyền</option>
                                                    <c:forEach var="item" items="${role}">
                                                        <option value="${item.id}" <c:if
                                                            test="${item.id == model.roleId}">
                                                            selected="selected"
                                                </c:if>>
                                                ${item.name}
                                                </option>
                                                </c:forEach>
                                                </c:if>
                                            </select>
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                      <label class="col-sm-3 control-label no-padding-right">Code</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="code" name="code"
                                                value="${model.code}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                      <label class="col-sm-3 control-label no-padding-right">Tên</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="permission" name="permission"
                                                value="${model.permission}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <c:if test="${not empty model.id}">
                                                <input type="button" class="btn btn-white btn-warning btn-bold"
                                                    value="Cập nhật nhóm quyền" id="btnAddOrUpdateRoleDetail" />
                                            </c:if>
                                            <c:if test="${empty model.id}">
                                                <input type="button" class="btn btn-white btn-warning btn-bold"
                                                    value="Thêm nhóm quyền" id="btnAddOrUpdateRoleDetail" />
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
                $('#btnAddOrUpdateRoleDetail').click(function (e) {
                    e.preventDefault();
                    var formData = $('#formSubmit').serializeArray();
                    console.log(formData);
                    var id = $('#id').val();
                    if (id == "") {
                        addRoleDetail(formData);

                    } else {
                        updateRoleDetail(formData);
                    }
                });
                function addRoleDetail(data) {
                    $.ajax({
                        url: '${APIurl}',
                        type: 'POST',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        dataType: 'json',
                        success: function (result) {
                            window.location.href = "${RoleDetailURL}?type=edit&id=" + result.id + "&message=insert_success";
                        },
                        error: function (error) {
                            window.location.href = "${RoleDetailURL}?type=list&maxPageItem=6&page=1&message=error_system";
                        }
                    });
                }
                function updateRoleDetail(data) {
                    $.ajax({
                        url: '${APIurl}',
                        type: 'PUT',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        dataType: 'json',
                        success: function (result) {
                            window.location.href = "${RoleDetailURL}?type=edit&id=" + result.id + "&message=update_success";
                        },
                        error: function (error) {
                            window.location.href = "${RoleDetailURL}?type=list&maxPageItem=6&page=1&message=error_system";
                        }
                    });
                }
            </script>
        </body>

        </html>