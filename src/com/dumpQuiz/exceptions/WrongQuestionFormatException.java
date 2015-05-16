package com.dumpQuiz.exceptions;

public class WrongQuestionFormatException extends Throwable{
    private final String message;

    public WrongQuestionFormatException(String filename) {
        message = filename + ": Invalid Question set";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
