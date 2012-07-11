package com.mlinee; /**
 * Created with IntelliJ IDEA.
 * User: alexandr.tkachuk
 * Date: 11.07.12
 * Time: 14:36
 * To change this template use File | Settings | File Templates.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mlinee {

    public static void main(String[] args) {
        FormFrame frame = new FormFrame();
        frame.setSize(200, 350);
        frame.setTitle("Meny");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //  frame.pack();
    }
}

class FormFrame extends JFrame {
    JPanel northPanel = new JPanel();
    JPanel westPanel= new JPanel();
    JPanel eastPanel = new JPanel();
    JPanel southPanel= new JPanel();
    Container westBox= Box.createVerticalBox();
    Container southBox= Box.createVerticalBox();
    Component strut=Box.createVerticalStrut(10);

    Component glue=Box.createVerticalGlue();
    //????????? ????????
    JCheckBox comps=new JCheckBox ("computers");
    JCheckBox netBooks=new JCheckBox ("notebooks");
    JCheckBox notebook=new JCheckBox ("notebook");
    JCheckBox foto=new JCheckBox ("foto");
    JCheckBox video=new JCheckBox ("video");
    JCheckBox printers=new JCheckBox ("printers");
    JLabel chooseLabel=new JLabel();
    JLabel chooseLabel1=new JLabel();
    JButton confirmButton=new JButton("start");


    JFrame myframe=this;
    FormFrame(){

        setLayout(new BorderLayout());


        northPanel.add(new JLabel("Form"));
        northPanel.setBackground(Color.blue);


        westBox.add(new JLabel("hobby"));
        westBox.add(comps);
        westBox.add(netBooks);
        westBox.add(notebook);
        westBox.add(foto);
        westBox.add(video);
        westBox.add(printers);



        final ButtonGroup radioGroup=new ButtonGroup();


        Container eastBox= Box.createVerticalBox();


        eastBox.add(new JLabel("age"));
        JRadioButton radioButton;

        eastBox.add(radioButton=new JRadioButton("-"));
        radioButton.setSelected(true);
        radioButton.setActionCommand("-");
        radioGroup.add(radioButton);
        eastBox.add(radioButton=new JRadioButton("12..18"));
        radioButton.setActionCommand("12..18");
        radioGroup.add(radioButton);
        eastBox.add(radioButton=new JRadioButton("19..30"));
        radioButton.setActionCommand("19..30");
        radioGroup.add(radioButton);
        eastBox.add(radioButton=new JRadioButton("30..60"));
        radioButton.setActionCommand("30..60");
        radioGroup.add(radioButton);
        eastBox.add(radioButton=new JRadioButton(">60"));
        radioButton.setActionCommand(">60");
        radioGroup.add(radioButton);

        //???????


        confirmButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        southBox.add(confirmButton);
        chooseLabel1.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        southBox.add(chooseLabel1);
        chooseLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        southBox.add(strut);
        southBox.add(chooseLabel);
        southBox.add(glue);


        add(northPanel, BorderLayout.NORTH);
        add(westBox, BorderLayout.WEST);
        add(eastBox, BorderLayout.CENTER);
        add(southBox, BorderLayout.SOUTH);

        confirmButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent ae){
                String compClass, labelText="<HTML> hobby: <br/>";


                String radioCommand=radioGroup.getSelection().getActionCommand();
                System.out.println(radioCommand);
                String labelText1="you are "+radioCommand+" years old";
                chooseLabel1.setText(labelText1);

                Component[] components= westBox.getComponents();

                for (int i=0; i<components.length; i++){
                    compClass=components[i].getClass().toString();
                    if (compClass.equalsIgnoreCase("class javax.swing.JCheckBox")){
                        JCheckBox cb = (JCheckBox)components[i];
                        if (cb.isSelected()) {
                            labelText=labelText.concat("&nbsp &nbsp"+cb.getText()+"<br>");
                        }
                    }
                }

                chooseLabel.setText(labelText);

            }//actionPerformed()
        });
    }//formFrame()

}//FormFrame
