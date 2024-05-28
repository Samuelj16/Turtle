import java.awt.*;

public class Square extends Shape{

    public Square(double x, double y, Color color, double border, World world) {
        super(x, y, color, border, world);
    }

    public Square(double x, double y, Color color, double border, World world, double width, double height) {
        super(x, y, color, border, world, width, height);
    }

    @Override
    public void paint() {
        // how to draw a square
        Turtle turtle = getTurtle();
        turtle.forward(WIDTH);
        turtle.penUp();// stop drawing
        turtle.turnRight(90);

        turtle.penDown();// resume drawing
        turtle.forward(HEIGHT);

        turtle.penUp();//stop drawing
        turtle.turnRight(90);

        turtle.penDown();// resume drawing
        turtle.forward(WIDTH);

        turtle.penUp();
        turtle.turnRight(90);

        turtle.penDown();
        turtle.forward(HEIGHT);
    }
}
