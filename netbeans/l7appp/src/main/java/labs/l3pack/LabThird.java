package labs.l3pack;

import labs.l3pack.chordates.Chordates;
import labs.l3pack.chordates.mammals.Mammals;
import labs.l3pack.chordates.mammals.insectivores.Insectivores;
import labs.l3pack.chordates.mammals.insectivores.hedgehogs.Hedgehogs;
import labs.l3pack.chordates.mammals.insectivores.hedgehogs.hedgehog.Hedgehog;
import labs.l3pack.chordates.mammals.predatory.Predatory;
import labs.l3pack.chordates.mammals.predatory.feline.Feline;
import labs.l3pack.chordates.mammals.predatory.feline.lynx.Lynx;
import labs.l3pack.chordates.mammals.predatory.feline.manul.Manul;

import java.util.LinkedList;

public class LabThird {

    public static String example1(){
        String s = "";
        StringBuilder bS = new StringBuilder(s);
        Mammals cc1 = new Hedgehog("Hedgehog_name1");
        Mammals cc2 = new Lynx("Lynx_name2");
        Mammals cc3 = new Manul("Manul_name3");
        LinkedList<Mammals> src1 = new LinkedList<>();
        src1.add(cc1);
        src1.add(cc2);
        src1.add(cc3);
        LinkedList<Hedgehogs> h1 = new LinkedList<>();
        LinkedList<Feline> f1 = new LinkedList<>();
        LinkedList<Predatory> p1 = new LinkedList<>();
        Segregate.segregate(src1, h1, f1, p1);
        bS.insert(bS.length(), "Src1: Млекопитающие" + '\n');
        for(Mammals m : src1){
            bS.insert(bS.length(),m.getName()+ '\n');
        }
        bS.insert(bS.length(),"cl1: Ежовые"+ '\n');
        for(Hedgehogs m : h1){
            bS.insert(bS.length(),m.getName()+ '\n');
        }
        bS.insert(bS.length(),"cl2: Кошачьи"+ '\n');
        for(Feline m : f1){
            bS.insert(bS.length(),m.getName()+ '\n');
        }
        System.out.println("cl3: Хищные");
        for(Predatory m : p1){
            bS.insert(bS.length(),m.getName()+ '\n');
        }
        return bS.toString();
    }
    public static String example2(){
        String s = "";
        StringBuilder bS = new StringBuilder(s);
        LinkedList<Predatory> src2 = new LinkedList<>();
        LinkedList<Chordates> c2 = new LinkedList<>();
        LinkedList<Manul> m2 = new LinkedList<>();
        LinkedList<Feline> f2 = new LinkedList<>();
        Predatory pp1 = new Lynx("Lynx_name1");
        Predatory pp2 = new Manul("Manul_name2");
        Predatory pp3 = new Manul("Manul_name3");
        src2.add(pp1);
        src2.add(pp2);
        src2.add(pp3);
        Segregate.segregate(src2, c2, m2, f2);

        bS.insert(bS.length(),"Src2: Хищные"+'\n');
        for(Predatory m : src2){
            bS.insert(bS.length(),m.getName()+'\n');
        }
        bS.insert(bS.length(),"cl1: Хордовые"+'\n');
        for(Chordates m : src2){
            bS.insert(bS.length(), m.getName()+'\n');
        }
        bS.insert(bS.length(),"cl2: Манулы"+'\n');
        for(Manul m : m2){
            bS.insert(bS.length(),m.getName()+'\n');
        }
        bS.insert(bS.length(),"cl3: Кошачьи"+'\n');
        for(Feline m : f2){
            bS.insert(bS.length(),m.getName()+'\n');
        }
        return bS.toString();
    }

    public static String example3(){
        String s = "";
        StringBuilder bS = new StringBuilder(s);
        LinkedList<Hedgehogs> src3 = new LinkedList<>();
        LinkedList<Insectivores> i3 = new LinkedList<>();
        LinkedList<Predatory> p3 = new LinkedList<>();
        LinkedList<Predatory> p_3 = new LinkedList<>();
        Hedgehogs hh1 = new Hedgehog("Hedgehog_name_h1");
        Hedgehogs hh2 = new Hedgehog("Hedgehog_name_h2");
        Hedgehogs hh3 = new Hedgehog("Hedgehog_name_h3");
        src3.add(hh1);
        src3.add(hh2);
        src3.add(hh3);
        Segregate.segregate(src3, i3, p3, p_3);
        bS.insert(bS.length(),"Src3: Ежовые"+'\n');
        for(Hedgehogs m : src3){
            bS.insert(bS.length(),m.getName()+'\n');
        }
        bS.insert(bS.length(),"cl1: Насекомоядные"+'\n');
        for(Insectivores m : i3){
            bS.insert(bS.length(),m.getName()+'\n');
        }
        bS.insert(bS.length(),"cl2: Хищные"+'\n');
        for(Predatory m : p3){
            bS.insert(bS.length(),m.getName()+'\n');
        }
        bS.insert(bS.length(),"cl3: Хищные"+'\n');
        for(Predatory m : p_3){
            bS.insert(bS.length(),m.getName()+'\n');
        }
        return bS.toString();
    }
}