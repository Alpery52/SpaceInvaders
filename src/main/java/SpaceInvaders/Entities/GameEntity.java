package SpaceInvaders.Entities;

/**
 * Defines the core functionality for all game entities in the Space Invaders game.
 * A game entity is any object that can interact within the game world, including moving,
 * shooting, and being destroyed (hit).
 */
public interface GameEntity {

    /**
     * Retrieves the current x-coordinate of the entity on the game field.
     *
     * @return the x-coordinate of this entity.
     */
    int getx();

    /**
     * Retrieves the current y-coordinate of the entity on the game field.
     *
     * @return the y-coordinate of this entity.
     */
    int gety();

    /**
     * Retrieves the width of the entity.
     *
     * @return the width of this entity.
     */
    int getWidth();

    /**
     * Retrieves the height of the entity
     *
     * @return the height of this entity.
     */
    int getHeight();

    /**
     * Retrieves the speed of the entity. Defines how quickly the entity can move
     * across the game field.
     *
     * @return the speed of this entity.
     */
    int getSpeed();

    /**
     * Checks if the entity is currently "alive" or "active" in the game.
     * An entity that is not alive may not interact or be interacted with in the game.
     *
     * @return true if the entity is alive, false otherwise.
     */
    boolean getAlive();

    /**
     * Enables the entity to shoot a projectile. This method is used when the entity
     * is performing a shooting action.
     *
     * @return the Projectile that this entity shoots.
     */
    Projectile shoot();

    /**
     * Handles the logic when the entity is hit by a projectile or suffers any other form of damage.
     * This include updating the entity's "alive" status
     */
    void hit();
}
