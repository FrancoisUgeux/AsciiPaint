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
            String commands = view.askCommand().toLowerCase().trim();
            String[] param = commands.split(" ");
            String command = param[0];
            if (command.equals("quit")) {
                System.out.println("");
                view.quit();
                isOver = true;
            } else if (command.equals("show")) {
                System.out.println(view.asAscii(paint));
            } else if (command.equals("add")) {
                if (param[1].equals("circle")) {
                    paint.newCircle(Integer.parseInt(param[2]), Integer.parseInt(param[3]),
                            Double.parseDouble(param[4]), param[5].charAt(0));
                    view.completedShape();
                }
                if (param[1].equals("rectangle")) {
                    paint.newRectangle(Integer.parseInt(param[2]), Integer.parseInt(param[3]),
                            Double.parseDouble(param[4]), Double.parseDouble(param[5]), param[6].charAt(0));
                    view.completedShape();
                }
                if (param[1].equals("square")) {
                    paint.newSquare(Integer.parseInt(param[2]), Integer.parseInt(param[3]),
                            Double.parseDouble(param[4]), param[5].charAt(0));
                    view.completedShape();
                }
            }
        }
    }
}
