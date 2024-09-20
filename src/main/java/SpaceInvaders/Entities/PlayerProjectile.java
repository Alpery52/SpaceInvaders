package SpaceInvaders.Entities;

import java.awt.*;

/**
 * Represents a projectile fired by the player in the Space Invaders game.
 * This class manages the properties and behaviors of a player's projectile,
 * such as its movement.
 */
public class PlayerProjectile implements Projectile{
    private  final int WIDTH = 5;
    private  final int HEIGHT = 10;
    private  int x;
    private  int y;
    private int speed = 5;

    /**
     * Constructs a new PlayerProjectile with specified initial position.
     * The projectile will be centered on the x-coordinate passed in.
     *
     * @param x the initial x-coordinate of the projectile, centered to the projectile width.
     * @param y the initial y-coordinate of the projectile.
     */
    public PlayerProjectile(int x, int y) {
        this.x = x-this.WIDTH / 2;
        this.y = y;
    }

    /**
     * Gets the rectangle of this projectile which is used for collision detection.
     *
     * @return a Rectangle object that outlines the bounds of the projectile.
     */
    @Override
    public Rectangle getRectangle() {
        return new Rectangle(this.x, this.y, this.WIDTH, this.HEIGHT);
    }

    /**
     * Retrieves the current x-coordinate of the projectile.
     *
     * @return the x-coordinate of this projectile.
     */
    @Override
    public int getx() {
        return this.x;
    }

    /**
     * Retrieves the current y-coordinate of the projectile.
     *
     * @return the y-coordinate of this projectile.
     */
    @Override
    public int gety() {
        return this.y;
    }

    /**
     * Retrieves the width of the projectile.
     *
     * @return the width of this projectile, in pixels.
     */
    @Override
    public int getWidth() {
        return this.WIDTH;
    }

    /**
     * Retrieves the height of the projectile.
     *
     * @return the height of this projectile, in pixels.
     */
    @Override
    public int getHight() {
        return this.HEIGHT;
    }

    /**
     * Updates the position of the projectile based on its speed.
     * This method is called once per game update to move the projectile upwards.
     */
    @Override
    public void update() {
        this.y -=speed;
    }
}
