package org.example.springProject.jsonTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.print.DocFlavor;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class QuizWrite {

    public static void main(String args[]) {
        String input = "";
       // URL fileUrl = QuizWrite.class.getResource("/gcp_questions.json");
        //File file = null;
        Map<String, String> optionChar = Map.of("A.","A", "B.","B", "C.", "C", "D.", "D", "E.", "E");
//        try {
//            file = new File(fileUrl.toURI());
//        }catch(URISyntaxException use) {
//            use.printStackTrace();
//        }
       try( Scanner scan = new Scanner(System.in)){
//            FileWriter fileWriter = new FileWriter(file)) {
           Question quiz = new Question();
           quiz.setOptions(new HashMap<>());
           quiz.setQuestion(new ArrayList<>());
           System.out.println("Enter the data:");
           do{

                input = scan.nextLine();
                if(!input.isEmpty() && input.length()>2 && optionChar.containsKey(input.substring(0,2))) {
                    String options = input.substring(2);

                    quiz.getOptions().put(optionChar.get(input.substring(0,2)),
                            List.of(options.split(",")));
                }
                else if(!"close".equals(input)) {
                    quiz.getQuestion().add(input);

                }

           } while(!"close".equals(input));
           System.out.println("Enter the answer value");
           quiz.setAnswer(scan.nextLine());
           ObjectMapper mapper = new ObjectMapper();
//           fileWriter.write(mapper.writeValueAsString(quiz));
           System.out.println(mapper.writeValueAsString(quiz));

       } catch(Exception e) {
           e.printStackTrace();
       }

    }
}
