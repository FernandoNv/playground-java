package exercicios.poo.usingInterface.model;

public class Podcast extends Audio{
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getRate() {
        return this.likesCount >= 1000 ? 9: 8;
    }
}
