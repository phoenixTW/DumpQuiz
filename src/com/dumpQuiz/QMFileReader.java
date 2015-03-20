package com.dumpQuiz;

import java.io.*;

/**
 * Created by kaustavc on 3/20/2015.
 * File reader for Quiz Master
 */
public class QMFileReader {

    public static String read(String filename) throws IOException, WrongFileNameException {
        FileReader fr;
        File thisFile = new File(filename);

        try {
            fr = new FileReader(thisFile);
        } catch(FileNotFoundException e) {
            throw new WrongFileNameException(filename);
        }

        int length = (int)thisFile.length();
        char cbuf[] = new char[length];
        new BufferedReader(fr).read(cbuf, 0, length);

        return new String (cbuf);
    }
}
