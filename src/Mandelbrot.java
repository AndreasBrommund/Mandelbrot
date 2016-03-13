import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by andreasbrommund on 2016-01-12.
 * 
 */
public class Mandelbrot extends JFrame{

    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;

    private final int maxIterations = 255;

    private int pixels[][];

    public static void main(String[] args) {
        new Mandelbrot();
    }

    public Mandelbrot(){
        super("Mandelbrot");

        pixels = new int[WIDTH][HEIGHT];

        calculatePixels();

        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        repaint();
        setVisible(true);
    }

    private void calculatePixels(){
        for(int x = 0;x < WIDTH;x++){
            for(int y = 0;y < HEIGHT;y++){
                pixels[x][y] = calculateIterations(x,y);
            }
        }
    }

    private int calculateIterations(double x,double y){
        int iterations = 0;
        ComplexNumber c = new ComplexNumber((4*x)/WIDTH-2,(-4*y)/HEIGHT+2);
        ComplexNumber z = new ComplexNumber(0,0);

        while(ComplexNumber.abs(z) < 2 && iterations < maxIterations){
            z = func(z,c);
            iterations++;
        }

        return iterations;
    }

    private ComplexNumber func(ComplexNumber z, ComplexNumber c){
        return ComplexNumber.add(ComplexNumber.mul(z,z),c);
    }

    @Override
    public void paint(Graphics g) {
        for(int x = 0;x < WIDTH;x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (pixels[x][y] == maxIterations){
                    g.setColor(Color.BLACK);
                }else if(pixels[x][y] > 20){
                    g.setColor(Color.BLUE);
                }else if(pixels[x][y] > 10){
                    g.setColor(Color.CYAN);
                }else{
                    g.setColor(Color.GREEN);
                }

                g.drawLine(x,y,x,y);
            }
        }
    }
}
