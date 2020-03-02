import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JFrame{
    public void MyWindow() {

        setSize(600,800);
        setTitle("SideScroll");
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       // JButton leftButton = new JButton("L");
        //JButton rightButton = new JButton("R");

        GridBagConstraints gridConstr = new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);

        DrawPanel drawPanel = new DrawPanel();
        DrawPanelBarier drawPanelBarier = new DrawPanelBarier();
        add(drawPanel, gridConstr);
        //add(drawPanelBarier, gridConstr);

        setVisible(true);

    }

}
