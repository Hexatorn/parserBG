package RebuildConfig;

import ReadXMLConfig.ReadXMLConfig;
import SetConf.ConfigData;
import Util.SERWER_TYPE;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class CreateNewConfig {

    /*
    * Creating a configuration file with empty values.
    * */
    public  static boolean create(){
        return create(
                new ConfigData(SERWER_TYPE.SFTP),
                new ConfigData(SERWER_TYPE.SQL),
                new ConfigData(SERWER_TYPE.SMTP)
        );
    }
    /*
    * Setting values in the configuration file.
    * It is mandatory to provide three ConfigData objects
    * */
    public static boolean create(ConfigData SFTPConfigData,ConfigData SQLConfigData, ConfigData SMTPConfigData){
        boolean succesCreate = true;

        try {
            PrintWriter newConfig = new PrintWriter("config.xml");
            newConfig.print("<config>\n");
            newConfig.print(createXmlEntry(SFTPConfigData));
            newConfig.print(createXmlEntry(SQLConfigData));
            newConfig.print(createXmlEntry(SMTPConfigData));
            newConfig.print("</config>\n");
            newConfig.close();
        } catch (FileNotFoundException e) {
            succesCreate = false;
        }

        return succesCreate;
    }
    /*
    * Changing the configuration data of one of the servers.
    * */
    public  static boolean create(ConfigData configData){
        boolean succesCreate = true;
        /*
        * Checking the server type and determining the place in the configuration file.
        * */
        int positionOnTheArrayList = setPosition(configData);
        System.out.println("Position on the list "+positionOnTheArrayList);
        System.out.println(configData);
        /*
        * Reading the current configuration file
        * */
        ArrayList<ConfigData> configDataArrayList;
        configDataArrayList = ReadXMLConfig.getConfigDataList();
        /*
        * Setting new configuration data in configDataArrayList
        * */
        configDataArrayList.set(positionOnTheArrayList,configData);
        /*
        * Saving data to the configuration file
        * */
        return create(
                configDataArrayList.get(0),
                configDataArrayList.get(1),
                configDataArrayList.get(2)
        );
    }

    /*
    * Creates an entry in the configuration file for one server.
    * Doesn't save data to a file.
    * */

    private static String createXmlEntry (ConfigData configData){
        return
            "\t<serwer>\n" +
            "\t\t<server_type>" +
            configData.getSerwer_type()+
            "</server_type>\n" +
            "\t\t<serer_adress>" +
            configData.getSerwerAdress()+
            "</serer_adress>\n" +
            "\t\t<login>" +
            configData.getLogin()+
            "</login>\n" +
            "\t\t<password>" +
            configData.getPassword()+
            "</password>\n" +
            "\t</serwer>\n";
    }

    /*
    * Defines the position of the server configuration data in the configuration file
    * */
    private static int setPosition(ConfigData configData){
        int position = -1;
        if(configData.getSerwer_type().equals(SERWER_TYPE.SFTP))
            position = 0;
        else if(configData.getSerwer_type().equals(SERWER_TYPE.SQL))
            position = 1;
        else if(configData.getSerwer_type().equals(SERWER_TYPE.SMTP))
            position = 2;
        return position;
    }

}
