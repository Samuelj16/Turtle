import java.awt.*;
import java.awt.geom.Point2D;

/*
Shape: abstract
 */
public abstract class Shape implements Paintable{
    public double WIDTH = 200;
    public double HEIGHT = 200;

    //turtle: the turtle that is used to paint the shape
    private Turtle turtle;
    //location: Point -- the x,y coordinate where the shape should be drawn
    private Point2D location;
    //color: the color used for the border
    private Color color;
    //border: the width of the shape border
    private double border;
    private double x;
    private double y;

    public Shape(double x, double y, Color color, double border, World world){
        // create the Turtle
       turtle = new Turtle(x, y, world);
       turtle.setColor(color);
       turtle.setPenWidth(border);
       this.location = turtle.getLocation();
       this.color = color;
       this.border = border;
       this.x = x;
       this.y = y;
    }

    public Shape(double x, double y, Color color, double border, World world, double width, double height){
        // create the Turtle
        this(x,  y,  color,  border, world);
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    public Turtle getTurtle() {
        return turtle;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getBorder() {
        return border;
    }

    public Color getColor() {
        return color;
    }
}
