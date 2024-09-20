package SpaceInvaders.Controller;

import SpaceInvaders.Model.GameState;
import SpaceInvaders.Model.SpaceInvadersModel;
import SpaceInvaders.View.SpaceInvadersView;
import SpaceInvaders.midi.SpaceInvadersMusic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The controller for the Space Invaders game, responsible for handling user input
 * and managing the timing and logic updates necessary for running the game.
 */
public class SpaceInvadersController implements KeyListener {
    private SpaceInvadersModel model;
    private SpaceInvadersView view;
    private Timer timer;
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private boolean spaceReleased = true;  // Endret til å spore om mellomromstasten er sluppet
    private SpaceInvadersMusic backgroundMusic;

    /**
     * Constructs a Space Invaders controller with a model and a view.
     * Sets up key listener for the view and initializes the game update timer.
     *
     * @param model The model of the Space Invaders game.
     * @param view  The view used to display the Space Invaders game.
     */
    public SpaceInvadersController(SpaceInvadersModel model, SpaceInvadersView view) {
        this.model = model;
        this.view = view;
        view.addKeyListener(this);

        this.timer = new Timer(10, this::clockTick);
        this.backgroundMusic = new SpaceInvadersMusic();
        new Thread(backgroundMusic).start(); //Tried to make a new thread so that it didnt effect the game speed. didnt work

    }


    /**
     * Handles key press events to control the game based on the game state.
     * Manages directional inputs for moving the player and the space bar for shooting.
     *
     * @param e The KeyEvent triggered when a key is pressed.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (model.getGameState() == GameState.ACTIVE_GAME) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    leftPressed = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    rightPressed = true;
                    break;
                case KeyEvent.VK_SPACE:
                    if (spaceReleased) {  // Sjekk om tasten nylig ble sluppet før du skyter igjen
                        model.playerShoot();
                        spaceReleased = false;  // Tasten er nå trykket ned, ikke skyt igjen før den slippes
                    }
                    break;
            }
        } else if (model.getGameState() == GameState.GAME_OVER || model.getGameState() == GameState.VICTORY) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE:
                    this.model.resetGame();
                    this.view.repaint();
                    model.update();
            }
        }
        else if (model.getGameState() == GameState.WELCOME_SCREEN){
            switch (e.getKeyCode()){
                case KeyEvent.VK_SPACE:
                    startgame();
            }
        }

    }
    /**
     * Starts the game by setting the game state to active and starting the timer.
     */
    private void startgame(){
        model.startGame();
        timer.start();
    }

    /**
     * Handles key release events to update movement flags and reset player icon.
     *
     * @param e The KeyEvent triggered when a key is released.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                leftPressed = false;
                model.getPlayer().resetIcon();
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = false;
                model.getPlayer().resetIcon();
                break;
            case KeyEvent.VK_SPACE:
                spaceReleased = true;  // Spilleren har sluppet mellomromstasten, klar for nytt skudd
                break;
        }
    }


    /**
     * Updates the movement of the player based on current key presses.
     */
    private void updateGame() {
        if (leftPressed) model.playerMoveLeft();
        if (rightPressed) model.playerMoveRight();
    }

    /**
     * Updates the game when the timer ticks if the game is active.
     * This method is called automatically by the timer and handles the repetitive tasks
     * needed to update game logic and refresh the display.
     *
     * @param e The ActionEvent from the timer.
     */
    private void clockTick(ActionEvent e) {
        if (model.getGameState() == GameState.ACTIVE_GAME) {
            model.update();
            view.repaint();
            updateGame();
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {}
}

