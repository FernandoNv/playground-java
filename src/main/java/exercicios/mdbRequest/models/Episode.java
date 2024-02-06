package exercicios.mdbRequest.models;

import exercicios.mdbRequest.qualify.Qualifying;

public class Episode implements Qualifying {
    private int number;
    private String name;
    private TvSeries tvSeries;
    private int viewsCount;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TvSeries getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(TvSeries tvSeries) {
        this.tvSeries = tvSeries;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    @Override
    public int getQualifying() {
        if(viewsCount > 100){
            return 4;
        }

        return 2;
    }
}
