/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toggl_backend;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.ArrayList;

/**
 *
 * @author jeremy
 */
public class togglAccount {
                            
    private String uName;
    private String password = "api_token";
    private ArrayList <togglProject> projects = new ArrayList();
    private ArrayList <togglTag> tags = new ArrayList();
   
    
    
    public togglAccount(String api_key){
        uName = api_key;
    }
    
      public togglAccount(String user_name, String user_password) throws ProtocolException, IOException{
        uName = getApiToken(user_name, user_password);
        
    }
    
    public String getApiToken (String user_name, String user_password)throws ProtocolException, IOException{
        String output =  Universal_JSON_Body_Http_Methods.Universal_Get("https://www.toggl.com/api/v8/me",user_name,user_password);
        return output.substring(output.indexOf("api_token")+12,output.indexOf("api_token")+44);
    }
      
    public void currentTimer () throws ProtocolException, IOException
    {
        String output =  Universal_JSON_Body_Http_Methods.Universal_Get("https://www.toggl.com/api/v8/time_entries/current",uName,password);
        //System.out.println(output);
        
        if ("{\"data\":null}".equals(output))
        {
            System.out.println("no current timer");
            
        }
        else
        {
        
        int startLoc = output.indexOf("description");
        startLoc += ("description".length() + 3);
        int endLoc = output.indexOf("\"", startLoc);
        
        String description = output.substring(startLoc, endLoc);
        //System.out.println(description);
        
        startLoc = output.indexOf("pid");
        startLoc += ("pid".length() + 2);
        endLoc = output.indexOf(",", startLoc);
        
        String pid = output.substring(startLoc, endLoc);
        //System.out.println(pid);
        
        startLoc = output.indexOf("duration");
        startLoc += ("duration".length() + 2);
        endLoc = output.indexOf(",", startLoc);
        
        
        String duration = output.substring(startLoc, endLoc);
        long negitiveDuration = Long.parseLong(duration);
        long epoch = System.currentTimeMillis()/1000;
        
        long numofsec = epoch + negitiveDuration ;
        long numofmin = numofsec/60;
        numofsec = numofsec - (numofmin*60);
        long numofhr = numofmin/60;
        numofmin = numofmin - (numofhr*60);
        
        
        output = Universal_JSON_Body_Http_Methods.Universal_Get("https://www.toggl.com/api/v8/projects/"+pid,uName,password);
        //System.out.println(output);
        
        startLoc = output.indexOf("name");
        startLoc += ("name".length() + 3);
        endLoc = output.indexOf("\"", startLoc);
        
        String name = output.substring(startLoc, endLoc);
        System.out.println(name);
        
        System.out.println(numofhr + ":" + numofmin + ":" + numofsec);
        }
    }
    
    public void stopCurrent () throws ProtocolException, IOException
    {
        String output = Universal_JSON_Body_Http_Methods.Universal_Get("https://www.toggl.com/api/v8/time_entries/current",uName,password);
        System.out.println(output);
        
        if ("{\"data\":null}".equals(output))
        {
            System.out.println("no current timer");
            
        }
        else
        {
        int startLoc = output.indexOf("id");
        startLoc += ("id".length() + 2);
        int endLoc = output.indexOf(",", startLoc);
        
        String id = output.substring(startLoc, endLoc);
        
        output = Universal_JSON_Body_Http_Methods.Universal_Get("https://www.toggl.com/api/v8/time_entries/"+id+"/stop",uName,password);
        System.out.println(output);
        }
    }
    
    public void addProjectToDatabase(String newId,String newName)
    {
        togglProject tempProj = new togglProject(newId,newName);
    }
    
    public void addTagToDatabase(String newId,String newName)
    {
        togglTag tempTag = new togglTag(newId,newName); 
    }
    
    public void readAllProjects() throws ProtocolException, IOException
    {
        togglProject tempProject;
        String id;
        String name;
        
        String output  = Universal_JSON_Body_Http_Methods.Universal_Get("https://www.toggl.com/api/v8/me",uName,password);
        //System.out.println(output); 
        
        int startLoc = output.indexOf("wid");
        startLoc += ("wid".length() + 2);
        int endLoc = output.indexOf(",", startLoc);
        
        String wid = output.substring(startLoc, endLoc);
        
        output = Universal_JSON_Body_Http_Methods.Universal_Get("https://www.toggl.com/api/v8/workspaces/"+ wid +"/projects",uName,password);
        
        //System.out.println(output);
        
        while (output.contains("name"))
        {
        
            startLoc = output.indexOf("id");
            startLoc += ("id".length() + 2);
            endLoc = output.indexOf(",", startLoc);

            id = output.substring(startLoc, endLoc);

            startLoc = output.indexOf("name");
            startLoc += ("name".length() + 3);
            endLoc = output.indexOf("\"", startLoc);

            name = output.substring(startLoc, endLoc);

            output = output.substring(endLoc);
            
            tempProject = new togglProject(id,name);
            projects.add(tempProject);
        }
    }
    
