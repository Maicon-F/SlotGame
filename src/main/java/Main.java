import core.Game;

import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        Game game = new Game();
        boolean playAgain = play();
        while(playAgain){
            game.run();
            System.out.println("-----------------");
            playAgain = play();
        }

    }

    //dialog box
    private static boolean play(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to play or any  other key to quit");
        String userInput = scanner.nextLine();

        if (userInput.isEmpty()) {
            return true;
        }

        scanner.close();
        return false;
    }


}