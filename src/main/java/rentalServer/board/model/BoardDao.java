package rentalServer.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import rentalServer.utill.DBManager;

public class BoardDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BoardDao() {

	}

	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {
		return instance;
	}

	public List<BoardResponseDto> findBoardAll() {

		List<BoardResponseDto> list = new ArrayList<BoardResponseDto>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM boards";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userId = rs.getString(1);
				int boardNum = rs.getInt(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				String type = rs.getString(5);
				Timestamp record = rs.getTimestamp(6);
				Timestamp modTime = rs.getTimestamp(7);

				BoardResponseDto board = new BoardResponseDto(userId, boardNum, title, content, type, record, modTime);
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	public List<BoardResponseDto> findBoard(String tp) {

		List<BoardResponseDto> list = new ArrayList<BoardResponseDto>();

		try {
			conn = DBManager.getConnection();

			String sql = "";
			if (tp == null) {
				tp = "%글";
				sql = "SELECT * FROM boards WHERE type LIKE ?;";
			}
			else
				sql = "SELECT * FROM boards WHERE type=?";
				

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tp);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userId = rs.getString(1);
				int boardNum = rs.getInt(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				String type = rs.getString(5);
				Timestamp record = rs.getTimestamp(6);
				Timestamp modTime = rs.getTimestamp(7);

				BoardResponseDto board = new BoardResponseDto(userId, boardNum, title, content, type, record, modTime);
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	public BoardResponseDto createBoard(BoardRequestDto boardDto) {

		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO boards(user_id, title , content , type) VALUE(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, boardDto.getUser_id());
			pstmt.setString(2, boardDto.getTitle());
			pstmt.setString(3, boardDto.getContent());
			pstmt.setString(4, boardDto.getType());

			pstmt.execute();

			BoardResponseDto checkBoard = findBoardCur(boardDto.getUser_id());

			return checkBoard;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return null;

	}

	private BoardResponseDto findBoardCur(String uid) {

		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM boards WHERE user_id = ? ORDER BY record DESC LIMIT 1;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);

			rs = pstmt.executeQuery();

			System.out.println(uid);

			BoardResponseDto board = null;
			while (rs.next()) {
				String userId = rs.getString(1);
				int boardNum = rs.getInt(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				String type = rs.getString(5);
				Timestamp record = rs.getTimestamp(6);
				Timestamp modTime = rs.getTimestamp(7);

				board = new BoardResponseDto(userId, boardNum, title, content, type, record, modTime);
			}

			return board;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public BoardResponseDto updateBoard(BoardRequestDto boardDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE boards SET title=? , content=? , type=? WHERE board_num = ?;";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, boardDto.getTitle());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setString(3, boardDto.getType());
			pstmt.setInt(4, boardDto.getBoard_num());

			pstmt.execute();

			BoardResponseDto checkBoard = findBoardNum(boardDto.getBoard_num());

			return checkBoard;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return null;
	}

	private BoardResponseDto findBoardNum(int bN) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM boards WHERE board_num = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bN);

			rs = pstmt.executeQuery();

			BoardResponseDto board = null;
			while (rs.next()) {
				String userId = rs.getString(1);
				int boardNum = rs.getInt(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				String type = rs.getString(5);
				Timestamp record = rs.getTimestamp(6);
				Timestamp modTime = rs.getTimestamp(7);

				board = new BoardResponseDto(userId, boardNum, title, content, type, record, modTime);
			}

			return board;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public boolean deleteBoard(String id, int num) {
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM boards WHERE user_id=? AND board_num = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, num);

			int result = pstmt.executeUpdate();

			if (result == 0)
				return false;
			else
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return false;
	}

}
