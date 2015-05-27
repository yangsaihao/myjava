package control;

import java.util.List;

import model.Books;
import model.Student;

import org.hibernate.Session;

import dao.BooksDAO;
import dao.StudentDAO;
import factory.HibernateSessionFactory;

public class BooksControl {
	private static BooksControl control = null; 
	public static BooksControl getBooksControl(){
		//if(null==control){
			control = new BooksControl();
		//}
		return control;
	}
	

	private BooksDAO booksDAO = null;
	private Session session = null;
	
	private BooksControl(){
		booksDAO = new BooksDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	public Books addBooks(String bookId, String bookName)
	{
		try{
			Books books = new Books(bookId,bookName);
			booksDAO.save(books);
			session.beginTransaction().commit();
			session.flush();
			return books;
		}
		catch(Exception e){
			return null;
		}
	}
	public List findAllBooks()
	{
		try{
			List list = booksDAO.findAll();
			return list;
		}
		catch(Exception e){
			return null;
		}
	}
	public Books deleteBooks(String booksId, String booksName)
	{
		try{
			Books books = new Books(booksId,booksName);
			booksDAO.delete(books);
			session.beginTransaction().commit();
			session.flush();
			return books;
		}
		catch(Exception e){
			return null;
		}
	}

}
