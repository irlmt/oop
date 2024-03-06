package labs.l3pack.chordates.mammals.predatory.feline.manul;

import labs.l3pack.chordates.mammals.predatory.feline.Feline;

public final class Manul extends Feline {
    public Manul(String name) {
        super(name);
    }

    @Override
    public String getClassName() {
        return super.getClassName() + " - Манул";
    }
}
