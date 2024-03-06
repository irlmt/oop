package labs.l3pack.chordates.mammals.insectivores.hedgehogs.hedgehog;

import labs.l3pack.chordates.mammals.insectivores.hedgehogs.Hedgehogs;

public final class Hedgehog extends Hedgehogs {
    @Override
    public String getClassName(){
        return super.getClassName()+" - Еж";
    }
public Hedgehog(String name) {
    super(name);
}

}
