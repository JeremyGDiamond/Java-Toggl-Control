/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toggl_backend;

import java.io.IOException;
import java.net.ProtocolException;


/**
 *
 * @author jeremy
 */
public class Test_Main {
    public static void main(String[] args) throws ProtocolException, IOException {
        
        togglAccount testAccount = new togglAccount("naatv.jeremy@gmail.com","811312khm");
        //Universal_JSON_Body_Http_Methods testCase = new Universal_JSON_Body_Http_Methods();
        String testRet = " "; 
        
        //testAccount.currentTimer();
        //testAccount.stopCurrent();
        testAccount.readAllProjects();
        testAccount.readAllTags();
        for (int i = 0; i < testAccount.tags.size(); ++i )
            System.out.print((testAccount.tags.get(i).name)+"\n");
       // testRet = testCase.Universal_Post("https://www.toggl.com/api/v8/time_entries/start","{\"time_entry\":{\"description\" : \"test description\", \"pid\" : 12345678, \"created_with\" : \"java\"}}","1234567890abcdefghijklmnopqrstuv","api_token");
        //System.out.print(testRet);
        testAccount.startATimer(0, 0);
       // testRet = testCase.Universal_Put("https://www.toggl.com/api/v8/time_entries/897164346/stop","1234567890abcdefghijklmnopqrstuv","api_token");
        System.out.print(testRet);
    }
    
}  
