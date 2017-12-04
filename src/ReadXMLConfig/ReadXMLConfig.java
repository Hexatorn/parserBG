package ReadXMLConfig;

import SetConf.ConfigData;
import Util.SERWER_TYPE;
import javafx.scene.control.Alert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ReadXMLConfig {
    private static Document doc = null;

    public static ArrayList<ConfigData> getConfigDataList(){
        ArrayList<ConfigData> configDataList = new ArrayList<>();
        if (doc==null)
            readXMLFile();
        NodeList nodeList = doc.getElementsByTagName("serwer");

        for (int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            Element element = ((Element) node);
            configDataList.add(new ConfigData(
                    conertStringToEnumSerwerType(element.getElementsByTagName("server_type").item(0).getTextContent()),
                    element.getElementsByTagName("serer_adress").item(0).getTextContent(),
                    element.getElementsByTagName("login").item(0).getTextContent(),
                    element.getElementsByTagName("password").item(0).getTextContent()
            ));
        }

        System.out.println(configDataList);

        return configDataList;
    }

    private static SERWER_TYPE conertStringToEnumSerwerType(String serverType){
        switch (serverType){
            case "SFTP":
                return SERWER_TYPE.FTP;
            case "SQL":
                return SERWER_TYPE.SQL;
            case "SMTP":
                return SERWER_TYPE.SMTP;
        }
        return null;
    }

    private static void readXMLFile(){
        File file = new File("config.xml");

        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
        }
        catch(FileNotFoundException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert");
            alert.setHeaderText("Błąd odczytu pliku konfiguracyjknego.\nPlik nie istnieje lub nie można go odczytać.\nBrak dostępu do zapamiętanych ustawień.");
            alert.setContentText(""+e.getMessage()+
                    "\n\n Możliwe sposoby rozwiązania problemu:\n"+
                    "1. Sprawdzenie uprawnień do katalogu i\\lub pliku.\n"+
                    "2. Przekopiowanie pliku konfiguracyjnego do z innego komputera.\n"+
                    "3. Stworzenie nowej konfiguracji w programie i zapisanie.");
            alert.showAndWait();
        } catch (ParserConfigurationException | IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert");
            alert.setHeaderText("Błąd odczytu pliku konfiguracyjknego.");
            alert.setContentText(""+e.getMessage());
            alert.showAndWait();
            e.printStackTrace();
        } catch (SAXException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert");
            alert.setHeaderText("Błąd odczytu pliku konfiguracyjknego.\n\nBrak dostępu do zapamiętanych ustawień.");
            alert.setContentText(""+e.getMessage()+
                    "\n\n Możliwe sposoby rozwiązania problemu:\n"+
                    "1. Przekopiowanie pliku konfiguracyjnego do z innego komputera.\n"+
                    "2. Stworzenie nowej konfiguracji i zapisanie w programie.");
            alert.showAndWait();
        }
    }
}
