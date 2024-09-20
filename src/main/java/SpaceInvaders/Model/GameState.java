package SpaceInvaders.Model;

/**
 * Enum representing the possible states of the game in Space Invaders.
 * This helps in managing different phases of the game such as starting, ending,
 * actively playing, or when the player has won the game.
 */
public enum GameState {

    /**
     * Represents the state where the game is currently being played.
     * In this state, player interactions are active and the game logic is continuously executed.
     */
    ACTIVE_GAME,

    /**
     * Represents the state when the game has ended due to player losing all lives.
     * This state is used to display the game over screen and manage post-game logic.
     */
    GAME_OVER,

    /**
     * Represents the initial state of the game (welcome screen)
     * This is the entry point for players, showing the start button.
     */
    WELCOME_SCREEN,

    /**
     * Represents the state when the player has defeated all enemies and won the game.
     * This state is used to display the victory screen
     */
    VICTORY
}
