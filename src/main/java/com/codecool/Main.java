package com.codecool;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public String getWelcomeString() {
        return "Hi!";
    }

    public static void main(String[] args)  throws ParserConfigurationException, IOException, SAXException {
        Main main = new Main();
        System.out.println(main.getWelcomeString());

        XMLParser parser = new XMLParser();
        parser.loadXmlDocument("src/main/java/com/codecool/Rules.xml");

    }
}
