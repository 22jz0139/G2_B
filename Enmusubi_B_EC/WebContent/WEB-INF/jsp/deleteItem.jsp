<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="assets/css/deleteItem_style.css">

    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width,initial-scale=1.0">
      <title>Insert title here</title>
    </head>

    <body>
      <header>
        <h1>商品削除</h1>
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
        <h1>商品削除</h1>

        <p class="msg">${msg}</p>

        <form action="DeleteItem" method="post">
          <ul class="deleteItemList">

            <h2>削除商品</h2>

            <li class="deleteItem"><label for="item_id">商品番号 :</label>
              <input type="number" min="1" max="99" step="1" name="item_id" placeholder="例) 1">
            </li>
            
            <h2>ボタンを押下すると商品を削除します。よろしいですか？</h2>
            
            <button class="button2" type="submit" value="insert" name="button">削除</button>

          </ul>
        </form>
      </main>
    </body>

    </html>