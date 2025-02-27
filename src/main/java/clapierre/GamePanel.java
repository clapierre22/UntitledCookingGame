package src.main.java.clapierre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
    static final int WIDTH = 640, HEIGHT = 480;
    Player player;
    List<Rectangle> platforms;
    Timer timer;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        player = new Player(100, 300);

        // 60 FPS
        timer = new Timer(16, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    // case KeyEvent.VK_LEFT -> player.moveLeft();
                    // case KeyEvent.VK_RIGHT -> player.moveRight();
                    case KeyEvent.VK_SPACE -> player.jump();
                    case KeyEvent.VK_A -> player.moveLeft();
                    case KeyEvent.VK_D -> player.moveRight();
                    case KeyEvent.VK_W -> player.jump();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D) {
                    player.stop();
                }
            }
        });
        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update(platforms);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Draw player
    }
}
