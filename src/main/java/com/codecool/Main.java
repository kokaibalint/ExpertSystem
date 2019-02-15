package com.codecool;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        RuleParser parser = new RuleParser();
        parser.getRuleRepository();
        System.out.println("\n");
        FactParser otherparser = new FactParser();
        otherparser.FactParser();

    }
}
