package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection abrirConexao() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url ="jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			final String USER = "user";
			final String PASS = "pass";
			con = DriverManager.getConnection(url, USER, PASS);
			System.out.println("Conexão aberta.");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public static void fecharConexao(Connection con) {
		try {
			con.close();
			System.out.println("Conexão encerrada.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
