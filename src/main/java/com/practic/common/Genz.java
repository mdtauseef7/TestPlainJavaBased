package com.practic.common;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Genz {
    public static void main(String[] args) {
              //System.out.println(reserString("Tauseef"));
              //System.out.println(reserString("rwrwrww"));
               //swapTwoNum(2,3);
             //countWordsUsingHashMap("Two words are equal to Two");
            //duplicateCharacters("Tauseefa");
        int num[] = {4,5,4,6,34,3,23,2,1,4,33,32,35};
        //System.out.println(secondHighestArr(num));
        //removeWhiteSpace("sdfs dfcszfd fvsd");
        //commaSeperatedConcanated("avd,sd,ef,bc");
        //System.out.println(isGoodString("ihfgeeihfg"));
        //System.out.println(isAnagram("Tauseef","eeTaufs"));
        LinkedList<Integer> list = new LinkedList<>();
        list.addAll(Arrays.asList(54,56,78,97));
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addAll(Arrays.asList(3,15,18,70,73,98,200,18,3));
        //System.out.println(mergeTwoLinkedList(list,list1));

       // printEven(list1);
       // startsWithOne(list1);
        //duplicateNum(list1);
        //findFirst(list);
        //firstNonRepetativeChar("Java articles are Awesome");
        //firstRepetativeChar("Java articles are Awesome");
         //sortReverseOrder(list1);

        //System.out.println(isNotAllDistinct(list1));
       // cubeAndGreater(list1);
        lengthOfLongestSubstring("asfdsfd");
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;
            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    static void cubeAndGreater(List<Integer> numList){
        numList.stream().map(integer -> integer*integer*integer)
                .filter(integer -> integer >50)
                .forEach(System.out::println);
    }

    static Boolean isNotAllDistinct(List<Integer> numList){

       return numList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .findAny().isPresent();


    }

    static void sortReverseOrder(List<Integer> list){
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

    }

    static void firstRepetativeChar(String input){
        Stream.of(input.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() >1)
                .map(Map.Entry::getKey).findFirst().ifPresent(System.out::println);
    }
    static void firstNonRepetativeChar(String input){
        Stream.of(input.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() ==1)
                .map(Map.Entry::getKey)
                .findFirst().ifPresent(System.out::println);
    }

    static void findFirst(List<Integer> numList){

        Optional<Integer> first = numList.stream().findFirst();
        System.out.println(first.get());
    }

    static void duplicateNum(List<Integer> numList){
        numList.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

    }

    static void startsWithOne(List<Integer> numList){
        numList.stream()
                .map(num -> Integer.toString(num))
                .filter(num -> num.startsWith("1"))
                .mapToInt(Integer::valueOf)
                .forEach(System.out::println);
    }

    static void printEven(List<Integer> numList){

        List<Integer> s = numList.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println(s);

    }

    static LinkedList<Integer> mergeTwoLinkedList(LinkedList<Integer> list1, LinkedList<Integer> list2){
        LinkedList<Integer> sorted = new LinkedList<>();
        int i=0,j=0;

        while(i<list1.size() && j<list2.size()){
             int val1 = list1.get(i);
             int val2 = list2.get(j);
            if(val1 < val2){
                sorted.add(val1);
                i++;
            }else{
                sorted.add(val2);
                j++;
            }
        }

        while( i < list1.size()){
            sorted.add(list1.get(i++));
        }

        while ( j < list2.size()){
            sorted.add(list2.get(j++));
        }

        return sorted;
    }
    
    
    static Boolean isAnagram(String s1, String s2){

        Map<String, Long> collect = Stream.of(s1.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(String s: s2.split("")){
           if(collect.containsKey(s)){
             long count = collect.get(s);
             if(count == 1){
                 collect.remove(s);
             }else{
                 count--;
                 collect.put(s,count);
             }
             continue;
           }
           return false;

        }

        if(collect.isEmpty()){
            return true;
        }

        return false;
    }
    

    static int[] removeEle(int[] nums, int val){
          int j = 0;
        for(int i = 0; i <nums.length; i++){
            if(val == nums[i]){
              continue;
            }
            nums[j++] = nums[i];
        }

        return nums;
    }


    static Boolean isGoodString(String input){
        long count = Stream.of(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .mapToLong(Map.Entry::getValue)
                .distinct()
                .count();

        if(count == 1){
            return true;
        }

        return false;
    }

    static void commaSeperatedConcanated(String input){
        String collect = Stream.of(input.split(",")).sorted().collect(Collectors.joining());
        System.out.println(collect);
    }

    static void findIndicesForTargetNum(int[] nums, int target){
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
               System.out.println("Two indices are: "+i+" and "+numMap.get(complement));
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    static void removeWhiteSpace(String input){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i <input.length(); i++){
            Character c = input.charAt(i);
            if(c == ' ') continue;
            str.append(c);
        }
        System.out.println(str);
    }
    static String reserString(String input){
        int left = 0, right = input.length()-1;
        char[] outputChar = input.toCharArray();
        while(left < right){
            char temp = input.charAt(left);
            outputChar[left] = input.charAt(right);
            outputChar[right] = temp;
            left++;
            right--;
        }
        return new String(outputChar);
    }
    static String reversStringUsingStack(String input){

        Stack<Character> characterStack = new Stack<>();
        for (int i =0;i< input.length(); i++){
            characterStack.push(input.charAt(i));
        }
        char[] outputChar = new char[input.length()];
        for (int i =0;i< input.length(); i++){
            outputChar[i] = characterStack.pop();
        }
        return new String(outputChar);
    }
    static void swapTwoNum(int a, int b){
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("After swap a: "+a+" and b: "+b);
    }

    static void countWordsUsingHashMap(String input){
         String[] strs = input.split(" ");
         HashMap<String, Integer> wordsCount = new HashMap<>();
         for (String str:strs){
             wordsCount.put(str, wordsCount.getOrDefault(str,0)+1);
         }
         System.out.println(wordsCount);
    }

    static void iterateHashMap(HashMap<String, String> input){
          Set<Map.Entry<String,String>> entrySets = input.entrySet();
          for(Map.Entry<String,String> entry:entrySets){

        }

        Iterator<Map.Entry<String,String>> iterator = input.entrySet().iterator();
          while (iterator.hasNext()){

          }

    }

    static Boolean isPrimeOrNot(int input){
        if(input == 1 || input == 2){
            return true;
        }
        for (int i=2; i <input/2; i++){
            if(input % i == 0){
                return false;
            }
        }
        return true;
    }
    static int fibonaciiSeries(int n){
        if(n <=1){
            return n;
        }
        return fibonaciiSeries(n-1) + fibonaciiSeries(n-2);
    }


    static void duplicateCharacters(String input){
        List<String> collect = Stream.of(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entryObj -> entryObj.getValue() > Long.valueOf(1))
                .map(Map.Entry::getKey).collect(Collectors.toUnmodifiableList());
        System.out.println(collect);
    }

    static int secondHighestArr(int[] nums){
        int highest=0, secondHighest=0;
        for(int num: nums){
            if(num > highest){
                secondHighest = highest;
                highest = num;
            }
            if(secondHighest < num && num < highest ){
                secondHighest = num;
            }
        }
        return secondHighest;
    }



}
