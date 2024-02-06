package exercicios.mdbRequest.models;

import exercicios.mdbRequest.qualify.Qualifying;

public class Movie extends VisualContent implements Qualifying {
    private String director;

    public Movie(String nome, int yearReleased) {
        super(nome, yearReleased);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie: " + this.getName() + " (" + this.getYearReleased() + ") ";
    }

    @Override
    public int getQualifying() {
        return (int) getAverage()/2;
    }
}
