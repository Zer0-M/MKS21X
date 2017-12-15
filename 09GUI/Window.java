import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Window extends JFrame implements ActionListener {
    private Container pane;
    private JCheckBox CtoF;
    private JCheckBox FtoC;
    private JButton convert;
    private JTextField t;
 
  //CONSTRUCTOR SETS EVERYTHING UP
  public void actionPerformed(ActionEvent e) { 
      String s =e.getActionCommand();
      System.out.println(s);
      
  } 
  public Window() {
     this.setTitle("My first GUI");
     this.setSize(600,400);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     pane = this.getContentPane();
     pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
    
     FtoC = new JCheckBox("Farenheit to Celsius");
     CtoF = new JCheckBox("Celsius to Farenheit");
     convert= new JButton("Convert");
     t = new JTextField(12);
     convert.addActionListener(this);
     FtoC.addActionListener(this);
     CtoF.addActionListener(this);
     pane.add(FtoC);
     pane.add(CtoF);
     pane.add(t);
     pane.add(convert);
 }

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     Window g = new Window();
     g.setVisible(true);
  }
}
