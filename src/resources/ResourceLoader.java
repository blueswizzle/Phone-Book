package resources;



public class ResourceLoader {

    private static final String PHONENUMBER_FOLDERNAME = "Phone Numbers List";

    public static String getResourceFolder(){
        String userDirectory = System.getProperty("user.dir");
        String filePath = userDirectory + "//"+ PHONENUMBER_FOLDERNAME;
        return filePath;
    }

}
