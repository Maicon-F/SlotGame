import java.util.HashMap;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

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

        return resultGrid;
    }

    private int randomGenerator(){
        Random random = new Random();
        return random.nextInt(4);
    }

    private int[][] paylineCalculator(){
        //per line
        // per column
        // per diagonal right
        // per diagonal left

        return null; //TODO

    }

    //2 for loops. mxn complexity to compute horizonal paylines plus the diagonal complexity
    private int[][] payoutManager(int line){
        int[] diagPayLine = {-1,-1};
        int[] diagInvPayLine = {-1,-1};
        for(int row = 0; row < 3; row++){
            int[] payLine = {-1,-1};
            //check if there is a payouts, and saves the highest one found for every payLine
            for(int col = 0; col < 4; col++){
                int currentSimbol = resultGrid[row][col];
                updatePayLine(currentSimbol, payLine);
            }
        }

        updateDiagonalPayLine(diagIndexes,diagPayLine);
        updateDiagonalPayLine(diagIndexes,diagInvPayLine);

        return null; //TODO
    }


    private void updateDiagonalPayLine(int[][]indexes, int[]diagonal) {
        for (int[] index : indexes) {
            int row = index[0];
            int col = index[1];
            int currentSimbol = resultGrid[row][col];
            updatePayLine(currentSimbol, diagonal);
        }
    }

    private void updatePayLine(int currentSimbol, int[]payLine){
        int repetitions = payLine[1];
        if(currentSimbol == payLine[0]){
            payLine[1] = ++repetitions;
            if(repetitions >= 3 ){
                //TODO save payload
                //TODO save as []
            }
        }else {
            payLine[0] = currentSimbol;
            payLine[1] = ++repetitions;
        }
    }

    private int payload(Object[][] input ){
        // get the highest payload over the rows

        // get the the second payload but only if it doesnt contain an already used reference
        return 0;
    }


}