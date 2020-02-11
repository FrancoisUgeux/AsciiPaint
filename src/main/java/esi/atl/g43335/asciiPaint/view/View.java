package esi.atl.g43335.asciiPaint.view;

import java.util.Scanner;

/**
 *
 * @author franc
 */
public class View {

    private Scanner in;

    public View() {
        this.in = new Scanner(System.in);
    }

    public void initialize() {
        System.out.println("Welcome!");
    }

    public void quit() {
        System.out.println("See you soon(or never again)");
    }

    public void displayError(String message) {
        System.out.println(message);
    }

    public void displayHelp() {
        System.out.println(" ");
        System.out.println("input: ");
        System.out.println(" ");
        System.out.println("add rectangle, x-axis, y-axis, width, height, color: "
                + "add a new rectangle");
        System.out.println("add circle, x-axis, y-axis, radius, color: add a new circle");
        System.out.println("add square, x-axis, y-axis, side, color: add a new square");
        System.out.println("show: display the shapes already added");
        System.out.println("quit: kill me :( (has a badly writted program "
                + "i have feelings too!)");
        System.out.println(" ");
    }

    public String askCommand() {
        System.out.println("please enter your command(s): ");
        return in.nextLine();
    }

    public String askShape() {
        System.out.println("Choose a shape to add from the following: "
                + "rectangle/circle/square");
        return in.next();
    }

    public int askX() {
        System.out.println("Enter the x-axis");
        return in.nextInt();
    }

    public int askY() {
        System.out.println("Enter the y-axis");
        return in.nextInt();
    }

    public int askWidth() {
        System.out.println("Enter the width");
        return in.nextInt();
    }

    public int askHeight() {
        System.out.println("Enter the height");
        return in.nextInt();
    }

    public int askSide() {
        System.out.println("Enter the size of your square");
        return in.nextInt();
    }

    public int askRadius() {
        System.out.println("Enter the radius");
        return in.nextInt();
    }

    public char askColor() {
        System.out.println("Enter a color for your shape"
                + "(reminder: its a character not an actual color)");
        return in.next().charAt(0);
    }

    public void completedShape() {
        System.out.println("Shape added you can now show it or add a new one");
    }
}
