package exercicios.poo.usingInterface.model;

public abstract class Audio implements Rating{
    protected String title;
    protected int duration;
    protected String author;
    protected long likesCount;
    protected long playsCount;

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getLikesCount() {
        return likesCount;
    }

    public long getPlaysCount() {
        return playsCount;
    }

    @Override
    public int getRate() {
        return 0;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void like(){
        this.likesCount++;
    }

    public void play(){
        this.playsCount++;
    }
}
