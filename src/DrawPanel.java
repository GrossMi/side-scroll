import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel extends JPanel implements Runnable{

    private Rect rect;
    private Rect rectBarier;
    private boolean Left = false;
    private boolean Right = false;

    public DrawPanel() {

        rectBarier = new Rect();
        rectBarier.setRect(275, 100, 100, 50);
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

                if(rect.getX() < 25) Left = false;
                if(rect.getX() > 500) Right = false;
                if(e.getKeyCode() == KeyEvent.VK_LEFT && rect.getX() >= 25) Left = true;
                if(e.getKeyCode() == KeyEvent.VK_RIGHT && rect.getX() <= 500) Right = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT) Left = false;
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) Right = false;
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(rect);
        g2.draw(rectBarier);

    }

    public void animation(){
        if(Left) rect.moveLeft();
        if(Right) rect.moveRight();
       // rectBarier.moveDown();
        super.repaint();
    }


    @Override
    public void run() {
        while(true){
            animation();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

