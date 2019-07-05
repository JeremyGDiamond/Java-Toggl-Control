/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestMain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.util.ArrayList;
import toggl_api_interface.togglAccount;


/**
 *
 * @author jeremy
 */
public class Main {
    public static void main(String[] args) throws ProtocolException, IOException {
        
        //make variables for testing
            String uName;
            String pWord;
        
        //read login from the console
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("What's your email");
            
            uName = reader.readLine();
            
            System.out.println("What's your password");
            
            pWord = reader.readLine();
            
        //create new account object
            togglAccount testAccount = new togglAccount(uName,pWord);
            
            //read projects and tags from toggl server
            testAccount.readAllProjects();
            testAccount.readAllTags();
       
        //testing all universal json body http methods methods
        
            //Universal_Post is made use of by togglAccount.startATimer
                testAccount.startATimer(0,0);
        
            //Universal_Get is made use of in togglAccount.currentTimer
                System.out.println(testAccount.currentTimer());
            
            //Universal_Put not currently used
      
        //testing all account methods
        	
            // togglAccount(String api_key)
                // first constructor takes api key and builds account

            // togglAccount(String user_name, String user_password) SEE ABOVE USE 
                // second constructor takes user name and password then builds account

            // String getApiToken (String user_name, String user_password) used in second constructor
                // retreives api key from server

            // String currentTimer ()
                // retreives current timer from server

            // void stopCurrent ()
                // stops current timer on server

            // void addProjectToDatabase(String newId,String newName)
                // adds project to internal list of projects

            // void addTagToDatabase(String newId,String newName)
                // adds tag to internal list of tag
                
            // void RemoveTagFromDatabase(int tagIndex)

            // void RemoveProjectFromDatabase(int projectIndex)

            // void readAllProjects() 

            // void readAllTags() 

            // ArrayList<String> getAProjectsData(int index)

            // ArrayList<String> getATagsData(int index)

            // ArrayList<ArrayList> getAllTagsData(ArrayList<Integer> indexs)

            // ArrayList<ArrayList> getAllProjectsData(ArrayList<Integer> indexs)

            // ArrayList<String> getAllDescriptionsFromAProject(int projectIndex)

            // void setAllDescriptionsFromAProject(int projectIndex, ArrayList<String> newDescrips)

            // void startATimer(int projectIndex, int desriptionIndex) SEE ABOVE USE,

            // void startATimerWithTags(int projectIndex, int desriptionIndex,ArrayList<Integer> tagIndexs)
    }

   
    
}  
