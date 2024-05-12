package rentalServer.car.model;

public class CarRequestDto {
	
	private int code;
	private String carName;
	private int price;
	private String type;
	private String model;
	private int review;
	private int score;
	private String brand;
	private int seater;
	private String color;
	private String carNum;
	private String img;
	private boolean resStat;
	
	public CarRequestDto(int code, String carName, int price, String type, String model, int review, int score,
			String brand, int seater, String color, String carNum, String img, boolean resStat) {
		super();
		this.code = code;
		this.carName = carName;
		this.price = price;
		this.type = type;
		this.model = model;
		this.review = review;
		this.score = score;
		this.brand = brand;
		this.seater = seater;
		this.color = color;
		this.carNum = carNum;
		this.img = img;
		this.resStat = resStat;
	}

	public int getCode() {
		return code;
	}

	public String getCarName() {
		return carName;
	}

	public int getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public String getModel() {
		return model;
	}

	public int getReview() {
		return review;
	}

	public int getScore() {
		return score;
	}

	public String getBrand() {
		return brand;
	}

	public int getSeater() {
		return seater;
	}

	public String getColor() {
		return color;
	}

	public String getCarNum() {
		return carNum;
	}

	public String getImg() {
		return img;
	}

	public boolean isResStat() {
		return resStat;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setSeater(int seater) {
		this.seater = seater;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setResStat(boolean resStat) {
		this.resStat = resStat;
	}
	
	
}