    public void readAllTags() throws ProtocolException, IOException
    {
        togglTag tempTag;
        String id;
        String name;
        
        String output  = Universal_JSON_Body_Http_Methods.Universal_Get("https://www.toggl.com/api/v8/me",uName,password);
        //System.out.println(output); 
        
        int startLoc = output.indexOf("wid");
        startLoc += ("wid".length() + 2);
        int endLoc = output.indexOf(",", startLoc);
        
        String wid = output.substring(startLoc, endLoc);
        
        output = Universal_JSON_Body_Http_Methods.Universal_Get("https://www.toggl.com/api/v8/workspaces/"+ wid +"/tags",uName,password);
        
        //System.out.println(output);
        
        while (output.contains("name"))
        {
        
            startLoc = output.indexOf("id");
            startLoc += ("id".length() + 2);
            endLoc = output.indexOf(",", startLoc);

            id = output.substring(startLoc, endLoc);

            startLoc = output.indexOf("name");
            startLoc += ("name".length() + 3);
            endLoc = output.indexOf("\"", startLoc);

            name = output.substring(startLoc, endLoc);

            output = output.substring(endLoc);
            
            tempTag = new togglTag(id,name);
            tags.add(tempTag);
        }
       
    }
    
    public ArrayList<String> getAProjectsData(int index)
    {
        ArrayList<String> projectInfo = new ArrayList();
        
        projectInfo.add(projects.get(index).id);
        projectInfo.add(projects.get(index).name);
        
        int desListSize = projects.get(index).descriptions.size();
        
        for (int i = 0; i < desListSize; ++i)
        {
            projectInfo.add(projects.get(index).descriptions.get(i));
        }
        
        return projectInfo;
    }
    
    public ArrayList<String> getATagsData(int index)
    {
        ArrayList<String> tagInfo = new ArrayList();
        
        tagInfo.add(tags.get(index).id);
        tagInfo.add(tags.get(index).name);
        
        
        return tagInfo;
    }
    
    public ArrayList<ArrayList> getAllTagsData(ArrayList<Integer> indexs)
    {
        ArrayList<ArrayList> allTags = new ArrayList();
        ArrayList<String> tagInfo;
        
        for (int i = 0; i < tags.size(); ++i)
        {
            tagInfo = getATagsData(i);
            allTags.add(tagInfo);
        }
        
        return allTags;
    }
    
        public ArrayList<ArrayList> getAllProjectsData(ArrayList<Integer> indexs)
    {
        ArrayList<ArrayList> allProjects = new ArrayList();
        ArrayList<String> projectInfo;
        
        for (int i = 0; i < projects.size(); ++i)
        {
            projectInfo = getAProjectsData(i);
            allProjects.add(projectInfo);
        }
        
        return allProjects;
    }
    
    public void startATimer(int projectIndex, int desriptionIndex) throws MalformedURLException, IOException
    {
        Universal_JSON_Body_Http_Methods.Universal_Post("https://www.toggl.com/api/v8/time_entries/start","{\"time_entry\":{\"description\" : \""+projects.get(projectIndex).descriptions.get(desriptionIndex)+"\", \"pid\" : "+ projects.get(projectIndex).id + ", \"created_with\" : \"java\"}}", uName, password);
    }

    public void startATimerWithTags(int projectIndex, int desriptionIndex,ArrayList<Integer> tagIndexs) throws MalformedURLException, IOException
    {
        String tagString = "\"tags\":[" ; 
        for (int i = 0; i < tagIndexs.size(); ++i)
        {
           tagString = tagString + "\""+ tags.get(tagIndexs.get(i)).name + "\",";
        }
        
        tagString = tagString.substring(0,tagString.lastIndexOf(",")-1) + tagString.substring(tagString.lastIndexOf(",")+1);
        
        tagString = tagString + "\"],";
        
        //System.out.print(tagString);
        
        Universal_JSON_Body_Http_Methods.Universal_Post("https://www.toggl.com/api/v8/time_entries/start","{\"time_entry\":{\"description\" : \""+projects.get(projectIndex).descriptions.get(desriptionIndex)+"\"," + tagString + "\"pid\" : "+ projects.get(projectIndex).id + ", \"created_with\" : \"java\"}}", uName, password);
    }
}
