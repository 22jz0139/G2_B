<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="assets/css/style.css">
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width,initial-scale=1.0">
      <title>商品一覧</title>
    </head>

    <body>
      <header>
        <h1>在庫編集</h1>
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
        <h1>在庫編集</h1>

        <p class="msg">${msg}</p>

        <div class="popup1">
          <input type="checkbox" id="popup">
          <label class="popup-open" for="popup">在庫編集</label>

          <div class="popup-overlay">
            <div class="popup-window">
              <p class="popup-text">在庫を編集します。</p>
              <form action="ItemList" method="post">
                <div class="popup-main">
                  <label for="item_id">変更する商品(id) :</label>
                  <input type="number" value="${Item.item_id}" min="1" max="99" step="1" name="item_id"><br>

                  <label for="stock">在庫 : </label>
                  <input type="number" value="${Item.stock}" min="0" max="99" step="1" name="stock"><br>
                </div>
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

        <ul class="ItemCardList">
          <c:forEach var="Item" items="${list}">
            <li class="ItemCard">
              <img src="${Item.img_url}" alt="商品画像" class="Item_img">
              <p>商品番号 : ${Item.item_id}</p>
              <p>商品名 : ${Item.item_name}</p>
              <p>価格 : ${Item.price}</p>
              <p>在庫数 : ${Item.stock}</p>
              <p>商品カテゴリID : ${Item.category_id}</p>
            </li>
          </c:forEach>
        </ul>

      </main>
    </body>

    </html>