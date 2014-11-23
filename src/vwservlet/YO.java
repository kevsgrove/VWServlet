package vwservlet;

import java.net.*;
import java.io.*;
import java.security.*;
import javax.net.ssl.*;
public class YO  {
    public YO() {
    }
    
    //static String[] users;
    	
    	public void YoInfo() throws IOException{
    		
         
          String url = "https://api.justyo.co/yoall/";
          URL obj = new URL(url);
          HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
          con.setRequestMethod("POST");
         // String[] ac = {"TEAMWEREWOLF", "MIGUELINNII", "MYEPEZ", "KEVSGROVE"};
          
          String urlParameters = "api_token=3e712cda-c7cd-4f7f-8751-0ba54e9abb2c&username=VWHACK";
          con.setDoOutput(true);
          DataOutputStream wr = new DataOutputStream(con.getOutputStream());
          wr.writeBytes(urlParameters);
          wr.flush();
          wr.close();
          int responseCode = con.getResponseCode();
          System.out.print(responseCode);
          BufferedReader in = new BufferedReader(
                  new InputStreamReader(con.getInputStream()));
          String inputLine;
          StringBuffer response = new StringBuffer();
          while ((inputLine = in.readLine()) != null) {
              response.append(inputLine);
          }
          in.close();
  }
 }