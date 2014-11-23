package vwservlet;

public class Player {
	static String yoName;
	static String id;
	static boolean vamp;
	static Integer health;
	
	
	public Player(String yo, String uid, boolean v) {
	    yoName=yo;
	    health=100;
	    id=uid;
	    vamp=v;
	}
}
