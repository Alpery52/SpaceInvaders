package no.uib.inf101.sample;

import SpaceInvaders.Entities.PlayerProjectile;
import SpaceInvaders.Entities.Projectile;
import SpaceInvaders.Model.GameState;
import SpaceInvaders.Model.SpaceInvadersModel;
import SpaceInvaders.Entities.Enemy;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SpaceInvadersModelTest {

    @Test
    public void testPlayerMoveLeft() {
        SpaceInvadersModel model = new SpaceInvadersModel(800, 600);
        int initialX = model.getPlayer().getx();
        model.playerMoveLeft();
        assertTrue(model.getPlayer().getx() >= 0, "Player should not move left beyond the screen");
        assertTrue(model.getPlayer().getx() < initialX, "Player should move left");
    }


    @Test
    public void testPlayerMoveRight() {
        SpaceInvadersModel model = new SpaceInvadersModel(800, 600);
        int initialX = model.getPlayer().getx();
        model.playerMoveRight();
        assertTrue(model.getPlayer().getx() + model.getPlayer().getWidth() <= 800, "Player should not move right beyond the screen");
        assertTrue(model.getPlayer().getx() > initialX, "Player should move right");
    }

    @Test
    public void testPlayerShoot() {
        SpaceInvadersModel model = new SpaceInvadersModel(800, 600);
        model.playerShoot();
        assertEquals(1, model.getProjectiles().size());
    }

    @Test
    public void testEnemyCreation() {
        SpaceInvadersModel model = new SpaceInvadersModel(800, 600);
        assertEquals("52 enemies should be created", 52, model.getEnemies().size());
    }

    @Test
    public void testUpdateProjectiles() {
        SpaceInvadersModel model = new SpaceInvadersModel(800, 600);
        model.playerShoot();
        int beforeUpdate = model.getProjectiles().size();
        model.update();
        int afterUpdate = model.getProjectiles().size();

        assertTrue(afterUpdate <= beforeUpdate, "Projectiles should be less or equal after update");
    }

    @Test
    public void testGameStateChangeToVictory() {
        SpaceInvadersModel model = new SpaceInvadersModel(800, 600);
        model.getEnemies().clear(); // Simulate all enemies being defeated
        model.checkIfenemyeft(); // method checks if the enemy list is empty and updates the game state
        assertEquals("Game state should be VICTORY when all enemies are defeated",
                GameState.VICTORY, model.getGameState());
    }

    @Test
    public void testEnemyMovement() {
        SpaceInvadersModel model = new SpaceInvadersModel(800, 600);
        int initialX = model.getEnemies().get(0).getx();
        model.moveEnemies();
        assertEquals("Enemies should move to the right",
                initialX + model.getEnemies().get(0).getSpeed(),
                model.getEnemies().get(0).getx());
    }

    @Test
    public void testCollisionDetection() {
        SpaceInvadersModel model = new SpaceInvadersModel(800, 600);
        Enemy enemy = model.getEnemies().get(0);
        Projectile projectile = new PlayerProjectile(enemy.getx(), enemy.gety()); // Direct hit
        model.getProjectiles().add(projectile);
        model.checkPlayerProjectileCollisions();
        assertTrue(!model.getEnemies().contains(enemy),
                "Enemy should be hit and removed on collision");
        assertTrue(model.getProjectiles().isEmpty(),
                "Projectile should be removed on collision");
    }


    @Test
    public void testResetGame() {
        SpaceInvadersModel model = new SpaceInvadersModel(800, 600);
        model.resetGame();  // Assume resetGame should reset the game to its initial state
        assertEquals("Game score should be reset to 0", 0, model.getGameScore());
        assertTrue(model.getProjectiles().isEmpty(), "Projectiles should be cleared on reset");
        assertTrue(model.getEnemyProjectiles().isEmpty(), "Enemy projectiles should be cleared on reset");
        assertEquals("Game state should be set to ACTIVE_GAME on reset", GameState.ACTIVE_GAME, model.getGameState());
        assertEquals("Enemies list should be repopulated (52 enemies)", model.getEnemies().size(), 52);
    }




}

