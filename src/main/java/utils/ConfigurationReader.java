package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //this class will be responsible for loading properties file and will provide access to values nased on key names
    //we use this class to load custom.properties files
    private static Properties configFile;

    static {
        try {
            //provide access to file
            //try/catch block stands for handling exception, if exception occurs, code inside the catch block will be executed
            //any class that is related to InputOutput produce checked exception .
            // without handling check exception, you cannot run the code
           FileInputStream  fileInputStream = new FileInputStream("configuration.properties");
            configFile = new Properties();
            //load your properties file
            configFile.load(fileInputStream);
           fileInputStream.close();
        }catch (IOException e){
            System.out.println("File was not loaded");
            e.printStackTrace();
        }
    }

    public static String  getProperty(String key){
        return configFile.getProperty(key);
    }

}
