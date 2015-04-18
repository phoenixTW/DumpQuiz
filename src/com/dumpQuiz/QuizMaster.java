package com.dumpQuiz;

import java.io.IOException;

/**
 * Created by kaustavc on 3/20/2015.
 * Quiz Master class who will conduct the quiz
 */
public class QuizMaster {
    private String filename;
    private String questionSet;

    public QuizMaster(String filename) {

        this.filename = "data/" + filename;
    }

    public String getSet() {
        return questionSet;
    }

    public void readQuestions() throws IOException, WrongFileNameException {

        questionSet = new QMFileReader(filename).read();
    }
}
