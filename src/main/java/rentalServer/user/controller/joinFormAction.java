package rentalServer.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalServer.user.model.UserDao;
import rentalServer.user.model.UserRequestDto;
import rentalServer.user.model.UserResponseDto;

/**
 * Servlet implementation class joinFormAction
 */
public class joinFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinFormAction() {
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
		
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String birth1 = request.getParameter("birth1");
		String birth2 = request.getParameter("birth2");
		String telecom = request.getParameter("telecom");
		String phone = request.getParameter("phone");
		
		boolean isValid = true;
		
		if(id == null || id.equals(""))
			isValid = false;
		else if(pw == null || pw.equals(""))
			isValid = false;
		else if(email == null || email.equals(""))
			isValid = false;
		else if(name == null || name.equals(""))
			isValid = false;
		else if(birth1 == null || birth1.equals(""))
			isValid = false;
		else if(birth2 == null || birth2.equals(""))
			isValid = false;
		else if(telecom == null || telecom.equals(""))
			isValid = false;
		else if(phone == null || phone.equals(""))
			isValid = false;
		
		if(isValid) {
			UserRequestDto userDto = new UserRequestDto(id, pw, name, birth1+"-"+birth2, email, phone, telecom);
			UserDao userDao = UserDao.getInstance();
			
			UserResponseDto user = userDao.createUser(userDto);
			if(user == null) {
				// 실패
				System.out.println("조인실패");
				response.sendRedirect("/home");
			} else {
				// 성공
				System.out.println("조인성공");
				response.sendRedirect("/loginForm");			
			}
		}else {
			response.sendRedirect("/home");
		}
	}

}
