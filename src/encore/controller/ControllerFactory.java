package encore.controller;

import encore.model.Dao;

public class ControllerFactory {
	
	private static ControllerFactory Factory = new ControllerFactory();
	private ControllerFactory () {}
	public static ControllerFactory getInstance() {
		return Factory;
	}
	
	public Controller createController(String command) {
		// DispatcherServlet 에서 받아온 command값에 맞는 Controller 를 생성하도록 한다_ 이경우는 FindController(); 
		
		Controller controller= null;
		
		if(command.equals("find")) {  //find_notebook 에서 form 값을 보낼 때 name 이 command 고 value 가 find. 물론 hidden이라 url에서는 보이진 않지만 request에서는 가져올 수 있다
			controller = new FindController();    // find command에 맞는  Controller _ MVC 모델에서는 Servlet / FrontController 에는 하나의 Servlet 의 메서드 해당
			System.out.println("FindController Creating by factory");
		}
		return controller;
	}

}
