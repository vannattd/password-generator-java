import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class gui {

  boolean hasSpecials;
  ItemListener itemListener = new ItemListener() {
    public void itemStateChanged(ItemEvent e) {
      int state = e.getStateChange();

      if (state == ItemEvent.SELECTED) {
        hasSpecials = true;
      } else {
        hasSpecials = false;
      }
    }
  };

  KeyAdapter keyAdapter = new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
        e.consume(); // if it's not a number, ignore the event
      }
    }
  };

  public gui() {
    JFrame frame = new JFrame("Password Generator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 800);

    JPanel mainPanel = new JPanel();
    JPanel controlPanel = new JPanel();

    JToggleButton specialButton = new JToggleButton("Special Characters");

    JLabel passwordLabel = new JLabel("Password Length");
    JTextField numCharsTextField = new JTextField(5);
    JButton generateButton = new JButton("Generate Password");

    numCharsTextField.addKeyListener(keyAdapter);

    specialButton.addItemListener(itemListener);

    mainPanel.add(specialButton);

    controlPanel.add(passwordLabel);
    controlPanel.add(numCharsTextField);
    controlPanel.add(generateButton);


    frame.getContentPane().add(BorderLayout.NORTH, controlPanel);
    frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

    frame.setVisible(true);
  }

  public static void main(String[] args) {

    new gui();

  }

}
