import java.util.HashMap;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    int payout = 0;
    int[] simbols = {0, 1, 2, 3};
    int[][] resultGrid = new int[3][5];
    int[][] payouts = new int[1][1];

    int[][] firstLineIndexes = { {0, 0},{0, 1},{0, 2},{0, 3}, {0, 4}};
    int[][] secondLineIndexes = {{1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}};
    int[][] thirdLineIndexes =  {{2, 0},{2, 1},{2, 2},{2, 3},{2, 4}};
    int[][] diagIndexes =  {{0, 0},{1, 1},{2, 2},{1, 3},{0, 4}};
    int[][] diagInvIndexes = {{2, 0}, {1, 1}, {0, 2}, {1, 3}, {2, 4}};

    public static void main(String[] args) {

        // declare variables
        // initialize the 2D array
        // create a spin function
        // calculate the payload after every spin
        // simulate 10 000 spins and store results for analytical purposes



    }

    public int[][] spin(){
        //iterates over the row and columns. Initializing every element of the grid
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 5; col++){
                resultGrid[row][col] = randomGenerator();
            }
            //TODO: print grid
        }
        payoutManager();
        return resultGrid;
    }

    private int randomGenerator(){
        Random random = new Random();
        return random.nextInt(4);
    }


    //2 for loops. mxn complexity to compute horizonal paylines plus the diagonal complexity
    private void payoutManager(){
        checkPayline(firstLineIndexes);
        checkPayline(secondLineIndexes);
        checkPayline(thirdLineIndexes);

        checkPayline(diagIndexes);
        checkPayline(diagInvIndexes);
    }


    private void checkPayline(int[][]indexes ) {
        //payline may contain up 2 elements. the first index represents the element 0 1 2 3
        // the second index represents the amount of times it repeats itself.
        int[]line = new int[2];
        for (int[] index : indexes) {
            int row = index[0];
            int col = index[1];
            int currentSimbol = resultGrid[row][col];
            updateLineData(currentSimbol, line);

            //updates when finds one
            if(line[1] >= 3 ){
                payout = payout + getLinePayout(line);
            }
        }
    }

    private void updateLineData(int currentSimbol, int[]line){
        int repetitions = line[1];
        if(currentSimbol == line[0]){
            line[1] = ++repetitions;
        }else {
            line[0] = currentSimbol;
            line[1] = ++repetitions;
        }
    }


    private int getLinePayout(int[]payline )  {
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

        Object[][] payload = new Object[5][2];
        return rules[payline[0]][payline[1]];
    }


}