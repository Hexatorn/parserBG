package SetConf;




public class EncryptionTool {
    /*
    * Encryption of the String
    * Basic use - password encryption
    * */
    public static String Encryption(String login, String password){
        int count = login.length() > password.length() ? login.length():password.length();
        StringBuilder tempValue = new StringBuilder();
        char appEnd;
        for (int i = 0; i < count ; i++) {
            tempValue.append(login.length() > i ? login.charAt(i) : 0);
            tempValue.append(password.length() > i ? password.charAt(i) : 0);
        }
        StringBuilder out = new StringBuilder();
        for (char c : tempValue.toString().toCharArray()) {
            char c0,c1,c2;
            c0 = (char) (c + 123);
            c1 = (char) (c0/2-40);
            c2 = (char) (c0-c1);
            out.append(c1);
            out.append(c2);
        }
        return out.toString();
    }
    public  static String Decryption(String login,String encryptedString){
        String out = "null";

        return out;
    }
}