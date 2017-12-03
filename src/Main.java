import SetConf.*;
import javafx.application.Application;

public class Main {
    public static ConfigData dataFTP = new ConfigData();

    static String testString;

    public static void main(String[] args) {
        ReadConfig.read();
        if (args.length==0){
            System.out.println("Przetwarzaj dane");
        } else
        if (args.length==1 && args[0].equals("config")){
            System.out.println("config all");
        } else if (args.length==1 && args[0].equals("configFTP")){


        } else if (args.length==1 && args[0].equals("configSQL")){
            System.out.println("configSQL");
        }



    }
}
