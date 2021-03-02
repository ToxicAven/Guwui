package Aven.Toxic;

import javax.swing.*;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class Main {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("Guwui");

        JTextField outputField = new JTextField("");
        outputField.setBounds(50,150,650,20);
        outputField.setEditable(false);

        JTextField inputField = new JTextField();
        inputField.setBounds(50,75,650,20);

        JLabel cliptext = new JLabel("");
        cliptext.setBounds(450,200,200,50);

        JLabel inputText = new JLabel("Input:");
        inputText.setBounds(50,40,200,50);

        JLabel outputText = new JLabel("Output:");
        outputText.setBounds(50,115,200,50);

        JButton btnOK = new JButton("Generate");
        btnOK.setBounds(325,200,100,50);
        btnOK.addActionListener(
                e -> {
                    String s1 = inputField.getText();
                    String stepTwo = gen(s1);
                    outputField.setText(stepTwo);
                    StringSelection stringSelection = new StringSelection(stepTwo);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(stringSelection, null);
                    cliptext.setText("Copied result to clipboard!");
                });


        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 300);
        frame.add(inputField);
        frame.add(btnOK);
        frame.add(inputText);
        frame.add(outputText);
        frame.add(outputField);
        frame.add(cliptext);
        frame.setVisible(true);
    }

    public static String gen(String input) {
        return input.replace("r", "w")
                    .replace("R", "W")
                    .replace("l", "w")
                    .replace("L", "W")
                    .replace(" n", " ny")
                    .replace(" N", " Ny")
                    .replace("ove", "uv")
                    .replace("OVE", "UV")
                    .replace("this", "dis");
    }
}
