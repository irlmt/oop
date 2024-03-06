package labs.l3pack.chordates.mammals.insectivores;

import labs.l3pack.chordates.mammals.Mammals;

public abstract class Insectivores extends Mammals {
    @Override
    public String getClassName(){
        return super.getClassName()+" - Насекомоядные";
    }
    public Insectivores(String name){super(name);}
}
