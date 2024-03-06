package labs.l5pack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LabFifth {
    public static List<Integer> toIntList(String s){
        List<Integer> l = new ArrayList<>();
        String d = "";
        StringBuilder bD = new StringBuilder(d);
        StringBuilder bS = new StringBuilder(s);
        while(!bS.toString().isEmpty()){
            int i = bS.toString().indexOf(" ");
            if(i!=-1){
                bD.delete(0, bD.length());
                bD.insert(0, bS.substring(0, i));
                bS.delete(0, i+1);
            }
            else{
                if(!bS.isEmpty()){
                    bD.delete(0, bD.length());
                    bD.insert(0, bS);
                    bS.delete(0, bS.length());
                }
            }
            l.add(Integer.valueOf(bD.toString()));
        }
        return l;
    }
    public static List<String> toStrList(String s){
        List<String> l = new ArrayList<>();
        String d = "";
        StringBuilder bD = new StringBuilder(d);
        StringBuilder bS = new StringBuilder(s);
        while(!bS.toString().isEmpty()){
            int i = bS.toString().indexOf(" ");
            if(i!=-1){
                bD.delete(0, bD.length());
                bD.insert(0, bS.substring(0, i));
                bS.delete(0, i+1);
            }
            else{
                if(!bS.isEmpty()){
                    bD.delete(0, bD.length());
                    bD.insert(0, bS);
                    bS.delete(0, bS.length());
                }
            }
            l.add(bD.toString());
        }
        return l;
    }
    public static String task1(String s){
        List<Integer> l = toIntList(s);
        double r1 = l.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics()
                .getAverage();
        return String.valueOf(r1);
    }
    public static String task2(String str){
        List<String> l2 = toStrList(str);
        String tmp = "";
        StringBuilder bTmp = new StringBuilder(tmp);
        l2.stream()
                .map(s->s.toUpperCase())
                .map(s->"_new_"+s)
                .forEach(s ->bTmp.insert(bTmp.length(),s+" "));
        return bTmp.toString();
    }
    public static String task3(String str){
        List<Integer> l3 = toIntList(str);
        String tmp = "";
        StringBuilder bTmp = new StringBuilder(tmp);
        l3.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach(s->bTmp.insert(bTmp.length(),String.valueOf(s*s)+'\n'));
        return bTmp.toString();
    }
    public static String task4(String str, char c){
        List<String> l4 = toStrList(str);
        String tmp = "";
        StringBuilder bTmp = new StringBuilder(tmp);
        l4.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .filter(s->s.charAt(0)==c)
                .forEach(s->bTmp.insert(bTmp.length(), s+'\n'));
        return bTmp.toString();
    }
    public static String task5(String str)throws NoSuchElementException{
        List<Integer> l51 = toIntList(str);
        return String.valueOf(l51.stream().reduce((x,y)->{return y;}).orElseThrow(() -> new NoSuchElementException("List is empty")));
    }
    public static String task6(String str){
        List<Integer> l61 = toIntList(str);
       return String.valueOf(l61.stream().filter(s -> s % 2 == 0).reduce(0, (x, y) -> x + y));
    }
    public static String task7(String s){
        List<String> l7 = toStrList(s);
        String tmp = "";
        StringBuilder bTmp = new StringBuilder(tmp);
        l7.stream()
                .collect(Collectors.toMap(str -> str.charAt(0), str -> str.substring(1)))
                .forEach((a, b)-> bTmp.insert(bTmp.length(),"key:"+a+", val:"+b+'\n'));
        return bTmp.toString();
    }
}