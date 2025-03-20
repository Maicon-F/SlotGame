package core;

import java.util.Random;

public class Game {

    public Game(){
        counter++;
        System.out.println("Instances: " + counter);
    }

    private int payout = 0;
    private int[][] resultGrid = new int[3][5];
    private static int counter = 0;

    static int[][] firstLineIndexes = { {0, 0},{0, 1},{0, 2},{0, 3}, {0, 4}};
    static int[][] secondLineIndexes = {{1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}};
    static int[][] thirdLineIndexes =  {{2, 0},{2, 1},{2, 2},{2, 3},{2, 4}};
    static int[][] diagIndexes =  {{0, 0},{1, 1},{2, 2},{1, 3},{0, 4}};
    static int[][] diagInvIndexes = {{2, 0}, {1, 1}, {0, 2}, {1, 3}, {2, 4}};

    public int run() {
        return spin();
    }

    public int spin(){
        //iterates over the row and columns. Initializing every element of the grid
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 5; col++){
                resultGrid[row][col] = randomGenerator();
            }
        }
        //enable to visualize the resulting grid
        //displayGrid(resultGrid);
        payoutManager();

        //System.out.println(payout);

        return payout;
    }

    private int randomGenerator(){
        Random random = new Random();
        return random.nextInt(4);
    }


    //2 for loops. mxn complexity to compute horizonal paylines plus the diagonal complexity
    public void payoutManager(){
        checkPayline(firstLineIndexes);
        checkPayline(secondLineIndexes);
        checkPayline(thirdLineIndexes);

        checkPayline(diagIndexes);
        checkPayline(diagInvIndexes);
    }

    private void checkPayline(int[][]indexes ) {
        //payline may contain up 2 elements. the first index represents the element, possibly 0 1 2 3
        // the second index represents the amount of times it matches

        int linePayout = 0;
        int[]line = new int[2];
        for (int[] index : indexes) {
            int row = index[0];
            int col = index[1];
            int currentSimbol = resultGrid[row][col];
            updateLineData(currentSimbol, line);

            //gets payout when finds a low win, but updates if it grows
            if(line[1] >= 3 ){
                linePayout = getLinePayout(line);
            }
        }
        payout = payout + linePayout;
    }

    private static void updateLineData(int currentSymbol, int[]line){
        int repetitions = line[1];
        if(currentSymbol == line[0]){
            line[1] = ++repetitions;
        }else {
            line[0] = currentSymbol;
            line[1] = 1;
        }
    }


    private static int getLinePayout(int[] payline)  {
        int[][] rules = {
                // Symbol 0 payouts: 3oak, 4oak, 5oak
                {5, 10, 20},
                // Symbol 1 payouts: 3oak, 4oak, 5oak
                {10, 20, 40},
                // Symbol 2 payouts: 3oak, 4oak, 5oak
                {15, 30, 60},
                // Symbol 3 payouts: 3oak, 4oak, 5oak
                {20, 50, 100}
        };

        return rules[payline[0]][payline[1]-3];
    }

    //print the grid on the console
    private static void displayGrid(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col]);
                if (col != grid[row].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    public void setGrid(int[][] grid) {
        this.resultGrid = grid;
    }

    public int getPayload() {
        return payout;}

}