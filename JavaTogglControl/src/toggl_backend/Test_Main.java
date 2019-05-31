/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toggl_backend;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;


/**
 *
 * @author jeremy
 */
public class Test_Main {
    public static void main(String[] args) throws ProtocolException, IOException {
        
        togglAccount testAccount = new togglAccount("naatv.jeremy@gmail.com","811312khm");
        //Universal_JSON_Body_Http_Methods testCase = new Universal_JSON_Body_Http_Methods();
        String testRet = " "; 
        ArrayList<Integer> tagIndexs = new ArrayList();
        ArrayList<String> getInfo = new ArrayList();
        ArrayList<ArrayList> compoundList = new ArrayList();
        
        tagIndexs.add(0);
        tagIndexs.add(3);
        tagIndexs.add(2);
        
        //testAccount.currentTimer();
        //testAccount.stopCurrent();
        testAccount.readAllProjects();
        testAccount.readAllTags();
        //for (int i = 0; i < testAccount.tags.size(); ++i ) //tags m,ust be made public for this to work
            //System.out.print((testAccount.tags.get(i).name)+"\n");
       // testRet = testCase.Universal_Post("https://www.toggl.com/api/v8/time_entries/start","{\"time_entry\":{\"description\" : \"test description\", \"pid\" : 12345678, \"created_with\" : \"java\"}}","1234567890abcdefghijklmnopqrstuv","api_token");
        //System.out.print(testRet);
        //testAccount.startATimer(0, 0);
       // testRet = testCase.Universal_Put("https://www.toggl.com/api/v8/time_entries/897164346/stop","1234567890abcdefghijklmnopqrstuv","api_token");
       //testAccount.startATimerWithTags(0, 0, tagIndexs);
       getInfo = testAccount.getAProjectsData(0);
       
       for (int i = 0; i < getInfo.size(); i++)
           System.out.print(getInfo.get(i)+", ");
       
       
       System.out.print("\n\n");
       getInfo = testAccount.getATagsData(0);
       
       for (int i = 0; i < getInfo.size(); i++)
           System.out.print(getInfo.get(i)+", ");
       
       System.out.print("\n\n");
       compoundList = testAccount.getAllTagsData(tagIndexs);
       
       for (int j = 0; j <compoundList.size() ; j++){
            for (int i = 0; i < compoundList.get(j).size(); i++){
                System.out.print(compoundList.get(j).get(i)+", ");
            }
            System.out.print("\n");

       }
       
       System.out.print("\n\n");
       compoundList = testAccount.getAllProjectsData(tagIndexs);
       
       for (int j = 0; j <compoundList.size() ; j++){
            for (int i = 0; i < compoundList.get(j).size(); i++){
                System.out.print(compoundList.get(j).get(i)+", ");
            }
            System.out.print("\n");

       }
    }
    
}  
