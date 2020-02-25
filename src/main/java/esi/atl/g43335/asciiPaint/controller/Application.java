package esi.atl.g43335.asciiPaint.controller;

import esi.atl.g43335.asciiPaint.view.AsciiPaint;
import esi.atl.g43335.asciiPaint.view.View;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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
            switch (command) {
                case "quit":
                    System.out.println("");
                    view.quit();
                    isOver = true;
                    break;
                case "show":
                    System.out.println(view.asAscii(paint));
                    break;
                case "add":
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
                    break;
                case "move":
                    paint.moveShape(Integer.parseInt(param[1]), Integer.parseInt(param[2]), Integer.parseInt(param[3]));
                    break;
                case "group":
                    paint.newGroup(Integer.parseInt(param[1]), Integer.parseInt(param[2]));
                    break;
                case "remove":
                    paint.removeShape(Integer.parseInt(param[1]));
                    break;
                case "list":
                    view.list(paint.getDrawing().getShapes());
                    break;
                case "help":
                    view.displayHelp();
                    break;
                case "color":
                    paint.changeColor(Integer.parseInt(param[1]), param[2].charAt(0));
                    break;
                case "load":
                    loadFile(param[1]);
                    break;
                case "eof":
                    view.setInput(System.in);
                    break;
                case "speed":
                    paint.setSpeed(param[1]);
                    break;
                case "undo":
                    paint.undo();
                    break;
                case "redo":
                    paint.redo();
                    break;
                default:
                    view.displayError("Wrong command.type 'help' for more info");
                    break;
            }
            paint.pause();
            if (paint.getSpeed() > 0) {
                view.show(paint);
            }
        }
    }

    void loadFile(String file) {
        try {
            InputStream in = new FileInputStream(file);
            view.setInput(in);
        } catch (FileNotFoundException ex) {
            System.err.println("File not found " + file);
        }
    }
}
