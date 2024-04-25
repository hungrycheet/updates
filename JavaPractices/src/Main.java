import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int [] A = {1, 2, 1, 3, 4, 3};
        int B = 3;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n = A.length;
        for(int i=0;i<=n-B;i++){
            for(int j=i;j<B;j++) {
                if (map.containsKey(A[j])) {
                    map.put(A[j], map.get(A[j]) + 1);
                } else {
                    map.put(A[i], 1);
                }
            }
            list.add(map.size());

        }
        System.out.println(list);


        //remove duplicate characters in the string
//          String s = "invigilation";
//          StringBuilder result = new StringBuilder();
//        LinkedHashSet<Character> set= new LinkedHashSet<>();
//        for(char ch : s.toCharArray()) {
//            if (!set.contains(ch)) {
//                result.append(ch);
//                set.add(ch);
//            }
//        }
//        System.out.println(result);

        //longest substring without duplicates

//        String s= "pwwkew";
//        String longessubstring="";
//        Set<Character> set = new HashSet<>();
//        int start=0;int end=0;int n=s.length();
//        int max=0;
//        while(end<n){
//            if(!set.contains(s.charAt(end))) {
//                set.add(s.charAt(end));
//                end++;
//                if(end-start > longessubstring.length()){
//                    longessubstring = s.substring(start , end);
//                }
//                max = Math.max(max, end - start);
//            }else{
//                set.remove(s.charAt(start));
//                start++;
//            }
//        }
//        System.out.println(longessubstring);
        System.out.println(ispalindrome("aba"));
        String str = "aaabbbccdd";
        StringBuilder resultstr = new StringBuilder();
        Map<Character, Integer> countmap = new HashMap<>();
        for(char ch : str.toCharArray()){
            countmap.put(ch , countmap.getOrDefault(ch ,0)+1);
        }
        for(Map.Entry ch : countmap.entrySet()){
            resultstr.append(ch.getKey());
            resultstr.append(ch.getValue());
        }
        System.out.println(resultstr);

        String result = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(item->item , Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByKey()).map(item -> item.getKey() + ""+item.getValue()).collect(Collectors.joining());

        String str1 = "a3b2c1d1";
        StringBuilder strres = new StringBuilder();
        for(int i=0;i<str1.length();i=i+2){
            int count= Character.getNumericValue(str1.charAt(i+1));
            for(int j=0;j<count;j++){
                strres.append(str1.charAt(i));
            }
            count=0;
        }
        System.out.println(strres);



    }
    public static boolean ispalindrome (String s){
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}