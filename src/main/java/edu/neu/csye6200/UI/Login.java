package edu.neu.csye6200.UI;

import org.apache.batik.ext.awt.image.spi.JDKRegistryEntry;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Login {
    public static void main(String args[]) {
        Login tf = new Login();
        tf.showFrame();
    }

//        //鐩戝惉鍣ㄥ唴閮ㄧ被
//        private class MyActionListener implements ActionListener{
//
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                        System.out.println("姝ゅ搴旇璺宠浆");
//                }
//        }

    public void showFrame() {
        //创建窗体对象
        JFrame fr = new JFrame();
        fr.setTitle("Login to DayCare");
        fr.setSize(1200, 800);
        //璁剧疆閫�鍑鸿繘绋嬬殑鏂规硶
        fr.setDefaultCloseOperation(3);

        //设置居中显示
        fr.setLocationRelativeTo(null);

        //设置panel
        JPanel root = new JPanel();
        fr.setContentPane(root);
        root.setLayout(null);

        JPanel container = new JPanel();
        container.setBounds(320, 80, 550, 250);//上面的位置和大小，也可以用setbounds来设置
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
        label1.setFont(new Font(label1.getFont().getName(), label1.getFont().getStyle(), 25));
        label2 = new JLabel("Name:");
        label2.setFont(new Font(label2.getFont().getName(), label2.getFont().getStyle(), 20));
        label3 = new JLabel("Password:");
        label3.setFont(new Font(label3.getFont().getName(), label3.getFont().getStyle(), 20));
        label4 = new JLabel("Welcome to DayCare System!");
        //label4.setBounds(550, 200, 400, 200);
        label4.setFont(new Font(label4.getFont().getName(), label4.getFont().getStyle(), 30));
        tf = new JTextField();
        tf.setPreferredSize(new Dimension(50,30));
        psf = new JPasswordField();
        //showPassword=new JCheckBox("Show Password");
        button = new JButton("Login");
        button.setFont(new Font(button.getFont().getName(), button.getFont().getStyle(), 20));
        button.setBackground(Color.WHITE);
        //鐩戝惉鍣ㄥ璞�

        button.addActionListener(e->{
            if(tf.getText().isEmpty()&&psf.getPassword().length==0)
            {
                JOptionPane.showMessageDialog(null,"Empty input","!",JOptionPane.WARNING_MESSAGE);
            }else{
                if(tf.getText().startsWith("s")){
                    if(psf.getPassword().length!=0){
                    	new StudentTable().showFrame();
                        fr.dispose();
                    	
                        //new TeacherTable().showFrame();
                        //fr.dispose();
//                        new VaccinationTable().showFrame();
//                        fr.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"Empty password","!",JOptionPane.WARNING_MESSAGE);
                    }
                }else if(tf.getText().startsWith("t")){
                    if(psf.getPassword().length!=0){
                    	  new TeacherTable().showFrame();
                          fr.dispose();
//                        new StudentTable().showFrame();
//                        fr.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"Empty password","!",JOptionPane.WARNING_MESSAGE);
                    }

                }else{
                    JOptionPane.showMessageDialog(null,"invaild user","!",JOptionPane.WARNING_MESSAGE);
                }
            }

        });
        
        //在login界面插入图片
        JLabel lblBackground = new JLabel();
        //URL resource = this.getClass().getResource("E:\\eclipse_workspace_csye6200_finalproject\\NEUCSYE6200GroupProject\\res\\loginbg.png");
        ImageIcon icon = new ImageIcon("res/loginbg.png");
        lblBackground.setIcon(icon);
        lblBackground.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        fr.getContentPane().add(lblBackground);

        // 为指定的 Container 创建 GroupLayout
        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);
        //创建GroupLayout的水平连续组，粍锛岋紝瓒婂厛鍔犲叆鐨凱arallelGroup锛屼紭鍏堢骇绾у埆瓒婇珮銆�
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGap(5);//娣诲姞闂撮殧
        hGroup.addGroup(layout.createParallelGroup().addComponent(label2)
                .addComponent(label3));               
        hGroup.addGap(5);
        hGroup.addGroup(layout.createParallelGroup().addComponent(label4)
        		.addComponent(label1)
                .addComponent(psf)
                .addComponent(tf)
                .addComponent(button));
        hGroup.addGap(5);

        layout.setHorizontalGroup(hGroup);
        //鍒涘缓GroupLayout鐨勫瀭鐩磋繛缁粍锛岋紝瓒婂厛鍔犲叆鐨凱arallelGroup锛屼紭鍏堢骇绾у埆瓒婇珮銆�
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
        //璁剧疆鍨傜洿缁�
        layout.setVerticalGroup(vGroup);
        fr.setVisible(true);
    }
}