package com.dumpQuiz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kaustav on 4/7/2015.
 * Test for Database Class
 */

public class DatabaseTest {
    @Test
    public void testGetTotalQuestionsShouldReturn2ForQuestionSets() {
        Database db = new Database("data/QuestionSets");
        db.init();
        assertEquals(2, db.getTotalQuestions());
    }

    @Test
    public void testGetTotalQuestionsShouldReturn3ForQuestionSets2() {
        Database db = new Database("data/QuestionSets2");
        db.init();
        assertEquals(3, db.getTotalQuestions());
    }
}
