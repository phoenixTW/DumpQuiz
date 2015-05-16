package com.dumpQuiz;

import com.dumpQuiz.exceptions.WrongFileNameException;
import com.dumpQuiz.exceptions.WrongQuestionFormatException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by kaustavc on 5/17/15.
 */
public class QMFileReaderTest {
    QMFileReader expected = null;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        expected = new QMFileReader("tests/data/QuestionsOutput");
    }

    @After
    public void tearDown() throws Exception {
        expected = null;
    }

    @Test
    public void testShouldAbleToReadAProperQuestionSet() throws IOException, WrongFileNameException, WrongQuestionFormatException {
        QMFileReader fr = new QMFileReader("data/QuestionSets");
        assertEquals(expected.read(), fr.read());
    }

//    @Test
//    public void testShouldThrowWrongQuestionFormatExceptionForWrongQuestionFormat() {
//        new QMFileReader("data/WrongFormatQuestion");
//    }
}