package core.java;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {

        List<Integer> myList = Arrays.asList(10,15,8,10,25,98,32);
        System.out.println("Duplicate number");
        Set<Integer> set = new HashSet();
        myList.stream()
                .filter(n -> !set.add(n))
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");
        System.out.println("Find number");
        myList.stream().filter(x -> x==8).findFirst().ifPresent(System.out::println);
        System.out.println("Max number");
        myList.stream().max(Integer::compare).ifPresent(System.out::println);
        System.out.println("-----------------------------------------------------------");

        String input = "Java Hungry Blog Alive is Awesome";

        Character result = input.chars() // Stream of String
                .mapToObj(s -> Character.toLowerCase((char) s)) // First convert to Character object and then to lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println(result);

        myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
        System.out.println( "Second Last " +   myList.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get());

        System.out.println( "Second Last " +   myList.stream().sorted().skip(myList.size()-2).findFirst().get());

        List<Emp> emps = new ArrayList<>();

        emps.add(new Emp(10,"A"));
        emps.add(new Emp(2,"H"));
        emps.add(new Emp(3,"G"));
        emps.add(new Emp(1,"D"));

        emps.stream().sorted(Comparator.comparingInt(Emp::getId).reversed()).map(x -> x.getId()).forEach(System.out::println);
    }
}
class Emp {
    private int id;
    private String name;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}