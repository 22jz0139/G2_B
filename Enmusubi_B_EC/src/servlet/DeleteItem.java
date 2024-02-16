package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.deleteItemDAO;

/**
 * Servlet implementation class DeleteItem
 */
@WebServlet("/DeleteItem")
public class DeleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		 RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/deleteItem.jsp");
		    dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
			// 商品登録
	    int item_id = Integer.parseInt(request.getParameter("item_id"));
				
		deleteItemDAO dao = new deleteItemDAO();
				int ret = dao.insert(item_id);
				
				if (ret != -1) {
					request.setAttribute("msg", "商品の削除が完了しました");
				
					doGet(request,response);
					request.getRequestDispatcher("WEB-INF/jsp/deleteItem.jsp").forward(request, response);
				//  dispatcher.forward(request,response);
				} else {
					// エラー時はエラーメッセージを追加し自分へ戻る
					request.setAttribute("msg", "商品の削除に失敗しました");
					doGet(request,response);
					request.getRequestDispatcher("WEB-INF/jsp/deleteItem.jsp").forward(request, response);
					//	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/itemList.jsp");
				//  dispatcher.forward(request,response);
				
				}
	}

}
