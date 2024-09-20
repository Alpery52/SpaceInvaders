package SpaceInvaders.View;

import javax.swing.*;
import java.awt.*;

/**
 * Class for the default Theme for the space invaders
 */
public class DefaultTheme implements Theme{

    @Override
    public Color getBackgroundColor() {return Color.BLACK;}

    @Override
    public Color gameOverColor() {return new Color(0, 0, 0, 128);}

    @Override
    public Color gameOverTekstColor() {return Color.RED;}

    @Override
    public Color reStartTextColor() {return Color.WHITE;}

    @Override
    public Color scoreColor() {return Color.RED;}

    @Override
    public Color enemyProsjectile() {
        return Color.GREEN;
    }

    @Override
    public Color PlayerProsjectile() {
        return Color.WHITE;
    }

    @Override
    public Color victoryTextColor() {
        return Color.GREEN;
    }

    @Override
    public Image playerImage() {
        return new ImageIcon("src\\main\\java\\SpaceInvaders\\Ressurser\\PlayerBigger.png").getImage();
    }

    @Override
    public Image playerImageR() {
        return new ImageIcon("src\\main\\java\\SpaceInvaders\\Ressurser\\tiltr.png").getImage();
    }

    @Override
    public Image playerImageL() {
        return new ImageIcon("src\\main\\java\\SpaceInvaders\\Ressurser\\tiltl.png").getImage();
    }

    @Override
    public Image enemyImage() {
        return new ImageIcon("src\\main\\java\\SpaceInvaders\\Ressurser\\invader1.png").getImage();
    }

    @Override
    public Image startImage() {
        return new ImageIcon("src\\main\\java\\SpaceInvaders\\Ressurser\\startscreen.png").getImage();
    }

    @Override
    public Image backgroundImage() {
        return new ImageIcon("src\\main\\java\\SpaceInvaders\\Ressurser\\background.jpg").getImage();
    }
}
