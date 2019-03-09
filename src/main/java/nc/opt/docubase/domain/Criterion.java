package nc.opt.docubase.domain;

import java.io.Serializable;
import java.util.Objects;

public class Criterion implements Serializable {
    private String word;
    private String categoryId;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Criterion criterion = (Criterion) o;
        return Objects.equals(word, criterion.word) &&
                Objects.equals(categoryId, criterion.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, categoryId);
    }

    @Override
    public String toString() {
        return "Criterion{" +
                "word='" + word + '\'' +
                ", categoryId='" + categoryId + '\'' +
                '}';
    }
}
