import java.awt.*;
import java.awt.geom.*;

/**
 * An example for the use of a GeneralPath to draw a car.
 *
 * @author Frank Klawonn
 *         Last change 07.01.2005
 */
public class RoundedCorners extends Frame {
    // Constructor
    RoundedCorners() {
        // Enables the closing of the window.
        addWindowListener(new MyFinishWindow());
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Use of antialiasing to have nicer lines.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // The lines should have a thickness of 3.0 instead of 1.0.
        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);

        GeneralPath path = new GeneralPath();
        path.moveTo(70, 70);
        path.lineTo(230, 70);
        path.quadTo(250, 70, 250, 90);
        path.lineTo(250, 130);
        path.quadTo(250, 150, 230, 150);
        path.lineTo(70, 150);
        path.quadTo(50, 150, 50, 130);
        path.lineTo(50, 90);
        path.quadTo(50, 70, 70, 70);

        g2d.draw(path);

        g2d.setStroke(new BasicStroke(1.0f));
        // Draw a coordinate system.
        drawSimpleCoordinateSystem(300, 200, g2d);

    }

    /**
     * Draws a coordinate system (according to the window coordinates).
     *
     * @param xmax x-coordinate to which the x-axis should extend.
     * @param ymax y-coordinate to which the y-axis should extend.
     * @param g2d  Graphics2D object for drawing.
     */
    public static void drawSimpleCoordinateSystem(int xmax, int ymax,
            Graphics2D g2d) {
        int xOffset = 30;
        int yOffset = 50;
        int step = 20;
        String s;
        // Remember the actual font.
        Font fo = g2d.getFont();
        // Use a small font.
        g2d.setFont(new Font("sansserif", Font.PLAIN, 9));
        // x-axis.
        g2d.drawLine(xOffset, yOffset, xmax, yOffset);
        // Marks and labels for the x-axis.
        for (int i = xOffset + step; i <= xmax; i = i + step) {
            g2d.drawLine(i, yOffset - 2, i, yOffset + 2);
            g2d.drawString(String.valueOf(i), i - 7, yOffset - 7);
        }

        // y-axis.
        g2d.drawLine(xOffset, yOffset, xOffset, ymax);

        // Marks and labels for the y-axis.
        s = "  "; // for indention of numbers < 100
        for (int i = yOffset + step; i <= ymax; i = i + step) {
            g2d.drawLine(xOffset - 2, i, xOffset + 2, i);
            g2d.drawString(s + String.valueOf(i), xOffset - 25, i + 5);
        }

        // Reset to the original font.
        g2d.setFont(fo);
    }

    public static void main(String[] argv) {
        RoundedCorners f = new RoundedCorners();
        f.setTitle("Rounded Rectangle");
        f.setSize(400, 250);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}
