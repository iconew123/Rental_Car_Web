package rentalServer.board.model;

public class BoardRequestDto {
	private String user_id;
	private int board_num;
	private String title;
	private String content;
	private String type;
	
	
	public BoardRequestDto(String user_id, int board_num, String title, String content, String type) {
		super();
		this.user_id = user_id;
		this.board_num = board_num;
		this.title = title;
		this.content = content;
		this.type = type;
	}


	public BoardRequestDto(String user_id, String title, String content, String type) {
		super();
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.type = type;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public int getBoard_num() {
		return board_num;
	}


	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
}
