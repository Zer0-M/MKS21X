import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Window extends JFrame implements ActionListener {
  private Container pane;
  private JCheckBox CtoF;
  private JCheckBox FtoC;
  private JButton convert;
  private JTextField input;
  private JTextField result;
  
 
  //CONSTRUCTOR SETS EVERYTHING UP
  public void actionPerformed(ActionEvent e) { 
      String s =e.getActionCommand();
      if(s.equals("Convert")){
        if(CtoF.isSelected()){
          result.setText(Temperature.CtoF(Double.parseDouble(input.getText()))+"");
        }
        else if(FtoC.isSelected()){
          result.setText(Temperature.FtoC(Double.parseDouble(input.getText()))+"");
        }
      }    
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
     input = new JTextField(12);
     result = new JTextField(12);
     convert.addActionListener(this);
     FtoC.addActionListener(this);
     CtoF.addActionListener(this);
     pane.add(FtoC);
     pane.add(CtoF);
     pane.add(input);
     pane.add(convert);
     pane.add(result);
 }

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     Window g = new Window();
     g.setVisible(true);
  }
}
