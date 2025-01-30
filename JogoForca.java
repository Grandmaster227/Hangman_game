import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class JogoForca {
        private Word word;
        private Player player;
        private int remainingAttempts;


        public JogoForca() {
            List<String> words = new ArrayList<>();
            words.add("java");
            words.add("coding");
            words.add("pc");
            words.add("development");
            words.add("algorythm");
            words.add("panzerkampfwagen");
            words.add("king");
            words.add("iron");
            words.add("fist");


            Random random = new Random();
            String chosenWord = words.get(random.nextInt(words.size()));
            this.word = new Word(chosenWord);
            this.player = new Player();
            this.remainingAttempts = 6;


        }

        public void iniciar() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to hangman's game");
            System.out.println("The word has " + word.getSize() + " letras.");

            while (remainingAttempts > 0) {
                System.out.println("\nWords: " + word.getHiddenWord());
                System.out.println("Remaining attempts: " + remainingAttempts);
                System.out.println("Attempted letters: " + player.getAttemptedLetters());

                System.out.println("Type one letter: ");
                char Letter = scanner.next().toLowerCase().charAt(0);

                if (player.alreadyTried(Letter)) {
                    System.out.println("U have already tried this letter, try another");
                    continue;
                }


                player.addTriedLetter(Letter);

                if (word.hasLetter(Letter)) {
                    System.out.println("Correct letter");
                    word.revealLetter(Letter);

                } else {
                    System.out.println("Wrong letter");
                    remainingAttempts--;
                }

                if (word.wasCompleted()) {
                    System.out.println("\n Congrats! you have guessed the word: " + word.getWord());
                    break;
                }

            }

            if (remainingAttempts == 0 ) {
                System.out.println("\n You lose! the word was: " + word.getWord());
            }

            scanner.close();
        }
}
