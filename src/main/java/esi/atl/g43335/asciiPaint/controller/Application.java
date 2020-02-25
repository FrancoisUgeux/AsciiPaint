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
        view.displayHelp();
        while (!isOver) {
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
                }
                if (param[1].equals("rectangle")) {
                    paint.newRectangle(Integer.parseInt(param[2]), Integer.parseInt(param[3]),
                            Double.parseDouble(param[4]), Double.parseDouble(param[5]), param[6].charAt(0));
                }
                if (param[1].equals("square")) {
                    paint.newSquare(Integer.parseInt(param[2]), Integer.parseInt(param[3]),
                            Double.parseDouble(param[4]), param[5].charAt(0));
                }
                if (param[1].equals("line")) {
                    paint.newLine(Integer.parseInt(param[2]), Integer.parseInt(param[3]),
                            Integer.parseInt(param[4]), Integer.parseInt(param[5]), param[6].charAt(0));
                }
            } else if (command.equals("move")) {
                paint.moveShapeAt(Integer.parseInt(param[1]), Integer.parseInt(param[2]),
                        Integer.parseInt(param[3]), Integer.parseInt(param[4]));
            } else if (command.equals("group")) {
                paint.newGroup(Integer.parseInt(param[1]), Integer.parseInt(param[2]),param[3].charAt(0));
            } else if (command.equals("remove")) {
                paint.removeShape(Integer.parseInt(param[1]));
            } else if (command.equals("list")) {
                view.list(paint.getDrawing().getShapes());
            } else if (command.equals("help")) {
                view.displayHelp();
            } else if (command.equals("color")) {
                paint.changeColor(Integer.parseInt(param[1]), param[2].charAt(0));
            } else if (command.equals("load")) {
                paint.loadFile(param[1]);
            } else if (command.equals("eof")) {
                view.setInput(System.in);
            } else if (command.equals("speed")) {
                paint.setSpeed(param[1]);
            } else if (command.equals("undo")){
                
            } else if (command.equals("redo")){
                
            }
            paint.pause();
            if (paint.getSpeed() > 0)view.show(paint);
        }
    }
}
