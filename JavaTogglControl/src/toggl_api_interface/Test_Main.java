/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toggl_api_interface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ProtocolException;
import java.util.ArrayList;


/**
 *
 * @author jeremy
 */
public class Test_Main {
    public static void main(String[] args) throws ProtocolException, IOException {
        
        //make variables for testing
            String uName = new String();
            String pWord = new String();
        
        //read login from the console
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("What's your email");
            
            uName = reader.readLine();
            
            System.out.println("What's your password");
            
            pWord = reader.readLine();
            
        //create new account object
            togglAccount testAccount = new togglAccount(uName,pWord);
            
            testAccount.readAllProjects();
            testAccount.readAllTags();
       
        //testing all universal json body http methods methods
        
            //Universal_Post is made use of by togglAccount.startATimer
                testAccount.startATimer(0,0);
        
            //Universal_Get is made use of in togglAccount.currentTimer
                System.out.println(testAccount.currentTimer());
            
            //Universal_Put not currently used
        
        //testing all project methods
        
            
        
        //testing all tag methods
       
        //testing all account methods
    }

   
    
}  
