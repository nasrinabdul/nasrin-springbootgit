package org.example.springProject.jsonTest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringReverse {

    public static void main(String args[]) {
        System.out.println("enter the string: ");
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        StringBuilder builder = new StringBuilder(text);

        System.out.println(builder.reverse());

        System.out.println(text);
        String[] str = text.split("\\s+");

        Arrays.stream(str).forEach(s->System.out.println(s));
        System.out.println(str.length);
        String reversedSentence = IntStream.range(0, str.length).mapToObj(i-> str[str.length-1-i])
                        .collect(Collectors.joining(" "));
    //forEach(s-> System.out.println(s));
                               // .peek(s -> System.out.println(s)).collect(Collectors.joining(" "));
       System.out.println(reversedSentence.stripTrailing());
    }
}

