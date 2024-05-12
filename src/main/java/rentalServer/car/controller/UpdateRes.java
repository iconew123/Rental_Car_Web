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

/**
 * Servlet implementation class UpdateRes
 */
public class UpdateRes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRes() {
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
		CarDao carDao = CarDao.getInstance();
		String id = request.getParameter("userid");
		int code = Integer.parseInt(request.getParameter("carCode"));
		String startDateStr = request.getParameter("startDate");
		String endDateStr = request.getParameter("endDate");
		String myStartDateStr = request.getParameter("myStart");
		String myEndDateStr = request.getParameter("myEnd");
		
		Date startDate = Date.valueOf(startDateStr);
		Date endDate = Date.valueOf(endDateStr);
		Date myStartDate = Date.valueOf(myStartDateStr);
		Date myEndDate = Date.valueOf(myEndDateStr);


		ReservationRequsetDto reservation = new ReservationRequsetDto(id, code, startDate, endDate);
		boolean check = carDao.createRes(reservation);
		if(check) {
			boolean dCheck = carDao.deleteRes(id,code,myStartDate,myEndDate);
			if(dCheck) {				
				response.sendRedirect("/car");
			}else {				
				response.sendRedirect("/errorFailRes");
			}
		}else {
			response.sendRedirect("/errorFailRes");
		}
	}

}
