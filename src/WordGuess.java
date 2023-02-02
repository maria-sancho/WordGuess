import java.util.Random;
import java.util.Scanner;

public class WordGuess {
    private static final String[] WORDS = {"apple", "banana", "grape", "orange", "strawberry"};

    private MagicWord magicWord;

    public WordGuess() {
        Random rand = new Random();
        String word = WORDS[rand.nextInt(WORDS.length)];
        magicWord = new MagicWord(word);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        int attempts = 0;

        while (!magicWord.isGuessed()) {
            System.out.println("Attempt " + (attempts + 1) + ": " + magicWord.getState());
            System.out.print("Enter one character or your guess word: ");
            String input = scanner.nextLine();

            if (input.length() == 1) {
                magicWord.updateState(input.charAt(0));
            } else {
                if (input.equals(magicWord.getWord())) {
                    magicWord.setGuessed(true);
                }
            }
            attempts++;
        }

        System.out.println("Congratulation! You got it in " + attempts + " attempts.");
    }

}