package trm.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyContext
{
    	private ConfigurableApplicationContext context ;
    
    	public void close()
	{
	    System.out.println("Hello");
	    context.close();
	}
}
