package exercicios.poo.usingInterface.model;

import exercicios.poo.usingInterface.model.Audio;

public class Song extends Audio {
    private String album;
    private String genre;

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public int getRate() {
        return this.playsCount >= 5000 ? 9 : 7;
    }
}
