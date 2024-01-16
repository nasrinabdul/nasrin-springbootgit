package org.example.springProject.jsonTest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class GCPQuiz {

    public static void main(String[] args) {

        //randomAllQuestions1();
        //randomAllQuestions2();
        //randomAllQuestions();
        randomRangeQuestions(161, 246);
        //allQuestions1();
        //allQuestions2();

    }

    private static void randomRangeQuestions(int minRange, int maxRange) {
        int qNo = 0;
        try(InputStream in = GCPQuiz.class.getResourceAsStream("/gcp_questions2.json");
            InputStream in2 = GCPQuiz.class.getResourceAsStream("/gcp_questions.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(in2))) {

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = br.lines().collect(Collectors.joining());
            String jsonString2 = br2.lines().collect(Collectors.joining());

            Question[] quizzes1 = mapper.readValue(jsonString, Question[].class);
            Question[] quizzes2 = mapper.readValue(jsonString2, Question[].class);
            List<Question> quizList1 = new ArrayList<>(List.of(quizzes1));
            List<Question> quizList2 = new ArrayList<>(List.of(quizzes2));

            int corrects=0;
            corrects = randomQuestions(quizList1, quizList2, 50, minRange, maxRange);
            System.out.println("Percentage :" + (corrects*100/50));

        } catch(IOException io) {
            io.printStackTrace();
        }
    }

    private static void randomAllQuestions() {
        int qNo = 0;
        try(InputStream in = GCPQuiz.class.getResourceAsStream("/gcp_questions2.json");
            InputStream in2 = GCPQuiz.class.getResourceAsStream("/gcp_questions.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(in2))) {

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = br.lines().collect(Collectors.joining());
            String jsonString2 = br2.lines().collect(Collectors.joining());

            Question[] quizzes = mapper.readValue(jsonString, Question[].class);
            Question[] quizzes2 = mapper.readValue(jsonString2, Question[].class);
            List<Question> quizList = new ArrayList<>(List.of(quizzes));
            List<Question> quizList2 = new ArrayList<>(List.of(quizzes2));

            int corrects=0;
            corrects = randomQuestions(quizList, quizList2, 50, 0, 0);
            System.out.println("Percentage :" + (corrects*100/50));

        } catch(IOException io) {
            io.printStackTrace();
        }
    }

    private static void randomAllQuestions1() {
        int qNo = 0;
        try(InputStream in2 = GCPQuiz.class.getResourceAsStream("/gcp_questions.json");
            BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
            Scanner scan = new Scanner(System.in)) {

            ObjectMapper mapper = new ObjectMapper();
            String jsonString2 = br2.lines().collect(Collectors.joining());

            Question[] quizzes2 = mapper.readValue(jsonString2, Question[].class);
            List<Question> quizList2 = new ArrayList<>(List.of(quizzes2));

            int corrects=0;
            corrects = randomQuestions(quizList2, null, 50,0, 0);
            System.out.println("Percentage :" + (corrects*100/50));

        } catch(IOException io) {
            io.printStackTrace();
        }
    }

    private static void randomAllQuestions2() {
        int qNo = 0;
        try(InputStream in2 = GCPQuiz.class.getResourceAsStream("/gcp_questions2.json");
            BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
            Scanner scan = new Scanner(System.in)) {

            ObjectMapper mapper = new ObjectMapper();
            String jsonString2 = br2.lines().collect(Collectors.joining());

            Question[] quizzes2 = mapper.readValue(jsonString2, Question[].class);
            List<Question> quizList2 = new ArrayList<>(List.of(quizzes2));

            int corrects=0;
            corrects = randomQuestions(null, quizList2, 50, 0, 0);
            System.out.println("Percentage :" + (corrects*100/50));

        } catch(IOException io) {
            io.printStackTrace();
        }
    }
    private static void allQuestions2() {
        int qNo = 0;
        try(InputStream in = GCPQuiz.class.getResourceAsStream("/gcp_questions2.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            Scanner scan = new Scanner(System.in)) {

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = br.lines().collect(Collectors.joining());

            Question[] quizzes = mapper.readValue(jsonString, Question[].class);
            List<Question> quizList = new ArrayList<>(List.of(quizzes));
            Collections.shuffle(quizList);

            int corrects=0;
            for(Question quiz : quizList) {
                corrects = printQuestion(quiz, scan, qNo, corrects);
            }
            System.out.println("Percentage :" + (corrects*100/quizList.size()));

        } catch(IOException io) {
            io.printStackTrace();
        }
    }

    private static void allQuestions1() {
        int qNo = 0;
        try(InputStream in = GCPQuiz.class.getResourceAsStream("/gcp_questions.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            Scanner scan = new Scanner(System.in)) {

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = br.lines().collect(Collectors.joining());

            Question[] quizzes = mapper.readValue(jsonString, Question[].class);
            List<Question> quizList = new ArrayList<>(List.of(quizzes));
            Collections.shuffle(quizList);

            int corrects=0;
            for(Question quiz : quizList) {
                corrects = printQuestion(quiz, scan, qNo, corrects);
            }
            System.out.println("Percentage :" + (corrects*100/quizList.size()));

        } catch(IOException io) {
            io.printStackTrace();
        }
    }

    private static int printQuestion(Question quiz, Scanner scan, int qNo, int corrects) {
        String question =  quiz.getQuestion().stream().reduce((q,s) -> q.concat(s)).get();
        if(question.length()>150) {
            System.out.println(++qNo + ". " + question.substring(0, 150));
            for (int i = 2; i <= (question.length() / 150); i++) {
                System.out.println(question.substring(150 * (i - 1), 150 * i));
            }
            System.out.println(question.substring(150 * (question.length() / 150)));
        } else  {
            System.out.println(++qNo + ". " + question);
        }
//                System.out.println(++qNo +". " + questionSpace); //.replaceAll("\n", System.lineSeparator()));
        List<String> optionKeys = new ArrayList<>(quiz.getOptions().keySet());
        Collections.shuffle(optionKeys);
        Map<Integer, String> keyMap = new HashMap<>();

        optionKeys.stream().unordered().forEach(k -> {
            List<String> op = quiz.getOptions().get(k);
            keyMap.put(keyMap.size()+1, k);
            String value = op.stream().reduce((q,s) -> q.concat(s)).get().toString();
            if(value.length() > 150) {
                System.out.println(keyMap.size() + " : " + value.substring(0, 150));
                for(int i=2; i<=(value.length()/150);i++) {
                    System.out.println(value.substring(150*(i-1),150*i));
                }
                System.out.println(value.substring(150*(value.length()/150)));
            }
            else {
                System.out.println(keyMap.size() + " : " + value);
            }

        });
        System.out.println("Enter the answer");
        int answer = scan.nextInt();
        if(quiz.getAnswer().length()==2) {
            if(quiz.getAnswer().equalsIgnoreCase(keyMap.get(answer/10)+keyMap.get(answer%10))) {
                System.out.println("correct");
                corrects++;
            } else {
                System.out.println("wrong : " + quiz.getOptions().get(quiz.getAnswer().substring(0, 1))
                        + quiz.getOptions().get(quiz.getAnswer().substring(1)));
            }
        } else {
            if(quiz.getAnswer().equalsIgnoreCase(keyMap.get(answer))) {
                System.out.println("correct");
                corrects++;
            } else {
                System.out.println("wrong : " + quiz.getOptions().get(quiz.getAnswer()));
            }
        }

        System.out.println("");
        return corrects;
    }
    private static int randomQuestions(List<Question> quizList1, List<Question> quizList2, int questionNum, int minRange, int maxRange) {
        List<Question> quizList = new ArrayList<>();
        int maxNum = 1;
        int minNum = 1;

        if(quizList1 != null && !quizList1.isEmpty() && quizList2 != null && !quizList2.isEmpty()) {
            quizList.addAll(quizList1);
            quizList.addAll(quizList2);
            if(minRange > 0 && maxRange > 0) {
                minNum = minRange;
                maxNum = maxRange;
            } else {
                minNum = 1;
                maxNum = 246;
            }
        }
        else if(quizList1 != null && !quizList1.isEmpty()) {
            quizList.addAll(quizList1);
            maxNum = 117;
            minNum = 1;
        }
        else if(quizList2 != null && !quizList2.isEmpty()) {
            quizList.addAll(quizList2);
            maxNum = 246;
            minNum = 118;
        }


        Map<Integer, Question> quizMap = quizList.stream().collect(Collectors.toMap(Question::getqNo, question -> question));
        List<Integer> quizAsked = new ArrayList<>();
        int corrects = 0;
        try(Scanner scan = new Scanner(System.in)) {
            for(int i=1; i<=questionNum; i++) {
                int qNo = minNum + (int)(Math.random()*(maxNum-minNum));
                while(quizAsked.contains(qNo)) {
                    qNo = minNum + (int)(Math.random()*(maxNum-minNum));
                }
                quizAsked.add(qNo);
                Question quiz = quizMap.get(qNo);

                corrects = printQuestion(quiz, scan, qNo, corrects);
            }
        }
        return corrects;
    }

}

class Question {
    @JsonProperty("qNo")
    private int qNo;
    @JsonProperty("question")
    private List<String> question;
   @Getter
   @JsonProperty("options")
    private Map<String, List<String>> options;
    @JsonProperty("answer")
    private String answer;

    public List<String> getQuestion() {
        return question;
    }

    public void setQuestion(List<String> question) {
        this.question = question;
    }

    public void setOptions(Map<String, List<String>> options) {
        this.options = options;
    }

    public Map<String, List<String>> getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getqNo() {
        return qNo;
    }

    public void setqNo(int qNo) {
        this.qNo = qNo;
    }
}