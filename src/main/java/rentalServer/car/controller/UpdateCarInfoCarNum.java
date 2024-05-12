package rentalServer.car.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalServer.car.model.CarDao;
import rentalServer.car.model.CarResponseDto;
import rentalServer.car.model.ReservationResponseDto;

/**
 * Servlet implementation class UpdateCarInfoCarNum
 */
public class UpdateCarInfoCarNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCarInfoCarNum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarDao carDao = CarDao.getInstance();
		int code = Integer.parseInt(request.getParameter("code"));
		String id = request.getParameter("user");
		String myStartDateStr = request.getParameter("start");
		String myEndDateStr = request.getParameter("end");

		Date myStartDate = Date.valueOf(myStartDateStr);
		Date myEndDate = Date.valueOf(myEndDateStr);

		if(id.equals("")) {
			System.out.println("비로그인");
			response.sendRedirect("/errorPageLogin");
		}else {
			System.out.println("로그인");
			CarResponseDto carInfo = carDao.carInfoByCode(code);
			ReservationResponseDto resInfo = carDao.resDateCarCode(code);
			ReservationResponseDto curRes = carDao.curReservation(id,code,myStartDate,myEndDate);
			if(resInfo == null) {				
				request.setAttribute("totalResDate", null);
			}else {				
				request.setAttribute("totalResDate", resInfo);
			}
			request.setAttribute("carInfo", carInfo);
			request.setAttribute("resDay", curRes);
			
			request.getRequestDispatcher("/updateCar").forward(request, response);
		}
	}

}
