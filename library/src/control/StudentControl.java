package control;

import java.util.List;

import model.Student;

import org.hibernate.Session;

import dao.StudentDAO;
import factory.HibernateSessionFactory;

public class StudentControl {
	private static StudentControl control = null; 
	public static StudentControl getStudentControl(){
		//if(null==control){
			control = new StudentControl();
		//}
		return control;
	}
	

	private StudentDAO studentDAO = null;
	private Session session = null;
	
	private StudentControl(){
		studentDAO = new StudentDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	public Student addStudent(String stuId, String stuName)
	{
		try{
			Student student = new Student(stuId,stuName);
			studentDAO.save(student);
			session.beginTransaction().commit();
			session.flush();
			return student;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List findAllStudent()
	{
		try{
			List list = studentDAO.findAll();
			return list;
		}
		catch(Exception e){
			return null;
		}
	}
	public Student deleteStudent(String stuId, String stuName)
	{
		try{
			Student student = new Student(stuId,stuName);
			studentDAO.delete(student);
			session.clear();
			session.beginTransaction().commit();
			session.flush();
			return student;
		}
		catch(Exception e){
			return null;
		}
	}
	
}
