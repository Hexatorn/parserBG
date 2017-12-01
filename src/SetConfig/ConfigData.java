package SetConfig;

/**
 * Created by Hexatorn on 2017-12-01.
 */
public class ConfigData {
    private SERWER_TYPE serwer_type = null;
    private String serwerAdress ="";
    private String login = "";
    private String password = "";
    ConfigData(SERWER_TYPE serwer_type, String serwerAdress, String login ,String password){
        this.serwer_type = serwer_type;
        this.serwerAdress = serwerAdress;
        this.login = login;
        this.password = password;
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
}
