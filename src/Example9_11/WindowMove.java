package Example9_11;
/*
 *   Example9_11
 *   Author：fjs
 *   2022-04-24
 *   10:59
 */


import javax.swing.*;
import java.awt.*;

public class WindowMove extends JFrame {
    LP layeredPane;

    WindowMove() {
        layeredPane = new LP();
        add(layeredPane, BorderLayout.CENTER);
        setVisible(true);
        setBounds(12, 12, 300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
