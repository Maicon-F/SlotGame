package core;

import java.util.Random;

public class Game {

    private static int[][] statistics = new int[5][3];
    public Game(){
    }

    private int payout = 0;
    private int[][] resultGrid = new int[3][5];

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
        checkPayline(firstLineIndexes, 0);
        checkPayline(secondLineIndexes, 1);
        checkPayline(thirdLineIndexes, 2);

        checkPayline(diagIndexes, 3);
        checkPayline(diagInvIndexes, 4);
    }

    private void checkPayline(int[][]indexes, int ref ) {
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

        //feeds the statistic report
        if(line[1] >=3){
            ++statistics[ref][line[1]-3];
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

    // Print the statistics summary
    private static void printReport(int[][] grid) {
        int wins = 0;
        System.out.println("Summary:");
        System.out.println("Payline  | 3oak | 4oak | 5oak");
        System.out.println("------------------------------");
        for (int row = 0; row < grid.length; row++) {
            System.out.print("   " + row + "     | ");
            for (int col = 0; col < grid[row].length; col++) {
                wins = grid[row][col] + wins;
                System.out.print(grid[row][col]);

                if (col != grid[row].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
        System.out.println("\nTotal wins: " + wins);
    }


    public void setGrid(int[][] grid) {
        this.resultGrid = grid;
    }

    public int getPayload() {
        return payout;}

    public static void printReport(){
        printReport(statistics);
    }

}