package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ordersDAO;
import model.Order;

@WebServlet("/OrderList")
public class OrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
   /**@see ---- */
   /**GETリクエストを受け付けて、DBからデータを取得する*/
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {

	   ordersDAO dao = new ordersDAO();
	   //格納するList
      List<Order> order_list = dao.get();
    //DBから取得したデータを渡す

      System.out.println(order_list);
    request.setAttribute("order_list",order_list);

    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/order_list.jsp");
    dispatcher.forward(request,response);
   }
}