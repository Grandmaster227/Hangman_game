import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Character> triedLetters;

    public Player() {
        this.triedLetters = new ArrayList<>();
    }

    public void addTriedLetter(char letter ) {
        triedLetters.add(letter);
    }

    public boolean alreadyTried(char letter) {
        return triedLetters.contains(letter);
    }

    public List<Character> getAttemptedLetters() {
        return triedLetters;
    }
}
