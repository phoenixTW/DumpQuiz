package com.dumpQuiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import com.dumpQuiz.exceptions.WrongFileNameException;
import com.dumpQuiz.exceptions.WrongQuestionFormatException;
import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * Created by kaustavc on 3/20/2015.
 * An unit testing for QUIZ MASTER
 */
public class QuizMasterTest extends TestCase {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private static final String GOLD_PATH = "tests/data";
    QuizMaster qm = new QuizMaster("QuestionSets");

    public void testFileReaderShouldReadFile () throws Exception, WrongFileNameException, WrongQuestionFormatException {
        qm.readQuestions();
        equalsFile("QuestionsOutput", qm.getSet());
    }

    public void testFileReaderShouldThrowErrorForInvalidFileName () {
        exception.expect(WrongFileNameException.class);
        exception.expectMessage("No file with the name data/InvalidFile found");
        new QuizMaster("InvalidFile");
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
