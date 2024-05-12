package rentalServer.car.model;

import java.sql.Date;
import java.sql.Timestamp;

public class ReservationResponseDto {
	
	private String userId;
	private int carCode;
	private Date startDate;
	private Date endDate;
	private int use_date;
	private Timestamp regDate;
	private Timestamp modDate;
	private String carName;
	
	public ReservationResponseDto(String userId, int carCode, Date startDate, Date endDate, int use_date,
			Timestamp regDate, Timestamp modDate) {
		super();
		this.userId = userId;
		this.carCode = carCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.use_date = use_date;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	
	
	
	public ReservationResponseDto(String userId, int carCode, Date startDate, Date endDate, int use_date,
			Timestamp regDate, Timestamp modDate, String carName) {
		super();
		this.userId = userId;
		this.carCode = carCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.use_date = use_date;
		this.regDate = regDate;
		this.modDate = modDate;
		this.carName = carName;
	}



	public ReservationResponseDto(Date startDate, Date endDate) {
		super();
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

	public Timestamp getRegDate() {
		return regDate;
	}

	public Timestamp getModDate() {
		return modDate;
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

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public void setModDate(Timestamp modDate) {
		this.modDate = modDate;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	
}
