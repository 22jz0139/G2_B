package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.itemDAO;
import model.Item;

@WebServlet("/ItemList")
public class ItemList extends HttpServlet {
	private static final long serialVersionUID = 1L;
   /**@see ---- */
   /**GETリクエストを受け付けて、DBからデータを取得する*/
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {

	   request.setCharacterEncoding("UTF-8");
	   response.setContentType("text/html; charset=UTF-8");
		
	   itemDAO dao = new itemDAO();
	   //格納するList
      List<Item> list = dao.get();
    //DBから取得したデータを渡す

      System.out.println(list);
    request.setAttribute("list",list);

    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/itemList.jsp");
    dispatcher.forward(request,response);
 

   }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
			// 在庫編集
	    int item_id = Integer.parseInt(request.getParameter("item_id"));
		int stock = Integer.parseInt(request.getParameter("stock"));
				
				itemDAO dao = new itemDAO();
				int ret = dao.update(stock,item_id);
				
				if (ret != -1) {
					request.setAttribute("msg", "在庫の変更が完了しました");
				
					doGet(request,response);
				//	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/itemList.jsp");
				//  dispatcher.forward(request,response);
				} else {
					// エラー時はエラーメッセージを追加し自分へ戻る
					request.setAttribute("msg", "在庫の変更に失敗しました");
					doGet(request,response);
					//	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/itemList.jsp");
				//  dispatcher.forward(request,response);
				
				}
		}
}