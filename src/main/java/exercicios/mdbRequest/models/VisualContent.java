package exercicios.mdbRequest.models;

import exercicios.mdbRequest.exceptions.ValidateYearException;

public class VisualContent implements Comparable<VisualContent>{
    private String name;
    private boolean inSubscription;
    private int yearReleased;
    private double ratingSum;
    private int ratingCount;
    private int durationInMinutes;

    public VisualContent(String name, int yearReleased) {
        this.name = name;
        this.yearReleased = yearReleased;
    }

    public VisualContent(VisualContentOMDB visualContentOMDB) throws ValidateYearException{
        if(visualContentOMDB.year().length() > 4){
            throw new ValidateYearException("Could not convert year received from VisualContentOMDB");
        }
        this.name = visualContentOMDB.title();
        this.yearReleased = Integer.parseInt(visualContentOMDB.year());
        this.durationInMinutes = Integer.parseInt(visualContentOMDB.runtime().substring(0, visualContentOMDB.runtime().length()-4));
    }

    public String getName() {
        return name;
    }

    public boolean isInSubscription() {
        return inSubscription;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public double getRatingSum() {
        return ratingSum;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInSubscription(boolean inSubscription) {
        this.inSubscription = inSubscription;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void showInformations(){
        System.out.println("Nome do filme: " + name);
        System.out.println("Ano de lançamento: " + yearReleased);
    }

    public void rate(double rating){
        this.ratingSum += rating;
        ratingCount++;
    }

    public double getAverage(){
        return ratingSum/ratingCount;
    }

    @Override
    public String toString() {
        return String.format("(name=%s, yearReleased=%d, durationInMinutes=%d)", name, yearReleased, durationInMinutes);
    }

    @Override
    public int compareTo(VisualContent visualContent) {
        return this.getName().compareTo(visualContent.getName());
    }
}
