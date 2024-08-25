import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Calculator implements ActionListener {
    JFrame f;
    JTextField t;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bdiv, bmul, bsub, badd, bdec, beq, bclr;

    Calculator() {
        f = new JFrame("Calculator");
        t = new JTextField();
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        bdiv = new JButton("/");
        bmul = new JButton("X");
        bsub = new JButton("-");
        badd = new JButton("+");
        bdec = new JButton(".");
        beq = new JButton("=");
        bclr = new JButton("Clear");

        t.setBounds(20, 20, 294, 60);
        t.setBackground(Color.WHITE);
        b7.setBounds(40, 100, 50, 40);
        b8.setBounds(110, 100, 50, 40);
        b9.setBounds(180, 100, 50, 40);
        bdiv.setBounds(250, 100, 50, 40);

        b4.setBounds(40, 170, 50, 40);
        b5.setBounds(110, 170, 50, 40);
        b6.setBounds(180, 170, 50, 40);
        bmul.setBounds(250, 170, 50, 40);

        b1.setBounds(40, 240, 50, 40);
        b2.setBounds(110, 240, 50, 40);
        b3.setBounds(180, 240, 50, 40);
        bsub.setBounds(250, 240, 50, 40);

        bdec.setBounds(40, 310, 50, 40);
        b0.setBounds(110, 310, 50, 40);
        badd.setBounds(180, 310, 50, 40);
        beq.setBounds(250, 300, 50, 130);

        bclr.setBounds(30, 370, 200, 60);

        f.add(t);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(bdiv);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(bmul);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(bsub);
        f.add(bdec);
        f.add(b0);
        f.add(beq);
        f.add(badd);
        f.add(bclr);

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(350, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        badd.addActionListener(this);
        bdiv.addActionListener(this);
        bmul.addActionListener(this);
        bsub.addActionListener(this);
        bdec.addActionListener(this);
        beq.addActionListener(this);
        bclr.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // Number buttons and decimal
        if (e.getSource() == b1) t.setText(t.getText().concat("1"));
        if (e.getSource() == b2) t.setText(t.getText().concat("2"));
        if (e.getSource() == b3) t.setText(t.getText().concat("3"));
        if (e.getSource() == b4) t.setText(t.getText().concat("4"));
        if (e.getSource() == b5) t.setText(t.getText().concat("5"));
        if (e.getSource() == b6) t.setText(t.getText().concat("6"));
        if (e.getSource() == b7) t.setText(t.getText().concat("7"));
        if (e.getSource() == b8) t.setText(t.getText().concat("8"));
        if (e.getSource() == b9) t.setText(t.getText().concat("9"));
        if (e.getSource() == b0) t.setText(t.getText().concat("0"));
        if (e.getSource() == bdec) t.setText(t.getText().concat("."));

        // Operator buttons
        if (e.getSource() == badd) t.setText(t.getText().concat(" + "));
        if (e.getSource() == bsub) t.setText(t.getText().concat(" - "));
        if (e.getSource() == bmul) t.setText(t.getText().concat(" * "));
        if (e.getSource() == bdiv) t.setText(t.getText().concat(" / "));

        // Equals button: Calculate result
        if (e.getSource() == beq) {
            try {
                String expression = t.getText();
                double result = evaluateExpression(expression);
                t.setText(String.valueOf(result));
            } catch (Exception ex) {
                t.setText("Error");
            }
        }

        // Clear button
        if (e.getSource() == bclr) {
            t.setText("");
        }
    }

    // Method to evaluate the expression
    public static double evaluateExpression(String expression) {
        // Replace X with * for correct evaluation
        expression = expression.replaceAll("X", "*");

        // Split expression into tokens
        String[] tokens = expression.split(" ");
        if (tokens.length == 0) return 0;

        // Process multiplication and division first
        double result = Double.parseDouble(tokens[0]);
        int i = 1;
        while (i < tokens.length) {
            String operator = tokens[i];
            double nextNumber = Double.parseDouble(tokens[i + 1]);
            if (operator.equals("*")) {
                result *= nextNumber;
            } else if (operator.equals("/")) {
                result /= nextNumber;
            }
            i += 2;
        }

        // Process addition and subtraction
        i = 1;
        while (i < tokens.length) {
            String operator = tokens[i];
            double nextNumber = Double.parseDouble(tokens[i + 1]);
            if (operator.equals("+")) {
                result += nextNumber;
            } else if (operator.equals("-")) {
                result -= nextNumber;
            }
            i += 2;
        }

        return result;
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
