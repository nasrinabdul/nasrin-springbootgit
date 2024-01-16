package org.example.springProject.jsonTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontFactory;

import java.io.*;
import java.util.stream.Collectors;

public class JsonToPdf {

    public static void convertJsonToPdf()
    {
        try (InputStream in = GCPQuiz.class.getResourceAsStream("/gcp_questions2.json");
             InputStream in2 = GCPQuiz.class.getResourceAsStream("/gcp_questions.json");
             BufferedReader br = new BufferedReader(new InputStreamReader(in));
             BufferedReader br2 = new BufferedReader(new InputStreamReader(in2))) {

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = br.lines().collect(Collectors.joining());
            String jsonString2 = br2.lines().collect(Collectors.joining());

            Question[] quizzes1 = mapper.readValue(jsonString, Question[].class);
            Question[] quizzes2 = mapper.readValue(jsonString2, Question[].class);

            Document document = new Document();


            try {
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("GCP_DUMP.pdf"));
                document.open();
                Font font1 = FontFactory.getFont(FontFactory.HELVETICA, 24, BaseColor.GREEN);
                Font font2 = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
                Font font3 = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.RED);

                document.addHeader("Questions", "GCP Associate Cloud Engineer Questions");
                int qNo = 0;
                for(Question quiz: quizzes1) {
                    qNo++;
                      document.add(new Paragraph("" + qNo + ". " + quiz.getQuestion().stream().collect(Collectors.joining()), font2));
                    document.add(new Paragraph("    "));
                      document.add(new Paragraph("A : " + quiz.getOptions().get("A").stream().collect(Collectors.joining()), font2));
                    document.add(new Paragraph("B : " + quiz.getOptions().get("B").stream().collect(Collectors.joining()), font2));
                    document.add(new Paragraph("C : " + quiz.getOptions().get("C").stream().collect(Collectors.joining()), font2));
                    document.add(new Paragraph("D : " + quiz.getOptions().get("D").stream().collect(Collectors.joining()), font2));
                    document.add(new Paragraph("Answer : " + quiz.getAnswer(), font3));
                    document.add(new Paragraph("    "));
                }
                for(Question quiz: quizzes2) {
                    qNo++;
                    document.add(new Paragraph("" + qNo + ". " + quiz.getQuestion().stream().collect(Collectors.joining()), font2));
                    document.add(new Paragraph("    "));
                    document.add(new Paragraph("A : " + quiz.getOptions().get("A").stream().collect(Collectors.joining()), font2));
                    document.add(new Paragraph("B : " + quiz.getOptions().get("B").stream().collect(Collectors.joining()), font2));
                    document.add(new Paragraph("C : " + quiz.getOptions().get("C").stream().collect(Collectors.joining()), font2));
                    document.add(new Paragraph("D : " + quiz.getOptions().get("D").stream().collect(Collectors.joining()), font2));
                    document.add(new Paragraph("Answer : " + quiz.getAnswer(), font3));
                    document.add(new Paragraph("    "));
                }

                document.close();
                writer.close();

            }catch (DocumentException e)
            {
                e.printStackTrace();
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
//
        } catch (
                IOException io) {
            io.printStackTrace();
        }
    }

    public static void main(String[] args) {
        convertJsonToPdf();
    }
}
