package rentalServer.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalServer.board.model.BoardDao;
import rentalServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class FindBoardList
 */
public class FindBoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao = BoardDao.getInstance();
		String type = request.getParameter("type");
		System.out.println(type);
		
		List<BoardResponseDto> list = boardDao.findBoard(type);
		request.setAttribute("boardList", list);
		
		request.getRequestDispatcher("/boardlist").forward(request, response);
	}


}
