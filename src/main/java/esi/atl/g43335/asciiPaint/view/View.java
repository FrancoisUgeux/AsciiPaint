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
        System.out.println("Welcome, type help to learn more about the commands");
    }

    public void quit() {
        System.out.println("See you soon(or never again)");
    }

    public void displayError(String message) {
        System.out.println(message);
    }

    public void displayHelp() {
        System.out.println("Here are the different integrated command: ");
        System.out.println("add: add a new shape");
        System.out.println("show: display the shapes already added");
        System.out.println("quit: kill me :( (has a badly writted program "
                + "i have feelings too!)");
    }

    public String askCommand() {
        System.out.println("please enter your command(s): ");
        String commands = in.nextLine();
        return commands;
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
}
