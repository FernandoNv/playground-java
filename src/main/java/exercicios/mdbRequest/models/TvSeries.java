package exercicios.mdbRequest.models;

public class TvSeries extends VisualContent{
    private int seasons;
    private boolean stillRunning;
    private int episodesPerSeason;
    private int minutesPerEpisode;

    public TvSeries(String name, int yearReleased) {
        super(name, yearReleased);
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public boolean isStillRunning() {
        return stillRunning;
    }

    public void setStillRunning(boolean stillRunning) {
        this.stillRunning = stillRunning;
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public int getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    public void setMinutesPerEpisode(int minutesPerEpisode) {
        this.minutesPerEpisode = minutesPerEpisode;
    }

    @Override
    public int getDurationInMinutes() {
        return seasons * episodesPerSeason * minutesPerEpisode;
    }

    @Override
    public String toString() {
        return "TvSeries: " + this.getName() + "(" + getYearReleased() + ")";
    }
}
