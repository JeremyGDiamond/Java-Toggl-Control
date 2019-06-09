
package toggl_backend;

import java.util.ArrayList;

/**
*This is a ADT to hold the info for projects
*   
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
