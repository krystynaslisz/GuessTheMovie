import java.util.Scanner;
public class Game {

    private String movieToGuess;
    private int lostPoints;
    private String wrongLetters;
    private String rightLetters;
    private boolean ifGameWon;

    public Game (String pathname) {
        ListofMovies listofMovies = new ListofMovies(pathname);
        movieToGuess = listofMovies.getRandomMovie().trim();
        lostPoints = 0;
        rightLetters = "";
        wrongLetters = "";
        ifGameWon = false;

    }

    //method returning the movie title
    public String getMovieTitle() {
        return movieToGuess;
    }

    //method replacing letters in the movie's title with underscores "_"
    public String getHiddenMovieTitle() {
        if(rightLetters.equals("")){
            return movieToGuess.replaceAll("[a-zA-Z]", "_");
        }
        else {
            return movieToGuess.replaceAll("[a-zA-Z&&[^" + rightLetters +"]]", "_");
        }
    }
    //method returning wronlgy guessed letters

    public String getWrongLetters() {
        return wrongLetters;
    }
    //methods thats changes booleanifGameWon to true
    public boolean isIfGameWon() {
        return ifGameWon;
    }

    //method returning the message that game is over when 10 points are lost

    public boolean gameOver() {
        if (lostPoints >= 10) {
            return true;
        }

        if (!getHiddenMovieTitle().contains("_")) {
            ifGameWon = true;
            return true;
        }
        return false;
    }
    //method that scans input letter that the player provided, converts to lower case and maatches if it is a real letter or a guessed one
    private String inputLetter(){

        System.out.println("Guess a letter");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine().toLowerCase();

        if(!letter.matches("[a-z]")){
            System.out.println("Hey, that is not a letter!");
            return inputLetter();
        } else if (wrongLetters.contains(letter) || rightLetters.contains(letter)) {
            System.out.println("You have already provided that letter.");
            return inputLetter();
        }
        else {
            return letter;
        }

    }
    // method that adds the geussed letter or if the letter was wrong adds 1 ponit to the lost

    public void guessedLetter() {
        String guessedLetter = inputLetter();

        if (movieToGuess.toLowerCase().contains(guessedLetter)) {
            rightLetters += guessedLetter + guessedLetter.toUpperCase();
        }
        else {
            lostPoints++;
            wrongLetters += " " + guessedLetter;
        }
    }

}
