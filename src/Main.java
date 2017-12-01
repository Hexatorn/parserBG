import SetConfig.SetConfig;

public class Main {

    public static void main(String[] args) {
        ReadConfig.read();
        if (args.length==1 && args[0].equals("config")){
            System.out.println("Przetwarzaj dane");
        } else
        if (args.length==1 && args[0].equals("config")){
            System.out.println("config all");
        } else if (args.length==1 && args[0].equals("configFTP")){
            SetConfig.set();
        } else if (args.length==1 && args[0].equals("configSQL")){
            SetConfig.set();
        }


    }
}
