package trm.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DAOJDBCTemplate 
{
    private ApplicationContext appContext;
    
    public JdbcTemplate getJdbcTemplate()
    {
	appContext = new ClassPathXmlApplicationContext("spring-config.xml");
	return (JdbcTemplate)appContext.getBean("jTemp");
    }
    
    /*
    public void close()
    {
	System.out.println("Close method is called.");
	((ConfigurableApplicationContext) appContext).close();
    }
    */
}
