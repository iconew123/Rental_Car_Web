package rentalServer.car.model;

public class Car {
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
	
	public Car(int code, String carName, int price, String type, String model, int review, int score, String brand,
			int seater, String color, String carNum, String img, boolean resStat) {
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
	
}
