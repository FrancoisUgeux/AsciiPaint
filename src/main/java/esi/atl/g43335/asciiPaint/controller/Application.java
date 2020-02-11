package esi.atl.g43335.asciiPaint.controller;

import esi.atl.g43335.asciiPaint.view.AsciiPaint;
import esi.atl.g43335.asciiPaint.view.View;

/**
 *
 * @author g43335
 */
public class Application {

    private View view;
    private AsciiPaint paint;

    public Application(View view, AsciiPaint paint) {
        this.view = view;
        this.paint = paint;
    }

    public void start() {
        boolean isOver = false;
        view.initialize();
        while (!isOver) {
            view.displayHelp();
            String commands = view.askCommand().trim();
            String[] param = commands.split(" ");
            String command = param[0];
            if (command.equals("quit")) {
                System.out.println("");
                view.quit();
                isOver = true;
            } else if (command.equals("show")) {
                System.out.println(paint.asAscii());
            } else if (command.equals("add")) {
                if (param[1].equals("circle")) {
                    paint.newCircle(view.askX(), view.askY(), view.askRadius(), view.askColor());
                    view.completedShape();
                }
                if (param[1].equals("rectangle")) {
                    paint.newRectangle(view.askX(), view.askY(), view.askWidth(),
                            view.askHeight(), view.askColor());
                    view.completedShape();
                }
                if (param[1].equals("square")) {
                    paint.newSquare(view.askX(), view.askY(), view.askSide(), view.askColor());
                    view.completedShape();
                }
            }
        }
    }
}
