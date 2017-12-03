package RebuildConfig;

import SetConf.ConfigData;
import Util.SERWER_TYPE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CreateNewConfig {
    public CreateNewConfig() {


    }
    public static boolean create(){
        boolean succesCreate = true;

        try {
            PrintWriter newConfig = new PrintWriter("config.xml");
            newConfig.print("<config>\n");
            newConfig.print(createXmlEntry(new ConfigData(SERWER_TYPE.SFTP)));
            newConfig.print(createXmlEntry(new ConfigData(SERWER_TYPE.SQL)));
            newConfig.print(createXmlEntry(new ConfigData(SERWER_TYPE.SMTP)));
            newConfig.print("</config>\n");
            newConfig.close();
        } catch (FileNotFoundException e) {
            succesCreate = false;
        }

        return succesCreate;
    }

    private static String createXmlEntry (ConfigData configData){
        return "\t<serwer>\n" +
                "\t\t<server_type>\n" +
                "\t\t\t"+configData.getSerwer_type()+"\n" +
                "\t\t</server_type>\n" +
                "\t\t<serer_adress>\n" +
                "\t\t\t"+configData.getSerwerAdress()+"\n" +
                "\t\t</serer_adress>\n" +
                "\t\t<login>\n" +
                "\t\t\t"+configData.getLogin()+"\n" +
                "\t\t</login>\n" +
                "\t\t<password>\n" +
                "\t\t\t"+configData.getPassword()+"\n" +
                "\t\t</password>\n" +
                "\t</serwer>\n";
    }

}
