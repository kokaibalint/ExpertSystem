package com.codecool;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public String getWelcomeString() {
        return "Hi!";
    }

    public static void main(String[] args)  throws ParserConfigurationException, IOException, SAXException {
        RuleParser parser = new RuleParser();
        parser.getRuleRepository();
        System.out.println("\n\n");
        FactParser otherparser = new FactParser();
        otherparser.getFactRepository();

    }
}
