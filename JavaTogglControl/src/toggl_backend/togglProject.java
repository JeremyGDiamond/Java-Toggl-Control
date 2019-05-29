/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toggl_backend;

import java.util.ArrayList;

/**
 *
 * @author jeremy
 */
public class togglProject {
    
    public String id = new String();
    public String name = new String();
    public ArrayList <String> descriptions = new ArrayList();
    
    togglProject ()
    {
    descriptions.add("time well spent");    
    }
    
    togglProject (String newid, String newname)
    {
        id = newid;
        
        name = newname;
        
        descriptions.add("time well spent");    
    }
    
    
}
