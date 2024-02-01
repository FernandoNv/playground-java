package exercicios.poo.usingInterface;

import exercicios.poo.usingInterface.model.Favourite;
import exercicios.poo.usingInterface.model.Podcast;
import exercicios.poo.usingInterface.model.Song;

public class Main {
    public static void main(String[] args) {
        Song song = new Song();
        song.setTitle("Heat Waves");
        song.setAlbum("Dreamland");
        song.setGenre("Indie Rock");
        song.setAuthor("Glass Animal");
        song.setDuration(3);

        Podcast podcast = new Podcast();
        podcast.setAuthor("Flow Podcast");
        podcast.setTitle("Podcast numero 100");
        podcast.setDescription("Numero 100 do programa");
        podcast.setDuration(60);

        for (int i = 0; i < 5000; i++){
            song.play();
        }

        for (int i = 0; i < 100; i++){
            podcast.like();
        }

        Favourite favourite = new Favourite();

        favourite.add(song);
        favourite.add(podcast);
    }
}
