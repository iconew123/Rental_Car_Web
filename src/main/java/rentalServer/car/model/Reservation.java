package rentalServer.car.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Reservation {
	private String userId;
	private int carCode;
	private Date startDate;
	private Date endDate;
	private int use_date;
	private Timestamp regDate;
	private Timestamp modDate;
	
	public Reservation(String userId, int carCode, Date startDate, Date endDate, int use_date) {
		super();
		this.userId = userId;
		this.carCode = carCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.use_date = use_date;
	}

	public String getUserId() {
		return userId;
	}

	public int getCarCode() {
		return carCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public int getUse_date() {
		return use_date;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}

}
