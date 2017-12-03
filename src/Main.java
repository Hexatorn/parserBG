import SetConf.*;
import RebuildConfig.*;
import Util.SERWER_TYPE;

public class Main {
    public static void main(String[] args) {

        CreateNewConfig.create();

        ReadConfig.read();
        if (args.length==0){
            System.out.println("Przetwarzaj dane");
        } else
        if (args.length==1 && args[0].equals("config")){
            System.out.println("config all");
        } else if (args.length==1 && args[0].equals("configFTP")){
            DialogWindowConfigConection dialogWindowConfigConection = new DialogWindowConfigConection();
            dialogWindowConfigConection.showWindow(SERWER_TYPE.FTP);



        } else if (args.length==1 && args[0].equals("configSQL")){
            System.out.println("configSQL");
        }
    }
}
