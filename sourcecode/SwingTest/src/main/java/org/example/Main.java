package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        JFrame ramka = new JFrame("Moja aplikacja");
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setBounds(100,100,100,100);
        ramka.setVisible(true);
    }
}