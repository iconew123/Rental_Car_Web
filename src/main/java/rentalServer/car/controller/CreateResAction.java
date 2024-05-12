package rentalServer.car.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalServer.car.model.CarDao;
import rentalServer.car.model.ReservationRequsetDto;
import rentalServer.car.model.ReservationResponseDto;

/**
 * Servlet implementation class CreateResAction
 */
public class CreateResAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateResAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarDao carDao = CarDao.getInstance();
		String id = request.getParameter("userid");
		int code = Integer.parseInt(request.getParameter("carCode"));
		String startDateStr = request.getParameter("startDate");
		String endDateStr = request.getParameter("endDate");

		Date startDate = Date.valueOf(startDateStr);
		Date endDate = Date.valueOf(endDateStr);


		ReservationRequsetDto reservation = new ReservationRequsetDto(id, code, startDate, endDate);
		boolean check = carDao.createRes(reservation);
		if(check) {
			response.sendRedirect("/car");
		}else {
			response.sendRedirect("/errorFailRes");
		}
	}

}
