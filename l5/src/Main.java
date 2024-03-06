import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("1) среднее значение");
        List<Integer> l1 =List.of(1, 3, 5, 7, 10);
        task1(l1);
        System.out.println("2) _new_ + верхний регистр");
        List<String> l2 = List.of("first", "second", "third");
        task2(l2);
        System.out.println();
        System.out.println("3) квадрат всех встречающихся один раз элементов");
        List<Integer> l3 = List.of(0, 4, 5, 4, 6, 6, 9, 8, 9); //8, 5, 0
        task3(l3);
        System.out.println("4) отсортированные строки с \"f\"");
        List<String> l4 = List.of( "cgjn", "ffgkm","fGkfmFg", "aaa");
        task4(l4, 'f');
        System.out.println("5) последний элемент или исключение");
        List<Integer> l51 = List.of(8, 800, 555, 35);
        List<Integer> l52 = List.of();
        try{
               System.out.println(task5(l51));
               System.out.println(task5(l52));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("6) сумма четных чисел или 0");
        List<Integer> l61 = List.of(5, 7, 9, 11);
        List<Integer> l62 = List.of(4, 5, 6, 7, 8);
        task6(l61);
        task6(l62);
        System.out.println("7) преобразование всех строк в Мар, где 1ый символ - ключ, остальные - значение");
        List<String> l7 = List.of("wwell", "ddimple", "stop");
        task7(l7);
    }
    public static void task1(List<Integer> l){
        double r1 = l.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics()
                .getAverage();
        System.out.println(r1);
    }
    public static void task2(List<String> l2){
        l2.stream()
                .map(s->s.toUpperCase())
                .map(s->"_new_"+s)
                .forEach(s ->System.out.print(s+" "));
    }
    public static void task3(List<Integer> l3){
        l3.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach(s->System.out.println(s*s));
    }
    public static void task4(List<String> l4, char c){
        l4.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .filter(s->s.charAt(0)==c)
                .forEach(s->System.out.println(s));
    }
    public static Integer task5(List<Integer> l51) throws NoSuchElementException{
        return l51.stream().reduce((x,y)->{return y;}).orElseThrow(() -> new NoSuchElementException("List is empty"));
    }
    public static void task6(List<Integer> l61){
        System.out.println(l61.stream().filter(s -> s % 2 == 0).reduce(0, (x, y) -> x + y));
    }
    public static void task7(List<String> l7){
        l7.stream()
                .collect(Collectors.toMap(str -> str.charAt(0), str -> str.substring(1)))
                .forEach((a, b)-> System.out.println("key:"+a+", val:"+b));
    }
}