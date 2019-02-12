package com.codecool;

import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.File;


public class RuleParser extends XMLParser {

/*
    @Override
    public Document loadXmlDocument(String xmlPath) throws ParserConfigurationException, IOException, SAXException {
        return super.loadXmlDocument(xmlPath);
    }
*/


    public RuleRepository getRuleRepository() throws ParserConfigurationException, IOException, SAXException {
        Document doc = loadXmlDocument("src/main/java/com/codecool/Rules.xml");
        try {
            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            //doc.getDocumentElement().normalize();

     //       System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Rule");
     //       System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
     //           System.out.println("\nCurrent Element: " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("\nRule id: " + eElement.getAttribute("id"));
                    System.out.println("Question: " + eElement.getElementsByTagName("Question").item(0).getTextContent());
                    System.out.println("If " + eElement.getAttribute("value"));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}

