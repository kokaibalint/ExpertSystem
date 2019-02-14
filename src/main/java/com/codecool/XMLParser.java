package com.codecool;

import java.io.File;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;

/*Reads the xml documents */
public abstract class XMLParser {

    public Document loadXMLDocument(String xmlPath) {

        try {
            File inputFile = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile); // a doc-ban lesz a teljes xml.

            doc.getDocumentElement().normalize(); // a tagok közötti (>...<) text-típusú whitespaceket távolítja el.
            return doc;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}


