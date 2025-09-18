import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Expensetracker extends JFrame implements ActionListener {

    JPanel p1, p2;
    JPanel pp, cp;

    JLabel l1, l2;
    JButton prsnlbtn, cmbtn;

    JButton b1p, b2p, b3p;
    JButton b1c, b2c, b3c;

    JComboBox<String> personalCategory, personalDay;
    JComboBox<String> personalMonth;
    JComboBox<Integer> personalYear;
    JTextField personalAmount, personalNotes;

    JComboBox<String> commercialDay;
    JComboBox<String> commercialMonth;
    JComboBox<Integer> commercialYear;
    JTextField codeField, productTypeField, pieceField, companyField;
    JTextField commercialAmount, commercialNotes;

    String[][] expenses = new String[100][8];
    int count = 0;
    String currentMode = "personal";

    public Expensetracker() {
        super("Expense Tracker");
        this.setSize(900, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        p1 = new JPanel();
        p1.setBounds(0, 0, 900, 100);
        p1.setBackground(new Color(139, 0, 0));
        p1.setLayout(null);
        this.add(p1);

        l1 = new JLabel("EXPENSE TRACKER");
        l1.setFont(new Font("Serif", Font.BOLD, 30));
        l1.setForeground(Color.WHITE);
        l1.setBounds(300, 0, 400, 40);
        p1.add(l1);

        l2 = new JLabel("Easy solution for decorating YOUR EXPENSES");
        l2.setFont(new Font("Serif", Font.BOLD, 15));
        l2.setForeground(Color.white);
        l2.setBounds(300, 40, 400, 30);
        p1.add(l2);

        prsnlbtn = new JButton("Personal Expense");
        prsnlbtn.setBounds(100, 70, 150, 25);
        p1.add(prsnlbtn);

        cmbtn = new JButton("Commercial Expense");
        cmbtn.setBounds(270, 70, 180, 25);
        p1.add(cmbtn);

        p2 = new JPanel(null);
        p2.setBounds(0, 100, 900, 600);
        this.add(p2);

        pp = new JPanel(null);
        pp.setBounds(0, 0, 900, 600);
        pp.setBackground(Color.white);

        JPanel personalDateP = new JPanel(null);
        personalDateP.setBounds(50, 20, 800, 50);
        personalDateP.setBorder(BorderFactory.createTitledBorder("Date"));
        personalDateP.setBackground(new Color(245, 245, 245));
        pp.add(personalDateP);

        String[] days = new String[31];
        for (int i = 0; i < 31; i++) days[i] = String.valueOf(i + 1);
        personalDay = new JComboBox<>(days);
        personalDay.setBounds(20, 20, 60, 25);
        personalDateP.add(personalDay);

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        personalMonth = new JComboBox<>(months);
        personalMonth.setBounds(100, 20, 100, 25);
        personalDateP.add(personalMonth);

        Integer[] years = new Integer[26];
        for (int i = 0; i < 26; i++) years[i] = 2025 + i;
        personalYear = new JComboBox<>(years);
        personalYear.setBounds(220, 20, 100, 25);
        personalDateP.add(personalYear);

        JPanel personalDetailsP = new JPanel(null);
        personalDetailsP.setBounds(50, 90, 800, 150);
        personalDetailsP.setBorder(BorderFactory.createTitledBorder("Personal Expense Details"));
        personalDetailsP.setBackground(new Color(245, 245, 245));
        pp.add(personalDetailsP);

        JLabel catL = new JLabel("CATEGORY:");
        catL.setBounds(20, 20, 100, 20);
        personalDetailsP.add(catL);
        personalCategory = new JComboBox<>(new String[]{"Food", "Transport", "Rent", "Shopping", "Others"});
        personalCategory.setBounds(140, 20, 200, 25);
        personalDetailsP.add(personalCategory);

        JLabel amountL = new JLabel("AMOUNT:");
        amountL.setBounds(20, 50, 100, 20);
        personalDetailsP.add(amountL);
        personalAmount = new JTextField();
        personalAmount.setBounds(140, 50, 200, 25);
        personalDetailsP.add(personalAmount);

        JLabel notesL = new JLabel("NOTES:");
        notesL.setBounds(20, 80, 100, 20);
        personalDetailsP.add(notesL);
        personalNotes = new JTextField();
        personalNotes.setBounds(140, 80, 500, 25);
        personalDetailsP.add(personalNotes);

        b1p = new JButton("SAVE");
        b1p.setBounds(200, 420, 100, 40);
        b1p.addActionListener(this);
        pp.add(b1p);

        b2p = new JButton("CANCEL");
        b2p.setBounds(350, 420, 100, 40);
        b2p.addActionListener(this);
        pp.add(b2p);

        b3p = new JButton("SHOW");
        b3p.setBounds(500, 420, 100, 40);
        b3p.addActionListener(this);
        pp.add(b3p);

        cp = new JPanel(null);
        cp.setBounds(0, 0, 900, 600);
        cp.setBackground(Color.white);

        JPanel commercialDateP = new JPanel(null);
        commercialDateP.setBounds(50, 20, 800, 50);
        commercialDateP.setBorder(BorderFactory.createTitledBorder("Date"));
        commercialDateP.setBackground(new Color(245, 245, 245));
        cp.add(commercialDateP);

        commercialDay = new JComboBox<>(days);
        commercialDay.setBounds(20, 20, 60, 25);
        commercialDateP.add(commercialDay);

        commercialMonth = new JComboBox<>(months);
        commercialMonth.setBounds(100, 20, 100, 25);
        commercialDateP.add(commercialMonth);

        commercialYear = new JComboBox<>(years);
        commercialYear.setBounds(220, 20, 100, 25);
        commercialDateP.add(commercialYear);

        JPanel productP = new JPanel(null);
        productP.setBounds(50, 90, 800, 120);
        productP.setBorder(BorderFactory.createTitledBorder("Product Info"));
        productP.setBackground(new Color(245, 245, 245));
        cp.add(productP);

        JLabel codeL = new JLabel("CODE:");
        codeL.setBounds(20, 20, 100, 20);
        productP.add(codeL);
        codeField = new JTextField();
        codeField.setBounds(140, 20, 200, 25);
        productP.add(codeField);

        JLabel productTypeL = new JLabel("PRODUCT TYPE:");
        productTypeL.setBounds(20, 50, 120, 20);
        productP.add(productTypeL);
        productTypeField = new JTextField();
        productTypeField.setBounds(140, 50, 200, 25);
        productP.add(productTypeField);

        JLabel pieceL = new JLabel("PIECE:");
        pieceL.setBounds(20, 80, 100, 20);
        productP.add(pieceL);
        pieceField = new JTextField();
        pieceField.setBounds(140, 80, 200, 25);
        productP.add(pieceField);

        JPanel companyP = new JPanel(null);
        companyP.setBounds(50, 220, 800, 80);
        companyP.setBorder(BorderFactory.createTitledBorder("Company Info"));
        companyP.setBackground(new Color(245, 245, 245));
        cp.add(companyP);

        JLabel companyL = new JLabel("COMPANY:");
        companyL.setBounds(20, 20, 100, 20);
        companyP.add(companyL);
        companyField = new JTextField();
        companyField.setBounds(140, 20, 200, 25);
        companyP.add(companyField);

        JPanel amountP = new JPanel(null);
        amountP.setBounds(50, 320, 800, 80);
        amountP.setBorder(BorderFactory.createTitledBorder("Amount & Notes"));
        amountP.setBackground(new Color(245, 245, 245));
        cp.add(amountP);

        JLabel amountCL = new JLabel("AMOUNT:");
        amountCL.setBounds(20, 20, 100, 20);
        amountP.add(amountCL);
        commercialAmount = new JTextField();
        commercialAmount.setBounds(140, 20, 200, 25);
        amountP.add(commercialAmount);

        JLabel notesCL = new JLabel("NOTES:");
        notesCL.setBounds(20, 50, 100, 20);
        amountP.add(notesCL);
        commercialNotes = new JTextField();
        commercialNotes.setBounds(140, 50, 500, 25);
        amountP.add(commercialNotes);

        b1c = new JButton("SAVE");
        b1c.setBounds(200, 420, 100, 40);
        b1c.addActionListener(this);
        cp.add(b1c);

        b2c = new JButton("CANCEL");
        b2c.setBounds(350, 420, 100, 40);
        b2c.addActionListener(this);
        cp.add(b2c);

        b3c = new JButton("SHOW");
        b3c.setBounds(500, 420, 100, 40);
        b3c.addActionListener(this);
        cp.add(b3c);

        p2.add(pp);
        p2.add(cp);

        pp.setVisible(true);
        cp.setVisible(false);

        prsnlbtn.addActionListener(e -> {
            currentMode = "personal";
            pp.setVisible(true);
            cp.setVisible(false);
        });

        cmbtn.addActionListener(e -> {
            currentMode = "commercial";
            pp.setVisible(false);
            cp.setVisible(true);
        });

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean isPersonal = pp.isVisible();
        String date, category, amount, note, code = "", type = "", piece = "", company = "";
        if (isPersonal) {
            if (ae.getSource() == b1p) {
                date = personalDay.getSelectedItem() + "-" + personalMonth.getSelectedItem() + "-" + personalYear.getSelectedItem();
                category = (String) personalCategory.getSelectedItem();
                amount = personalAmount.getText();
                note = personalNotes.getText();
            } else if (ae.getSource() == b2p) {
                clearPersonalFields();
                return;
            } else if (ae.getSource() == b3p) {
                showExpenses();
                return;
            } else return;
        } else {
            if (ae.getSource() == b1c) {
                date = commercialDay.getSelectedItem() + "-" + commercialMonth.getSelectedItem() + "-" + commercialYear.getSelectedItem();
                category = "Commercial";
                amount = commercialAmount.getText();
                note = commercialNotes.getText();
                code = codeField.getText();
                type = productTypeField.getText();
                piece = pieceField.getText();
                company = companyField.getText();
            } else if (ae.getSource() == b2c) {
                clearCommercialFields();
                return;
            } else if (ae.getSource() == b3c) {
                showExpenses();
                return;
            } else return;
        }

        if (amount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Amount is required.");
            return;
        }

        if (count >= expenses.length) {
            JOptionPane.showMessageDialog(this, "Max entries reached.");
            return;
        }

        expenses[count][0] = date;
        expenses[count][1] = category;
        expenses[count][2] = amount;
        expenses[count][3] = note;
        expenses[count][4] = code;
        expenses[count][5] = company;
        expenses[count][6] = piece;
        expenses[count][7] = type;
        count++;

        JOptionPane.showMessageDialog(this, "Expense saved successfully!");
        if (isPersonal) clearPersonalFields();
        else clearCommercialFields();
    }

    private void clearPersonalFields() {
        personalCategory.setSelectedIndex(0);
        personalAmount.setText("");
        personalNotes.setText("");
    }

    private void clearCommercialFields() {
        codeField.setText("");
        productTypeField.setText("");
        pieceField.setText("");
        companyField.setText("");
        commercialAmount.setText("");
        commercialNotes.setText("");
    }

    private void showExpenses() {
        if (count == 0) {
            JOptionPane.showMessageDialog(this, "No expenses recorded.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("DATE\tCATEGORY\tAMOUNT\tNOTE\tCODE\tCOMPANY\tPIECE\tPRODUCT\n");
        sb.append("---------------------------------------------------------------");
        sb.append("---------------------------------------------------------------");
        sb.append("---------------------------------------------------------------\n");

        double total = 0;

        for (int i = 0; i < count; i++) {
            sb.append(expenses[i][0]).append("\t")
              .append(expenses[i][1]).append("\t")
              .append(expenses[i][2]).append("\t")
              .append(expenses[i][3]).append("\t")
              .append(expenses[i][4]).append("\t")
              .append(expenses[i][5]).append("\t")
              .append(expenses[i][6]).append("\t")
              .append(expenses[i][7]).append("\n");
            try {
                total += Double.parseDouble(expenses[i][2]);
            } catch (Exception e) {
            }
        }

        sb.append("\nTOTAL EXPENSE: ").append(total);

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(800, 300));
        JOptionPane.showMessageDialog(this, scrollPane, "All Expenses", JOptionPane.INFORMATION_MESSAGE);
    }
}
