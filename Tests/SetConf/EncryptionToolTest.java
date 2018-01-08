package SetConf;

import org.junit.Test;

import static org.junit.Assert.*;


public class EncryptionToolTest {
    @Test
    public void encryption() throws Exception {
        assertEquals(EncryptionTool.Encryption("test","Pa55wor}"),"O =\u008EH\u0098F\u0096O\u009F0\u0080O 0\u0080\u0015fQ¡\u0015fM\u009D\u0015fN\u009F\u0015fT¤");
    }

    @Test
    public void decryption() throws Exception {
        assertEquals(EncryptionTool.Decryption("test","O =\u008EH\u0098F\u0096O\u009F0\u0080O 0\u0080\u0015fQ¡\u0015fM\u009D\u0015fN\u009F\u0015fT¤"),"Pa55wor}");

    }

}