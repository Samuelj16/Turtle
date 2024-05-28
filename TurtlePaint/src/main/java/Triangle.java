import java.awt.*;

public class Triangle extends Shape{

    public Triangle(double x, double y, Color color, double border, World world) {
        super(x, y, color, border, world);
    }

    public Triangle(double x, double y, Color color, double border, World world, double width, double height) {
        super(x, y, color, border, world, width, height);
    }

    @Override
    public void paint() {
        // start from center
        Turtle turtle = getTurtle();

        turtle.turnRight(60);
        turtle.forward(WIDTH);
        turtle.penUp();// stop drawing

        turtle.turnRight(120);
        turtle.penDown();// resume drawing
        turtle.forward(WIDTH);
        turtle.penUp();// stop drawing

        turtle.turnRight(120);
        turtle.penDown();// resume drawing
        turtle.forward(WIDTH);
    }
}
