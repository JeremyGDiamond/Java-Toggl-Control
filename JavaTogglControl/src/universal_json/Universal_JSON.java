/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universal_json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;

/**
 *
 * @author jdiamond
 */


public class Universal_JSON {

    /**
     * @param args the command line arguments
     */
    
    
    
    
    public static String Universal_Get(String urlString, String userName, String password ) throws MalformedURLException, ProtocolException, IOException
    {
     //String urlString = "https://www.toggl.com/api/v8/workspaces/1234567/projects";
     //String userName = "1234567890abcdefghijklmnopqrstuv";
     //String password = "api_token";

    // open url connection
    URL url = new URL( urlString );
    HttpURLConnection con = (HttpURLConnection) url.openConnection();

    // set up url connection to get retrieve information back
    con.setRequestMethod( "GET" );
    con.setDoInput( true );

    // stuff the Authorization request header
    byte[] encodedPassword = ( userName + ":" + password ).getBytes();
   
    con.setRequestProperty( "Authorization","Basic " + Base64.getEncoder().encodeToString(encodedPassword ) );

    // pull the information back from the URL
    InputStream is = con.getInputStream();
    StringBuffer buf = new StringBuffer();
    int c;
    while( ( c = is.read() ) != -1 ) {
      buf.append( (char) c );
        }
    con.disconnect();

    // output the information
    int indent = 0;
    int locate = 0;
    String raw = buf.toString();
   
    return (raw);
    
    }
    
    public static String Universal_Put(String urlString, String userName, String password ) throws MalformedURLException, ProtocolException, IOException
    {
     //String urlString = "https://www.toggl.com/api/v8/workspaces/1234567/projects";
     //String userName = "1234567890abcdefghijklmnopqrstuv";
     //String password = "api_token";

    // open url connection
    URL url = new URL( urlString );
    HttpURLConnection con = (HttpURLConnection) url.openConnection();

    // set up url connection to get retrieve information back
    con.setRequestMethod( "PUT" );
    con.setDoInput( true );

    // stuff the Authorization request header
    byte[] encodedPassword = ( userName + ":" + password ).getBytes();
   
    con.setRequestProperty( "Authorization","Basic " + Base64.getEncoder().encodeToString(encodedPassword ) );

    // pull the information back from the URL
    InputStream is = con.getInputStream();
    StringBuffer buf = new StringBuffer();
    int c;
    while( ( c = is.read() ) != -1 ) {
      buf.append( (char) c );
        }
    con.disconnect();

    // output the information
    int indent = 0;
    int locate = 0;
    String raw = buf.toString();
   
    return (raw);
    
    }
    
    public static String Universal_Post(String query_url,String json,String userName,String password) throws ProtocolException, MalformedURLException, IOException
    {
        //String query_url = "https://www.toggl.com/api/v8/time_entries/start";
        //String json = "{\"time_entry\":{\"description\" : \"test description\", \"pid\" : 12345678, \"created_with\" : \"java\"}}";
        //String userName = "1234567890abcdefghijklmnopqrstuv";
        //String password = "api_token";
           
           URL url = new URL(query_url);
           HttpURLConnection conn = (HttpURLConnection) url.openConnection();
           
            byte[] encodedPassword = ( userName + ":" + password ).getBytes();
            conn.setRequestProperty( "Authorization","Basic " + Base64.getEncoder().encodeToString(encodedPassword ) );
           
           conn.setConnectTimeout(5000);
           conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
           conn.setDoOutput(true);
           conn.setDoInput(true);
           conn.setRequestMethod("POST");
           OutputStream os = conn.getOutputStream();
           os.write(json.getBytes("UTF-8"));
           os.close(); 
           // read the response
           InputStream in = conn.getInputStream();
           
           String UTF8 = "utf8";
           int BUFFER_SIZE = 8192;

            BufferedReader br = new BufferedReader(new InputStreamReader(in,UTF8), BUFFER_SIZE);
           
           String raw = br.readLine();
           
           in.close();
           conn.disconnect();
           
           return (raw);
           
       
    }
    
}
