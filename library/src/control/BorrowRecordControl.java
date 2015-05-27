package control;

import model.BorrowRecord;
import model.Student;

import org.hibernate.Session;






import dao.BorrowRecordDAO;
import factory.HibernateSessionFactory;

public class BorrowRecordControl {
	private static BorrowRecordControl control = null; 
	public static BorrowRecordControl getBorrowRecordControl(){
		if(null==control){
			control = new BorrowRecordControl();
		}
		return control;
	}
	

	private BorrowRecordDAO borrowRecordDAO = null;
	private Session session = null;
	
	private BorrowRecordControl(){
		borrowRecordDAO = new BorrowRecordDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	public BorrowRecord addBorrowRecord(String recordID, String bookID, String stuId)
	{
		try{
			BorrowRecord borrowRecord = new BorrowRecord(recordID,bookID,stuId);
			borrowRecordDAO.save(borrowRecord);
			session.beginTransaction().commit();
			session.flush();
			return borrowRecord;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public BorrowRecord findByRecordID(String recordID)
	{
		try{
			return borrowRecordDAO.findById(recordID);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public BorrowRecord deleteBorrowRecord(BorrowRecord borr)
	{
		try{
			borrowRecordDAO.delete(borr);
			session.beginTransaction().commit();
			session.flush();
			return borr;
		}
		catch(Exception e){
			return null;
		}
	}
}
