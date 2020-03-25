import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel extends JPanel implements Runnable{

    private Rect rect;
    private Rect rectBarrier;

    public DrawPanel() {

        rectBarrier = new Rect();
        rectBarrier.setRect(275, 100, 100, 50);
        rect = new Rect();
        rect.setRect(275, 700, 50, 50);
        setFocusable(true);

        new Thread(this).start();

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_LEFT && rect.getX() >= 10) {
                    rect.moveLeft();
                }


                if(e.getKeyCode() == KeyEvent.VK_RIGHT && rect.getX() <= 520) {
                    rect.moveRight();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(rect);
        //System.out.println(rect.getX());
       // g2.draw(rectBarrier);

    }


  @Override
    public void run() {
        while(true){
            super.repaint();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

