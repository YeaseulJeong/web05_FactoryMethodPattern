package encore.model;

import java.sql.SQLException;

public class Dao {
	// singletone 으로 작성
	private static Dao dao = new Dao();
	private Dao () {}
	public static Dao getInstance() {
		return dao;
	}
	
	// CRUD 로직을 원래 여기서 구현해야 하는데 이번에는 한개만 했다.
	// 비즈니스 로직 : findNoteBook(model)
	public NoteBook findNoteBook(String model) throws SQLException{
		// DB 연결됐다고 치고 쿼리문 가동됐다고 치고
		System.out.println(model);
		
		NoteBook nb = new NoteBook(model, 15000000);
		return nb;
	}
	

}
