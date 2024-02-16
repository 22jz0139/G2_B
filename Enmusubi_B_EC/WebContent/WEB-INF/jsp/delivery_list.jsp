<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="assets/css/delivery_style.css">

    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width,initial-scale=1.0">
      <title>配送状況一覧</title>
    </head>

    <body>

      <header>
        <h1>配送状況</h1>

        <nav class="nav_content">
          <ul class="nav_list">
            <li class="nav_item"><a href="http://localhost:8080/Enmusubi_B_EC/ItemList">在庫編集</a></li>
            <li class="nav_item"><a href="http://localhost:8080/Enmusubi_B_EC/OrderList">注文一覧</a></li>
            <li class="nav_item"><a href="http://localhost:8080/Enmusubi_B_EC/DeliveryList">配送状況一覧</a></li>
            <li class="nav_item"><a href="http://localhost:8080/Enmusubi_B_EC/CreateItem">商品登録</a></li>
            <li class="nav_item"><a href="http://localhost:8080/Enmusubi_B_EC/DeleteItem">商品削除</a></li>
          </ul>
        </nav>
      </header>

      <main>
        <h1>配送一覧</h1>

        <p class="msg">${msg}</p>

        <div class="popup1">
          <input type="checkbox" id="popup">
          <label class="popup-open" for="popup">配送ステータス編集</label>

          <div class="popup-overlay">
            <div class="popup-window">
              <p class="popup-text">配送ステータスを編集します。</p>
              <form action="DeliveryList" method="post">
                <label for="delivery_id">変更する配送番号(id) :</label>
                <input type="number" value="${Delivery.delivery_id}" min="1" max="999" step="1" name="delivery_id"><br>

                <label for="status_id">配送状況 : </label>
                <input type="number" value="${Delivery.status_id}" min="1" max="3" step="1" name="status_id"><br>

                <button type="submit" value="update" name="button">更新</button>
              </form>


              <label class="popup-close" for="popup">
                <svg width="18" height="18" xmlns="http://www.w3.org/2000/svg">
                  <line x1="0" y1="0" x2="18" y2="18" stroke="white" stroke-width="3"></line>
                  <line x1="0" y1="18" x2="18" y2="0" stroke="white" stroke-width="3"></line>
                </svg>
              </label>
            </div>
          </div>
        </div>

        <ul class="DeliveryCardList">
          <c:forEach var="Delivery" items="${delivery_list}">
            <li class="DeliveryCard">
              <p>配送番号 : ${Delivery.delivery_id}</p>
              <p>配送状況 : ${Delivery.status_id}</p>

              <p>注文番号 : ${Delivery.order_id}</p>
            </li>
          </c:forEach>
        </ul>
      </main>
    </body>

    </html>