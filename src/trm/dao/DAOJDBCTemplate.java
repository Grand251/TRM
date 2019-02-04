package trm.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DAOJDBCTemplate 
{
	public static JdbcTemplate getJdbcTemplate()
	{
		ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-config.xml");
		return (JdbcTemplate)appContext.getBean("jtemp");
	}
}
