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
    
    public void start(){
        System.out.println("sa maman");
    }
    
    public static void main(String[] args) {
        Application app = new Application();
        AsciiPaint paint = new AsciiPaint();
        View view = new View();
        view.initialize();
        app.start();
    }
}
