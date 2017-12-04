import ReadXMLConfig.ReadXMLConfig;
import SetConf.*;
import RebuildConfig.*;
import Util.SERWER_TYPE;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        /*
        * Checking if configuration file exist
        * If it does not exist, an empty configuration file is created
        * */
        File config = new File("config.xml");
        if(config.exists()){
            System.out.println("log-> Plik konfiguracyjny istnieje");
        }else{
            CreateNewConfig.create();
            System.out.println("log-> Został utworzony nowy konfig");
        }
        /*
        *
        * */
        ReadXMLConfig.getConfigDataList();


        /*
        * Starting the program in one of the available modes
        * no choice - normal run
        * config - change all configuration data one by one
        * configSFTP - set up the SFTP server configuration again
        * configSQL - set up the SQL server configuration again
        * configSMTP - set up the SMTP server configuration again
        * */
        if (args.length==0){
            System.out.println("Przetwarzaj dane");
        } else
        if (args.length==1 && args[0].equals("config")){
            System.out.println("config all");
        } else if (args.length==1 && args[0].equals("configSFTP")){
            DialogWindowConfigConection dialogWindowConfigConection = new DialogWindowConfigConection();
            dialogWindowConfigConection.showWindow(SERWER_TYPE.FTP);
        } else if (args.length==1 && args[0].equals("configSQL")){
            System.out.println("configSQL");
        }
    }
}
