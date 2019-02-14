package com.codecool;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public String getWelcomeString() {
        return "Hi!";
    }

    public static void main(String[] args) {
        RuleParser ruleParser = new RuleParser();
        ruleParser.getRuleRepository();

        System.out.println("\n");

        FactParser factParser = new FactParser();
        factParser.getFactRepository();

    }
}
