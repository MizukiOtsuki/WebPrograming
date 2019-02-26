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

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	
	    HttpSession session = request.getSession();


	    if(session.getAttribute("userInfo") == null) {


	    	// loginサーブレットにリダイレクト
    		response.sendRedirect("loginServlet");
    		return;

	    }


		// ↓ フォワード SignUp.jspを表示させる！
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/SignUp.jsp");
		dispatcher.forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//文字化け防止のため
		request.setCharacterEncoding("UTF-8");


		// 入力項目を取得する
		String loginId = request.getParameter("loginId");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");



		//パスワードとパスワード(確認)の入力内容が異なる場合は登録をできない
		if(!password.equals(password2)) {


			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "入力された内容は正しくありません");

			// 新規登録に失敗した場合 SignUp.jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/SignUp.jsp");
			dispatcher.forward(request, response);
			return;


		}


		//入力項目にひとつでも未入力のものがある場合は登録をできない
		if(loginId.equals("") || name.equals("") ||birthDate.equals("") || password.equals("") || password2.equals("")) {

			// リクエストスコープにエラーメッセージをセット
				request.setAttribute("errMsg", "入力された内容は正しくありません");

			// 新規登録に失敗した場合 SignUp.jspにフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/SignUp.jsp");
				dispatcher.forward(request, response);
				return;

		}



		//何も問題がなければDaoのメソッドを実行
        UserDao userDao = new UserDao();
 		userDao.signup(loginId,name,birthDate,password);

 		// 登録が成功した場合 Userlistサーブレットにリダイレクト
 		response.sendRedirect("UserListServlet");
		return;






	}

}
