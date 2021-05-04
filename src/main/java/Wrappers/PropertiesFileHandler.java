package Wrappers;
import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileHandler {
    static String fileNameAndPath = "Config.properties";
    public static Properties propFile = new Properties();


    static {
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(fileNameAndPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            propFile.load(fs);
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                fs.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String key){
        try {
            return ((propFile.getProperty(key).split(","))[0]);

        }
        catch (Exception e){
            return null;
        }
    }
}
