<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="assets/css/createItem_style.css">

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
        <h1>商品登録</h1>
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
        <h1>商品登録</h1>

        <p class="msg">${msg}</p>

        <form action="CreateItem" method="post">
          <ul class="createItemList">

            <h2>登録商品入力</h2>

            <li class="createItem"><label for="img_url">商品画像 : </label>
              <input type="text" name="img_url" placeholder="商品画像">
            </li>

            <li class="createItem"><label for="item_id">商品番号 :</label>
              <input type="number" min="1" max="99" step="1" name="item_id" placeholder="例) 1">
            </li>

            <li class="createItem"><label for="item_name">商品名 : </label>
              <input type="text" name="item_name" placeholder="例)燻製肉">
            </li>

            <li class="createItem"><label for="price">価格 : </label>
              <input type="number" min="1" step="1" name="price" placeholder="例)10000">
            </li>

            <li class="createItem"><label for="stock">在庫 : </label>
              <input type="number" min="0" max="99" step="1" name="stock" placeholder="例)20">
            </li>

            <li class="createItem"><label for="category_id">商品カテゴリID : </label>
              <input type="number" min="1" max="3" step="1" name="category_id" placeholder="例)1">
            </li>

            <button class="button2" type="submit" value="insert" name="button">登録</button>

          </ul>
        </form>
      </main>
    </body>

    </html>