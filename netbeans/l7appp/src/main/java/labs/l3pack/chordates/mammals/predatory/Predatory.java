package labs.l3pack.chordates.mammals.predatory;

import labs.l3pack.chordates.mammals.Mammals;

public abstract class Predatory extends Mammals {
    @Override
    public String getClassName(){
        return super.getClassName()+" - Хищные";
    }
public Predatory(String name) {
    super(name);
}

}
