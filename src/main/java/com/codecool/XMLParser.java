package com.codecool;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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


