package labs.l3pack.chordates.mammals;

import labs.l3pack.chordates.Chordates;

public abstract class Mammals extends Chordates {
    @Override
    public String getClassName(){
        return super.getClassName()+" - Млекопитающие";
    }
public Mammals(String name) {
    super(name);
}

}
