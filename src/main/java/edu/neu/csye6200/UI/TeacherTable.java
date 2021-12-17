package edu.neu.csye6200.UI;

import edu.neu.csye6200.common.Constant;
import edu.neu.csye6200.controller.Controller;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
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

public class TeacherTable {
    DefaultTableModel tableModel = new DefaultTableModel();
    List<Teacher> teacherList = new ArrayList<>();

    public void showFrame(){
        //鍒涙嵎绐椾綋瀵硅薄
        JFrame fr = new JFrame();
        fr.setTitle("Teacher Page");
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
        container.add(left,BorderLayout.WEST);
        left.setLayout(new VFlowLayout(VFlowLayout.MIDDLE));
        left.setBackground(new Color(148,124,176));
        //Button on left
        JButton viewStudent = new JButton("View Student Page");
        left.add(viewStudent);
        viewStudent.addActionListener(e->{
            new StudentTable().showFrame();
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

        //Top Panel
        JPanel top = new JPanel();
        container.add(top,BorderLayout.NORTH);
        JLabel tittle = new JLabel("TEACHER LIST PAGE");
        tittle.setFont(new Font(tittle.getFont().getName(), tittle.getFont().getStyle(), 80));
        top.setBackground(new Color(148,124,176));
        top.add(tittle);

        //Right Panel
//        JPanel right = new JPanel();
//        container.add(right,BorderLayout.EAST);
//        right.setLayout(new VFlowLayout(VFlowLayout.MIDDLE));

        //Middle Panel
        JPanel middle = new JPanel();
        container.add(middle,BorderLayout.CENTER);
        middle.setLayout(new BorderLayout());
        middle.setBackground(new Color(148,124,176));

        JLabel message = new JLabel("Please click on the vaccine column to check the detials.");
        message.setFont(new Font(message.getFont().getName(), message.getFont().getStyle(), 25));
        middle.add(message,BorderLayout.NORTH);
        //Middle Table
        JTable teacherTable = new JTable();
        middle.add(teacherTable,BorderLayout.CENTER);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//鍗曞厓鏍兼覆鏌撳櫒
        tcr.setHorizontalAlignment(JLabel.CENTER);//灞呬腑鏄剧ず
        teacherTable.setDefaultRenderer(Object.class, tcr);
        teacherTable.setFont(new Font(tittle.getFont().getName(), tittle.getFont().getStyle(), 20));

        teacherTable.setRowHeight(50);

        teacherTable.setModel(tableModel);
        middle.add(new JScrollPane(teacherTable),BorderLayout.CENTER);
        
        teacherTable.setBackground(new Color(205,181,205));

        tableModel.addColumn("Name");
        tableModel.addColumn("Age");
        tableModel.addColumn("Vaccine");

        teacherList = Controller.readTeacherInput(Constant.EXCEL_PATH);
        for (Teacher teacher : teacherList) {
            addRow(teacher);
        }
        teacherTable.getColumnModel().getColumn(2).setCellRenderer(new MyButtonRender());
        //Top Panel
        JPanel bottom = new JPanel();
        container.add(bottom,BorderLayout.SOUTH);
        bottom.setBackground(new Color(148,124,176));
        JLabel none = new JLabel();
        none.setPreferredSize(new Dimension(0,200));
        bottom.add(none);
        top.add(none);
        //鐩戝惉鍣ㄥ璞�
//        button.addActionListener(e->{
//            System.out.println("姝ゅ璺宠浆");
//        });

        teacherTable.addMouseListener( new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowI = teacherTable.rowAtPoint(e.getPoint());// 寰楀埌table鐨勮鍙�
                int columnI = teacherTable.columnAtPoint(e.getPoint());// 寰楀埌table鐨勫垪鍙�
//                JOptionPane.showMessageDialog(container,getVaccine(studentList,(String)studentTable.getValueAt(rowI, columnI)));
                if (rowI > -1&&columnI>-1){
                    showVaccine((String)teacherTable.getValueAt(rowI, 0));
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
    private void addRow(Teacher teacher){
        Vector<Object> rowData = new Vector<>();
        rowData.add(teacher.getName());
        rowData.add(teacher.getAge());
        tableModel.addRow(rowData);
    }
    public void showVaccine(String teacherName){
        List<VaccineRecord> list = new ArrayList<>();
        for(Teacher teacher:teacherList){
            if(teacher.getName().equals(teacherName)){
                list = teacher.getVaccineRecords();
            }
        }
        VaccineList vl = new VaccineList();
        vl.showFrame(teacherName,list);
    }
}
