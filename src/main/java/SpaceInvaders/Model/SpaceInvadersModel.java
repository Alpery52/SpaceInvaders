package SpaceInvaders.Model;

import SpaceInvaders.Entities.*;
import SpaceInvaders.View.DefaultTheme;
import SpaceInvaders.View.SohaibInvaders;
import SpaceInvaders.View.Theme;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

/**
 * Represents the model component of the Space Invaders game.
 * This class manages the game state, player, enemies, projectiles, and game logic.
 */
public class SpaceInvadersModel {
    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<Projectile> projectiles;
    private ArrayList<Projectile> enemyProjectiles;
    private GameState currentGameState;
    private int gameScore;
    private int WIDTH;
    private int HEIGHT;
    private Theme theme;
    private boolean movingRight = true;  // Initialize movingRight as true to start movement to the right


    /**
     * Initializes a new instance of the Space Invaders game model.
     * Sets up the game environment including player, enemies, and theme.
     *
     * @param Width  the width of the game area.
     * @param Height the height of the game area.
     */
    public SpaceInvadersModel(int Width, int Height) {
        this.currentGameState = GameState.WELCOME_SCREEN;
        this.theme = new DefaultTheme();
        this.gameScore = 0;
        this.WIDTH = Width;
        this.HEIGHT = Height;

        this.player = new Player((Width-50)/2, (Height-50)-10,
                theme.playerImage(), theme.playerImageL(), theme.playerImageR());
        this.enemies = new ArrayList<>();
        this.projectiles = new ArrayList<>();
        this.enemyProjectiles = new ArrayList<>();
        createEnemies();

    }

    /**
     * Moves the player left, ensuring they do not exit the game area.
     */
    public void playerMoveLeft() {
        if (player.getx() > 0) {
            player.movePlayerLeft(player.getSpeed());
        }
    }

    /**
     * Moves the player right, ensuring they do not exit the game area.
     */
    public void playerMoveRight() {
        if (player.getx() + player.getWidth() < WIDTH) {
            player.movePlayerRight(player.getSpeed());
        }

    }

    /**
     * Handles the shooting action from the player
     */
    public void playerShoot() {
        projectiles.add(player.shoot());
    }


    /**
     * Updates the game  by processing movements, collisions, and enemy actions.
     */
    public void update() {
        checkCollisions();
        updateProjectiles(projectiles);
        updateProjectiles(enemyProjectiles);
        moveEnemiesEdge();
        maybeShootFromEnemies();
    }


    private void updateProjectiles(ArrayList<Projectile> projectiles) {
        Iterator<Projectile> projectileIterator = projectiles.iterator();
        while (projectileIterator.hasNext()) {
            Projectile projectile = projectileIterator.next();
            projectile.update();
            if (projectile.gety() < 0 || projectile.gety() > HEIGHT) {
                projectileIterator.remove();
            }
        }
    }

    private void createEnemies() {
        for (int row = 0; row < 4; row++){
            for (int col = 0; col < 13; col++) {  // Antall fiender
                Enemy enemy = EnemyFactory.createEnemy("Basic", 100 + col * 50, 50 + row*50, theme.enemyImage());
                enemies.add(enemy);
            }
        }

    }



    private void moveEnemiesEdge() {
        Enemy edgeEnemy = getEdgeEnemy();
        if (edgeEnemy != null) {
            if (movingRight && edgeEnemy.getx() + edgeEnemy.getWidth() >= WIDTH) {
                shiftEnemiesDirection();  // Reverse direction by negating speed
                movingRight = false;         // Update direction flag
                shiftEnemiesDown();          // Move all enemies down
            } else if (!movingRight && edgeEnemy.getx() <= 0) {
                shiftEnemiesDirection();  // Reverse direction by negating speed
                movingRight = true;          // Update direction flag
                shiftEnemiesDown();          // Move all enemies down
            }
        }
        moveEnemies();  // Move enemies based on the current speed and direction
    }

    private void maybeShootFromEnemies() {
        Random rand = new Random();
        for (Enemy enemy : enemies) {
            if (rand.nextInt(1000) < 1) {  // ~1% sjanse for at hver fiende vil skyte i hvert klokkeslag
                enemyProjectiles.add(enemy.shoot());
            }
        }
    }

    /*
    *Move enemies based on the current speed and direction
     */
    public void moveEnemies() {
        for (Enemy enemy : enemies) {
            enemy.move();
        }
    }

    private void shiftEnemiesDown() {
        for (Enemy enemy : enemies) {
            enemy.shiftDown();
        }
    }
    private void shiftEnemiesDirection() {
        for (Enemy enemy : enemies) {
            enemy.reverseDirection();
        }
    }

