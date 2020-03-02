import javax.swing.*;
import java.awt.*;

public class DrawPanelBarier extends JPanel implements Runnable{

    private Rect rect;

    public DrawPanelBarier() {

        rect = new Rect();
        rect.setRect(250, 200, 100, 50);

        setFocusable(true);

        new Thread(this).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(rect);
    }

    @Override
    public void run() {
        while(true){
            rect.moveDown();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
