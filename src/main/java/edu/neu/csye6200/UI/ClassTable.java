package edu.neu.csye6200.UI;

import edu.neu.csye6200.controller.Controller;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.classroom.*;
import edu.neu.csye6200.model.group.Group;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ClassTable {

    DefaultTableModel tableModel = new DefaultTableModel();

    public void showFrame() {
        //创捷窗体对象
        JFrame fr = new JFrame();
        fr.setTitle("Login to DayCare");
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
        JLabel tittle = new JLabel("CLASS LIST PAGE");
        tittle.setFont(new Font(tittle.getFont().getName(), tittle.getFont().getStyle(), 80));
        top.add(tittle);

        //Right Panel
        JPanel right = new JPanel();
        container.add(right, BorderLayout.EAST);
        right.setLayout(new VFlowLayout(VFlowLayout.MIDDLE));

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

        tableModel.addColumn("Class name");
        tableModel.addColumn("Class id");
        tableModel.addColumn("Group id");
        tableModel.addColumn("Teacher");
        tableModel.addColumn("Student");

        List<List<Classroom>> classroomRecord = Controller.spreadToClassroomWithInputData().getClassroomRecord();
        for (int i = 0; i < classroomRecord.size(); i++) {
            addRow(classroomRecord.get(i), i);
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

    private void addRow(List<Classroom> classroomList, int classIndex) {
        String className;
        if (classIndex == 0) {
            className = "6 - 12 class";
        } else if (classIndex == 1) {
            className = "13 - 24 class";
        } else if (classIndex == 2) {
            className = "25 - 35 class";
        } else if (classIndex == 3) {
            className = "36 - 47 class";
        } else if (classIndex == 4) {
            className = "48 - 59 class";
        } else {
            className = "60 - class";
        }
        for (int i = 0; i < classroomList.size(); i++) {
            Classroom classroom = classroomList.get(i);
            int classId = i;
            Vector<Object> rowData = new Vector<>();
            rowData.add(className);
            rowData.add(classId);
            List<Group> groupList = classroom.getGroupList();
            for (int j = 0; j < groupList.size(); j++) {
                Group group = groupList.get(j);
                int groupId = j;
                Vector<Object> rowDataGroup = new Vector<>(rowData);
                rowDataGroup.add(groupId);
                rowDataGroup.add(group.getTeacher().getName());
                StringBuilder stringBuilder = new StringBuilder();
                List<Student> studentList = group.getStudentList();
                for(int k = 0;k<studentList.size();k++){
                    stringBuilder.append(studentList.get(k).getName());
                    if(k!=studentList.size()-1){
                        stringBuilder.append(", ");
                    }
                }
                rowDataGroup.add(stringBuilder.toString());
                tableModel.addRow(rowDataGroup);
            }
        }
    }

}
