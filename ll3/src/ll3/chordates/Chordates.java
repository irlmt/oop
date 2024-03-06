package ll3.chordates;

public abstract class Chordates {
    protected String id;
    public String getType() {
        return "Хордовые";
    }
    public String getId() {
        return id;
    }
    public abstract String getClas();
    public abstract String getDetachment();
    public abstract String getFamily();
    public abstract String getAnimal();
}
