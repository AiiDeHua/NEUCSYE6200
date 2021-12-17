package edu.neu.csye6200.UI;

import edu.neu.csye6200.common.Constant;
import edu.neu.csye6200.controller.Controller;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.classroom.Classroom;
import edu.neu.csye6200.model.group.Group;
import edu.neu.csye6200.model.vaccine.VaccineRecord;
import edu.neu.csye6200.util.DateUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class VaccinationTable {
    DefaultTableModel tableModel = new DefaultTableModel();

    public void showFrame() {
        //鍒涙嵎绐椾綋瀵硅薄
        JFrame fr = new JFrame();
        fr.setTitle("DayCare");
        fr.setSize(1200, 800);
        //璁剧疆閫�鍑鸿繘绋嬬殑鏂规硶
        fr.setDefaultCloseOperation(3);

        //璁剧疆灞呬腑鏄剧ず
        fr.setLocationRelativeTo(null);

        //璁剧疆panel
        JPanel container = new JPanel();
        fr.setContentPane(container);

        container.setLayout(new BorderLayout());

        //Left Panel
        JPanel left = new JPanel();
        container.add(left, BorderLayout.WEST);
        left.setLayout(new VFlowLayout(VFlowLayout.MIDDLE));
        left.setBackground(new Color(38, 194, 129));
        //Button on left
        JButton viewTeacher = new JButton("View Teacher Page");
        left.add(viewTeacher);
        viewTeacher.addActionListener(e -> {
            new TeacherTable().showFrame();
            fr.dispose();
        });

        JButton viewClass = new JButton("View Student Page");
        left.add(viewClass);
        viewClass.addActionListener(e -> {
            new StudentTable().showFrame();
            fr.dispose();
        });

        JButton back = new JButton("Logout");
        left.add(back);
        back.addActionListener(e -> {
            new Login().showFrame();
            fr.dispose();
        });

        //Top Panel
        JPanel top = new JPanel();
        container.add(top, BorderLayout.NORTH);
        JLabel tittle = new JLabel("Student Vaccination Page");
        tittle.setFont(new Font(tittle.getFont().getName(), tittle.getFont().getStyle(), 80));
        top.add(tittle);
        top.setBackground(new Color(38, 194, 129));

        //Right Panel
        JPanel right = new JPanel();
        container.add(right, BorderLayout.EAST);
        right.setLayout(new VFlowLayout(VFlowLayout.MIDDLE));
        right.setBackground(new Color(38, 194, 129));

        //JButton addStudent = new JButton("Add new student");
        //right.add(addStudent);

        //Middle Panel
        JPanel middle = new JPanel();
        container.add(middle, BorderLayout.CENTER);
        middle.setLayout(new BorderLayout());
        middle.setBackground(new Color(38, 194, 129));

        //Middle Table
        JTable studentTable = new JTable();
        middle.add(studentTable, BorderLayout.CENTER);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//鍗曞厓鏍兼覆鏌撳櫒
        tcr.setHorizontalAlignment(JLabel.CENTER);//灞呬腑鏄剧ず
        studentTable.setDefaultRenderer(Object.class, tcr);
        studentTable.setFont(new Font(tittle.getFont().getName(), tittle.getFont().getStyle(), 20));

        studentTable.setRowHeight(50);

        studentTable.setModel(tableModel);
        studentTable.setBackground(new Color(200, 247, 197));
        
        JScrollPane jScrollPane = new JScrollPane(studentTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        middle.add(jScrollPane);
//        middle.add(jScrollPane, BorderLayout.CENTER);

        tableModel.addColumn("Student Name");
        tableModel.addColumn("Hib");
        tableModel.addColumn("DTaP");
        tableModel.addColumn("Polio");
        tableModel.addColumn("HepatitisB");
        tableModel.addColumn("MMR");
        tableModel.addColumn("Varicella");


//        java.util.List<java.util.List<Classroom>> classroomRecord = Controller.spreadToClassroomWithInputData().getClassroomRecord();
//        for (int i = 0; i < classroomRecord.size(); i++) {
//            addRow(classroomRecord.get(i), i);
//        }
        List<Student> studentList = Controller.readStudentInput(Constant.EXCEL_PATH);
        for(int i=0;i<studentList.size();i++){
            addRow(studentList.get(i));
        }
        
        //Top Panel
        JPanel bottom = new JPanel();
        container.add(bottom, BorderLayout.SOUTH);
        bottom.setBackground(new Color(38, 194, 129));
        JLabel none = new JLabel();
        none.setPreferredSize(new Dimension(0, 200));
        bottom.add(none);
        top.add(none);
        //鐩戝惉鍣ㄥ璞�
//        button.addActionListener(e->{
//            System.out.println("姝ゅ璺宠浆");
//        });

        //鏄剧ず绐椾綋锛屾斁鍦ㄦ渶鍚�
        fr.setVisible(true);
    }

    private void addRow(Student in) {
        Vector<Object> rowData = new Vector<>();
        rowData.add(in.getName());
        for(VaccineRecord k:in.getVaccineRecords()){
            Date op= in.getNextVaxDate(k.getVacName());
            System.out.println(in.getName()+", "+k.getVacName()+" "+op);
            if(op==null){
               rowData.add("Completed");
           }else {
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat sf = new SimpleDateFormat(pattern);
                if(sf.format(op).equals(sf.format(new Date())))
                {
                    rowData.add("Now");
                }else{
                    rowData.add(sf.format(op));

                }
           }

        }


        tableModel.addRow(rowData);

    }
}
