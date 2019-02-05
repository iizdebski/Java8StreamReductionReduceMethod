package com.izdebski;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamReduction {

    public static void main(String[] args) {
        // 1+2+3
        OptionalInt reduced = IntStream.range(1,4).reduce((a, b)->a+b);
        System.out.println(reduced.getAsInt());

        System.out.println("-----------------------------------------");

        //10=1+2+3
        int reducedTwoParams = IntStream.range(1, 4).reduce(10, (a,b)->a+b);
        System.out.println(reducedTwoParams);

        System.out.println("-----------------------------------------");

        Integer reduce = Arrays.asList(1,2,3).parallelStream().reduce(10, (a,b)->a+b, (a,b)->{
            System.out.println("Combiner was called ...");
            return a+b;
        });
        //11,12+13=25, 25+11=36
        System.out.println(reduce);
    }
}