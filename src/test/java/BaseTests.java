import core.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseTests {

    Game game = new Game();


    @Test
    void referenceWithOnlyA4oak1Test(){
        int[][] grid = {
                {0, 1, 1, 2, 3},
                {1, 1, 1, 1, 2},
                {2, 3, 2, 1, 0}
        };

        game.setGrid(grid);
        game.payoutManager();
        assertEquals(30, game.getPayload());
    }

    @Test
    void maxPayloadTest(){
        int[][] grid = {
                {3, 3,3 ,3, 3},
                {3, 3, 3, 3, 3},
                {3, 3, 3, 3, 3}
        };

        game.setGrid(grid);
        game.payoutManager();
        assertEquals(500, game.getPayload());
    }

    @Test
    void diagonalWinWith3oak2Test(){
        int[][] grid = {
                {2, 3, 1, 0, 2},
                {0, 3, 1, 2, 3},
                {3, 2, 2, 0, 3}
        };

        game.setGrid(grid);
        game.payoutManager();
        assertEquals(15, game.getPayload());
    }


    @Test
    void diagonalInverseWinWith4oak0Test(){
        int[][] grid = {
                {2, 3, 0, 0, 2},
                {0, 0, 1, 0, 3},
                {3, 2, 2, 0, 0}
        };

        game.setGrid(grid);
        game.payoutManager();
        assertEquals(10, game.getPayload());
    }

    @Test
    void first3oak0AndThirdRowWith3oak2Test(){
        int[][] grid = {
                {2, 0, 0, 0, 2},
                {0, 0, 1, 1, 3},
                {3, 2, 2, 2, 0}
        };

        game.setGrid(grid);
        game.payoutManager();
        assertEquals(20, game.getPayload());
    }

    @Test
    void noWin1Test(){
        int[][] grid = {
                {2, 0, 1, 0, 2},
                {0, 0, 1, 1, 3},
                {3, 2, 1, 2, 0}
        };

        game.setGrid(grid);
        game.payoutManager();
        assertEquals(0, game.getPayload());
    }
}
