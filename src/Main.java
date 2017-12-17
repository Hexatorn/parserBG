import ReadXMLConfig.ReadXMLConfig;
import SetConf.*;
import RebuildConfig.*;
import Util.SERWER_TYPE;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        * Checking configuration file
        * If it does not exist, an empty configuration file is created
        * */
        File config = new File("config.xml");
        if(config.exists()){
            System.out.println("log-> Plik konfiguracyjny istnieje");
        }else{
            System.out.println("log-> Rozpoczęcie tworzenia nowego pliku konfiguracyjnego");
            if (CreateNewConfig.create())
                System.out.println("log-> Został utworzony nowy plik konfiguracyjny");
            else
                System.out.println("log-> Błąd tworzenia nowego pliku konfiguracyjnego");
        }


        /*
        * Starting the program in one of the available modes
        * no choice - normal run
        * config - change all configuration data one by one
        * configSFTP - set up the SFTP server configuration again
        * configSQL - set up the SQL server configuration again
        * configSMTP - set up the SMTP server configuration again
        * */

        if (args.length==0){
            /*
            * Reading the configuration file.
            * The configuration file should contain data to connect to:
            * - SFTP server (first element of the list)
            * - SQL  server (second element of the list)
            * - SMTP server (third element of the list)
            * */
            ArrayList<ConfigData> configDataArrayList;
            configDataArrayList = ReadXMLConfig.getConfigDataList();
            System.out.println(configDataArrayList);

            System.out.println("Przetwarzaj dane");
        } else
        if (args.length==1 && args[0].equals("config")){
            System.out.println("config all");
        } else if (args.length==1 && args[0].equals("configSFTP")){
            DialogWindowConfigConection dialogWindowConfigConection = new DialogWindowConfigConection();
            dialogWindowConfigConection.showWindow(SERWER_TYPE.SFTP);
        } else if (args.length==1 && args[0].equals("configSQL")){
            System.out.println("configSQL");
        }
    }
}
