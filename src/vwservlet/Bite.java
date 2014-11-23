package vwservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        // TODO Auto-generated constructor stub
    }
    
    static final String dbURL = "jdbc:mysql://localhost:3306/yohackvw";
    static final String username ="root";
    static final String password = "yohack";
    
    protected void biteHandler(String p1, String p2){
    	//sql query health of p2
    	//if(health>10) health-=10;
    	//else {
    	//health=0;
    	//sql query get team of p2
    	//sql get users on p2's team
    	//send yo to users
    	//}
    	//sql update health of p2
    }
    
    protected void setPlayerId(String id, String youser){
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
