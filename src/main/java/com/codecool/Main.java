package com.codecool;

public class Main {

    public static void main(String[] args) {
        RuleParser ruleParser = new RuleParser();
        ruleParser.getRuleRepository();

        System.out.println("\n");

        FactParser factParser = new FactParser();
        factParser.getFactRepository();

    }
}
