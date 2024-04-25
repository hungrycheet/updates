package Functionalnterface;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringExamples {
    public static void main(String[] args) {

        String s ="codeJavaProgram";
        StringBuilder result = new StringBuilder();
        String stres="";
        Set<Character> set = new HashSet<>();
//        for(char c: s.toCharArray()){
//            if(!set.contains(c)){
//                result.append(c);
//                set.add(c);
//            }
//        }

        String str1 = "betterbutter";
        Set<Character> set1 = new HashSet<>();
        for(char ch1: str1.toCharArray()){
            if(!set.contains(ch1)){
                set.add(ch1);
            }else{
                result.append(ch1);
            }
        }
        Map<Character, Integer> countmap = new HashMap<>();
        for(char chr:result.toString().toCharArray()){
                countmap.put(chr , countmap.getOrDefault(chr,0)+1);
        }

        for(int i=s.length()-1;i>0;i--){
            stres = stres + s.charAt(i);
        }
        System.out.println(countmap);

       Map<String, Long> map = Arrays.stream(s.split("")).collect(Collectors.groupingBy(item -> item , Collectors.counting()));
        System.out.println(map);

        Integer[] arr = {4, 1, 3, 2, 5, 1, 4, 4, 3, 2, 5};

        int sum = Arrays.stream(arr).mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        String str = "123Integer";
        StringBuilder integr =  new StringBuilder();
        int res=0;
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
               integr.append(c);
            }
        }
        res = Integer.parseInt(integr.toString());
        System.out.println(res);

        int number = 123;

        int sum1 = String.valueOf(number).chars().map(Character::getNumericValue).sum();
                //Stream.of(String.valueOf(123).split("")).mapToInt(Integer::parseInt).sum();
        System.out.println(sum1);


    }
}
