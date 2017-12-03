package SetConf;

/**
 * Created by Hexatorn on 2017-12-01.
 */
public class ConfigData {
    private SERWER_TYPE serwer_type = null;
    private String serwerAdress ="";
    private String login = "";
    private String password = "";

    public ConfigData(){
        this.serwerAdress = "null";
        this.login = "null";
        this.password = "****";
    }

    ConfigData(SERWER_TYPE serwer_type, String serwerAdress, String login ,String password){
        this.serwer_type = serwer_type;
        this.serwerAdress = serwerAdress;
        this.login = login;
        this.password = password;
        System.out.println("utworzono ConfigData");
    }

    public SERWER_TYPE getSerwer_type() {
        return serwer_type;
    }

    public String getSerwerAdress() {
        return serwerAdress;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setSerwer_type(SERWER_TYPE serwer_type) {
        this.serwer_type = serwer_type;
    }

    public void setSerwerAdress(String serwerAdress) {
        this.serwerAdress = serwerAdress;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ConfigData{" +
                "serwer_type=" + serwer_type +
                ", serwerAdress='" + serwerAdress + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
