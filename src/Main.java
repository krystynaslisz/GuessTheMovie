import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Game game = new Game("movies.txt");

        System.out.println("Let's guess some movie titles!");
        System.out.println("You will try to guess the movie based on the letters you will provide");
        System.out.println("Everytime you will guess the wrong letter you will lose 1 point");
        System.out.println("If you get 10 points - you lose");
        System.out.println("Have a good time");
        System.out.println("The movie title has " + game.getMovieTitle().length() + " characters (including spaces "
                + "and punctuation).");
        while (!game.gameOver()){
            System.out.println("You are guessing: " + game.getHiddenMovieTitle());
            System.out.println("You have guessed: " + game.getWrongLetters().length()/2 + " wrong letters:"
                    + game.getWrongLetters());
            game.guessedLetter();
        }
        if (game.isIfGameWon()){
            System.out.println("You win!");
            System.out.println("You have guessed " + game.getMovieTitle() + " correctly.") ;
        }
        else {
            System.out.println("You have guessed " + game.getWrongLetters().length()/2+ " wrong letters." + game.getWrongLetters());
            System.out.println("Game over");
            System.out.println("The movie title was" + game.getMovieTitle());
            System.out.println("Maybe next time");
        }

    }
    }


