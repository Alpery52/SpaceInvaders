package SpaceInvaders.View;

import SpaceInvaders.Entities.*;
import SpaceInvaders.Model.GameState;
import SpaceInvaders.Model.SpaceInvadersModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static SpaceInvaders.View.Inf101Graphics.drawCenteredString;

/**
 * Constructs a SpaceInvadersView with the specified for SpaceInvadersModel
 *
 * @param SpaceInvadersModel the SpaceInvadersModel to be displayed
 */
public class SpaceInvadersView extends JPanel {

    final int WINDOW_WIDTH;
    final int WINDOW_HIGHT;
    private  Player player;
    private ArrayList<Enemy> enemies;
    private SpaceInvadersModel model;
    private Theme theme;
    private Image startImage;
    private Image background;


    public SpaceInvadersView(SpaceInvadersModel model) {
        this.model = model;
        this.WINDOW_WIDTH = model.getWidth();
        this.WINDOW_HIGHT = model.getHeight();
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HIGHT));
        this.player = model.getPlayer();
        this.enemies = model.getEnemies();
        this.theme = model.getTheme();
        this.setBackground(theme.getBackgroundColor());
        this.startImage = theme.startImage();
        this.background = theme.backgroundImage();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (model.getGameState() == GameState.WELCOME_SCREEN){
            drawStartScreen(g2);
        }
        else if (model.getGameState() == GameState.ACTIVE_GAME){
            drawGame(g2);
        }
        else if (model.getGameState() == GameState.GAME_OVER){
            gameOver(g2);
        }
        else if (model.getGameState()== GameState.VICTORY){
            victory(g2);
        }
    }

    private void drawGame(Graphics2D g2) {
        drawBackground(g2);
        drawPlayer(g2, player);
        drawEnemies(g2, enemies);
        drawProjectile(g2, model.getProjectiles(), theme.PlayerProsjectile());
        drawProjectile(g2, model.getEnemyProjectiles(), theme.enemyProsjectile());
        drawGameScoreInGame(g2);
    }


    private void drawPlayer(Graphics2D g2, Player player) {
        g2.drawImage(model.getPlayer().getIcon(), player.getx(), player.gety(), player.getWidth(), player.getHeight(), null);
    }

    private void drawProjectile(Graphics2D g2, ArrayList<Projectile> projectiles, Color color) {
        for (Projectile p : projectiles) {
            g2.setColor(color);
            g2.fillRect(p.getx(), p.gety(), p.getWidth(), p.getHight());
        }
    }


    private void drawEnemies(Graphics2D g2, ArrayList<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (enemy.getAlive()) {
                g2.setColor(new Color(0, 0, 0, 0));
                g2.fillRect(enemy.getx(), enemy.gety(), enemy.getWidth(), enemy.getHeight());
                g2.drawImage(enemy.getIcon(), enemy.getx(), enemy.gety(), enemy.getWidth(), enemy.getHeight(), null);
            }
        }
    }

    private void drawGameScoreInGame(Graphics2D g2) {
        int score = model.getGameScore();
        String scoreText = "Score: " + score;
        g2.setColor(theme.scoreColor());
        g2.setFont(new Font("Arial", Font.PLAIN, 16));
        g2.drawString(scoreText, 10, 15);

    }
    private void gameOver(Graphics2D g2) {
        g2.setColor(theme.gameOverColor());
        g2.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HIGHT);


        drawGameOverText(g2);   // Draw gameover text
        drawFinalGameScore(g2); // Draw final game score when game over
        drawRestartMessage(g2); // Draw restart message when game over

    }
    private void victory(Graphics2D g2){
        g2.setColor(theme.gameOverColor());
        g2.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HIGHT);


        drawVictoryScreen(g2);   // Draw gameover text
        drawRestartMessage(g2); // Draw restart message when game over

    }

    //Gjennbruk av kode fra tetris
    private void drawRestartMessage(Graphics2D g2) {
        String message = "PRESS SPACE TO RESTART";
        g2.setColor(theme.reStartTextColor());
        g2.setFont(new Font("Arial", Font.PLAIN, 18));
        drawCenteredString(g2, message, WINDOW_WIDTH / 2, WINDOW_HIGHT / 2 + 70);
    }

    private void drawFinalGameScore(Graphics2D g2) {
        int score = model.getGameScore();
        String scoreText = "Score: " + score;
        g2.setFont(new Font("Arial", Font.PLAIN, 24));
        drawCenteredString(g2, scoreText, WINDOW_WIDTH / 2, WINDOW_HIGHT/ 2 + 40);

    }

    private void drawGameOverText(Graphics2D g2) {
        g2.setColor(theme.gameOverTekstColor());
        g2.setFont(new Font("Arial", Font.BOLD, 36));
        String gameOverText = "Game Over";
        drawCenteredString(g2, gameOverText, WINDOW_WIDTH / 2, WINDOW_HIGHT / 2);
    }


    private void drawStartScreen(Graphics2D g2) {
        if (this.startImage != null) {
            g2.drawImage(this.startImage, 0, 0, WINDOW_WIDTH, WINDOW_HIGHT, this);
        }

    }
    private void drawBackground(Graphics2D g2) {
        if (this.background != null) {
            g2.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HIGHT, null);
        }

    }
    private void drawVictoryScreen(Graphics2D g2) {
        g2.setColor(theme.victoryTextColor());
        g2.setFont(new Font("Arial", Font.BOLD, 36));
        String gameOverText = "VICTORY";
        drawCenteredString(g2, gameOverText, WINDOW_WIDTH / 2, WINDOW_HIGHT / 2);
    }
}