package edu.neu.csye6200.UI;

import edu.neu.csye6200.common.Constant;
import edu.neu.csye6200.controller.Controller;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.vaccine.VaccineRecord;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class StudentTable {
    DefaultTableModel tableModel = new DefaultTableModel();
    List<Student> studentList = new ArrayList<>();
    JTable studentTable;


    public void showFrame(){
        //鍒涙嵎绐椾綋瀵硅薄
        JFrame fr = new JFrame();
        fr.setTitle("Login to DayCare");
        fr.setSize(1200,800);
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
        left.setBackground(new Color(222,156,83));
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

        JButton back = new JButton("Logout");
        left.add(back);
        back.addActionListener(e->{
            new Login().showFrame();
            fr.dispose();
        });

        JButton addStudent = new JButton("Add new student");

        addStudent.addActionListener(e->{
            AddNewStudentPanel addNewStudentPanel = new AddNewStudentPanel();
            addNewStudentPanel.showFrame();
        });
        left.add(addStudent);

        JButton vaccinePage = new JButton("View the Vaccine Page");

        vaccinePage.addActionListener(e->{
            new VaccinationTable().showFrame();
        });
        left.add(vaccinePage);
        //Top Panel
        JPanel top = new JPanel();
        container.add(top,BorderLayout.NORTH);
        JLabel tittle = new JLabel("STUDENT LIST PAGE");
        tittle.setFont(new Font(tittle.getFont().getName(), tittle.getFont().getStyle(), 80));
        top.setBackground(new Color(222,156,83));
        top.add(tittle);

        //Right Panel
//        JPanel right = new JPanel();
//        container.add(right,BorderLayout.EAST);
//        right.setLayout(new VFlowLayout(VFlowLayout.MIDDLE));


        //Middle Panel
        JPanel middle = new JPanel();
        container.add(middle,BorderLayout.CENTER);
        middle.setLayout(new BorderLayout());

        JLabel message = new JLabel("Please click on the vaccine column to check the detials.");
        message.setFont(new Font(message.getFont().getName(), message.getFont().getStyle(), 25));
        middle.add(message,BorderLayout.NORTH);
        middle.setBackground(new Color(222,156,83));
        
        //Middle Table
        studentTable = new JTable();
        middle.add(studentTable,BorderLayout.CENTER);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//鍗曞厓鏍兼覆鏌撳櫒
        tcr.setHorizontalAlignment(JLabel.CENTER);//灞呬腑鏄剧ず
        studentTable.setDefaultRenderer(Object.class, tcr);
        studentTable.setFont(new Font(tittle.getFont().getName(), tittle.getFont().getStyle(), 20));

        studentTable.setRowHeight(50);

        studentTable.setModel(tableModel);
        middle.add(new JScrollPane(studentTable),BorderLayout.CENTER);

        tableModel.addColumn("Name");
        tableModel.addColumn("Age");
        tableModel.addColumn("Vaccine");
        
        
        studentTable.setBackground(new Color(250,235,215));

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
        bottom.setBackground(new Color(222,156,83));
        //鐩戝惉鍣ㄥ璞�
//        button.addActionListener(e->{
//            System.out.println("姝ゅ璺宠浆");
//        });
        studentTable.addMouseListener( new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowI = studentTable.rowAtPoint(e.getPoint());// 寰楀埌table鐨勮鍙�
                int columnI = studentTable.columnAtPoint(e.getPoint());// 寰楀埌table鐨勫垪鍙�
//                JOptionPane.showMessageDialog(container,getVaccine(studentList,(String)studentTable.getValueAt(rowI, columnI)));
                if (rowI > -1&&columnI>-1){
                    showVaccine((String)studentTable.getValueAt(rowI, 0));
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }

        });

        //鏄剧ず绐椾綋锛屾斁鍦ㄦ渶鍚�
        fr.setVisible(true);
        
    }
    private void addRow(Student student){
        Vector<Object> rowData = new Vector<>();
        rowData.add(student.getName());
        rowData.add(student.getAge());
        tableModel.addRow(rowData);
    }

    public void showVaccine(String studentName){
        List<VaccineRecord> list = new ArrayList<>();
        for(Student student:studentList){
            if(student.getName().equals(studentName)){
                list = student.getVaccineRecords();
            }
        }
        VaccineList vl = new VaccineList();
        vl.showFrame(studentName,list);
    }
}
