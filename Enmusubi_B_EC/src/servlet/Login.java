import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.AuthLogic;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// すでにログイン済みならビデオ一覧へリダイレクト、未ログインならログインページへ
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// ログイン
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		AuthLogic logic = new AuthLogic();
		User user = logic.login(email, password);
		
		if (user != null) {
			// ログインできたらトップページ（今回はVoD一覧）へリダイレクト
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			response.sendRedirect("/VoDSystem/VideoList");
		} else {
			// エラー時はエラーメッセージを追加し自分へ戻る
			request.setAttribute("msg", "ログインに失敗しました");
			doGet(request, response);
		}
	}
}
