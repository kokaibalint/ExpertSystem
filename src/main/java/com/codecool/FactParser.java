package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class FactParser extends XMLParser {

    public void FactParser() {

        try {
            File inputFile = new File("Facts.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile); // a doc-ban lesz a teljes xml.

            doc.getDocumentElement().normalize(); // a tagok közötti (>...<) text-típusú whitespaceket távolítja el: \n, szóköz

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList factNodes = doc.getElementsByTagName("Fact"); // 'Fact' elementek listája
            System.out.println("----------------------------");

            for (int temp = 0; temp < factNodes.getLength(); temp++) {
                Node factNode = factNodes.item(temp);

                if (factNode.getNodeType() == Node.ELEMENT_NODE) { // ha element-típusú (van nyitó & záró tag-je) akkor kiszedjük.
                    Element factElement = (Element) factNode; // átcastoljuk elementté
                    System.out.println(temp + 1 + ". Fact id: "
                            + factElement
                            .getAttribute("id"));
                    Element descriptionElement = (Element) factElement
                            .getElementsByTagName("Description")
                            .item(0);
                    System.out.println("Name: " + descriptionElement.getAttribute("value"));

                    NodeList evalNodes = doc.getElementsByTagName("Eval");
                    int k = evalNodes.getLength();
                    for (int i = 0; i < 12; i++) {
                        Node evalNode = evalNodes.item(i);

                        Element evalElement = (Element) evalNode;
                        System.out.print(String.format("%-11s",
                                evalElement
                                        .getAttribute("id")));
                        System.out.println(": "
                                + Boolean.valueOf(
                                evalElement.getTextContent()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
