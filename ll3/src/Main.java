import ll3.chordates.Chordates;
import ll3.chordates.mammals.insectivores.hedgehogs.hedgehog.Hedgehog;
import ll3.chordates.mammals.predatory.Predatory;
import ll3.chordates.mammals.predatory.feline.Feline;
import ll3.chordates.mammals.predatory.feline.lynx.Lynx;

import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Chordates ivan = new Hedgehog("Иван");
        Chordates nikolay = new Predatory("Николай");
        Chordates mrsNorris = new Feline("Миссис Норрис");
        Chordates grisha = new Lynx("Гриша");

        Queue<Chordates> queue = new Queue<>(4);
        queue.add(ivan);
        queue.add(nikolay);
        queue.add(mrsNorris);
        queue.add(grisha);

        queue.consume(queue.produce());
        System.out.println();

        System.out.println("Все:");
        while (queue.getSize() > 0) {
            System.out.println(queue.get());
        }
    }
}