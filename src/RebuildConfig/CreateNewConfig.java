package RebuildConfig;

import SetConf.ConfigData;
import Util.SERWER_TYPE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CreateNewConfig {


    public  static boolean create(){
        return create(
                new ConfigData(SERWER_TYPE.SFTP),
                new ConfigData(SERWER_TYPE.SQL),
                new ConfigData(SERWER_TYPE.SMTP)
        );
    }

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

    public  static boolean create(ConfigData configData){
        boolean succesCreate = true;
//        Tu będzie kod
        return succesCreate;
    }



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

}
