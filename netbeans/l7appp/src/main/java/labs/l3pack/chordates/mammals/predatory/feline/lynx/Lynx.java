package labs.l3pack.chordates.mammals.predatory.feline.lynx;

import labs.l3pack.chordates.mammals.predatory.feline.Feline;

public final class Lynx extends Feline {
    @Override
    public String getClassName(){
        return super.getClassName()+" - Рысь";
    }
public Lynx(String name) {
    super(name);
}

}
