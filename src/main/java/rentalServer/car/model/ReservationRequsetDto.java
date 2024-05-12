package rentalServer.car.model;

import java.sql.Date;


public class ReservationRequsetDto {

	private String userId;
	private int carCode;
	private Date startDate;
	private Date endDate;
	private int use_date;
	
	public ReservationRequsetDto(String userId, int carCode, Date startDate, Date endDate) {
		super();
		this.userId = userId;
		this.carCode = carCode;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setCarCode(int carCode) {
		this.carCode = carCode;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setUse_date(int use_date) {
		this.use_date = use_date;
	}
	
	
	
	
}
