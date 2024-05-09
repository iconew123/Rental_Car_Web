package rentalServer.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalServer.board.model.BoardDao;
import rentalServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class DeleteBoardAction
 */
public class DeleteBoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBoardAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("userId");
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		
		BoardDao boardDao = BoardDao.getInstance();

		boolean isDeleted = boardDao.deleteBoard(id,boardNum);
		
		if(isDeleted)
			response.sendRedirect("/board");
		else
			response.sendRedirect("/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("userId");
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		
		BoardDao boardDao = BoardDao.getInstance();

		boolean isDeleted = boardDao.deleteBoard(id,boardNum);
		
		if(isDeleted)
			response.sendRedirect("/board");
		else
			response.sendRedirect("/home");
	}

}
