package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;


public class UserDao {



	//ログインするためのメソッド

	 public User findByLoginInfo(String loginId, String password) {
	        Connection conn = null;

	        try {

	       // データベースへ接続する！
            conn = DBManager.getConnection();

           // SELECT文を準備する。
            //ログインするためにログインIDとパスワードの情報を
            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

           // SELECTを実行し、結果表を取得する！
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();

            if (!rs.next()) {
                return null;

            }

            // ↓ User.javaのログインセッションのとこに保存される
            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            return new User(loginIdData, nameData);


	        } catch (SQLException e) {
                e.printStackTrace();
                return null;


            } finally {


            	// データベース切断
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }

	 	}


	 //ユーザー一覧を取得するためのメソッド

	 public List<User> findAll() {
	        Connection conn = null;
	        List<User> userList = new ArrayList<User>();

	        try {
	            // データベースへ接続する
	            conn = DBManager.getConnection();

	            // SELECT文を準備する。ユーザーの全ての情報が欲しい！
	            // TODO: 未実装：管理者以外を取得するようSQLを変更する
	            String sql = "SELECT * FROM user";


	            // SELECTを実行し、結果表を取得
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);


	            // 結果表に格納されたレコードの内容を
	            // Userインスタンスに設定し、ArrayListインスタンスに追加
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String loginId = rs.getString("login_id");
	                String name = rs.getString("name");
	                Date birthDate = rs.getDate("birth_date");
	                String password = rs.getString("password");
	                String createDate = rs.getString("create_date");
	                String updateDate = rs.getString("update_date");
	                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

	                userList.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        } finally {


	        	// データベースを切断する！
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                    return null;
	                }
	            }
	        }
	        return userList;
}


	 //新規登録をするためのメソッド

	 public void signup(String loginId,String name,String birthDate,String password){

		 Connection conn = null;

	        try {

	       // データベースへ接続する！
         conn = DBManager.getConnection();

        // INSERT文を準備する。

         String sql = "INSERT INTO user (login_id, name, birth_date, password, create_date, update_date) VALUES (?,?,?,?,now(),now())";


        // INSERTを実行
         PreparedStatement pStmt = conn.prepareStatement(sql);
         pStmt.setString(1, loginId);
         pStmt.setString(2, name);
         pStmt.setString(3, birthDate);
         pStmt.setString(4, password);


         pStmt.executeUpdate();

         pStmt.close();




         } catch (SQLException e) {
			e.printStackTrace();


		} finally {


         	// データベースを切断
             if (conn != null) {
                 try {
                     conn.close();
                 } catch (SQLException e) {
                     e.printStackTrace();

                 }
             }
         }

	 }







	 //ユーザーデータを取得するためのメソッド

	 public User UserData(String loginId) {
	        Connection conn = null;

	        try {

	       // データベースへ接続する！
      conn = DBManager.getConnection();


      // SELECT文を準備する。

      String sql = "SELECT * FROM user WHERE login_id = ?";

     // SELECTを実行し、結果表を取得する！
      PreparedStatement pStmt = conn.prepareStatement(sql);
      pStmt.setString(1, loginId);

      ResultSet rs = pStmt.executeQuery();

      if (!rs.next()) {
          return null;

      }

      int id = rs.getInt("id");
      String loginId2 = rs.getString("login_id");
      String name = rs.getString("name");
      Date birthDate = rs.getDate("birth_date");
      String password = rs.getString("password");
      String createDate = rs.getString("create_date");
      String updateDate = rs.getString("update_date");
      User user = new User(id, loginId2, name, birthDate, password, createDate, updateDate);

      return user;


	        } catch (SQLException e) {
          e.printStackTrace();
          return null;


      } finally {


      	// データベース切断
          if (conn != null) {
              try {
                  conn.close();
              } catch (SQLException e) {
                  e.printStackTrace();
                  return null;
              }
          }
      }

	 	}



	 //ユーザー更新メソッド

	 public  void Update(String name, String birthDate, String password,String id) {
	        Connection conn = null;

	        try {

	       // データベースへ接続する！
   conn = DBManager.getConnection();

  // UPDATE文を準備する。

   String sql = "UPDATE user SET name = ? , birth_date = ? ,password = ? WHERE login_id = ?";

  // UPDATEを実行し、結果表を取得する！
   PreparedStatement pStmt = conn.prepareStatement(sql);
   pStmt.setString(1, name);
   pStmt.setString(2, birthDate);
   pStmt.setString(3, password);
   pStmt.setString(4, id);


   pStmt.executeUpdate();




	        } catch (SQLException e) {
       e.printStackTrace();



   } finally {


   	// データベース切断
       if (conn != null) {
           try {
               conn.close();
           } catch (SQLException e) {
               e.printStackTrace();

           }
       }
   }
	 }




	//ユーザー更新メソッド (パスワード以外)

		 public  void update(String name, String birthDate,String id) {
		        Connection conn = null;

		        try {

		       // データベースへ接続する！
	   conn = DBManager.getConnection();

	  // UPDATE文を準備する。

	   String sql = "UPDATE user SET name = ? , birth_date = ? WHERE login_id = ?";

	  // UPDATEを実行し、結果表を取得する！
	   PreparedStatement pStmt = conn.prepareStatement(sql);
	   pStmt.setString(1, name);
	   pStmt.setString(2, birthDate);
	   pStmt.setString(3, id);


	   pStmt.executeUpdate();




		        } catch (SQLException e) {
	       e.printStackTrace();



	   } finally {


	   	// データベース切断
	       if (conn != null) {
	           try {
	               conn.close();
	           } catch (SQLException e) {
	               e.printStackTrace();

	           }
	       }
	   }
		 }





		 //データを削除するメソッド
	 public  void Delete(String id) {
	        Connection conn = null;

	        try {

	       // データベースへ接続する！
conn = DBManager.getConnection();

// DELETE文を準備する。

String sql = "DELETE FROM user WHERE id = ?";

// DELETEを実行し、結果表を取得する！
PreparedStatement pStmt = conn.prepareStatement(sql);

pStmt.setString(1, id);


pStmt.executeUpdate();




	        } catch (SQLException e) {
    e.printStackTrace();



} finally {


	// データベース切断
    if (conn != null) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
	}

	 }

}