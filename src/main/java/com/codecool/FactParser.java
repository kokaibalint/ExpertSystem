package com.codecool;

import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class FactParser extends XMLParser {

/*
    @Override
    public Document loadXmlDocument(String xmlPath) throws ParserConfigurationException, IOException, SAXException {
        return super.loadXmlDocument(xmlPath);
    }
*/

    public FactRepository getFactRepository() throws ParserConfigurationException, IOException, SAXException {
        Document doc = loadXmlDocument("src/main/java/com/codecool/Facts.xml");
        try {
            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            //doc.getDocumentElement().normalize();

            //       System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Fact");
            //       System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //           System.out.println("\nCurrent Element: " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("\nFact id: " + eElement.getAttribute("id"));
                    System.out.println("Description: " + eElement.getAttribute("value"));
                    System.out.println("Eval: " + eElement.getAttribute("id"));
                    //System.out.println("Question: " + eElement.getElementsByTagName("Description").item(0).getTextContent());
                    //System.out.println("If " + eElement.getAttribute("value"));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}

