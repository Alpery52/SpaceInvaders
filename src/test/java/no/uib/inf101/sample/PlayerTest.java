package no.uib.inf101.sample;

import SpaceInvaders.Entities.Player;
import SpaceInvaders.Entities.Projectile;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;
import java.awt.*;

public class PlayerTest {
    private Player player;
    private Image defaultImage = new ImageIcon(
            "src\\main\\java\\SpaceInvaders\\Ressurser\\PlayerBigger.png").getImage();
    private Image tiltLeftImage = new ImageIcon(
            "src\\main\\java\\SpaceInvaders\\Ressurser\\tiltl.png").getImage();
    private Image tiltRightImage = new ImageIcon(
            "src\\main\\java\\SpaceInvaders\\Ressurser\\tiltr.png").getImage();

    @Before
    public void setUp() {
        // Initialize player with some default parameters and images
        player = new Player(100, 100, defaultImage, tiltLeftImage, tiltRightImage);
    }

    @Test
    public void testMovePlayerLeft() {
        int initialX = player.getx();
        player.movePlayerLeft(5);
        assertEquals("Player should move left by 5 units", initialX - 5, player.getx());
        assertSame("Player image should change when moving left", tiltLeftImage, player.getIcon());
    }

    @Test
    public void testMovePlayerRight() {
        int initialX = player.getx();
        player.movePlayerRight(5);
        assertEquals("Player should move right by 5 units", initialX + 5, player.getx());
        assertSame("Player image should change when moving right", tiltRightImage, player.getIcon());
    }

    @Test
    public void testPlayerShoot() {
        Projectile projectile = player.shoot();
        assertNotNull("Shooting should create a projectile", projectile);
    }

    @Test
    public void testPlayerHit() {
        player.hit();  // Assume this reduces health by 1
        assertFalse("Player should be dead after hit", player.getAlive());
    }

    @Test
    public void testResetIcon() {
        player.movePlayerLeft(5); // Change the icon
        player.resetIcon();
        assertSame("Player icon should reset to default", defaultImage, player.getIcon());
        assertEquals("Player height should reset to default", 50, player.getHeight());
    }
}
