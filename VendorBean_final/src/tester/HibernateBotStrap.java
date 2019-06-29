
package tester;

import static utils.HibernateUtils.*;

import org.hibernate.SessionFactory;

public class HibernateBotStrap {
	
	public static void main(String[] args)
	{
		try(SessionFactory sf=getSf())
		{
			System.out.println("Hibernated created");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
