package com.dumpQuiz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kaustav on 4/7/2015.
 * Test for QuestionBank Class
 */

public class QuestionBankTest {
    @Test
    public void testGetTotalQuestionsShouldReturn2ForQuestionSets() {
        QuestionBank qb = new QuestionBank("data/QuestionSets");
        qb.init();
        assertEquals(2, qb.getTotalQuestions());
    }

    @Test
    public void testGetTotalQuestionsShouldReturn3ForQuestionSets2() {
        QuestionBank qb = new QuestionBank("data/QuestionSets2");
        qb.init();
        assertEquals(3, qb.getTotalQuestions());
    }
}
