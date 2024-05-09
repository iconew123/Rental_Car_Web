package rentalServer.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rentalServer.utill.DBManager;
import rentalServer.utill.PasswordCrypto;

public class UserDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private UserDao() {

	}

	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	public UserResponseDto findUserByIdAndPassword(String id, String password) {
		UserResponseDto user = null;

		try {
			conn = DBManager.getConnection();
			String sql = "SELECT id, user_name, iden_Num, mail, phone, telecom, pw, is_admin FROM users WHERE id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString(2);
				String birth = rs.getString(3);
				String email = rs.getString(4);
				String phone = rs.getString(5);
				String telecom = rs.getString(6);
				String encryptedPassword = rs.getString(7);
				boolean is_admin = rs.getBoolean(8);
				System.out.println(is_admin);

				if (PasswordCrypto.decrypt(password, encryptedPassword)) {

					user = new UserResponseDto(id, name, birth, email, phone, telecom, is_admin);
				} else {
					System.out.println("실패");
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DBManager.close(conn, pstmt, rs);
		}
		return user;
	}

	public UserResponseDto createUser(UserRequestDto userDto) {

		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO users(id, pw, user_name, iden_num, mail, phone, telecom) VALUE(?,?,?,?,?,?,?);";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userDto.getId());
			// 비밀번호 암호화
			String originPw = userDto.getPw();
			String enCodingPw = PasswordCrypto.encrypt(originPw);
			pstmt.setString(2, enCodingPw);
			if (PasswordCrypto.decrypt(originPw, enCodingPw)) {
				System.out.println("일치");
			} else {
				System.out.println("불일치");
			}

			pstmt.setString(3, userDto.getName());
			pstmt.setString(4, userDto.getIdenNum());
			pstmt.setString(5, userDto.getMail());
			pstmt.setString(6, userDto.getPhone());
			pstmt.setString(7, userDto.getTelecom());
			System.out.println(userDto.getPhone());

			pstmt.execute();

			return findUserByIdAndPassword(userDto.getId(), userDto.getPw());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return null;
	}

	public UserResponseDto updateUserPassword(UserRequestDto userDto, String newPassword) {
		UserResponseDto user = null;

		if (newPassword == null || newPassword.equals("")) {
			return user;
		}

		if (findUserByIdAndPassword(userDto.getId(), userDto.getPw()) == null) {
			return user;
		}
		try {
			conn = DBManager.getConnection();

			String sql = "UPDATE users SET pw=? WHERE id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, PasswordCrypto.encrypt(newPassword));
			pstmt.setString(2, userDto.getId());

			pstmt.execute();

			User userVo = findUserById(userDto.getId());
			user = new UserResponseDto(userVo);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return user;
	}

	public UserResponseDto updateUserEmail(UserRequestDto userDto) {
		UserResponseDto user = null;
		if (findUserByIdAndPassword(userDto.getId(), userDto.getPw()) == null) {
			return user;
		}
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE users SET mail=? WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getMail());
			pstmt.setString(2, userDto.getId());

			pstmt.execute();
			System.out.println();
			user = findUserByIdAndPassword(userDto.getId(), userDto.getPw());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return user;
	}

	public UserResponseDto updateUserPhone(UserRequestDto userDto) {
		UserResponseDto user = null;
		try {
			if (findUserByIdAndPassword(userDto.getId(), userDto.getPw()) == null) {
				System.out.println("널널");
				System.err.println(userDto.getId());
				System.err.println(userDto.getPw());
				return user;
			}

			String sql = "UPDATE users SET telecom=?, phone=? WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getTelecom());
			pstmt.setString(2, userDto.getPhone());
			pstmt.setString(3, userDto.getId());

			pstmt.execute();

			user = findUserByIdAndPassword(userDto.getId(), userDto.getPw());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return user;
	}

	private User findUserById(String id) {
		User user = null;

		try {
			conn = DBManager.getConnection();
			String sql = "SELECT id, user_name, iden_num, mail, phone, telecom FROM users WHERE id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString(2);
				String idenNum = rs.getString(3);
				String mail = rs.getString(4);
				String phone = rs.getString(5);
				String telecom = rs.getString(6);

				user = new User(id, name, idenNum, mail, phone, telecom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return user;
	}

	public boolean deleteUser(UserRequestDto userDto) {
		if (findUserByIdAndPassword(userDto.getId(), userDto.getPw()) == null)
			return false;

		try {

			String sql = "DELETE FROM users WHERE id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userDto.getId());

			pstmt.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return false;
	}
}
