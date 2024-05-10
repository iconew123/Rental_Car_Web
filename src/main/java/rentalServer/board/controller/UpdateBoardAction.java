package rentalServer.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalServer.board.model.BoardDao;
import rentalServer.board.model.BoardRequestDto;
import rentalServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class UpdateBoardAction
 */
public class UpdateBoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBoardAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("userId");
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String type = request.getParameter("wtype");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boolean isValid = true;
		
		if (id == null || id.equals(""))
			isValid = false;
		else if (type == null || type.equals(""))
			isValid = false;
		else if (title == null || title.equals(""))
			isValid = false;
		else if (content == null || content.equals(""))
			isValid = false;
		
		if(isValid) {
			BoardRequestDto boardDto = new BoardRequestDto(id, boardNum ,title, content, type);
			BoardDao boardDao = BoardDao.getInstance();

			BoardResponseDto board = boardDao.updateBoard(boardDto);
			
			boolean isChecked = true;
			
			if(boardNum != board.getBoard_num())
				isChecked = false;
			
			if(!isChecked)
				response.sendRedirect("/home");
			
			response.sendRedirect("/board");
		}else {
			response.sendRedirect("/home");
		}
	}

}
