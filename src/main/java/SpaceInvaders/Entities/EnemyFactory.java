package SpaceInvaders.Entities;

import java.awt.*;

/**
 * Factory class for creating different types of enemy objects in the Space Invaders game.
 * This class simplifies the process of enemy instantiation by centralizing enemy creation logic,
 * allowing for easy modification and maintenance of the code that generates enemies.
 */
public class EnemyFactory {

    /**
     * Creates and returns an enemy object based on the specified type.
     * Each type of enemy can have different attributes such as health, speed, and point value.
     *
     * @param type The type of the enemy to create. This determines the attributes of the enemy.
     * @param x The initial x-coordinate of the enemy.
     * @param y The initial y-coordinate of the enemy.
     * @param enemyImage The image used to visually represent the enemy.
     * @return A new instance of an Enemy, configured according to the specified type.
     */
    public static Enemy createEnemy(String type, int x, int y, Image enemyImage) {
        switch (type) {
            case "Basic":
                // The simplest form of enemy; low health, slow movement, and minimum points.
                return new Enemy(x, y, 1, 1, 1, enemyImage);
            case "Hard":
                // A harder enemy; more health, faster, and potentially worth more points.
                return new Enemy(x, y, 3, 2, 1, enemyImage);
            default:
                // Default case to handle unspecified types, creates a basic enemy.
                return new Enemy(x, y, 1, 1, 1, enemyImage);
        }
    }
}
