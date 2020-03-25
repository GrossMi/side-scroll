import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rect extends Rectangle2D {

    private Point point;
    private double width;
    private double height;

    private double x0;
    private double y0;

    public Rect() {
        point = new Point();
    }

    @Override
    public void setRect(double x, double y, double width, double height) {
        point.setLocation(x, y);
        this.width = width;
        this.height = height;

        x0 = point.getX();
        y0 = point.getY();

    }

    @Override
    public int outcode(double x, double y) {
        return 0;
    }

    @Override
    public Rectangle2D createIntersection(Rectangle2D r) {
        return null;
    }

    @Override
    public Rectangle2D createUnion(Rectangle2D r) {
        return null;
    }

    @Override
    public double getX() {
        return x0;
    }

    @Override
    public double getY() {
        return y0;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public boolean isEmpty() {

        return false;
    }

    public void moveLeft(){
        x0 -= 5;
        this.setRect(x0, y0, getWidth(), getHeight());
    }

    public void moveRight(){
        x0 += 5;
        this.setRect(x0, y0, getWidth(), getHeight());
    }

    public void moveDown() {
        y0+= 1;
        this.setRect(x0, y0, getWidth(), getHeight());
    }
}
