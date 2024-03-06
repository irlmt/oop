package labs.l3pack;

import labs.l3pack.chordates.Chordates;
import labs.l3pack.chordates.mammals.insectivores.hedgehogs.hedgehog.Hedgehog;
import labs.l3pack.chordates.mammals.predatory.feline.lynx.Lynx;
import labs.l3pack.chordates.mammals.predatory.feline.manul.Manul;

import java.util.LinkedList;

public class Segregate<T> {
public static void segregate(LinkedList<? extends Chordates> srcCollection, LinkedList<? super Hedgehog> collection1,
                             LinkedList<? super Manul> collection2, LinkedList<? super Lynx> collection3) {
    for (Chordates chordate: srcCollection) {
        if (chordate instanceof Hedgehog) {
            collection1.add((Hedgehog) chordate);
        }
        if (chordate instanceof Manul) {
            collection2.add((Manul) chordate);
        }
        if (chordate instanceof Lynx) {
            collection3.add((Lynx) chordate);
        }
    }
}
}
