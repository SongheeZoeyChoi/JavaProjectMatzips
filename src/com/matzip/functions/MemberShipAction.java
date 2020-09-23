package com.matzip.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.function.ShareVar;

public class MemberShipAction {

	private final String url_mysql = ShareVar.DBNAME;
	private final String id_mysql = ShareVar.DBUSER;
	private final String pw_mysql = ShareVar.DBPASS;

	private String nickname, email, password;

	public MemberShipAction() {
		// TODO Auto-generated constructor stub
	}

	public MemberShipAction(String nickname, String email, String password) {
		super();
		this.nickname = nickname;
		this.email = email;
		this.password = password;
	}

	public boolean checkNickname(String nickname) {

		String WhereDefault = "select nickname from customer where nickname = '";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(WhereDefault + nickname + "'");

			if (rs.next()) {
				conn_mysql.close();
				return false;
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean checkEmail(String email) {

		String WhereDefault = "select email from customer where email = '";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(WhereDefault + email + "'");

			if (rs.next()) {
				conn_mysql.close();
				return false;
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean registerAction() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String SQL = "insert into customer (nickname, email, password) values (?,?,?)";

			ps = conn_mysql.prepareStatement(SQL);
			ps.setString(1, nickname);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.executeUpdate();

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
