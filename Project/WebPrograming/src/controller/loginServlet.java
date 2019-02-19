package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// HttpSessionインスタンスの取得
	    HttpSession session = request.getSession();


	    if(session.getAttribute("userInfo") != null) {

	    	// ユーザ一覧のサーブレットにリダイレクト
    		response.sendRedirect("UserListServlet");
    		return;

	    }

		// ↓ フォワード login.jspを表示させる！
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 // リクエストパラメータの文字コードを指定 文字化け防止！
        request.setCharacterEncoding("UTF-8");


     // リクエストパラメータの入力項目を取得 ログインID＆パスワード
        String loginId = request.getParameter("loginId");

        String password = request.getParameter("password");


     // リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
     		UserDao userDao = new UserDao();
     		User user = userDao.findByLoginInfo(loginId, password);


     		if (user == null) {
    			// リクエストスコープにエラーメッセージをセット
    			request.setAttribute("errMsg", "ログインに失敗しました。");

    			// login.jspにフォワード
    			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
    			dispatcher.forward(request, response);
    			return;
    		}

     	// セッションにユーザの情報をセット
    		HttpSession session = request.getSession();
    		session.setAttribute("userInfo", user);

    		// ユーザ一覧のサーブレットにリダイレクト
    		response.sendRedirect("UserListServlet");

	}

}
