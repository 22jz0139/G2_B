package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.createItemDAO;

/**
 * Servlet implementation class DeleteItem
 */
@WebServlet("/CreateItem")
/**
 * Servlet implementation class CreateItem
 */

public class CreateItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	   /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateItem() {
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

		 RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/createItem.jsp");
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
		
		String img_url = request.getParameter("img_url");
	    int item_id = Integer.parseInt(request.getParameter("item_id"));
	    String item_name = request.getParameter("item_name");
	    int price = Integer.parseInt(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int category_id = Integer.parseInt(request.getParameter("category_id"));
				
		
				
				
				createItemDAO dao = new createItemDAO();
				int ret = dao.insert(img_url,item_id,item_name,price,stock,category_id);
				System.out.println(item_name);
				
				if (ret != -1) {
					request.setAttribute("msg", "商品の登録が完了しました");
				
					doGet(request,response);
					request.getRequestDispatcher("WEB-INF/jsp/createItem.jsp").forward(request, response);
				//  dispatcher.forward(request,response);
				} else {
					// エラー時はエラーメッセージを追加し自分へ戻る
					request.setAttribute("msg", "商品の登録に失敗しました");
					doGet(request,response);
					request.getRequestDispatcher("WEB-INF/jsp/createItem.jsp").forward(request, response);
					//	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/itemList.jsp");
				//  dispatcher.forward(request,response);
				
				}
				//System.out.println(msg);
		}
}
