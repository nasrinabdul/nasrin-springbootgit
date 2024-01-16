package org.example.springProject.jsonTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class DuplicateChars {

    public static void main(String[] args) {
        String text = "abcdefghijk";

        Set <Character> actualSet = new LinkedHashSet<>();
        Set<Character> duplicateSet = new LinkedHashSet<>();

        for(char c : text.toCharArray()) {
                if(!actualSet.add(c)) {
                    duplicateSet.add(c);
                }
        }
        System.out.println("Duplicated characters are: "+ duplicateSet);
        System.out.println("First repeated character : " + (!duplicateSet.isEmpty()? duplicateSet.iterator().next() : "Nothing"));
        actualSet.removeAll(duplicateSet);
        System.out.println("First non repeated character : " + (!actualSet.isEmpty()?actualSet.iterator().next(): "Nothing"));
    }
}
