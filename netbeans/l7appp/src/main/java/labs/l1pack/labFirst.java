package labs.l1pack;

import java.util.HashMap;

public class labFirst {
    private static HashMap<String, Hero> heroMap = new HashMap<>();

    public static boolean addHero(String name, String mStr){
        if(heroMap.isEmpty() || (!heroMap.isEmpty() && heroMap.get(name)==null))
        {
                Hero h = new Hero(name);
                switch (mStr) {
                    case ("Fly"):
                        h.setMoveStrategy(new FlyMoveStrategy());
                        break;
                    case ("Run"):
                        h.setMoveStrategy(new RunMoveStrategy());
                        break;
                    case ("Swim"):
                        h.setMoveStrategy(new SwimMoveStrategy());
                        break;
                    default:
                        return false;
                }
                heroMap.put(name, h);
                return true;
        }
        return false;
    }
    public static boolean changeStrategy(String name, String mStr){
       if(!heroMap.isEmpty() && heroMap.get(name)!=null){
            switch (mStr) {
                case ("Fly"):
                    heroMap.get(name).setMoveStrategy(new FlyMoveStrategy());
                    break;
                case ("Run"):
                    heroMap.get(name).setMoveStrategy(new RunMoveStrategy());
                    break;
                case ("Swim"):
                    heroMap.get(name).setMoveStrategy(new SwimMoveStrategy());
                    break;
                default:
                    return false;
            }
            return true;
        }
       return false;
    }
    public static String getStrategy(String name){
        return heroMap.get(name).move();
    }
}
