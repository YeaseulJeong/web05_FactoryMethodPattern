package encore.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encore.model.Dao;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DispatcherServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성..
		
		//1. command 값 받는다
		String command = request.getParameter("command");
		String path = "erro.jsp";
		
		//2. Factory 의 메서드 호출해서 Controller 리턴 받는다
		Controller controller = ControllerFactory.getInstance().createController(command);   
		// 인터페이스(부모??) 타입으로  객체를 생성하고 받으니까 command 마다/ login/ logout/ update/ delete/ find 마다 코드를 안쳐줘도 된다  _ 재사용성 중요!!!!!
		// 만약에 FindController타입으로 받고 FindController.execute () 를 하면 Controller 마다 코드를 일일이 쳐줘야 한다 
		// 근데 interface 타입으로 해놓으면 이렇게 한번만 치면 됨_끝
		
		
		//3. Controller 의 메서드 호출해서 패스를 리턴 받는다 
		try {
			path = controller.execute(request, response);
			
		}catch(SQLException e) {
			
		}
		
		//4. 네비게이션 (결과 jsp 들로_ path 에 담음)
		//각각의 Controller 에서 setAttribute 를 한 것에 대한 것 
		// idCheckController 에서는 flag 값을 idcheck.jsp 로 forwarding 함
		request.getRequestDispatcher(path).forward(request, response);
	}


}
