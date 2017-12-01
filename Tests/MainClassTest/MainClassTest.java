import org.junit.Test;

import java.util.TreeMap;


public class MainClassTest {
    @Test
    public void testRun(){
        //System.out.println(new StartMode().get(StartMode.Start_Mode.CONFIG_ALL_RUN));
        run(StartMode.Start_Mode.CONFIG_ALL_RUN);
    }

    private void run(StartMode.Start_Mode start_mode){
        System.out.println("start main class without parameters");
        String[] args = new StartMode().get(start_mode);
        Main.main(args);
        System.out.println("end of run");
    }




}
