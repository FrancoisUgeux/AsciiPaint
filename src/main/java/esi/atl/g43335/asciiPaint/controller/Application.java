package esi.atl.g43335.asciiPaint.controller;

import esi.atl.g43335.asciiPaint.view.AsciiPaint;
import esi.atl.g43335.asciiPaint.view.View;
import esi.atl.g43335.asciiPaint.view.View;

/**
 *
 * @author g43335
 */
public class Application {

    private View view;
    private AsciiPaint paint;

    public Application() {
    }

    public void start() {
        boolean isOver = false;
        while (!isOver) {
            String commands = view.askCommand().toLowerCase().trim();
            isOver = commands.equals("quit");
            if (commands.equals("show")) {
                System.out.println(paint.asAscii());
            } else if (commands.equals("add")) {
                String shape = view.askShape();
                switch (shape) {
                    case "circle":
                        paint.newCircle(view.askX(), view.askY(),
                                view.askRadius(), view.askColor());
                        break;

                    case "rectangle":
                        paint.newRectangle(view.askX(), view.askY(),
                                view.askWidth(), view.askHeight(), view.askColor());
                        break;
                    case "square":
                        paint.newSquare(view.askX(), view.askY(),
                                view.askSide(), view.askColor());
                }
            }
        }
    }

    public static void main(String[] args) {
        Application app = new Application();
        AsciiPaint paint = new AsciiPaint();
        View view = new View();
        view.initialize();
        app.start();
    }
}
