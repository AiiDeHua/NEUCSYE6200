package edu.neu.csye6200.view;

import edu.neu.csye6200.common.Constant;
import edu.neu.csye6200.util.DateUtil;
import edu.neu.csye6200.util.FileUtil;

import javax.swing.*;
import java.awt.*;

public class AddNewStudentPanel {



    public void showFrame(){
        //创捷窗体对象
        JFrame fr = new JFrame();
        fr.setTitle("Login to DayCare");
        fr.setLayout(null);
        fr.setBounds(400, 200, 600, 400);
        fr.setBackground(new Color(38, 194, 129));
        //设置退出进程的方法
        fr.setDefaultCloseOperation(2);

        //设置居中显示
        fr.setLocationRelativeTo(null);

        JLabel name;
        JTextField nameInput;
        JLabel age;
        JTextField ageInput;
        JButton addNewStudent;

        name = new JLabel();
        name.setText("Student Name");
        name.setBounds(10, 10, 200, 30);
        nameInput = new JTextField();
        nameInput.setBounds(210, 10, 200, 30);
        age = new JLabel();
        age.setBounds(10, 50, 200, 30);
        age.setText("Student age");
        ageInput = new JTextField();
        ageInput.setBounds(210, 50, 200, 30);

        JLabel DTaP = new JLabel("DTaP");
        DTaP.setBounds(10, 90, 200, 30);
        javax.swing.JTextField DTapText = new JTextField();
        DTapText.setBounds(210, 90, 200, 30);
//        text.setText("date of birth");
        Chooser ser = Chooser.getInstance(DateUtil.formatter.toPattern());
        ser.register(DTapText);
        JLabel HepatitisB = new JLabel("HepatitisB");
        HepatitisB.setBounds(10, 130, 200, 30);
        javax.swing.JTextField HepatitisBText= new JTextField();
        HepatitisBText.setBounds(210, 130, 200, 30);
        Chooser ser1 = Chooser.getInstance(DateUtil.formatter.toPattern());
        ser1.register(HepatitisBText);

        JLabel Hib = new JLabel("Hib");
        Hib.setBounds(10, 170, 200, 30);
        javax.swing.JTextField HibText = new JTextField();
        HibText.setBounds(210, 170, 200, 30);
        Chooser ser2 = Chooser.getInstance(DateUtil.formatter.toPattern());
        ser2.register(HibText);

        JLabel MMR = new JLabel("MMR");
        MMR.setBounds(10, 210, 200, 30);
        javax.swing.JTextField MMRText = new JTextField();
        MMRText.setBounds(210, 210, 200, 30);
        Chooser ser3 = Chooser.getInstance(DateUtil.formatter.toPattern());
        ser3.register(MMRText);

        JLabel Polio = new JLabel("Polio");
        Polio.setBounds(10, 250, 200, 30);
        javax.swing.JTextField PolioText = new JTextField();
        PolioText.setBounds(210, 250, 200, 30);
        Chooser ser4 = Chooser.getInstance(DateUtil.formatter.toPattern());
        ser4.register(PolioText);

        JLabel Varicella = new JLabel("Varicella");
        Varicella.setBounds(10, 290, 200, 30);
        javax.swing.JTextField VaricellaText = new JTextField();
        VaricellaText.setBounds(210, 290, 200, 30);
        Chooser ser5 = Chooser.getInstance(DateUtil.formatter.toPattern());
        ser5.register(VaricellaText);


        addNewStudent = new JButton();
        addNewStudent.setText("add");
        addNewStudent.setBounds(500,330,100,30);
        addNewStudent.addActionListener(e -> {
            String delimiter = ";";
            String dateDelimiter = ",";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(nameInput.getText());
            stringBuilder.append(delimiter);
            stringBuilder.append(ageInput.getText());
            stringBuilder.append(delimiter);
            stringBuilder.append(DTaP.getText());
            stringBuilder.append(dateDelimiter);
            stringBuilder.append(DTapText.getText());
            stringBuilder.append(dateDelimiter);
            stringBuilder.append(HepatitisB.getText());
            stringBuilder.append(dateDelimiter);
            stringBuilder.append(HepatitisBText.getText());
            stringBuilder.append(dateDelimiter);
            stringBuilder.append(Hib.getText());
            stringBuilder.append(dateDelimiter);
            stringBuilder.append(HibText.getText());
            stringBuilder.append(dateDelimiter);
            stringBuilder.append(MMR.getText());
            stringBuilder.append(dateDelimiter);
            stringBuilder.append(MMRText.getText());
            stringBuilder.append(dateDelimiter);
            stringBuilder.append(Polio.getText());
            stringBuilder.append(dateDelimiter);
            stringBuilder.append(PolioText.getText());
            stringBuilder.append(dateDelimiter);
            stringBuilder.append(Varicella.getText());
            stringBuilder.append(dateDelimiter);
            stringBuilder.append(VaricellaText.getText());
            stringBuilder.append(" ");
            stringBuilder.append(dateDelimiter);
            FileUtil.writeExcelRowBySheet(stringBuilder.toString(), Constant.EXCEL_PATH, 0);
            fr.dispose();
        });

        fr.add(DTapText);
        fr.add(HepatitisBText);
        fr.add(HibText);
        fr.add(MMRText);
        fr.add(PolioText);
        fr.add(VaricellaText);
        fr.add(name);
        fr.add(nameInput);
        fr.add(age);
        fr.add(ageInput);
        fr.add(DTaP);
        fr.add(HepatitisB);
        fr.add(Hib);
        fr.add(MMR);
        fr.add(Polio);
        fr.add(Varicella);
        fr.add(addNewStudent);
        fr.setVisible(true);
    }

}
