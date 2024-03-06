import b.hero.Hero;
import b.move.FlyMoveStrategy;
import b.move.RunMoveStrategy;
import b.move.SwimMoveStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("введите имя героя: ");
        String heroName = in.nextLine();
        Hero hero1 = new Hero(heroName);
        System.out.print("введите стратегию(для остановки stop): ");
        String str = in.nextLine();
        while(!"stop".equals(str)){
            switch (str){
                case ("Fly"):
                    hero1.setMoveStrategy(new FlyMoveStrategy());
                    hero1.move();
                    break;
                case ("Run"):
                    hero1.setMoveStrategy(new RunMoveStrategy());
                    hero1.move();
                    break;
                case ("Swim"):
                    hero1.setMoveStrategy(new SwimMoveStrategy());
                    hero1.move();
                    break;
                default:
                    System.out.println("Wrong Strategy");
                    break;
            }
            System.out.print("введите стратегию(для остановки stop): ");
            str = in.nextLine();
        }
    }
}