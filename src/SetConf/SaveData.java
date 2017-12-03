package SetConf;

/**
 * Created by Hexatorn on 2017-11-27.
 */
class SaveData {
    static void save(ConfigData configData){
        System.out.println("Zapisywanie");
        System.out.println(configData.getSerwer_type());
        System.out.println(configData.getSerwerAdress());
        System.out.println(configData.getLogin());
        System.out.println(configData.getPassword());
    }
}
