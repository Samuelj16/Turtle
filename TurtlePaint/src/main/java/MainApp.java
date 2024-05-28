import java.awt.*;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainApp {
    static World world = null;

    static Map<Color, String> names = new HashMap<>();
    static {
        Field[] fields = Color.class.getDeclaredFields();
        for (Field f : fields) {
            if (f.getType() == Color.class) {
                try {
                    names.put((Color) f.get(Color.class), f.getName());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        world = new World();
        Scanner scanner = new Scanner(System.in);
        boolean exited = false;
        int choice = -1;
        while(!exited){
            printMenu();
            choice = scanner.nextInt();
            if(choice == 1){
                addShape(scanner, shapes);
            }
            else if(choice == 2){
                //saveImage(shapes);
            }
            else if(choice == 3){
                savePainting(shapes, scanner);
            }
            else if(choice == 4){
                openPainting(shapes, scanner);
            }
            else if(choice == 0){
                exited = true;
            }
        }
        System.out.println("Good bye");

        //Square square = new Square(-100, -100, Color.BLACK, 5);
        //square.paint();

       // Triangle triangle = new Triangle(-100, -100, Color.BLACK, 5);
       // triangle.paint();

        //Hexagon hexagon = new Hexagon(-100, -100, Color.BLACK, 5);
        //hexagon.paint();
    }

    private static void openPainting(ArrayList<Shape> shapes, Scanner scanner) {
        // Ask for the file name to open
        System.out.println("What's the file name to open?");
        scanner.nextLine();
        String filename = scanner.nextLine();
        ArrayList<String> lines = null;
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            lines = new ArrayList<>();
            String currentLine = null;
            while((currentLine = br.readLine()) != null){
                // read in each line into an array list
                lines.add(currentLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // process the relevant lines and create the shapes
        if(lines != null){
            String worldLine = lines.get(1); //world details
            String[] items = worldLine.split(",");
            int width = Integer.parseInt(items[0]);
            int height = Integer.parseInt(items[1]);
            // close the existing world, create a new world and paint each of the shapes
            world.dispose();
            world = new World(width, height);
            shapes.clear();

            for (int i = 3; i < lines.size(); i++) {
                processLine(lines.get(i), shapes);
            }
        }

    }

    private static void processLine(String str, ArrayList<Shape> shapes) {
        String[] items = str.split(",");
        String shapeName = items[0];
        double x = Double.parseDouble(items[1]);//shape.getX()+ "," +
        double y = Double.parseDouble(items[2]);// shape.getX()+ ","
        double border = Double.parseDouble(items[3]); //shape.getBorder()+ ","
        String colorString =  items[4]; // shape.getColor().toString()+ ","
        //System.out.println(colorString);
        Color color = getColor(colorString.toLowerCase());
        //System.out.println(color);
        double width =  Double.parseDouble(items[5]); //shape.WIDTH+ ","
        double height =  Double.parseDouble(items[6]); //       + shape.HEIGHT+

        Shape shape = null;
        if(shapeName.equalsIgnoreCase("square")){
            shape = new Square(x,  y,  color,  border, world, width, height);

        }
        else if(shapeName.equalsIgnoreCase("triangle")){
            shape = new Triangle(x,  y,  color,  border, world, width, height);
        }
        else if(shapeName.equalsIgnoreCase("hexagon")){
            shape = new Hexagon(x,  y,  color,  border, world, width, height);
        }
        if(shape != null){
            shapes.add(shape);
            shape.paint();
        }
    }

    private static void savePainting(ArrayList<Shape> shapes,
                                     Scanner scanner) {
        // Ask for the file name
        System.out.println("What's the file name to save into?");
        scanner.nextLine();
        String fileName = scanner.nextLine();
        // use String builder to build the lines that will be written to the file
        StringBuilder builder = new StringBuilder();
        builder.append("width, height,background\n");
        builder.append(world.getWidth() + "," +
                world.getHeight()+ "," +
                names.get(world.getBackground()) + "\n");
        builder.append("shape,x,y,border,color,width,height\n");
        for (Shape shape : shapes) {
            String shapeName = "";
            if(shape instanceof Square){
                shapeName = "square";
            }
            else if(shape instanceof Triangle){
                shapeName = "triangle";
            }
            else if(shape instanceof Hexagon){
                shapeName = "hexagon";
            }
            builder.append(shapeName + "," + shape.getX()+ "," +
                    + shape.getY()+ ","
                    + shape.getBorder()+ ","
                    + names.get(shape.getColor())+ ","
                    + shape.WIDTH+ ","
                    + shape.HEIGHT+ "\n" );
        }
        try {

            FileWriter writer = new FileWriter(fileName);
            // write the total string to the file
            writer.write(builder.toString());
            writer.flush();
            writer.close();
            System.out.println("Saved successfully to " + fileName);

        } catch (IOException exception){
            exception.printStackTrace();
        }
    }

    private static void addShape(Scanner scanner, ArrayList<Shape> shapes) {
        int shapeType = -1;
        do {
            System.out.println("Which shape (1. square, 2. triangle, 3. hexagon)?");
            shapeType = scanner.nextInt();
        } while(isShapeTypeInvalid(shapeType));

        System.out.println("What is the border width?");
        double border = scanner.nextDouble();
        Color color = null;
        do {
            System.out.println("What is the border color?");
            String colorString = scanner.next();
            //System.out.println(colorString);
            color = getColor(colorString);
        } while(isColorNull(color));
        String pointsString = null;
        boolean success = false;
        int[] point = null;
        do {
            try {
                System.out.println("What is the location of the shape (x,y)?");
                scanner.nextLine();
                pointsString = scanner.nextLine();
                String[] ps = pointsString.split(",");
                point = new int[]{Integer.parseInt(ps[0]),
                        Integer.parseInt(ps[1])};
                success = true;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                success = false;
            }
        } while(!success);

        if(shapeType == 1){
            Square square = new Square(point[0], point[1], color, border, world);
            shapes.add(square);
            square.paint();
        }
        else if(shapeType == 2){
            Triangle triangle = new Triangle(point[0], point[1], color, border, world);
            shapes.add(triangle);
            triangle.paint();
        }
        else if(shapeType == 3){
            Hexagon hexagon = new Hexagon(point[0], point[1], color, border, world);
            shapes.add(hexagon);
            hexagon.paint();
        }
    }

    public static Color getColor(String colorName) {
        try {
            Field field = Class.forName("java.awt.Color").getField(colorName);
            return (Color) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static boolean isColorNull(Color color) {
        if(color == null){
            System.out.println("Invalid color given");
            return true;
        }
        return false;
    }

    private static boolean isShapeTypeInvalid(int shapeType) {
        if(shapeType == 1 || shapeType == 2 || shapeType == 3){
            return false;
        }
        System.out.println("Invalid shape given");
        return true;
    }

    private static void printMenu(){
        System.out.println("1) Add Shape");
        System.out.println("2) Save Image");
        System.out.println("3) Save painting");
        System.out.println("4) Open painting");
        System.out.println("0) Exit");
    }
}