    private Enemy getEdgeEnemy() {
        // Source: GPT. Trengte hjelp her så søkte, men fant ikke noe. Spurte gpt og ga meg dette
        return movingRight ?
                enemies.stream().max(Comparator.comparing(Enemy::getx)).orElse(null) :
                enemies.stream().min(Comparator.comparing(Enemy::getx)).orElse(null);
    }


    private void checkCollisions() {
        checkEnemyProjectileCollisions();
        checkEnemyPlayerCollisions();
        checkPlayerProjectileCollisions();
    }
    private void checkEnemyProjectileCollisions() {
        Iterator<Projectile> projectileIterator = enemyProjectiles.iterator();
        while (projectileIterator.hasNext()) {
            Projectile projectile = projectileIterator.next();
            if (projectile.getRectangle().intersects(player.getRectangle())) {
                projectileIterator.remove();
                player.hit(); // Anta at denne metoden håndterer å redusere liv eller lignende
                if (!player.getAlive()) {
                    currentGameState = GameState.GAME_OVER;
                }
            }
        }
    }

    /**
     * Checks for collisions between projectiles fired by the player and enemies.
     **/
    public void checkPlayerProjectileCollisions() {
        Iterator<Projectile> projectileIterator = projectiles.iterator();
        while (projectileIterator.hasNext()) {
            Projectile projectile = projectileIterator.next();
            Iterator<Enemy> enemyIterator = enemies.iterator();
            while (enemyIterator.hasNext()) {
                Enemy enemy = enemyIterator.next();
                if (projectile.getRectangle().intersects(enemy.getRectangle())) {
                    projectileIterator.remove();
                    enemy.hit(); // Anta at denne metoden håndterer å redusere liv eller lignende
                    if (!enemy.getAlive()) {
                        enemyIterator.remove(); // Fjern fienden hvis liv <=0
                        updateGameScore(enemy);
                        checkIfenemyeft();
                    }
                    break; // Avslutt denne loopen siden prosjektilet allerede har truffet en fiende
                }
            }
        }
    }
    private void checkEnemyPlayerCollisions() {
        for (Enemy enemy : enemies) {
            if (enemy.getRectangle().intersects(player.getRectangle())) {
                currentGameState = GameState.GAME_OVER;
                break;
            }
        }
    }
    /*
    * Check if the enemy left. If no enemy left, Victory
     */
    public void checkIfenemyeft(){
        if (enemies.isEmpty()){
            currentGameState = GameState.VICTORY;
        }
    }
    private void updateGameScore(Enemy enemy){
        int score = enemy.getPointSize();
        gameScore += score;
    }

    /**
     * Resets the game to its initial state, clearing all lists, resetting the score,
     * and recreating enemies.
     */
    public void resetGame(){
        clearLists();
        gameScore = 0;
        movingRight = true;
        currentGameState = GameState.ACTIVE_GAME;
        createEnemies();
    }

    private void clearLists(){
        this.projectiles.clear();
        this.enemyProjectiles.clear();
        this.enemies.clear();
    }

    /**
     * Starts the game by setting the game state to active.
     */
    public void startGame(){
        this.currentGameState = GameState.ACTIVE_GAME;
    }

    /**
     * Returns the current width of the game area.
     *
     * @return the width of the game area.
     */
    public int getWidth(){return this.WIDTH;}

    /**
     * Returns the current height of the game area.
     *
     * @return the height of the game area.
     */
    public int getHeight(){return this.HEIGHT;}

    /**
     * Returns the current score of the game.
     *
     * @return the current game score.
     */
    public int getGameScore(){return this.gameScore;}

    /**
     * Returns the current game state, indicating if the game is active, over, or at the welcome screen.
     *
     * @return the current state of the game.
     */
    public GameState getGameState(){return this.currentGameState;}

    /**
     * Returns the player object
     *
     * @return the player.
     */
    public Player getPlayer(){return this.player;}

    /**
     * Returns a list of active projectiles fired by the player.
     *
     * @return a list of player projectiles.
     */
    public ArrayList<Projectile> getProjectiles(){return this.projectiles;}

    /**
     * Returns a list of active projectiles fired by the enemy.
     *
     * @return a list of enemy projectiles.
     */
    public ArrayList<Projectile> getEnemyProjectiles(){return this.enemyProjectiles;}


    /**
     * Returns a list of enemies
     *
     * @return a list of enemies
     */
    public ArrayList<Enemy> getEnemies(){ return this.enemies; }

    /**
     * Returns the Theme object for this model
     *
     * @return a Theme object
     */
    public Theme getTheme(){return this.theme;}
}
