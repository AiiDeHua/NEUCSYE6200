package edu.neu.csye6200.UI;

import edu.neu.csye6200.common.Constant;
import edu.neu.csye6200.controller.Controller;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.model.vaccine.VaccineRecord;
import edu.neu.csye6200.util.DateUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class VaccineList {

    public void showFrame(String name,List<VaccineRecord> list){
        //鍒涙嵎绐椾綋瀵硅薄
        JFrame fr = new JFrame();
        fr.setTitle("Vaccine Page");
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
        //Button on left
        JButton back = new JButton("Logout");
        left.add(back);
        back.addActionListener(e->{
            new Login().showFrame();
            fr.dispose();
        });

        //Top Panel
        JPanel top = new JPanel();
        container.add(top,BorderLayout.NORTH);
        JLabel tittle = new JLabel();
        tittle.setText("Vaccine Records: "+name);
        tittle.setFont(new Font(tittle.getFont().getName(), tittle.getFont().getStyle(), 80));
        top.add(tittle);

        //Right Panel
        JPanel right = new JPanel();
        container.add(right,BorderLayout.EAST);
        right.setLayout(new VFlowLayout(VFlowLayout.MIDDLE));

        JButton aReturn = new JButton("Return");
        right.add(aReturn);
        aReturn.addActionListener(e->{
            fr.dispose();
        });

        //Middle Panel
        JPanel middle = new JPanel();
        container.add(middle,BorderLayout.CENTER);
        middle.setLayout(new CardLayout());
        //Middle List
        DefaultListModel listModel = new DefaultListModel();
        JList vl = new JList();
        middle.add(vl);
        vl.setFont(new Font(vl.getFont().getName(), vl.getFont().getStyle(), 25));
        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        vl.setCellRenderer(renderer);
        vl.setModel(listModel);
        List<String> stringList = refactor(list);
        for (String vaccineRecord : stringList) {
            listModel.addElement(vaccineRecord);
        }

        //Top Panel
        JPanel bottom = new JPanel();
        container.add(bottom,BorderLayout.SOUTH);
        JLabel none = new JLabel();
        none.setPreferredSize(new Dimension(0,200));
        bottom.add(none);
        top.add(none);
        //鐩戝惉鍣ㄥ璞�
//        button.addActionListener(e->{
//            System.out.println("姝ゅ璺宠浆");
//        });

        
        //鏄剧ず绐椾綋锛屾斁鍦ㄦ渶鍚�
        fr.setVisible(true);
    }
    public List<String> refactor(List<VaccineRecord> list){
        List<String> result = new ArrayList<>();
        for (VaccineRecord vaccineRecord : list) {
            String temp = vaccineRecord.getVacName();
            result.add("_____ "+temp+" _____");
            List<Date> tempList = vaccineRecord.getDateList();
            String dateString = "Records:";
            if(tempList.size()==0){dateString += "No Record Found";
            } else{
                for (Date date : tempList) {
                dateString = dateString+DateUtil.formatter.format(date)+" ";
            } }
            result.add(dateString);
        }
        return result;
    }
}
