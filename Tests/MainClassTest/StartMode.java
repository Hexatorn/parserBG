import org.junit.Test;

import java.util.TreeMap;



class StartMode {

    public enum Start_Mode {
        NORMAL_RUN,
        CONFIG_ALL_RUN,
        CONFIG_FTP_RUN,
        CONFIG_SQL_RUN
    }

    private String[] args_normal_run = {};
    private String[] args_config_all = {"config"};
    private String[] args_config_FTP = {"configFTP"};
    private String[] args_config_SQL = {"configSQL"};

    private TreeMap<Start_Mode, String[]> treeMap = new TreeMap<>();

    {
        treeMap.put(Start_Mode.NORMAL_RUN, args_normal_run);
        treeMap.put(Start_Mode.CONFIG_ALL_RUN, args_config_all);
        treeMap.put(Start_Mode.CONFIG_FTP_RUN, args_config_FTP);
        treeMap.put(Start_Mode.CONFIG_SQL_RUN, args_config_SQL);
    }

    String[] get(Start_Mode start_mode) {
        return treeMap.get(start_mode);
    }
}

