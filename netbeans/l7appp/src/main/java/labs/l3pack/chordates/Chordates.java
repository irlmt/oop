package labs.l3pack.chordates;

public abstract class Chordates {
    private String name;
    public String getClassName(){
        return "Хордовые";
    }
    public String getName(){
        return name + ": " + getClassName();
    }
    public Chordates(String name) {
        this.name = name;
    }
}
