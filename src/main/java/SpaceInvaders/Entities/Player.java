package SpaceInvaders.Entities;
import java.awt.*;

/**
 * Represents the player in the Space Invaders game.
 * This class handles player movements, shooting mechanics, and visual representation through images
 * depending on movement direction.
 */
public class Player implements GameEntity {
    private final int PLAYER_WIDTH;
    private final int PLAYER_HEIGHTBOOSTER = 60;
    private int PLAYER_HEIGHT;
    private  final int speed = 5;
    private boolean alive;
    private int x;
    private int y;
    private int health = 1;
    private Image defaultImage;
    private Image tiltLefttImage;
    private Image tiltRightImage;
    private Image playerImage;


    /**
     * Creates a Player with initial position and images for different states.
     *
     * @param x Initial x-coordinate of the player.
     * @param y Initial y-coordinate of the player.
     * @param defaultImage Default image for the player not moving.
     * @param tiltLefttImage Image for the player moving left.
     * @param tiltRightImage Image for the player moving right.
     */
    public Player (int x, int y, Image defaultImage, Image tiltLefttImage, Image tiltRightImage){
        this.x = x;
        this.y = y;
        this.PLAYER_HEIGHT = 50;
        this.PLAYER_WIDTH = 50;
        this.alive = true;
        this.defaultImage = defaultImage;
        this.tiltLefttImage = tiltLefttImage;
        this.tiltRightImage = tiltRightImage;
        setIcon(defaultImage);
    }

    /**
     * Moves the player to the left and changes the player's image.
     *
     * @param x Amount to move left.
     */
    public void movePlayerLeft(int x){
        this.x -= x;
        setIcon(tiltLefttImage);
        this.PLAYER_HEIGHT = PLAYER_HEIGHTBOOSTER;
    }

    /**
     * Moves the player to the right and changes the player's image.
     *
     * @param x Amount to move right.
     */
    public void movePlayerRight(int x){
        this.x += x;
        setIcon(tiltRightImage);
        this.PLAYER_HEIGHT = PLAYER_HEIGHTBOOSTER;

    }

    /**
     * Handles what happens when the player is hit, such as decrementing health.
     */
    @Override
    public void hit() {
        health -= 1;
        if (health <= 0) {
            alive = false;
        }
    }

    /**
     * Returns the bounding rectangle of the player, used for collision detection.
     *
     * @return The bounding rectangle.
     */
    public Rectangle getRectangle() {
        return new Rectangle(this.x, this.y, this.PLAYER_WIDTH, this.PLAYER_HEIGHT);
    }


    @Override
    public int getx() {return this.x;}
    @Override
    public int gety() {return this.y;}
    @Override
    public int getWidth() {return this.PLAYER_WIDTH;}
    @Override
    public int getHeight() {return this.PLAYER_HEIGHT;}
    @Override
    public int getSpeed() {return this.speed;}
    @Override
    public boolean getAlive() {return this.alive;}


    /**
     * Creates and returns a projectile that the player shoots.
     *
     * @return A new PlayerProjectile instance representing the projectile shot by the player.
     */
    @Override
    public Projectile shoot() {
        return new PlayerProjectile(this.x + this.PLAYER_WIDTH / 2, this.y-10);
    }

    /**
     * Retrieves the current image of the player.
     *
     * @return The current player image.
     */
    public Image getIcon(){return this.playerImage;}

    /**
     * Sets the current player image.
     *
     * @param icon The new image to set.
     */
    public void setIcon(Image icon){this.playerImage = icon;}

    /**
     * Resets the player's image to the default and height to the normal level after movement.
     */
    public void resetIcon(){
        this.playerImage =defaultImage;
        this.PLAYER_HEIGHT = 50;
    }

}
