import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class RoundedRectangles extends JPanel{
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        int x = 50;
        int y = 50;
        int width = 200;
        int height = 100;
        int arcWidth = 20;
        int arcHeight = 20;

        GeneralPath path = new GeneralPath();
        path.moveTo(x + arcWidth, y);
        path.lineTo(x + width - arcWidth, y);
        path.quadTo(x + width, y, x + width, y + arcHeight);
        path.lineTo(x + width, y + height - arcHeight);
        path.quadTo(x + width, y + height, x + width - arcWidth, y + height);
        path.lineTo(x + arcWidth, y + height);
        path.quadTo(x, y + height, x, y + height - arcHeight);
        path.lineTo(x, y + arcHeight);
        path.quadTo(x, y, x + arcWidth, y);
        path.closePath();

        graphics2D.draw(path);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Rounded Rectangles");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.getContentPane().add(new RoundedRectangles());
            frame.setVisible(true);
        });
    }
}
