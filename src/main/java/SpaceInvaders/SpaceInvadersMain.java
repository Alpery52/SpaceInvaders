package SpaceInvaders;
import SpaceInvaders.Controller.SpaceInvadersController;
import SpaceInvaders.Model.SpaceInvadersModel;
import SpaceInvaders.View.SpaceInvadersView;
import SpaceInvaders.midi.SpaceInvadersMusic;


import javax.swing.*;


public class SpaceInvadersMain {

    private static final String WINDOW_TITLE = "Space Invaders";
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;


    public static void main(String[] args) {
        JFrame frame = new JFrame(WINDOW_TITLE);
        SpaceInvadersModel model = new SpaceInvadersModel(WINDOW_WIDTH, WINDOW_HEIGHT);  // Window dimensions
        SpaceInvadersView view = new SpaceInvadersView(model);
        new SpaceInvadersController(model, view);

        frame.setContentPane(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
