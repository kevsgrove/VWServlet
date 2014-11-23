package vwservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Servlet implementation class Bite
 */
public class Bite extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bite() {
    	super();
    	
    	
    	
  /* YO yo = new YO();
   try {
	   yo.YoInfo();
   }
   catch (IOException e) {
	// TODO Auto-generated catch block
	   e.printStackTrace();
   }*/
      
   
   
        // TODO Auto-generated constructor stub
    }
    
    static final String dbURL = "jdbc:mysql://localhost:3306/yohackvw";
    static final String username ="root";
    static final String password = "yohack";
    static boolean vampFlop=true;
    YO yo = new YO();
    static ArrayList<Player> pList = new ArrayList<Player>();
    
    protected void biteHandler(String p1, String p2){
    	
    	/*
    	PoolProperties p = new PoolProperties();
        p.setUrl("jdbc:mysql://localhost:3306/yohackvw");
        p.setDriverClassName("com.mysql.jdbc.Driver");
        p.setUsername("root");
        p.setPassword("password");
        p.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
                "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        DataSource datasource = new DataSource();
        datasource.setPoolProperties(p);
    	
    	
    	
    	String query;
    	String ret="-";
    	Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
    	try{
    	    //Class.forName("com.mysql.jdbc.Driver");
    		query="select health from yohackvw.players where tagid='"+p2+"';";
    		dbCon = datasource.getConnection();
            stmt = dbCon.createStatement();
            rs = stmt.executeQuery(query);
            if(rs.getInt(1)>10){
            	
            }
            rs.next();
            int r=rs.getInt("health");
            Integer re=r;
            ret=re.toString();
            //ret=query;
            
            
    	}
    	catch (Exception ex){
    		ex.printStackTrace();
    	}
    	
    	
    	
    	//sql query health of p2
    	//if(health>10) health-=10;
    	//else {
    	//health=0;
    	//sql query get team of p2
    	//sql get users on p2's team
    	//send yo to users
    	//}
    	//sql update health of p2
    	
    	
    	*/
    	int c=0;
    	for(Player p : pList){
    		if(p.id.equals(p2)){
    			if(p.health>20)
    				p.health-=20;
    			else{
    				p.health=0;
    				try {
    					yo.YoInfo();
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
    			}
			}
    		if(p.health>0) c++;
    	}
    	if(c<=1){
    		endgame();
    	}
    	
    }
    
    protected void endgame(){
    	pList.clear();
    	
    }
    
    protected void setPlayerId(String id, String youser){
    	pList.add(new Player(youser, id, vampFlop));
    	vampFlop=!vampFlop;
    	//YO.users[YO.users.length]=youser;
    	//sql query where yousername=youser
    	//sql set that player's id
    	//add youser to yo list
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String par1 =  request.getParameter("p1");
		String par2 =  request.getParameter("p2");
	    if(Character.isLowerCase(par2.charAt(0))){
	    	out.println(par1);
	    	setPlayerId(par1, par2);
	    }
	    else if (par1.equals(par2))
	    	out.println(par1+"-self bite");
	    else {
	    	out.println(par1+"-"+par2);
	    	biteHandler(par1, par2);
	    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
