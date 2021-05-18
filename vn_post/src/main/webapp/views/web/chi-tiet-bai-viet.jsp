<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@include file="/common/taglib.jsp" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Chi tiết bài viết</title>
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
              <c:url var="bai-viet-nhom" value="/bai-viet-nhom">
                <c:param name="id" value="${item.id}" />
              </c:url>
              <a href='<c:url value ="nhom-bai-viet?categoryId=${item.id }"/>' style=" color: black; text-decoration: none;">${item.name}</a>
            </div>
          </c:forEach>
        </div>
        <div class="content">
          <!-- <c:forEach var="item" items="${categories.listResult}" begin="${item.size()}" end="${item.size()+3}">
          <form id="getCategoryId" method="post">
            <input type="hidden" value="${item.id}" name="id" id="id">
            </form>
            <div class="content-news">
              <div class="first-news">
                <c:forEach var="item1" items="${model.listResult}" begin="${item1.size()}" end="${item1.size()}">
                  <span style="font-size: 14px; font-weight: bold;">${item1.title}</span>
                  <p>
                    <img src="${item.thumbnail}" style="width: 355px; height: 200px;">
                  </p>
                  <span style="font-size: 14px">${item1.shortDescription}</span>
                </c:forEach>
              </div>
              <div class="second-news">
                <c:forEach var="item1" items="${model.listResult}" begin="${item1.size()+1}" end="${item1.size()+4}">
                  <span style="font-size: 13px">${item1.title}</span>
                </c:forEach>
              </div>
              <div class="last-news">
                <c:forEach var="item1" items="${model.listResult}" begin="${item1.size()+5}" end="${item1.size()+5}">
                  <p>
                    <img src="${item1.thumbnail}" style="width: 200px; height: 175px;">
                  </p>
                  <span style="font-size: 14px; font-weight: bold;">${item1.title}</span>
                </c:forEach>
              </div>
            </div>
          </c:forEach> -->
          <div class="content-news">
                <div class="title">
                  <span style="font-size: 20px; font-weight: bold;">${model.title}</span>
                  <span style="font-size: 14px; color: #B4B4B4;">${model.createdDate}</span>
                </div>
                <div class="content-news-content">
                  <span style="font-size: 14px;">${model.content}</span>
                </div>
          </div>
        </div>
      </div>
    </body>

    </html>