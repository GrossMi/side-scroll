import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;
import java.awt.*;


public class Window extends JFrame{
    public void MyWindow() {

        setSize(600,800);
        setTitle("SideScroll");
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
      //  getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 25));

       // JButton leftButton = new JButton("L");
        //JButton rightButton = new JButton("R");

        GridBagConstraints gridConstraints = new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);

        DrawPanel drawPanel = new DrawPanel();
        add(drawPanel, gridConstraints);


        setVisible(true);

    }

}
