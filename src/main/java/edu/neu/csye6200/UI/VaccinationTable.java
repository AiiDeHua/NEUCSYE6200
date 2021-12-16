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
        //创捷窗体对象
        JFrame fr = new JFrame();
        fr.setTitle("DayCare");
        fr.setSize(2000, 800);
        //设置退出进程的方法
        fr.setDefaultCloseOperation(3);

        //设置居中显示
        fr.setLocationRelativeTo(null);

        //设置panel
        JPanel container = new JPanel();
        fr.setContentPane(container);

        container.setLayout(new BorderLayout());

        //Left Panel
        JPanel left = new JPanel();
        container.add(left, BorderLayout.WEST);
        left.setLayout(new VFlowLayout(VFlowLayout.MIDDLE));
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

        //Right Panel
        JPanel right = new JPanel();
        container.add(right, BorderLayout.EAST);
        right.setLayout(new VFlowLayout(VFlowLayout.MIDDLE));

        //JButton addStudent = new JButton("Add new student");
        //right.add(addStudent);

        //Middle Panel
        JPanel middle = new JPanel();
        container.add(middle, BorderLayout.CENTER);
        middle.setLayout(new BorderLayout());

        //Middle Table
        JTable studentTable = new JTable();
        middle.add(studentTable, BorderLayout.CENTER);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
        tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示
        studentTable.setDefaultRenderer(Object.class, tcr);
        studentTable.setFont(new Font(tittle.getFont().getName(), tittle.getFont().getStyle(), 20));

        studentTable.setRowHeight(50);

        studentTable.setModel(tableModel);
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
        JLabel none = new JLabel();
        none.setPreferredSize(new Dimension(0, 200));
        bottom.add(none);
        top.add(none);
        //监听器对象
//        button.addActionListener(e->{
//            System.out.println("此处跳转");
//        });

        //显示窗体，放在最后
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
