package com.dumpQuiz;

/**
 * Created by kaustavc on 3/20/2015.
 * WrongFileNameException for invalid filename
 */
public class WrongFileNameException extends Throwable {
    private final String message;

    public WrongFileNameException(String filename) {
        message = "No file with the name " + filename + " found";
    }
}
