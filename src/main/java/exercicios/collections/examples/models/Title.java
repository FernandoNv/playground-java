package exercicios.collections.examples.models;

public class Title implements Comparable<Title>{
    private String name;

    public Title(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Title title) {
        return this.name.compareTo(title.getName());
    }

    @Override
    public String toString() {
        return "[Title]: name: " + this.name;
    }
}
