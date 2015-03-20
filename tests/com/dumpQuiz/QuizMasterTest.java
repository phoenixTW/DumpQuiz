package com.dumpQuiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import junit.framework.TestCase;

/**
 * Created by kaustavc on 3/20/2015.
 * An unit testing for QUIZ MASTER
 */
public class QuizMasterTest extends TestCase {

    private static final String GOLD_PATH = "tests/data";
    QuizMaster qm = new QuizMaster("QuestionSets");

    public void testFileReaderShouldReadFile () throws Exception, WrongFileNameException {
        qm.readQuestions();
        equalsFile("QuestionsOutput", qm.getSet());
    }

    protected void equalsFile(String fileName, String actualValue) throws IOException{
        BufferedReader file = new BufferedReader (new FileReader (GOLD_PATH + '/' + fileName));
        BufferedReader actualStream = new BufferedReader (new StringReader (actualValue));
        String thisFileLine;
        while  ((thisFileLine = file.readLine()) != null) {
            assertEquals ("in file: " + fileName, thisFileLine, actualStream.readLine());
        }
    }
}
