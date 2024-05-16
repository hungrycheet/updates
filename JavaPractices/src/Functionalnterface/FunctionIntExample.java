package Functionalnterface;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionIntExample {
    public FunctionIntExample() {
    }

    public static void main(String[] args){
//
        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes( "note1", 11));
        noteLst.add(new Notes( "note2", 22));
        noteLst.add(new Notes( "note3", 33));
        noteLst.add(new Notes( "note4", 44));
        noteLst.add(new Notes( "note5", 55));
        noteLst.add(new Notes( "note4", 66));

        Map<String, Integer> salaryMap = new HashMap<>();
        salaryMap.put("Alice", 50000);
        salaryMap.put("Bob", 60000);
        salaryMap.put("Charlie", 70000);
        salaryMap.put("David", 55000);


        List<Integer> lkist = salaryMap.values().stream().collect(Collectors.toList());

        Map<Integer, String> map = noteLst.stream().collect(Collectors.toMap(Notes::getTagId , Notes::getTagName));

        List<String> list = noteLst.stream().map(Notes::getTagName).collect(Collectors.toList());
        System.out.println(map);

        List<Employee> empList = new ArrayList<>();

        empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));

        empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));

        empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));

        empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));

        empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));

        empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));

        empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));

        empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandrum", 2015));

        empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010));


     List<Long> list1 = empList.stream().filter(e-> e.getAge() > 25 && e.getDeptName() == "IT" && e.getSalary() > 120)
             .map(Employee::getSalary).collect(Collectors.toList());

//        long sum = empList.stream().filter(e -> "HR".equalsIgnoreCase(e.getDeptName())).map(e->e.getSalary()).reduce((a,b) -> a + b).get();
           long sum = empList.stream().filter(e -> "HR".equalsIgnoreCase(e.getDeptName())).mapToLong(Employee::getSalary).sum();

           Map<String , Long> map10 = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName , Collectors.summingLong(Employee::getSalary)));
           map10.entrySet().stream().max(Map.Entry.comparingByValue());

        Optional<Map.Entry<String, Double>> map2 =empList.stream().collect(Collectors.groupingBy(Employee::getDeptName , Collectors.averagingLong(Employee::getSalary)))
                        .entrySet().stream().max(Map.Entry.comparingByValue());

       Optional<Map.Entry<Long, String>> map3 = empList.stream().collect(Collectors.toMap(Employee::getSalary , Employee::getCity))
               .entrySet().stream().max(Map.Entry.comparingByKey());

       Map<Long, String> map4 = empList.stream().collect(Collectors.toMap(Employee::getSalary, Employee::getDeptName));

        Map<String,Long> highestSalaryByDepartment = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().map(Employee::getSalary).orElse(0L)));
                //.forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue().orElse(null)));

        Map<String, Long> maxSalaryByDept = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                                opt -> opt.map(Employee::getSalary).orElse(null)
                        )));


        List<String> strlist = Arrays.asList("AB","BC","CD","DE");
        List<Character> chars = strlist.stream().flatMapToInt(CharSequence::chars).mapToObj(c -> (char) c).distinct().collect(Collectors.toList());

        List<Integer> intlist = Arrays.asList(1,2,23,2,4,5,4,1,3,3,5);

        Integer[] arr = {4, 1, 3, 2, 5, 1, 4, 4, 3, 2, 5};
        List<Integer> sortedList = Arrays.stream(arr)
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                .flatMap(entry -> Collections.nCopies(entry.getValue().intValue(), entry.getKey()).stream())
                .collect(Collectors.toList());

        Map<Integer, Long> map5 = intlist.stream().collect(Collectors.groupingBy(item -> item , Collectors.counting())).entrySet().stream()
                .sorted(Map.Entry.<Integer , Long>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey ,Map.Entry::getValue));

       System.out.println(map3.get());

       int[] arr1 = {0,1,2};

        int res = IntStream.range(0,arr1.length + 1).filter(i -> Arrays.stream(arr1).noneMatch(x -> x ==i)).findFirst().orElse(0);

        System.out.println(map10);

    }
}
