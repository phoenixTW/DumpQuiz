package com.dumpQuiz;

import com.dumpQuiz.exceptions.WrongFileNameException;
import com.dumpQuiz.exceptions.WrongQuestionFormatException;

import java.io.*;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

/**
 * Created by kaustavc on 3/20/2015.
 * File reader for Quiz Master
 */
public class QMFileReader {

    private String filename;

    public QMFileReader(String filename) {

        this.filename = filename;
    }

    public String read() throws IOException, WrongFileNameException, WrongQuestionFormatException {
        String data = null;

        try {
            data = new String(readAllBytes(get(filename)));
        } catch(FileNotFoundException e) {
            throw new WrongFileNameException(filename);
        }

        return isCorrectFormat(data) ? data : null;
    }

    private boolean isCorrectFormat(String data) throws WrongQuestionFormatException {
        String[] lines = data.split(System.lineSeparator());

        for (String line : lines) {
            if (line.split(":").length != 2){
                throw new WrongQuestionFormatException(filename);
            }
        }

        return true;
    }
}
