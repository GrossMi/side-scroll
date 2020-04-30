import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel extends JPanel implements Runnable{

    private Rect rect;
    private Rect rectBarrier;
    private boolean left;
    private boolean right;
    private int x = 0;
    private double rateX = 1, rateY = 1;
    private double winX = 580;
    private double winY = 751;


    public DrawPanel() {
        /*rectBarrier = new Rect();
        rectBarrier.setRect(275, 100, 100, 50);*/
        rect = new Rect();
        rect.setRect(240, 650, 100, 110);
        setFocusable(true);

        new Thread(this).start();

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_LEFT && rect.getX() >= 10) {
                    left = true;

                }


                if(e.getKeyCode() == KeyEvent.VK_RIGHT && rect.getX() <= 480*rateX) {
                    right = true;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                rateX = getBounds().width/winX;
                rateY = getBounds().height/winY;
                rect.changePlace(rateX, rateY);
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });

    }

    public void movieObjects(){
        if(right) {
            rect.moveRight();
            x += 5;
            if(x == 120){
                right = false;
                x = 0;
            }
        }
        if(left){
            rect.moveLeft();
            x += 5;
            if(x == 120){
                left = false;
                x = 0;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        movieObjects();
        g2.draw(rect);
        //System.out.println(rect.getX());
       // g2.draw(rectBarrier);
    }


    @Override
    public void run() {
        while(true){
            super.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

