package rentalServer.utill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Context init = new InitialContext();
			DataSource source = (DataSource) init.lookup("java:comp/env/jdbc/RentalServerDB");
			
			conn = source.getConnection();
			
			System.out.println("[DB 연동 성공]");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("[DB 연동 실패]");
		}
		
		return conn;
	}
	
	public static void close(Connection conn , PreparedStatement pstmt, ResultSet rs) {
		try {
			conn.close();
			pstmt.close();
			rs.close();
			
			System.out.println("[DB 연결 해제]");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("[DB 연결 해제 실패]");
		}
	}
	
	// rs는 옵셔널하게 오버로딩
	public static void close(Connection conn , PreparedStatement pstmt) {
		try {
			conn.close();
			pstmt.close();
			
			System.out.println("[DB 연결 해제]");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("[DB 연결 해제 실패]");
		}
	}
}
