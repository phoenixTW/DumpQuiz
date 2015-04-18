package com.dumpQuiz;

import java.io.*;

/**
 * Created by kaustavc on 3/20/2015.
 * File reader for Quiz Master
 */
public class QMFileReader {

    private String filename;

    public QMFileReader(String filename) {

        this.filename = filename;
    }

    public String read() throws IOException, WrongFileNameException {
        FileReader fr;
        File thisFile = new File(filename);

        try {
            fr = new FileReader(thisFile);
        } catch(FileNotFoundException e) {
            throw new WrongFileNameException(filename);
        }

        char[] cbuf = writeOnBuffer(fr, thisFile);

        return new String (cbuf);
    }

    private char[] writeOnBuffer(FileReader fr, File thisFile) throws IOException {
        int length = (int)thisFile.length();
        char cbuf[] = new char[length];
        new BufferedReader(fr).read(cbuf, 0, length);
        return cbuf;
    }
}
