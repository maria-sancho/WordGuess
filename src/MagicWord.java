public class MagicWord {
    private String word;
    private String state;
    private boolean[] revealed;
    private boolean guessed;

    public MagicWord(String word) {
        this.word = word;
        this.state = "";

        for (int i = 0; i < word.length(); i++) {
            this.state += "_";
        }
        this.revealed = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            this.revealed[i] = false;
        }
        this.guessed = false;
    }

    public String getWord() {
        return this.word;
    }

    public String getState() {
        return this.state;
    }

    public boolean isGuessed() {
        return this.guessed;
    }

    public void updateState(char c) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                revealed[i] = true;
            }
        }

        this.state = "";
        for (int i = 0; i < word.length(); i++) {
            if (revealed[i]) {
                this.state += word.charAt(i);
            } else {
                this.state += "_";
            }
        }

        boolean allRevealed = true;
        for (int i = 0; i < word.length(); i++) {
            if (!revealed[i]) {
                allRevealed = false;
                break;
            }
        }

        if (allRevealed) {
            this.guessed = true;
        }
    }

    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
    }
}