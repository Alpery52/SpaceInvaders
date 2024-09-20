package no.uib.inf101.sample;
import SpaceInvaders.View.DefaultTheme;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.Color;
import javax.swing.ImageIcon;

public class DefaultThemeTest {

    @Test
    public void testThemeProperties() {
        DefaultTheme theme = new DefaultTheme();

        // Test all color properties
        assertEquals("Background color should be black", Color.BLACK, theme.getBackgroundColor());
        assertEquals("Game over color should be semi-transparent black", new Color(0, 0, 0, 128), theme.gameOverColor());
        assertEquals("Game over text color should be red", Color.RED, theme.gameOverTekstColor());
        assertEquals("Restart text color should be white", Color.WHITE, theme.reStartTextColor());
        assertEquals("Score color should be red", Color.RED, theme.scoreColor());
        assertEquals("Enemy projectile color should be green", Color.GREEN, theme.enemyProsjectile());
        assertEquals("Player projectile color should be white", Color.WHITE, theme.PlayerProsjectile());
        assertEquals("Victory text color should be green", Color.GREEN, theme.victoryTextColor());

        // Test all image properties
        assertNotNull("Player image should not be null", theme.playerImage());
        assertNotNull("Player right image should not be null", theme.playerImageR());
        assertNotNull("Player left image should not be null", theme.playerImageL());
        assertNotNull("Enemy image should not be null", theme.enemyImage());
        assertNotNull("Start image should not be null", theme.startImage());
        assertNotNull("Background image should not be null", theme.backgroundImage());
    }
}
