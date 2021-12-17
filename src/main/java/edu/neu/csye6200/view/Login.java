package edu.neu.csye6200.view;

import javax.swing.*;
import java.awt.*;

public class Login {

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
        //上面的位置和大小,也可以用setBounds来设置
        container.setBounds(320, 80, 550, 250);
        container.setOpaque(false);
        root.add(container);

        JLabel label1;
        JLabel label2;
        JLabel label3;
        JLabel label4;
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
        label4 = new JLabel("Welcome to DayCare System!");
        label4.setFont(new Font(label4.getFont().getName(), label4.getFont().getStyle(), 30));
        tf = new JTextField();
        tf.setPreferredSize(new Dimension(50,30));
        psf = new JPasswordField();
        //showPassword=new JCheckBox("Show Password");
        button = new JButton("Login");
        button.setFont(new Font(button.getFont().getName(), button.getFont().getStyle(), 20));
        button.setBackground(Color.WHITE);
        //监听器对象

        button.addActionListener(e->{
            if(tf.getText().isEmpty()&&psf.getPassword().length==0)
            {
                JOptionPane.showMessageDialog(null,"Empty input","!",JOptionPane.WARNING_MESSAGE);
            }else{
                if(tf.getText().startsWith("s")){
                    if(psf.getPassword().length!=0){
                        new StudentTable().showFrame();
                        fr.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"Empty password","!",JOptionPane.WARNING_MESSAGE);
                    }
                }else if(tf.getText().startsWith("t")){
                    if(psf.getPassword().length!=0){
                        new TeacherTable().showFrame();
                        fr.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"Empty password","!",JOptionPane.WARNING_MESSAGE);
                    }

                }else{
                    JOptionPane.showMessageDialog(null,"invaild user","!",JOptionPane.WARNING_MESSAGE);
                }
            }

        });

        JLabel lblBackground = new JLabel();
        ImageIcon icon = new ImageIcon("res/loginbg.png");
        lblBackground.setIcon(icon);
        lblBackground.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        fr.getContentPane().add(lblBackground);

        // 为指定的 Container 创建 GroupLayout
        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);
        //创建GroupLayout的水平连续组，，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGap(5);//添加间隔
        hGroup.addGroup(layout.createParallelGroup().addComponent(label2)
                .addComponent(label3));
        hGroup.addGap(5);
        hGroup.addGroup(layout.createParallelGroup().addComponent(label4)
                .addComponent(label1)
                .addComponent(psf)
                .addComponent(tf).addComponent(button));
        hGroup.addGap(5);

        layout.setHorizontalGroup(hGroup);
        //创建GroupLayout的垂直连续组，，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(label4));
        vGroup.addGap(20);
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