package trm.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class MyContext
{
    	//private ConfigurableApplicationContext context ;
    	private JdbcTemplate jTemp = new DAOJDBCTemplate().getJdbcTemplate();
    	public int getActiveConnectionCount()
	{
	    Integer numberOfConnections = jTemp.queryForObject("select count(*) from v$session where osuser = 'syntel' group by username, osuser order by count(*) desc", Integer.class);
	    return numberOfConnections.intValue();
	}
        
    	/*
    	public void close()
	{
	    System.out.println("Hello");
	    context.close();
	}
	*/
}
