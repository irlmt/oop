package labs.l3pack.chordates.mammals.insectivores.hedgehogs;

import labs.l3pack.chordates.mammals.insectivores.Insectivores;

public abstract class Hedgehogs extends Insectivores {
    @Override
    public String getClassName(){
        return super.getClassName()+" - Ежовые";
    }
public Hedgehogs(String name) {
    super(name);
}

}
