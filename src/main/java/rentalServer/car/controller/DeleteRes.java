package rentalServer.car.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalServer.car.model.CarDao;

/**
 * Servlet implementation class DeleteRes
 */
@WebServlet("/DeleteRes")
public class DeleteRes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRes() {
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
		
		String id = request.getParameter("user");
		int code = Integer.parseInt(request.getParameter("code"));
		String myStartDateStr = request.getParameter("start");
		String myEndDateStr = request.getParameter("end");
		
		Date myStartDate = Date.valueOf(myStartDateStr);
		Date myEndDate = Date.valueOf(myEndDateStr);
		
		boolean check = carDao.deleteRes(id, code, myStartDate, myEndDate);
		if(check) {
			response.sendRedirect("/car");
		}else {
			response.sendRedirect("/errorFailRes");
		}
	}

}
