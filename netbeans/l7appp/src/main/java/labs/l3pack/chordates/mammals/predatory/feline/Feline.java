package labs.l3pack.chordates.mammals.predatory.feline;

import labs.l3pack.chordates.mammals.predatory.Predatory;

public abstract class Feline extends Predatory {
    @Override
    public String getClassName(){
        return super.getClassName()+" - Кошачьи";
    }
    public Feline(String name) {
    super(name);
}
}