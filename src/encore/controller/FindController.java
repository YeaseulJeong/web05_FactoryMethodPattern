package encore.controller;

import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.naming.ContextAccessController;

import encore.model.Dao;
import encore.model.NoteBook;

public class FindController implements Controller{   
	// 즉, ControllerFactory 나 ActionFactory에서 생성된 Contorller/Action 인터페이스를 구현한 각각의
	// 세부 component들은 결국 DAO에서 비즈니스 로직 중 하나를 호출/사용하는 걸 목표로 만들어진 것

	/*
	 * 1. 폼값 받아서  "model"
	 * 2. dao 리턴 _ 비즈니스 로직 호출 
	 * 3. return 값 바인딩
	 * 4. path....find_result.jsp
	 */
	
	public String execute(HttpServletRequest request, HttpServletResponse rewponse) throws SQLException{

	String path ="find_fail.jsp";
	String model = request.getParameter("model2");   // 처음 browser 에서부터 받아올 수 있음 execute(HttpServletRequest request, HttpServletResponse rewponse)
	NoteBook nb = Dao.getInstance().findNoteBook(model);    //비즈니스로직 이렇게 실한다고치고
	request.setAttribute("nb",nb);
	path = "find_result.jsp";
	
	return path;
	
	}
	

}
