import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;

public class move extends JPanel implements ActionListener, KeyListener {
    private double x, y = 0, velx = 0, vely = 0;
    private Random randomGenerator = new Random();
    private int randX = randomGenerator.nextInt(40) * 20;
    private int randY = randomGenerator.nextInt(30) * 20;
    private int numTail = 2;
    private double[][] tail = new double[1000][2];
    private int Iscore = 0;

    move() {
        Timer t = new Timer(5, this);
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        x = 0;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.RED);
        Ellipse2D.Double Apple = new Ellipse2D.Double(randX, randY, 20,20);
        g2.fill(Apple);
        g.setColor(Color.GREEN);
        Ellipse2D.Double Head = new Ellipse2D.Double(x, y, 20, 20);
        g2.fill(Head);
        for (int i = 0; i < numTail; i++){
            g2.fill(new Ellipse2D.Double(tail[i][0], tail[i][1], 20, 20));
        }
        if((Apple.getX() == Head.getX()) && (Apple.getY() == Head.getY())) {
            randX = randomGenerator.nextInt(39);
            randY = randomGenerator.nextInt(29);
            randX = 20 * randX;
            randY = 20 * randY;
            numTail++;
            Iscore += 10;
            System.out.println(Iscore);
        }

    }

    public void actionPerformed(ActionEvent e) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        repaint();
        for (int i = numTail; i > 0; i--) {
            tail[i][0] = tail[i - 1][0];
            tail[i][1] = tail[i - 1][1];
        }
        tail[0][0] = x;
        tail[0][1] = y;
        x += velx;
        y += vely;
        for (int i = 0; i < numTail; i++){
            if ((tail[i][0] == x) && (tail[i][1] == y) && (y != 0) && (x != 0)){
                numTail = 2;
                Iscore = 0;
            }
        }

        if(x >= 780) {
            x = 0;
        } else if(y >= 580) {
            y = 0;
        } else if(x < 0) {
            x = 780;
        } else if(y < 0) {
            y = 580;
        }
    }
    private void left() {
        velx = -20;
        vely = 0;
    }
    private void right() {
        velx = 20;
        vely = 0;
    }
    private void down() {
        velx = 0;
        vely = 20;
    }
    private void up() {
        velx = 0;
        vely = -20;
    }
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W) {
            up();
        }
        if(code == KeyEvent.VK_S) {
            down();
        }
        if(code == KeyEvent.VK_A) {
            left();
        }
        if(code == KeyEvent.VK_D) {
            right();
        }
    }
    public void keyTyped(KeyEvent e) {
    }
    public void keyReleased(KeyEvent e) {
    }
}