package com.dumpQuiz;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kaustav on 4/7/2015.
 */
public class QuestionBank {
    private final String filePath;
    private Map<String, String> questionAnswers;

    public QuestionBank(String filePath) {
        this.filePath = filePath;
        questionAnswers = new HashMap<String, String>();
    }

    public void init() {
        try{
            String data = new QMFileReader(filePath).read();
            importQuestionAndAnswers(data);
        } catch (WrongFileNameException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importQuestionAndAnswers(String data) {
        String[] lines = data.split(System.lineSeparator());
        for (String line : lines) {
            String[] qAndA = line.split(":");
            questionAnswers.put(qAndA[0].trim(), qAndA[1].trim());
        }
    }

    public int getTotalQuestions() {
        return questionAnswers.size();
    }
}
