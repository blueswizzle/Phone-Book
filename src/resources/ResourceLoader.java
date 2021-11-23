package resources;

import java.io.File;

public class ResourceLoader {

    private static final String DIRECTORY_FOLDERNAME = "Phone Numbers List";

    public static String getResourceFolder(){
        String userDirectory = System.getProperty("user.dir");
        String filePath = userDirectory + "\\"+ DIRECTORY_FOLDERNAME;
        return filePath;
    }

}
