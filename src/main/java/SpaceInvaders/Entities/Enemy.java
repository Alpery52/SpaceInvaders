package SpaceInvaders.Entities;

import java.awt.*;

/**
 * Represents an enemy in the Space Invaders game.
 * This class manages enemy attributes such as position, movement, health, and shooting mechanics.
 */
public class Enemy implements GameEntity {
    private int x, y;
    private int WIDTH, HEIGHT;
    private boolean alive;
    private int speedX;
    private int health;
    private Image enemyImage;
    private int pointSize;



    /**
     * Constructs an Enemy with specified attributes.
     *
     * @param x Initial x-coordinate of the enemy.
     * @param y Initial y-coordinate of the enemy.
     * @param health Initial health of the enemy.
     * @param speedX Horizontal speed of the enemy.
     * @param pointSize Points awarded for defeating this enemy.
     * @param enemyImage Image representing the enemy.
     */
    public Enemy(int x, int y, int health, int speedX, int pointSize, Image enemyImage) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.WIDTH = 40;
        this.HEIGHT = 40;
        this.alive = true;
        this.speedX = speedX;
        this.pointSize = pointSize;
        this.enemyImage = enemyImage;
    }

    /**
     * Returns the point size value which indicates how many points this enemy is worth when defeated.
     *
     * @return the point value of the enemy.
     */
    public int getPointSize(){return this.pointSize;}

    @Override
    public int getx() {
        return x;
    }
    @Override
    public int gety() {
        return y;
    }
    @Override
    public int getWidth() {
        return WIDTH;
    }
    @Override
    public int getHeight() {
        return HEIGHT;
    }
    @Override
    public int getSpeed() {
        return this.speedX;
    }
    @Override
    public boolean getAlive() {
        return alive;
    }

    /**
     * Creates and returns a projectile that the enemy shoots downward.
     *
     * @return A new EnemyProjectile instance representing the projectile shot by this enemy.
     */
    @Override
    public Projectile shoot() {
        return new EnemyProjectile(this.x + this.WIDTH / 2, this.y + this.HEIGHT);
    }


    /**
     * Reverses the horizontal direction of the enemy's movement.
     */
    public void reverseDirection() {
        this.speedX = this.speedX * (-1);
    }


    /**
     * Moves the enemy horizontally based on its speed.
     */
    public void move() {
        x += speedX;
    }

    /**
     * Reduces the health of the enemy by one each time it is hit. If health reaches zero, the enemy dies.
     */
    @Override
    public void hit() {
        health -= 1;
        if (health <= 0) {
            alive = false;
        }
    }

    /**
     * Returns the bounding rectangle of the enemy for collision detection.
     *
     * @return The bounding rectangle of the enemy.
     */
    public Rectangle getRectangle() {
        return new Rectangle(this.x, this.y, this.WIDTH, this.HEIGHT);
    }

    /**
     * Retrieves the current image of the enemy.
     *
     * @return The image representing the enemy.
     */
    public Image getIcon() {
        return this.enemyImage;
    }

    /**
     * Shifts the enemy downward on the game field
     */
    public void shiftDown () {
        y += 30;
    }

    public int getHealth() {return this.health;}

}


