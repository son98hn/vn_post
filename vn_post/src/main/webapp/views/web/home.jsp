<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@include file="/common/taglib.jsp" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Trang chủ</title>
    </head>

    <body>
      <main class="main">
        <div class="slide">
          <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
              <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
              <li data-target="#myCarousel" data-slide-to="1"></li>
              <li data-target="#myCarousel" data-slide-to="2"></li>
              <li data-target="#myCarousel" data-slide-to="3"></li>
              <li data-target="#myCarousel" data-slide-to="4"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">
              <div class="item active">
                <img src="./img/giai-chay.png" width="100%" height="400">
              </div>

              <div class="item">
                <img src="./img/post-mart.jpg" width="100%" height="400">
              </div>

              <div class="item">
                <img src="./img/rac-thai.jpg" width="100%" height="400">
              </div>

              <div class="item">
                <img src="./img/nhan-vien.png" width="100%" height="400">
              </div>

              <div class="item">
                <img src="./img/may-bay.png" width="100%" height="400">
              </div>
            </div>

            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
              <span class="glyphicon glyphicon-chevron-left"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
              <span class="glyphicon glyphicon-chevron-right"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>
        </div>

        <!-- <div id="carousel" class="carousel slide my-5" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carousel" data-slide-to="0" class="active"></li>
            <li data-target="#carousel" data-slide-to="1"></li>
            <li data-target="#carousel" data-slide-to="2"></li>
            <li data-target="#carousel" data-slide-to="3"></li>
            <li data-target="#carousel" data-slide-to="4"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item">
              <img class="d-block" src="./img/giai-chay.png" width="100%" height="400">
            </div>
            <div class="carousel-item active">
              <img class="d-block" src="./img/post-mart.jpg" width="100%" height="400">
            </div>
            <div class="carousel-item">
              <img class="d-block" src="./img/rac-thai.jpg" width="100%" height="400">
            </div>
            <div class="carousel-item">
              <img class="d-block" src="./img/nhan-vien.png" width="100%" height="400">
            </div>
            <div class="carousel-item">
              <img class="d-block" src="./img/may-bay.png" width="100%" height="400">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div> -->

        <div class="content">
          <div class="left-content">
            <div class="content-left-content">
              <div class="content-left-content-block">
                <img class="content-left-content-block-1" src="./img/noi-khong-voi-rac-thai.PNG" alt="">
                <div class="content-left-content-block-2">
                  <span>Nói không với rác thải nhựa</span>
                  <span>Bưu điện Việt Nam vì một cuộc sống xanh</span>
                </div>
                <span id="btn-next content-left-content-block-3"><i class="fas fa-chevron-right"></i></span>
              </div>
              <div class="content-left-content-block">
                <img class="content-left-content-block-1" src="./img/thong-hop-bao-chi.PNG" alt="">
                <div class="content-left-content-block-2">
                  <span>Tổng hợp báo chí</span>
                  <span>Tổng hợp báo chí của nghành bưu điện</span>
                </div>
                <span id="btn-next content-left-content-block-3"><i class="fas fa-chevron-right"></i></span>
              </div>
              <div class="content-left-content-block">
                <img class="content-left-content-block-1" src="./img/quan-li-chat-luong.PNG" alt="">
                <div class="content-left-content-block-2">
                  <span>Quản lí chất lượng</span>
                  <span>Văn bản quản lí chất lượng dịch vụ</span>
                </div>
                <span id="btn-next content-left-content-block-3"><i class="fas fa-chevron-right"></i></span>
              </div>
              <div class="content-left-content-block">
                <img class="content-left-content-block-1" src="./img/tem-buu-chinh.PNG" alt="">
                <div class="content-left-content-block-2">
                  <span>Tem bưu chính</span>
                  <span>Văn bản quản lí tem bưu chính</span>
                </div>
                <span id="btn-next content-left-content-block-3"><i class="fas fa-chevron-right"></i></span>
              </div>
              <div class="content-left-content-block">
                <img class="content-left-content-block-1" src="./img/thi-dua-khen-thuong.PNG" alt="">
                <div class="content-left-content-block-2">
                  <span>Thi đua - khen thưởng</span>
                  <span>Tổng hợp thông tin thi đua khen thưởng</span>
                </div>
                <span id="btn-next content-left-content-block-3"><i class="fas fa-chevron-right"></i></span>
              </div>
              <div class="content-left-content-block">
                <img class="content-left-content-block-1" src="./img/van-ban-phap-ly.PNG" alt="">
                <div class="content-left-content-block-2">
                  <span>Văn bản pháp lý</span>
                  <span>Văn bản pháp lý và các thông tin liên quan</span>
                </div>
                <span id="btn-next content-left-content-block-3"><i class="fas fa-chevron-right"></i></span>
              </div>
              <div class="content-left-content-block">
                <img class="content-left-content-block-1" src="./img/dai-hoi-dang.PNG" alt="">
                <div class="content-left-content-block-2">
                  <span>Đại hội Đảng</span>
                  <span>Hướng tới Đại hộc Đại biểu Đảng bộ TCT lần II</span>
                </div>
                <span id="btn-next content-left-content-block-3"><i class="fas fa-chevron-right"></i></span>
              </div>
              <div class="content-left-content-block">
                <img class="content-left-content-block-1">
                <div class="content-left-content-block-2">
                  <span>Thông tin doanh nghiệp</span>
                  <span>Chuyên trang thông tin doanh nghiệp</span>
                </div>
                <span id="btn-next content-left-content-block-3"><i class="fas fa-chevron-right"></i></span>
              </div>
            </div>
          </div>
          <div class="mid-content">
            <div class="mid-content-content">
              <c:forEach var="item" items="${model.listResult}" begin="${item.size()}" end="${item.size()}">
                <div class="mid-content-content-block-1">
                  <p><img src="${item.thumbnail}"></p>
                </div>
                <div class="mid-content-content-block-2">
                  <a href='<c:url value ="chi-tiet-bai-viet?id=${item.id }"/>' style="text-decoration: none;"><span
                      style="font-size: 14px; font-weight: bold; color: black;">
                      ${item.title}</span></a>
                  <span style="font-size: 13px; color: #BABABA;">${item.createdDate}</span>
                  <span style="font-size: 13px;">${item.shortDescription}</span>
                </div>
              </c:forEach>
            </div>
          </div>
          <div class="last-content">
            <c:forEach var="item" items="${model.listResult}" begin="${item.size()+1}" end="${item.size()+5}">
              <div class="last-content-block-1">
                <p><img src="${item.thumbnail}" style="width: 90px; height: 70px"></p>
                <div class="last-content-block-2">
                  <a href='<c:url value ="chi-tiet-bai-viet?id=${item.id }"/>' style="text-decoration: none;"><span
                      style="font-size: 13px; font-weight: bold; color: black;">
                      ${item.title}</span></a>
                  <span style="font-size: 13px; color: #BABABA;">${item.createdDate}</span>
                </div>
              </div>
            </c:forEach>
          </div>
        </div>
      </main>
    </body>

    </html>