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
        System.out.println("add rectangle, x-axis, y-axis, height, width, color: "
                + "add a new rectangle");
        System.out.println("add circle, x-axis, y-axis, radius, color: add a new circle");
        System.out.println("add square, x-axis, y-axis, side, color: add a new square");
        System.out.println("move x-axis, y-axis, deltaX, deltaY: move a point to the chosen delta");
        System.out.println("group shapeNbrInList1 shapeNbrInList2: create a group with the shapes selected");
        System.out.println("show: display the shapes already added");
        System.out.println("quit: kill me :( (as a badly writted program "
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

    public void completedShape() {
        System.out.println(" ");
        System.out.println("Shape added you can now show it or add a new one");
    }

    public String asAscii(AsciiPaint ascii) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < ascii.getHeight(); i++) {
            for (int j = 0; j < ascii.getWidth(); j++) {
                string.append(ascii.getColor(i, j)).append(" ");
            }
            string.append("\n");
        }
        return string.toString();
    }
}
