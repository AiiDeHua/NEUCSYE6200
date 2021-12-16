package edu.neu.csye6200.UI;

import edu.neu.csye6200.common.Constant;
import edu.neu.csye6200.controller.Controller;
import edu.neu.csye6200.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class StudentTable {
    DefaultTableModel tableModel = new DefaultTableModel();
    List<Student> studentList = new ArrayList<>();

    public void showFrame(){
        //创捷窗体对象
        JFrame fr = new JFrame();
        fr.setTitle("Login to DayCare");
        fr.setSize(1200,800);
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
        container.add(left,BorderLayout.WEST);
        left.setLayout(new VFlowLayout(VFlowLayout.MIDDLE));
            //Button on left
        JButton viewTeacher = new JButton("View Teacher Page");
        left.add(viewTeacher);
        viewTeacher.addActionListener(e->{
            new TeacherTable().showFrame();
            fr.dispose();
        });

        JButton viewClass = new JButton("View Class Page");
        left.add(viewClass);
        viewClass.addActionListener(e->{
            new ClassTable().showFrame();
            fr.dispose();
        });

        JButton back = new JButton("Back To Login");
        left.add(back);
        back.addActionListener(e->{
            new Login().showFrame();
            fr.dispose();
        });

        //Top Panel
        JPanel top = new JPanel();
        container.add(top,BorderLayout.NORTH);
        JLabel tittle = new JLabel("STUDENT LIST PAGE");
        tittle.setFont(new Font(tittle.getFont().getName(), tittle.getFont().getStyle(), 80));
        top.add(tittle);

        //Right Panel
        JPanel right = new JPanel();
        container.add(right,BorderLayout.EAST);
        right.setLayout(new VFlowLayout(VFlowLayout.MIDDLE));

        JButton addStudent = new JButton("Add new student");
        right.add(addStudent);

        //Middle Panel
        JPanel middle = new JPanel();
        container.add(middle,BorderLayout.CENTER);
        middle.setLayout(new BorderLayout());

        JLabel message = new JLabel("Please click on the vaccine column to check the detials.");
        message.setFont(new Font(message.getFont().getName(), message.getFont().getStyle(), 25));
        middle.add(message,BorderLayout.NORTH);
            //Middle Table
        JTable studentTable = new JTable();
        middle.add(studentTable,BorderLayout.CENTER);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
        tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示
        studentTable.setDefaultRenderer(Object.class, tcr);
        studentTable.setFont(new Font(tittle.getFont().getName(), tittle.getFont().getStyle(), 20));

        studentTable.setRowHeight(50);

        studentTable.setModel(tableModel);
        middle.add(new JScrollPane(studentTable),BorderLayout.CENTER);

        tableModel.addColumn("Name");
        tableModel.addColumn("Age");
        tableModel.addColumn("Vaccine");

        studentList = Controller.readStudentInput(Constant.EXCEL_PATH);
        for (Student student : studentList) {
            addRow(student);
        }
        studentTable.getColumnModel().getColumn(2).setCellRenderer(new MyButtonRender());
        //Top Panel
        JPanel bottom = new JPanel();
        container.add(bottom,BorderLayout.SOUTH);
        JLabel none = new JLabel();
        none.setPreferredSize(new Dimension(0,200));
        bottom.add(none);
        top.add(none);
        //监听器对象
//        button.addActionListener(e->{
//            System.out.println("此处跳转");
//        });


        //显示窗体，放在最后
        fr.setVisible(true);
    }
    private void addRow(Student student){
        Vector<Object> rowData = new Vector<>();
        rowData.add(student.getName());
        rowData.add(student.getAge());
        tableModel.addRow(rowData);
    }
}
