package esi.atl.g43335.asciiPaint;

import esi.atl.g43335.asciiPaint.controller.Application;
import esi.atl.g43335.asciiPaint.model.AsciiPaint;
import esi.atl.g43335.asciiPaint.view.View;

/**
 *
 * @author franc
 */
public class main {

    public static void main(String[] args) {
        AsciiPaint paint = new AsciiPaint(50, 50);
        View view = new View();
        Application app = new Application(view, paint);
        app.start();
    }
}
