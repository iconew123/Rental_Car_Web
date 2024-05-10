package rentalServer.car.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalServer.car.model.CarDao;
import rentalServer.car.model.CarResponseDto;

/**
 * Servlet implementation class FindCarList
 */
public class FindCarList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCarList() {
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
		
		CarDao carDao = CarDao.getInstance();
		String type = request.getParameter("type");
		String brand = request.getParameter("brand");
		String price = request.getParameter("price");
		
		System.out.println(type);
		System.out.println(brand);
		System.out.println(price);
		
		List<CarResponseDto> list = carDao.findCar(type, brand, price);
		
		request.setAttribute("car", list);
		
		request.getRequestDispatcher("/carlist").forward(request, response);
		
		
	}

}
