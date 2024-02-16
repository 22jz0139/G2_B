package logic;

public class AuthLogic {
	/**
	 * ログイン処理を行う
	 * @param email
	 * @param password
	 * @return 成功時はログインしたユーザ、失敗時はnull
	 */
	public User login(String email, String password) {
		UserDAO dao = new UserDAO();
		User user = dao.findByEmail(email);
		
		if ((user != null) && (BCrypt.　　　　　　(password, user.getPassword()))) {
			return user;
		}
		
		return null;
	}
	
	/**
	 * ログアウト処理を行う
	 * @return なし
	 */
	public void logout(HttpSession session) {
		if ( /* ログインしていれば */ ) { 
			session.removeAttribute("loginUser");
		}
	}
	
	/**
	 * ログイン状態を確認する
	 * @param session
	 * @return ログインしていれば true、していなければ false
	 */
	public boolean isLoggedIn(HttpSession session) {
		return session.getAttribute("loginUser") != null;
	}

}
