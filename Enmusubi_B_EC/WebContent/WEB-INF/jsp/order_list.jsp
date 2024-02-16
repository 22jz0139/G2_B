<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="assets/css/order_style.css">

    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width,initial-scale=1.0">
      <title>注文一覧</title>
    </head>

    <body>
      <header>
        <h1>注文一覧</h1>
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

        <h1>注文内容</h1>

        <ul class="OrderCardList">
          <c:forEach var="Order" items="${order_list}">
            <li>
              <div class="OrderCard">
                <p>注文番号 : ${Order.order_id}</p>
                <p>顧客番号 : ${Order.customer_id}</p>
                <p>商品番号 : ${Order.item_id}</p>
                <p>商品名 : ${Order.item_name}</p>
                <p>注文数 : ${Order.stock}</p>
                <p>配送番号 : ${Order.delivery_id}</p>
              </div>
            </li>
          </c:forEach>
        </ul>
      </main>
    </body>

    </html>