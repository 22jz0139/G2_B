package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.deliveryDAO;
import model.Delivery;

/**
 * Servlet implementation class DeliveryList
 */
@WebServlet("/DeliveryList")
public class DeliveryList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		deliveryDAO dao = new deliveryDAO();
		
		List<Delivery> delivery_list = dao.get();
		
		System.out.println(delivery_list);
		request.setAttribute("delivery_list", delivery_list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/delivery_list.jsp");
	    dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				// 配送ステータス編集
		    int delivery_id = Integer.parseInt(request.getParameter("delivery_id"));
			int status_id = Integer.parseInt(request.getParameter("status_id"));
					
					deliveryDAO dao = new deliveryDAO();
					int ret = dao.update(status_id,delivery_id);
					
					if (ret != -1) {
						// ログインできたらトップページ（今回はVoD一覧）へリダイレクト
						
						request.setAttribute("msg", "配送ステータスの変更が完了しました");
					
						doGet(request,response);
					//	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/itemList.jsp");
					//  dispatcher.forward(request,response);
					} else {
						// エラー時はエラーメッセージを追加し自分へ戻る
						request.setAttribute("msg", "配送ステータスの変更に失敗しました");
						doGet(request,response);
						//	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/itemList.jsp");
					//  dispatcher.forward(request,response);
					
					}
			}
}

