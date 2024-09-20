package SpaceInvaders.View;
import java.awt.*;

/**
 * The Theme interface defines a set of methods for retrieving color and image resources used for rendering
 * the visual elements of the Space Invaders game. Implementations of this interface provide specific
 * themes by defining colors and images for various game components such as backgrounds,
 * and text displays.
 *
 * @author Alper.Yarenbasi
 */
public interface Theme {


    /**
     * Retrieves the background color for the game's main area.
     *
     * @return The Color object representing the background color.
     */
    Color getBackgroundColor();

    /**
     * Retrieves the color used for the "game over" screen background.
     *
     * @return The Color object for the "game over" screen.
     */
    Color gameOverColor();

    /**
     * Retrieves the color used for the "game over" text.
     *
     * @return The Color object for the "game over" message.
     */
    Color gameOverTekstColor();

    /**
     * Retrieves the color used for the text of the restart message.
     *
     * @return The Color object for the restart message text.
     */
    Color reStartTextColor();

    /**
     * Retrieves the color used for displaying the game score.
     *
     * @return The Color object for the score display.
     */
    Color scoreColor();

    /**
     * Retrieves the color used for enemy projectiles.
     *
     * @return The Color object for enemy projectiles.
     */
    Color enemyProsjectile();

    /**
     * Retrieves the color used for player projectiles.
     *
     * @return The Color object for player projectiles.
     */
    Color PlayerProsjectile();

    /**
     * Retrieves the color used for victory text.
     *
     * @return The Color object for victory text.
     */
    Color victoryTextColor();

    /**
     * Retrieves the default player image.
     *
     * @return The Image object representing the player.
     */
    Image playerImage();

    /**
     * Retrieves the player image for the right movement.
     *
     * @return The Image object for the player moving right.
     */
    Image playerImageR();

    /**
     * Retrieves the player image for the left movement.
     *
     * @return The Image object for the player moving left.
     */
    Image playerImageL();

    /**
     * Retrieves the default enemy image.
     *
     * @return The Image object representing the enemy.
     */
    Image enemyImage();

    /**
     * Retrieves the image for the game's start screen.
     *
     * @return The Image object for the start screen.
     */
    Image startImage();

    /**
     * Retrieves the background image for the game.
     *
     * @return The Image object for the background.
     */
    Image backgroundImage();
}
