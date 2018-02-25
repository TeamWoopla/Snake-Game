import javax.swing.*;


public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Snakes");
        frame.setResizable(false);
        int height = 610;
        int width = 789;
        frame.setSize(width, height);
        move m = new move();
        frame.add(m);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}