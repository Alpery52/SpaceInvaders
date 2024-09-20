package SpaceInvaders.Entities;

import java.awt.*;

/**
 * Defines projectile objects in the Space Invaders game.
 * A projectile is an object that can move and interact with other objects in the game through collisions.
 * This interface requires methods for managing the projectile's movement, position, size, and collision detection.
 */
public interface Projectile{

    /**
     * Retrieves the x-coordinate of the projectile within the game window.
     *
     * @return the x-coordinate of the projectile.
     */
    int getx();

    /**
     * Retrieves the y-coordinate of the projectile within the game window.
     *
     * @return the y-coordinate of the projectile.
     */
    int gety();

    /**
     * Retrieves the width of the projectile.
     *
     * @return the width of the projectile in pixels.
     */
    int getWidth();

    /**
     * Retrieves the height of the projectile.
     *
     * @return the height of the projectile in pixels.
     */
    int getHight();

    /**
     * Updates the state of the projectile
     */
    void update();

    /**
     * Retrieves a {@link Rectangle} object that represents the current position and dimensions of the projectile.
     * This can be used for collision detection.
     *
     * @return a rectangle covering the projectile's current position and size.
     */
    Rectangle getRectangle();
}
