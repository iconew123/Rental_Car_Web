package rentalServer.car.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rentalServer.utill.DBManager;

public class CarDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private CarDao() {

	}

	private static CarDao instance = new CarDao();

	public static CarDao getInstance() {
		return instance;
	}

	public List<CarResponseDto> findAllCar() {
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM cars";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int code = rs.getInt(1);
				String carName = rs.getString(2);
				int price = rs.getInt(3);
				String type = rs.getString(4);
				String model = rs.getString(5);
				int review = rs.getInt(6);
				int score = rs.getInt(7);
				String brand = rs.getString(8);
				int seater = rs.getInt(9);
				String color = rs.getString(10);
				String carNum = rs.getString(11);
				String img = rs.getString(12);
				boolean resStat = rs.getBoolean(13);

				CarResponseDto car = new CarResponseDto(code, carName, price, type, model, review, score, brand, seater,
						color, carNum, img, resStat);
				list.add(car);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;

	}

	public List<CarResponseDto> randomCarList() {

		List<CarResponseDto> list = new ArrayList<CarResponseDto>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM cars ORDER BY rand() limit 6;";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int code = rs.getInt(1);
				String carName = rs.getString(2);
				int price = rs.getInt(3);
				String type = rs.getString(4);
				String model = rs.getString(5);
				int review = rs.getInt(6);
				int score = rs.getInt(7);
				String brand = rs.getString(8);
				int seater = rs.getInt(9);
				String color = rs.getString(10);
				String carNum = rs.getString(11);
				String img = rs.getString(12);
				boolean resStat = rs.getBoolean(13);

				CarResponseDto car = new CarResponseDto(code, carName, price, type, model, review, score, brand, seater,
						color, carNum, img, resStat);
				list.add(car);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	public CarResponseDto carInfoByCode(int code) {

		CarResponseDto car = null;

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM cars WHERE code=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				code = rs.getInt(1);
				String carName = rs.getString(2);
				int price = rs.getInt(3);
				String type = rs.getString(4);
				String model = rs.getString(5);
				int review = rs.getInt(6);
				int score = rs.getInt(7);
				String brand = rs.getString(8);
				int seater = rs.getInt(9);
				String color = rs.getString(10);
				String carNum = rs.getString(11);
				String img = rs.getString(12);
				boolean resStat = rs.getBoolean(13);

				car = new CarResponseDto(code, carName, price, type, model, review, score, brand, seater, color, carNum,
						img, resStat);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return car;
	}

	public List<CarResponseDto> findCar(String type, String brand, String price) {

		List<CarResponseDto> list = new ArrayList<CarResponseDto>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM cars WHERE type LIKE ? AND brand LIKE ? AND CAST(price AS CHAR) LIKE ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			pstmt.setString(2, brand);
			pstmt.setString(3, price);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int code = rs.getInt(1);
				String carName = rs.getString(2);
				int p = rs.getInt(3);
				type = rs.getString(4);
				String model = rs.getString(5);
				int review = rs.getInt(6);
				int score = rs.getInt(7);
				brand = rs.getString(8);
				int seater = rs.getInt(9);
				String color = rs.getString(10);
				String carNum = rs.getString(11);
				String img = rs.getString(12);
				boolean resStat = rs.getBoolean(13);

				CarResponseDto car = new CarResponseDto(code, carName, p, type, model, review, score, brand, seater,
						color, carNum, img, resStat);
				list.add(car);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
