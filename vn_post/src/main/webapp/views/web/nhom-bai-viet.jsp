<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@include file="/common/taglib.jsp" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Tin tức</title>
    </head>

    <body>
      <div class="main">
        <div class="menu">
          <div class="menu-title">
            <span style="font-size: 16px; color: orange; font-weight: bold;">CHUYÊN
              MỤC</span>
            <hr>

          </div>
          <c:forEach var="item" items="${categories.listResult}" begin="${item.size()}" end="${item.size()+3}">
            <div class="category">
              <a href='<c:url value ="nhom-bai-viet?categoryId=${item.id }"/>' style=" color: black; text-decoration: none;">${item.name}</a>
            </div>
          </c:forEach>
        </div>
        <div class="content">
          <!-- <div class="title"><span style="font-size: 22px;">TIN TỨC</span></div> -->
          <div class="content-content">
            <c:forEach var="item" items="${model.listResult}">
              <div class="block">
                <div class="block-1">
                 <a href='<c:url value ="chi-tiet-bai-viet?id=${item.id }"/>' style="text-decoration: none;"> <span style="font-size: 14px; font-weight: bold; color: black;">${item.title}
                 </span></a>
                </div>
                <div class="block-2">
                  <div class="block-2-1">
                    <p><img src="${item.thumbnail}" style="width: 184px; height: 138x;"></p>
                  </div>
                  <div class="block-2-2">
                    <span style="font-size: 14px; color: #b4b4b4;">${item.createdDate}</span>
                    <span style="font-size: 14px;">${item.shortDescription}</span>
                  </div>
                </div>

              </div>
            </c:forEach>
          </div>
        </div>
      </div>
    </body>

    </html>