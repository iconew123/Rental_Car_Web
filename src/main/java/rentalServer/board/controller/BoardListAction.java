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

public class BoardListAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao = BoardDao.getInstance();
		
		List<BoardResponseDto> list = boardDao.findBoardAll();
		request.setAttribute("boardList", list);
		
		request.getRequestDispatcher("/boardlist").forward(request, response);
	}
}
