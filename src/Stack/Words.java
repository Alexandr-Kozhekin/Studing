package Stack;

import java.util.Objects;

public class Words {

    private String word;
    private int counter = 0;

    public Words(String word) {
        this.word = word;
        this.counter++;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Words words = (Words) o;
        return Objects.equals(word, words.word);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(word);
    }

    @Override
    public String toString() {
        return "|word=" + word + ", counter=" + counter + "|";
    }
}

