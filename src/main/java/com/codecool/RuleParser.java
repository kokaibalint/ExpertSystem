package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class RuleParser extends XMLParser {

    public void getRuleRepository() {
        try {
            Document ruleDoc = loadXMLDocument("data/Rules.xml");

            System.out.println("Root element: " + ruleDoc.getDocumentElement().getNodeName());

            NodeList ruleNodes = ruleDoc.getElementsByTagName("Rule");
            System.out.print("----------------------------");

            for (int temp = 0; temp < ruleNodes.getLength(); temp++) {
                Node nNode = ruleNodes.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("\n" + (temp + 1) + ". Question id: "
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
