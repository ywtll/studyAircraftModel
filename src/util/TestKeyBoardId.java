package util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class TestKeyBoardId extends JFrame {

    public TestKeyBoardId(){

        this.setBounds(100,100,100,100);

        Toolkit.getDefaultToolkit().addAWTEventListener(event ->  {
                if ((event).getID() == KeyEvent.KEY_PRESSED) {
                    int code = ((KeyEvent) event).getKeyCode();
                    System.out.println(code);
                }

        }, AWTEvent.KEY_EVENT_MASK);


        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        new TestKeyBoardId();
    }
}
