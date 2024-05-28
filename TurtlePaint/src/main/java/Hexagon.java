import java.awt.*;

public class Hexagon extends Shape{
    public Hexagon(double x, double y, Color color, double border, World world) {
        super(x, y, color, border, world);
    }

    public Hexagon(double x, double y, Color color, double border, World world, double width, double height) {
        super(x, y, color, border, world, width, height);
    }

    @Override
    public void paint() {
        Turtle turtle = getTurtle();

        turtle.forward(WIDTH/2);
        turtle.penUp();// stop drawing
        turtle.turnRight(60);
        turtle.penDown();// resume drawing
        turtle.forward(WIDTH/2);
        turtle.penUp();// stop drawing

        turtle.turnRight(60);
        turtle.penDown();// resume drawing
        turtle.forward(WIDTH/2);
        turtle.penUp();// stop drawing

        turtle.turnRight(60);
        turtle.penDown();// resume drawing
        turtle.forward(WIDTH/2);
        turtle.penUp();// stop drawing

        turtle.turnRight(60);
        turtle.penDown();// resume drawing
        turtle.forward(WIDTH/2);
        turtle.penUp();// stop drawing

        turtle.turnRight(60);
        turtle.penDown();// resume drawing
        turtle.forward(WIDTH/2);
        turtle.penUp();// stop drawing
    }
}
