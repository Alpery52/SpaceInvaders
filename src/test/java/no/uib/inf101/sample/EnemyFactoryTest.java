package no.uib.inf101.sample;

import SpaceInvaders.Entities.Enemy;
import SpaceInvaders.Entities.EnemyFactory;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;
import java.awt.*;

public class EnemyFactoryTest {

    @Test
    public void testCreateBasicEnemy() {
        Image img = new ImageIcon("src\\main\\java\\SpaceInvaders\\Ressurser\\invader1.png").getImage();
        Enemy enemy = EnemyFactory.createEnemy("Basic", 100, 100, img);


        assertEquals("Basic enemy health should be 1", 1, enemy.getHealth());
        assertEquals("Basic enemy speed should be 1", 1, enemy.getSpeed());
        assertEquals("Basic enemy point value should be 1", 1, enemy.getPointSize());
        assertEquals("X coordinate should be set correctly", 100, enemy.getx());
        assertEquals("Y coordinate should be set correctly", 100, enemy.gety());
        assertSame("Enemy image should be set correctly", img, enemy.getIcon());
    }

    @Test
    public void testCreateHardEnemy() {
        Image img = new ImageIcon("src\\main\\java\\SpaceInvaders\\Ressurser\\invader1.png").getImage();
        Enemy enemy = EnemyFactory.createEnemy("Hard", 200, 200, img);

        assertEquals("Hard enemy health should be 3", 3, enemy.getHealth());
        assertEquals("Hard enemy speed should be 2", 2, enemy.getSpeed());
        assertEquals("Hard enemy point value should be 1", 1, enemy.getPointSize());
        assertEquals("X coordinate should be set correctly", 200, enemy.getx());
        assertEquals("Y coordinate should be set correctly", 200, enemy.gety());
        assertSame("Enemy image should be set correctly", img, enemy.getIcon());
    }

    @Test
    public void testCreateDefaultEnemy() {
        Image img = new ImageIcon("src\\main\\java\\SpaceInvaders\\Ressurser\\invader1.png").getImage();
        Enemy enemy = EnemyFactory.createEnemy("Undefined", 300, 300, img);


        assertEquals("Default enemy health should be 1", 1, enemy.getHealth());
        assertEquals("Default enemy speed should be 1", 1, enemy.getSpeed());
        assertEquals("Default enemy point value should be 1", 1, enemy.getPointSize());
        assertEquals("X coordinate should be set correctly", 300, enemy.getx());
        assertEquals("Y coordinate should be set correctly", 300, enemy.gety());
        assertSame("Enemy image should be set correctly", img, enemy.getIcon());
    }
}
