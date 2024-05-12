package rentalServer.car.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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

	public ReservationResponseDto resDateCarCode(int code) {

		ReservationResponseDto resveration = null;

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT MIN(start_date) AS min , MAX(end_date) AS max FROM reservation WHERE car_code = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Date startDate = rs.getDate(1);
				Date endDate = rs.getDate(2);

				if (startDate == null && endDate == null) {
					return null;
				}

				resveration = new ReservationResponseDto(startDate, endDate);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resveration;
	}

	public boolean createRes(ReservationRequsetDto reservation) {
	    try {
	        conn = DBManager.getConnection();

	        String sql = "INSERT INTO reservation (user_id, car_code, start_date, end_date, use_date) VALUES (?, ?, ?, ?, DATEDIFF(?, ?));";
	        pstmt = conn.prepareStatement(sql);
	        System.out.println( reservation.getCarCode());
	        System.out.println( reservation.getUserId());
	        pstmt.setString(1, reservation.getUserId());
	        pstmt.setInt(2, reservation.getCarCode());
	        pstmt.setDate(3, reservation.getStartDate());
	        pstmt.setDate(4, reservation.getEndDate());
	        pstmt.setDate(5, reservation.getEndDate());
	        pstmt.setDate(6, reservation.getStartDate());

	        int result = pstmt.executeUpdate();

	        if (result == 1) {
	            return true;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return false;
	}
	
	public List<ReservationResponseDto> findReservation(String id){
		
		List<ReservationResponseDto> list = new ArrayList<ReservationResponseDto>();
		
		try {			
			conn = DBManager.getConnection();
			String sql = "SELECT reservation.*, cars.car_name FROM reservation JOIN cars ON reservation.car_code = cars.code WHERE reservation.user_id = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				id = rs.getString(1);
				int code = rs.getInt(2);
				Date startDate = rs.getDate(3);
				Date endDate = rs.getDate(4);
				int useDate = rs.getInt(5);
				Timestamp regDate = rs.getTimestamp(6);
				Timestamp modDate = rs.getTimestamp(7);
				String carName = rs.getString(8);
				
				ReservationResponseDto resevation = new ReservationResponseDto(id, code, startDate, endDate, useDate, regDate, modDate,carName);
				System.out.println(resevation.getCarName());
				list.add(resevation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ReservationResponseDto curReservation(String id, int code, Date start, Date end) {
		System.out.println("start" + start);
		System.out.println("end" + end);
		System.out.println(id);
		ReservationResponseDto cur = null;
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT start_date, end_date FROM reservation WHERE user_id = ? AND car_code = ? AND start_date=? AND end_date= ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, code);
			pstmt.setDate(3, start);
			pstmt.setDate(4, end);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
			    Date startDate = rs.getDate(1);
			    Date endDate = rs.getDate(2);
			    cur = new ReservationResponseDto(startDate, endDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cur);
		return cur;
	}
	
	public boolean deleteRes(String id, int code, Date start, Date end) {
		
		try {
			conn =DBManager.getConnection();
			String sql = "DELETE FROM reservation WHERE user_id = ? AND car_code = ? AND start_date= ? AND end_date= ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, code);
			pstmt.setDate(3, start);
			pstmt.setDate(4, end);
			
	        int result = pstmt.executeUpdate();

	        if (result == 1) {
	            return true;
	        }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
}
