package com.codecool;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class RuleParser {

    public void getRuleRepository() {
        try {
            File inputFile = new File("Rules.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Rule");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println(temp + 1 + ". Question id: "
                            + eElement
                            .getAttribute("id"));
                    System.out.println("Question: "
                            + eElement
                            .getElementsByTagName("Question")
                            .item(0)
                            .getTextContent());


                    for (int i = 0; i < eElement.getElementsByTagName("SingleValue").getLength(); i++) {
                        System.out.println("   Value: "
                                + eElement
                                .getElementsByTagName("SingleValue")
                                .item(i)
                                .getAttributes()
                                .item(0)
                                .getTextContent());
                        System.out.println("   Meaning: "
                                + Boolean.valueOf(
                                eElement
                                        .getElementsByTagName("SingleValue")
                                        .item(i)
                                        .getParentNode() // The parent of this tag!!!
                                        .getAttributes()
                                        .item(0)
                                        .getTextContent()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
