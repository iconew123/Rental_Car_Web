package rentalServer.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalServer.user.model.UserDao;
import rentalServer.user.model.UserRequestDto;
import rentalServer.user.model.UserResponseDto;


/**
 * Servlet implementation class deleteFormAction
 */
public class deleteFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteFormAction() {
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

		UserDao userDao = UserDao.getInstance();
		HttpSession session = request.getSession();
		
		UserResponseDto user = (UserResponseDto) session.getAttribute("user");

		String id = user.getId();
		String password = request.getParameter("password");

		UserRequestDto userDto = new UserRequestDto();

		userDto.setId(id);
		userDto.setPw(password);

		boolean result = userDao.deleteUser(userDto);

		if(result) {
			session.removeAttribute("user");
			response.sendRedirect("/home");
		} else {	
			response.sendRedirect("/myPage");
		}
	}

}
