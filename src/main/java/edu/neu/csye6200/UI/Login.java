package edu.neu.csye6200.UI;

import org.apache.batik.ext.awt.image.spi.JDKRegistryEntry;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    public static void main(String args[]) {
        Login tf = new Login();
        tf.showFrame();
    }

//        //监听器内部类
//        private class MyActionListener implements ActionListener{
//
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                        System.out.println("此处应该跳转");
//                }
//        }

    public void showFrame() {
        //创捷窗体对象
        JFrame fr = new JFrame();
        fr.setTitle("Login to DayCare");
        fr.setSize(1200, 800);
        //设置退出进程的方法
        fr.setDefaultCloseOperation(3);

        //设置居中显示
        fr.setLocationRelativeTo(null);

        //设置panel
        JPanel root = new JPanel();
        fr.setContentPane(root);
        root.setLayout(null);

        JPanel container = new JPanel();
        container.setBounds(70, 200, 400, 200);//上面的位置和大小,也可以用setBounds来设置
        root.add(container);

        JLabel label1;
        JLabel label2;
        JLabel label3;
        JTextField tf;
        JPasswordField psf;
        JButton button;
        //JCheckBox showPassword;

        label1 = new JLabel("Administrator Login");
        label1.setFont(new Font(label1.getFont().getName(), label1.getFont().getStyle(), 20));
        label2 = new JLabel("Name：");
        label2.setFont(new Font(label2.getFont().getName(), label2.getFont().getStyle(), 20));
        label3 = new JLabel("Password：");
        label3.setFont(new Font(label3.getFont().getName(), label3.getFont().getStyle(), 20));
        tf = new JTextField();
        psf = new JPasswordField();
        //showPassword=new JCheckBox("Show Password");
        button = new JButton("Login");
        button.setFont(new Font(button.getFont().getName(), button.getFont().getStyle(), 20));
        //监听器对象

        button.addActionListener(e->{
            if(tf.getText().isEmpty()&&psf.getPassword().length==0)
            {
                JOptionPane.showMessageDialog(null,"Empty input","!",JOptionPane.WARNING_MESSAGE);
            }else{
                if(tf.getText().startsWith("s")){
                    if(psf.getPassword().length!=0){
                        //new TeacherTable().showFrame();
                        //fr.dispose();
//                        new VaccinationTable().showFrame();
//                        fr.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"Empty password","!",JOptionPane.WARNING_MESSAGE);
                    }
                }else if(tf.getText().startsWith("t")){
                    if(psf.getPassword().length!=0){
                        new StudentTable().showFrame();
                        fr.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"Empty password","!",JOptionPane.WARNING_MESSAGE);
                    }

                }else{
                    JOptionPane.showMessageDialog(null,"invaild user","!",JOptionPane.WARNING_MESSAGE);
                }
            }

        });

        // 为指定的 Container 创建 GroupLayout
        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);
        //创建GroupLayout的水平连续组，，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGap(5);//添加间隔
        hGroup.addGroup(layout.createParallelGroup().addComponent(label2)
                .addComponent(label3));
        hGroup.addGap(5);
        hGroup.addGroup(layout.createParallelGroup().addComponent(label1)
                .addComponent(psf)
                .addComponent(tf).addComponent(button));
        hGroup.addGap(5);

        layout.setHorizontalGroup(hGroup);
        //创建GroupLayout的垂直连续组，，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(label1));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(label2)
                .addComponent(tf));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(label3)
                .addComponent(psf));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(button));
        vGroup.addGap(10);
        //设置垂直组
        layout.setVerticalGroup(vGroup);
        fr.setVisible(true);
    }
}