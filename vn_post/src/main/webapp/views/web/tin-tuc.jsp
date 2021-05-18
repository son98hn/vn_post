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
              <a href='<c:url value ="nhom-bai-viet?categoryId=${item.id }"/>'
                style=" color: black; text-decoration: none;">${item.name}</a>
            </div>
          </c:forEach>
        </div>
        <div class="content">

          <div class="content-tin">
            <div class="name-category">
              <a href='<c:url value ="nhom-bai-viet?categoryId=1"/>' style="text-decoration: none; color:#485986;">Tin
                Vietnam Post</a>
            </div>
            <div class="content-news">
              <div class="first-news">
                <c:forEach var="item" items="${model1.listResult}" begin="${item.size()}" end="${item.size()}">
                  <a href='<c:url value ="chi-tiet-bai-viet?id=${item.id }"/>' style="text-decoration: none;"><span
                      style="font-size: 14px; font-weight: bold; color: black;">
                      ${item.title}</span></a>
                  <img src="${item.thumbnail}" >
                  <span style="font-size: 14px">${item.shortDescription}</span>
                </c:forEach>
              </div>
              <div class="second-news">
                <c:forEach var="item" items="${model1.listResult}" begin="${item.size()+1}" end="${item.size()+4}">
                  <a href='<c:url value ="chi-tiet-bai-viet?id=${item.id }"/>' style="text-decoration: none;"><span
                      style="font-size: 14px; color: black;">
                      ${item.title}</span></a>
                </c:forEach>
              </div>
              <div class="last-news">
                <c:forEach var="item" items="${model1.listResult}" begin="${item.size()+5}" end="${item.size()+5}">

                  <img src="${item.thumbnail}" >

                  <a href='<c:url value ="chi-tiet-bai-viet?id=${item.id }"/>' style="text-decoration: none;"><span
                      style="font-size: 14px; color: black;">
                      ${item.title}</span></a>
                </c:forEach>
              </div>
            </div>
          </div>
          <div class="content-tin">
            <div class="name-category"><a href='<c:url value ="nhom-bai-viet?categoryId=2"/>'
                style="text-decoration: none; color:#485986;">Bưu điện - Văn hóa xã</a></div>
            <div class="content-news">
              <div class="first-news">
                <c:forEach var="item" items="${model2.listResult}" begin="${item.size()}" end="${item.size()}">
                  <a href='<c:url value ="chi-tiet-bai-viet?id=${item.id }"/>' style="text-decoration: none;"><span
                      style="font-size: 14px; font-weight: bold; color: black;">
                      ${item.title}</span></a>

                  <img src="${item.thumbnail}" >

                  <span style="font-size: 14px">${item.shortDescription}</span>
                </c:forEach>
              </div>
              <div class="second-news">
                <c:forEach var="item" items="${model2.listResult}" begin="${item.size()+1}" end="${item.size()+4}">
                  <a href='<c:url value ="chi-tiet-bai-viet?id=${item.id }"/>' style="text-decoration: none;"><span
                      style="font-size: 14px; color: black;">
                      ${item.title}</span></a>
                </c:forEach>
              </div>
              <div class="last-news">
                <c:forEach var="item" items="${model2.listResult}" begin="${item.size()+5}" end="${item.size()+5}">

                  <img src="${item.thumbnail}">

                  <a href='<c:url value ="chi-tiet-bai-viet?id=${item.id }"/>' style="text-decoration: none;"><span
                      style="font-size: 14px; color: black;">
                      ${item.title}</span></a>
                </c:forEach>
              </div>
            </div>
          </div>
          <div class="content-tin">
            <div class="name-category"><a href='<c:url value ="nhom-bai-viet?categoryId=3"/>'
                style="text-decoration: none; color:#485986;">Người bưu điện</a></div>
            <div class="content-news">
              <div class="first-news">
                <c:forEach var="item" items="${model3.listResult}" begin="${item.size()}" end="${item.size()}">
                  <a href='<c:url value ="chi-tiet-bai-viet?id=${item.id }"/>' style="text-decoration: none;"><span
                      style="font-size: 14px; font-weight: bold; color: black;">
                      ${item.title}</span></a>

                  <img src="${item.thumbnail}" >

                  <span style="font-size: 14px">${item.shortDescription}</span>
                </c:forEach>
              </div>
              <div class="second-news">
                <c:forEach var="item" items="${model3.listResult}" begin="${item.size()+1}" end="${item.size()+4}">
                  <a href='<c:url value ="chi-tiet-bai-viet?id=${item.id }"/>' style="text-decoration: none;"><span
                      style="font-size: 14px; color: black;">
                      ${item.title}</span></a>
                </c:forEach>
              </div>
              <div class="last-news">
                <c:forEach var="item" items="${model3.listResult}" begin="${item.size()+5}" end="${item.size()+5}">

                  <img src="${item.thumbnail}">

                  <a href='<c:url value ="chi-tiet-bai-viet?id=${item.id }"/>' style="text-decoration: none;"><span
                      style="font-size: 14px; color: black;">
                      ${item.title}</span></a>
                </c:forEach>
              </div>
            </div>
          </div>
          <div class="content-tin">
            <div class="name-category"><a href='<c:url value ="nhom-bai-viet?categoryId=4"/>'
                style="text-decoration: none; color:#485986;">Hoạt động Đảng - Đoàn thể</a></div>
            <div class="content-news">
              <div class="first-news">
                <c:forEach var="item" items="${model4.listResult}" begin="${item.size()}" end="${item.size()}">
                  <a href='<c:url value ="chi-tiet-bai-viet?id=${item.id }"/>' style="text-decoration: none;"><span
                      style="font-size: 14px; font-weight: bold; color: black;">
                      ${item.title}</span></a>

                  <img src="${item.thumbnail}" >

                  <span style="font-size: 14px">${item.shortDescription}</span>
                </c:forEach>
              </div>
              <div class="second-news">
                <c:forEach var="item" items="${model4.listResult}" begin="${item.size()+1}" end="${item.size()+4}">
                  <a href='<c:url value ="chi-tiet-bai-viet?id=${item.id }"/>' style="text-decoration: none;"><span
                      style="font-size: 14px; color: black;">
                      ${item.title}</span></a>
                </c:forEach>
              </div>
              <div class="last-news">
                <c:forEach var="item" items="${model4.listResult}" begin="${item.size()+5}" end="${item.size()+5}">

                  <img src="${item.thumbnail}">

                  <a href='<c:url value ="chi-tiet-bai-viet?id=${item.id }"/>' style="text-decoration: none;"><span
                      style="font-size: 14px; color: black;">
                      ${item.title}</span></a>
                </c:forEach>
              </div>
            </div>
          </div>
        </div>
      </div>
    </body>
    <!-- <c:forEach var="item" items="${categories.listResult}" begin="${item.size()}" end="${item.size()+3}">
          <form id="getCategoryId" method="post">
            <input type="hidden" value="${item.id}" name="id" id="id">
            </form>
            <div class="content-news">
              <div class="first-news">
                <c:forEach var="item1" items="${model.listResult}" begin="${item1.size()}" end="${item1.size()}">
                  <span style="font-size: 14px; font-weight: bold; color: black;">${item1.title}</span>
                  
                    <img src="${item.thumbnail}" >
                  
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
                  
                    <img src="${item1.thumbnail}">
                  
                  <span style="font-size: 14px; font-weight: bold;">${item1.title}</span>
                </c:forEach>
              </div>
            </div>
          </c:forEach> -->

    </html>