import ReadXMLConfig.ReadXMLConfig;
import SetConf.*;
import Util.SERWER_TYPE;

import java.io.File;
import java.util.ArrayList;

public class ParserBG {
    public static void main(String[] args) {
        /*
        * Listing of available commands after entering "?" or "helep"
        */
        if (args.length==1 && (
                args[0].equals("help")||
                        args[0].equals("?"))){
            System.out.println("" +
                    "java ParserBG [tryb_uruchomienia]\n\n"+
                    "Nie wskazanie trybu uruchomienia powoduje uruchomienie w normalnym trybie pracy.\n"+ "" +
                    "Wskazanie trybu uruchomienia pozwala zmienić ustawienia konfiguracyjne\n\n"+
                    "możliwe tryby uruchomienia:\n"+
                    "configSFTP - konfiguraca połączenia z serwerem SFTP \n" +
                    "configSQL - konfiguraca połączenia z serwerem SQL\n" +
                    "configSMTP - konfiguraca połączenia z serwerem SMTP");
        }
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
        /*
        * Normal run section
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
        }
        /*
        * Run the SFTP server configuration
        * */
        else if (args.length==1 && args[0].equals("configSFTP")){
            DialogWindowConfigConection dialogWindowConfigConection = new DialogWindowConfigConection();
            dialogWindowConfigConection.showWindow(SERWER_TYPE.SFTP);
        }
        /*
        * Run the SQL server configuration
        * */
        else if (args.length==1 && args[0].equals("configSQL")){
            DialogWindowConfigConection dialogWindowConfigConection = new DialogWindowConfigConection();
            dialogWindowConfigConection.showWindow(SERWER_TYPE.SQL);
        }
        else if (args.length==1 && args[0].equals("configSMTP")){
            DialogWindowConfigConection dialogWindowConfigConection = new DialogWindowConfigConection();
            dialogWindowConfigConection.showWindow(SERWER_TYPE.SMTP);
        }
        else  {
            System.out.println("wpisz \"java ParserBG help\" w celu uzyskania pomocy");
        }
    }
}
