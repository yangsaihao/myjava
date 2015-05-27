package control;

import java.util.List;

import model.Manager;

import org.hibernate.Session;

import dao.ManagerDAO;
import factory.HibernateSessionFactory;

public class ManagerControl {
	private static ManagerControl control = null; 
	public static ManagerControl getManagerControl(){
		if(null==control){
			control = new ManagerControl();
		}
		return control;
	}
	

	private ManagerDAO managerDAO = null;
	private Session session = null;
	
	private ManagerControl(){
		managerDAO = new ManagerDAO();
		session = HibernateSessionFactory.getSession();
	}
	

    
	public Manager getManagerByName(String username){
		try{
			return (Manager)managerDAO.findByProperty("userName",username).get(0);
		}
		catch(Exception e){
			return null;
		}	

	}
	
	public static Boolean isUser(String username,String password)
	{
		try{
			Manager manager = ManagerControl.getManagerControl().getManagerByName(username);
			if(password.equals(manager.getPassward()))
				return true;
				else
					return false;
		}catch(Exception e){
			return false;
		}
		
	}

}
