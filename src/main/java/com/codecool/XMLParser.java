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

    protected Document doc;

    protected void loadXmlDocument (String xmlPath) {

        try {

            File inputFile = new File("Facts.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile); // a doc-ban lesz a teljes xml.
            doc.getDocumentElement().normalize(); // a tagok közötti (>...<) text-típusú whitespaceket távol
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

}


