import java.util.Arrays;


public class Word {
    private String word;
    private char[] hiddenWord;

    public Word(String word) {
        this.word = word;
        this.hiddenWord = new char[word.length()];
        Arrays.fill(hiddenWord, '_');

    }

    public boolean hasLetter(char letter ) {
        return word.contains(String.valueOf(letter));

    }

    public void revealLetter(char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                hiddenWord[i] = letter;
            }
        }
    }

    public boolean wasCompleted() {
        return String.valueOf(hiddenWord).equals(word);

    }

    public String getHiddenWord() {
        return String.valueOf(hiddenWord);
    }

    public String getWord() {
        return word;

    }

    public int getSize() {
        return word.length();
    }
}
