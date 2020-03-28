package com.astronautfinder.whosinspace;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class test {

    public static void main(String[] args) {
        // creating Arrays of String type
        Integer[] number = new Integer[] { 1,2,3 };

        // getting the list view of Array
        List<Integer> list = Arrays.asList(number);
        Optional<Integer> result = list.stream().reduce((num, sum) -> sum = sum + num);
        result.ifPresent(System.out::println);
    }
}
