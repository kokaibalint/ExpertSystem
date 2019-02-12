package com.codecool;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/*Reads the xml documents */
public abstract class XMLParser {

    public Document loadXmlDocument(String xmlPath) throws IOException, SAXException, ParserConfigurationException {
        InputStream is = Main.class.getResourceAsStream("/" + xmlPath);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(is);

        return document;
    }
}


