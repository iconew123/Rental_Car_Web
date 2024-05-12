package rentalServer.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalServer.car.model.CarDao;
import rentalServer.car.model.ReservationResponseDto;

/**
 * Servlet implementation class MyPageAction
 */
public class MyPageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarDao carDao = CarDao.getInstance();
		String id = request.getParameter("user");
		
		List<ReservationResponseDto> list = carDao.findReservation(id);
		request.setAttribute("myReserve", list);
		//System.out.println("D:"+list.get(0).getCarName());
		if(list==null) {
			response.sendRedirect("/errLoadMyPage");
		}else {
			request.getRequestDispatcher("/myPage").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
